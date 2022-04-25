package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Utils.utils;
import com.example.app_ban_hang.model.Giohang;
import com.example.app_ban_hang.model.New_Product;
import com.nex3z.notificationbadge.NotificationBadge;

import java.text.DecimalFormat;

public class ChitietActivity extends AppCompatActivity {
    TextView tensp,giasp,mota;
    Button btnthem;
    ImageView imghinhanh;
    Spinner spinner;
    Toolbar toolbar;
    New_Product sanPhamMoi;
    NotificationBadge notificationBadge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        initView();
        ActionToolBar ();
        initdata();
        initControl();
    }

    private void initControl ( ) {
        btnthem.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                themgiohang();
            }
        });
    }

    private void themgiohang ( ) {
        if(utils.manggiohang.size ()>0){
            boolean flag = false;
            int soluong = Integer.parseInt (spinner.getSelectedItem ().toString ());
            for(int i =0;i<utils.manggiohang.size ();i++){
                if (utils.manggiohang.get (i).getIdsp ()==sanPhamMoi.getId ()){
                    utils.manggiohang.get (i).setSoluong (soluong + utils.manggiohang.get (i).getSoluong ());
                    long gia = Long.parseLong (sanPhamMoi.getPrice ())*utils.manggiohang.get(i).getSoluong ();
                    utils.manggiohang.get (i).setGiasp (gia);
                    flag=true;


                }
            }
            if (flag==false){

                long gia = Long.parseLong (sanPhamMoi.getPrice ())*soluong;
                Giohang giohang = new Giohang ();
                giohang.setGiasp (gia);
                giohang.setSoluong (soluong);
                giohang.setIdsp (sanPhamMoi.getId ());
                giohang.setTensp (sanPhamMoi.getName ());
                giohang.setHinhsp (sanPhamMoi.getImage ());
                utils.manggiohang.add (giohang);

            }
        }else {
            int soluong = Integer.parseInt (spinner.getSelectedItem ().toString ());
            long gia = Long.parseLong (sanPhamMoi.getPrice ())*soluong;
            Giohang giohang = new Giohang ();
            giohang.setGiasp (gia);
            giohang.setSoluong (soluong);
            giohang.setIdsp (sanPhamMoi.getId ());
            giohang.setTensp (sanPhamMoi.getName ());
            giohang.setHinhsp (sanPhamMoi.getImage ());
            utils.manggiohang.add (giohang);
        }
        int totalitem = 0;
        for (int i = 0 ; i<utils.manggiohang.size ();i++){
            totalitem = totalitem + utils.manggiohang.get (i).getSoluong ();
        }
        notificationBadge.setText (String.valueOf (totalitem));
    }

    private void initdata ( ) {
        sanPhamMoi = (New_Product) getIntent ().getSerializableExtra ("chitiet");
        tensp.setText (sanPhamMoi.getName ());
        mota.setText (sanPhamMoi.getDescription ());
        Glide.with (getApplicationContext ()).load (sanPhamMoi.getImage ()).into (imghinhanh);
        DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");
        giasp.setText ("Giá: " + decimalFormat.format (Double.parseDouble (sanPhamMoi.getPrice ()))+" VND");
        Integer[] so = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> adapterspin = new ArrayAdapter<> (this,R.layout.support_simple_spinner_dropdown_item,so);
        spinner.setAdapter (adapterspin);
    }

    private void initView ( ) {
        tensp = findViewById (R.id.txt_tensanpham);
        giasp = findViewById (R.id.txt_giasanpham);
        mota = findViewById (R.id.txtmotachitiet);
        btnthem = findViewById (R.id.btn_themgiohang);
        imghinhanh = findViewById (R.id.img_chitiet);
        spinner = findViewById (R.id.spiner);
        toolbar= findViewById (R.id.toolbarchitiet);
        notificationBadge=findViewById (R.id.menu_sl);
        FrameLayout frameLayout_giohang = findViewById (R.id.frame_giohang);
        frameLayout_giohang.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent giohang = new Intent (getApplicationContext (),Gio_Hang_Activity.class);
                startActivity (giohang);
            }
        });
        if(utils.manggiohang!=null){
            int totalitem = 0;
            for (int i = 0 ; i<utils.manggiohang.size ();i++){
                totalitem = totalitem + utils.manggiohang.get (i).getSoluong ();
            }
            notificationBadge.setText (String.valueOf (totalitem));
        }
    }

    private void ActionToolBar ( ) {
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        toolbar.setNavigationOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                finish ();
            }
        });
    }

    @Override
    protected void onResume ( ) {
        super.onResume ();
        if(utils.manggiohang!=null){
            int totalitem = 0;
            for (int i = 0 ; i<utils.manggiohang.size ();i++){
                totalitem = totalitem + utils.manggiohang.get (i).getSoluong ();
            }
            notificationBadge.setText (String.valueOf (totalitem));
        }
    }
}