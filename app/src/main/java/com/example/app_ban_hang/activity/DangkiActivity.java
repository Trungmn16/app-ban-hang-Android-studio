package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Retrofit.Api_ban_hang;
import com.example.app_ban_hang.Retrofit.RetrofitClient;
import com.example.app_ban_hang.Utils.utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DangkiActivity extends AppCompatActivity {
    EditText email, pass , repass , mobile , username;
    AppCompatButton button;
    ImageButton imgbutton;
    Api_ban_hang apiBanHang;
    TextView txtdangky ,vld_email,vld_taikhoan , vld_pass,vld_repass,vld_sdt;
    CompositeDisposable compositeDisposable = new CompositeDisposable ();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dangki);
        initView();
        initControl();
    }

    private void initControl ( ) {
        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                dangKi();
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

        repass.setOnTouchListener (new View.OnTouchListener () {
            @Override
            public boolean onTouch (View view, MotionEvent motionEvent) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(motionEvent.getRawX() >= (repass.getRight() - repass.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        repass.setInputType (InputType.TYPE_CLASS_TEXT);

                        return true;
                    }
                }
                return false;
            }
        });

        imgbutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent dangky = new Intent (getApplicationContext (),Dangnhap_activity.class);
                startActivity (dangky);
            }
        });
        txtdangky.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent quaylai_dangnhap = new Intent (getApplicationContext (),Dangnhap_activity.class);
                startActivity (quaylai_dangnhap);
            }
        });

    }

    private void dangKi ( ) {

        String str_email = email.getText ().toString ().trim ();
        String str_pass = pass.getText ().toString ().trim ();
        String str_repass = repass.getText ().toString ().trim ();
        String str_mobile = mobile.getText ().toString ().trim ();
        String str_username = username.getText ().toString ().trim ();
        if(TextUtils.isEmpty (str_email)){
            vld_email.setText ("Bạn chưa nhập Email ! ");
            vld_email.setVisibility (View.VISIBLE);
            email.requestFocus ();
        }else if(TextUtils.isEmpty (str_username)) {
            vld_email.setVisibility (View.GONE);
            vld_taikhoan.setText ("Bạn chưa nhập tên tài khoản ! ");
            vld_taikhoan.setVisibility (View.VISIBLE);
            username.requestFocus ();
        }else if(TextUtils.isEmpty (str_pass)){
            vld_taikhoan.setVisibility (View.GONE);
            vld_pass.setText ("Bạn chưa nhập mật khẩu !");
            vld_pass.setVisibility (View.VISIBLE);
            pass.requestFocus ();
        }else if(TextUtils.isEmpty (str_repass)){
            vld_pass.setVisibility (View.GONE);
            vld_repass.setText ("Bạn chưa nhập lại mật khẩu !");
            vld_repass.setVisibility (View.VISIBLE);
            repass.requestFocus ();
        }else if(TextUtils.isEmpty (str_mobile)) {
            vld_repass.setVisibility (View.GONE);
            vld_sdt.setText ("Bạn chưa nhập số điện thoại !");
            vld_sdt.setVisibility (View.VISIBLE);
            mobile.requestFocus ();


//        }else if(str_pass.equals (str_repass)){
//            Toast.makeText (getApplicationContext (), "Thành công", Toast.LENGTH_LONG).show ();
//
//            Intent quaylai_dangnhap = new Intent (getApplicationContext (),Dangnhap_activity.class);
//            startActivity (quaylai_dangnhap);


            //past data
        }else   if(str_pass.equals (str_repass)){
            vld_sdt.setVisibility (View.GONE);
                compositeDisposable.add (apiBanHang.dangky (str_email,str_pass,str_username,str_mobile)
                .subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (
                        user_model -> {
                            if (user_model.isSuccess ()){
                                utils.user_current.setEmail (str_email);
                                utils.user_current.setPass (str_pass);
                                vld_repass.setVisibility (View.GONE);
                                Toast.makeText (getApplicationContext (), "Thành công", Toast.LENGTH_LONG).show ();
                                Intent quaylai_dangnhap = new Intent (getApplicationContext (),Dangnhap_activity.class);
                                startActivity (quaylai_dangnhap);
                                finish ();

                            }else {
                                Toast.makeText (getApplicationContext (), user_model.getMessage (), Toast.LENGTH_LONG).show ();

                            }
                        },
                        throwable -> {
                            Toast.makeText (getApplicationContext (),throwable.getMessage () , Toast.LENGTH_LONG).show ();

                        }
                ));


            }else {
            vld_pass.setVisibility (View.GONE);
            vld_repass.setText ("Mật khẩu nhập lại không khớp!");
            vld_repass.setVisibility (View.VISIBLE);
            }



    }
    private void initView ( ) {
        apiBanHang = RetrofitClient.getInstane (utils.BASE_URL).create (Api_ban_hang.class);
        email = findViewById (R.id.nhap_email_dangky );
        pass = findViewById (R.id.nhap_password_dangky);
        repass = findViewById (R.id.nhaplai_password_dangky);
        button = findViewById (R.id.btn_dangky);
        mobile = findViewById (R.id.nhap_mobile_dangky);
        username = findViewById (R.id.nhap_username_dangky);
        imgbutton = findViewById (R.id.btn_dangky_quaylai);
        txtdangky = findViewById (R.id.txtdangnhapngay);
        vld_email=findViewById (R.id.validate_email);
        vld_taikhoan = findViewById (R.id.validate_tentaikhoan);
        vld_pass = findViewById (R.id.validate_pass);
        vld_repass = findViewById (R.id.validate_repass);
        vld_sdt=findViewById (R.id.validate_sdt);


    }

    @Override
    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();
    }
}