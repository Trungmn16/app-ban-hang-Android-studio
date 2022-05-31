package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Utils.utils;
import com.example.app_ban_hang.adapter.GioHangAdapter;
import com.example.app_ban_hang.model.Envenbus.Tinh_Tong_Event;
import com.example.app_ban_hang.model.Giohang;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
import java.util.List;

public class Gio_Hang_Activity extends AppCompatActivity {
    TextView giohangtrong,tongtien;
    Button btnmuahang;
    Toolbar toolbar;
    RecyclerView recyclerView;
    GioHangAdapter adapter;
    List<Giohang> giohangList;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_gio_hang);
        initView();
        initcontrol();
        tinhtongtien();
        btnmuahang.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent muahang = new Intent (getApplicationContext (),Dangnhap_activity.class);
                startActivity (muahang);
            }
        });

    }

    private void tinhtongtien ( ) {
        long tongtiensp=0;
        for (int i = 0 ; i < utils.manggiohang.size ();i++){
            tongtiensp=tongtiensp+(utils.manggiohang.get (i).getGiasp ()*utils.manggiohang.get (i).getSoluong ());
        }
        DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");

        tongtien.setText (decimalFormat.format (tongtiensp) + " VND");

    }

    private void initcontrol ( ) {
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        toolbar.setNavigationOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                finish ();
            }
        });
        recyclerView.setHasFixedSize (true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager (layoutManager);
        if(utils.manggiohang.size ()==0){
            giohangtrong.setVisibility (View.VISIBLE);
        }else {
            adapter = new GioHangAdapter (getApplicationContext (),utils.manggiohang);
            recyclerView.setAdapter (adapter);
        }
    }

    private void initView ( ) {
        giohangtrong = findViewById (R.id.txt_giohangtrong);
        tongtien = findViewById (R.id.txt_tongtien);
        toolbar=findViewById (R.id.toolbar_giohang);
        recyclerView = findViewById (R.id.recycleview_giohang);
        btnmuahang = findViewById (R.id.btn_muahang);

    }

    @Override
    protected void onStart ( ) {
        super.onStart ();
        EventBus.getDefault ().register (this);
    }

    @Override
    protected void onStop ( ) {
        EventBus.getDefault ().unregister (this);
        super.onStop ();

    }
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public  void event_Tinh_tong_tien(Tinh_Tong_Event event){
        if(event!=null){

            tinhtongtien ();
        }
    }
}