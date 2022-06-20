package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Retrofit.Api_ban_hang;
import com.example.app_ban_hang.Retrofit.RetrofitClient;
import com.example.app_ban_hang.Utils.utils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.text.DecimalFormat;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Thanhtoan_activity extends AppCompatActivity {
    Button btndathang;
    Toolbar toolbar;
    TextView txt_tongtien , txt_sdt, txt_email;
    EditText edt_diachi;
    CompositeDisposable compositeDisposable = new CompositeDisposable ();
    Api_ban_hang api_ban_hang ;
    long tongtien;
    int totalitem;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_thanhtoan);
        initview();
        countItem();
        initcontroll();
        Actiontoolbar();


    }

    private void countItem ( ) {
         totalitem = 0;
        for (int i = 0 ; i<utils.manggiohang.size ();i++){
            totalitem = totalitem + utils.manggiohang.get (i).getSoluong ();
        }
    }

    private void initcontroll ( ) {
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        toolbar.setNavigationOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                finish ();
            }
        });
        DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");
         tongtien = getIntent ().getLongExtra ("tongtien",0);
        txt_tongtien.setText (decimalFormat.format (tongtien));
        txt_email.setText (utils.user_current.getEmail ());
        txt_sdt.setText (utils.user_current.getMobile ());
        btndathang.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {

                String str_diachi = edt_diachi.getText ().toString ().trim ();

                if(TextUtils.isEmpty (str_diachi)){
                    Toast.makeText (getApplicationContext (),"ban ko dc de rong",Toast.LENGTH_LONG).show ();
                }else{
                    String str_email =  utils.user_current.getEmail ();
                    String str_sdt =  utils.user_current.getMobile ();
                    int id = utils.user_current.getId ();
                    Log.d("test", new Gson ().toJson (utils.manggiohang));
                    compositeDisposable.add (api_ban_hang.creatOder (str_email, str_sdt ,String.valueOf (tongtien), id , str_diachi , totalitem , new Gson ().toJson (utils.manggiohang) )
                            .subscribeOn (Schedulers.io ())
                            .observeOn (AndroidSchedulers.mainThread ())
                            .subscribe (
                                     userModel -> {

                                            Toast.makeText (getApplicationContext (), "thanh cong ", Toast.LENGTH_SHORT).show ();
                                            Intent intent = new Intent (getApplicationContext (),MainActivity.class);
                                            startActivity (intent);
                                            finish ();


                                    },
                                    throwable -> {
                                        Toast.makeText (getApplicationContext (), throwable.getMessage (), Toast.LENGTH_LONG).show ();

                                    }
                            ));
                }

            }
        });
    }

    private void Actiontoolbar ( ) {
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);

        toolbar.setNavigationOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                finish ();
            }
        });
    }

    private void initview ( ) {
        api_ban_hang = RetrofitClient.getInstane (utils.BASE_URL).create (Api_ban_hang.class);
        toolbar=findViewById (R.id.toolbar_thanhtoan);
        txt_tongtien=findViewById (R.id.txt_tongtien);
        btndathang = findViewById (R.id.btn_dathang);
        txt_sdt = findViewById (R.id.txt_sdt);
        txt_email=findViewById (R.id.txt_email);
        edt_diachi=findViewById (R.id.edt_location);

    }
    @Override
    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();
    }
}