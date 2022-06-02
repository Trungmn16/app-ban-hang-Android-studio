package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Utils.utils;
import com.google.gson.Gson;

import java.text.DecimalFormat;

public class Thanhtoan_activity extends AppCompatActivity {
    Button btndathang;
    Toolbar toolbar;
    TextView txt_tongtien , txt_sdt, txt_email;
    EditText edt_diachi;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_thanhtoan);
        initview();
        initcontroll();
        Actiontoolbar();


    }

    private void initcontroll ( ) {

        DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");
        long tongtien = getIntent ().getLongExtra ("tongtien",0);
        txt_tongtien.setText (decimalFormat.format (tongtien));
        txt_email.setText (utils.user_current.getEmail ());
        txt_sdt.setText (utils.user_current.getMobile ())
        ;
        btndathang.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                String str_diachi = edt_diachi.getText ().toString ().trim ();
                if(TextUtils.isEmpty (str_diachi)){
                    Toast.makeText (getApplicationContext (),"ban ko dc de rong",Toast.LENGTH_LONG).show ();
                }else{
                    Log.d("test", new Gson ().toJson (utils.manggiohang));
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
        toolbar=findViewById (R.id.toolbar_thanhtoan);
        txt_tongtien=findViewById (R.id.txt_tongtien);
        btndathang = findViewById (R.id.btn_dathang);
        txt_sdt = findViewById (R.id.txt_sdt);
        txt_email=findViewById (R.id.txt_email);
        edt_diachi=findViewById (R.id.edt_location);

    }
}