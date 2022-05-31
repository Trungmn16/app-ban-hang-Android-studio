package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Retrofit.Api_ban_hang;
import com.example.app_ban_hang.Retrofit.RetrofitClient;
import com.example.app_ban_hang.Utils.utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class reset_pass_activity extends AppCompatActivity {
    EditText edt_email_reset;
    Button btn_reset;
    TextView validate_email;
    Api_ban_hang api_ban_hang;
    ProgressBar progressBar;
    CompositeDisposable compositeDisposable = new CompositeDisposable ();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_reset_pass);
        innitView();
        innitcontroll();
    }

    private void innitcontroll ( ) {
        btn_reset.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                String str_email = edt_email_reset.getText ().toString ().trim ();

                if(TextUtils.isEmpty (str_email)){
                    validate_email.setText ("Bạn không được để trống!");
                    validate_email.setVisibility (View.VISIBLE);
                }else {
                    progressBar.setVisibility (View.VISIBLE);
                    compositeDisposable.add (api_ban_hang.resetpass (str_email)
                    .subscribeOn (Schedulers.io ())
                    .observeOn (AndroidSchedulers.mainThread ())
                    .subscribe (
                            user_model -> {
                                if (user_model.isSuccess ()){
                                    Toast.makeText (getApplicationContext (),user_model.getMessage (),Toast.LENGTH_LONG).show ();
                                    Intent intent = new Intent (getApplicationContext (),Dangnhap_activity.class);
                                    startActivity (intent);
                                    finish ();
                                }else {
                                    Toast.makeText (getApplicationContext (),user_model.getMessage (),Toast.LENGTH_LONG).show ();
                                }
                                progressBar.setVisibility (View.INVISIBLE);
                            },

                            throwable -> {
                                Toast.makeText (getApplicationContext (),throwable.getMessage (),Toast.LENGTH_LONG).show ();
                                progressBar.setVisibility (View.INVISIBLE);
                            }
                    ));
                }
            }
        });

    }

    private void innitView ( ) {
        api_ban_hang= RetrofitClient.getInstane (utils.BASE_URL).create (Api_ban_hang.class);
        edt_email_reset=findViewById (R.id.edt_email_khoiphuc);
        btn_reset = findViewById (R.id.btn_khoiphuc);
        validate_email = findViewById (R.id.validate_email_khoiphuc);
        progressBar=findViewById (R.id.progressbar);

    }

    @Override
    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();
    }
}