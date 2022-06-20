package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Retrofit.Api_ban_hang;
import com.example.app_ban_hang.Retrofit.RetrofitClient;
import com.example.app_ban_hang.Utils.utils;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Dangnhap_activity extends AppCompatActivity {
    TextView txtdangkyngay, txtquenmk ,vldemail,vldpass , vldlogin;

    Button button;
    EditText email, pass ;
    Api_ban_hang apiBanHang;

    CompositeDisposable compositeDisposable = new CompositeDisposable ();
    boolean isLogin = false ;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dangnhap);
        initView();
        initControl();
    }

    private void initControl ( ) {
        txtdangkyngay.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent (getApplicationContext (),DangkiActivity.class);
                startActivity (intent);
            }
        });
        txtquenmk.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent cm = new Intent (getApplicationContext (),reset_pass_activity.class);
                startActivity (cm);
            }
        });




        pass.setOnTouchListener (new View.OnTouchListener () {
            @Override
            public boolean onTouch (View view, MotionEvent motionEvent) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(motionEvent.getRawX() >= (pass.getRight() - pass.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        pass.setInputType (InputType.TYPE_CLASS_TEXT);

                        return true;
                    }
                }
                return false;
            }
        });





        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {

                String str_email = email.getText ().toString ().trim ();
                String str_pass = pass.getText ().toString ().trim ();
                if (TextUtils.isEmpty (str_email)) {
                    vldemail.setText ("Bạn chưa nhập email!");
                    vldemail.setVisibility (View.VISIBLE);
                    vldlogin.setVisibility (View.GONE);
                    vldlogin.setVisibility (View.GONE);
                    email.requestFocus ();
                } else if (TextUtils.isEmpty (str_pass)) {
                    vldpass.setText ("Bạn chưa nhập password!");
                    vldemail.setVisibility (View.GONE);
                    vldpass.setVisibility (View.VISIBLE);
                    vldlogin.setVisibility (View.GONE);
                    pass.requestFocus ();
                }else{
                    //save
                    Paper.book().write("email", str_email);
                    Paper.book().write("pass", str_pass);
                    dangnhap (str_email,str_pass);


                }
            }
        });
        }

    private void dangnhap (String email , String pass ) {
        compositeDisposable.add (apiBanHang.dangnhap (email,pass)
                .subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (
                        user_model -> {

                            if(user_model.isSuccess ()){
                               isLogin=true;

                                Paper.book().write("islogin", isLogin);
                                utils.user_current = user_model.getResult ().get (0);
                                Intent intent = new Intent (getApplicationContext (),MainActivity.class);
                                startActivity (intent);
                                finish ();
                            }else {
                                vldpass.setVisibility (View.GONE);
                                vldlogin.setVisibility (View.VISIBLE);
                            }

                        },
                        throwable -> {
                            Toast.makeText (getApplicationContext (),throwable.getMessage (),Toast.LENGTH_LONG).show ();


                        }
                ));



    }

    private void initView () {
        Paper.init (this);

        apiBanHang = RetrofitClient.getInstane (utils.BASE_URL).create (Api_ban_hang.class);
        txtdangkyngay =findViewById (R.id.txt_dangkyngay);

        email =findViewById (R.id.email_dangnhap);
        pass = findViewById (R.id.password_dangnhap);
        button = findViewById (R.id.btn_dangnhap);
        txtquenmk =findViewById (R.id.txt_quenmatkhau);
        vldemail = findViewById (R.id.validate_email_login);
        vldpass=findViewById (R.id.validate_matkhau_login);
        vldlogin=findViewById (R.id.validate_login);


        //read data
        if(Paper.book ().read ("email")!=null &&  Paper.book ().read ("pass")!=null ){
                email.setText (utils.user_current.getEmail ());
                pass.setText (utils.user_current.getPass ());
                if(Paper.book ().read("islogin")!=null){
                   boolean flag = Paper.book ().read("islogin");
                    if(flag){
                        new Handler ().postDelayed (new Runnable () {
                            @Override
                            public void run ( ) {
                                dangnhap (Paper.book ().read("email"), Paper.book ().read ("pass"));
                            }
                        },1000);
                    }
                }

        }
    }
    protected  void onResmuse(){
        super.onResume ();
        if (utils.user_current.getEmail ()!=null && utils.user_current.getPass () !=null);
            email.setText (utils.user_current.getEmail ());
            pass.setText (utils.user_current.getPass ());
    }

    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();
    }
}