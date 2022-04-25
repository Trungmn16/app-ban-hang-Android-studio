package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.app_ban_hang.R;

public class reset_pass extends AppCompatActivity {
    EditText edt_email;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_reset_pass);
    }
}
