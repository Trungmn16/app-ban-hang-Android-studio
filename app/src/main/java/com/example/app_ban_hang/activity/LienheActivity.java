package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.app_ban_hang.R;

public class LienheActivity extends AppCompatActivity {
    ImageView img_send , img_file,img_video,img_anh , img_back;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_lienhe);
        initView();
        initcontrol();

    }

    private void initcontrol ( ) {
        img_send.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder (view.getRootView ().getContext ());
                builder.setTitle ("Thông báo");
                builder.setMessage ("Gửi tin nhắn thành công , chúng tôi sẽ phản hồi cho bạn sớm nhất có thể!");
                builder.setPositiveButton ("Tiếp tục mua sắm", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent (getApplicationContext (), MainActivity.class);
                        intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity (intent);
                    }
                });
                builder.show ();
            }
        });

        img_file.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                tDialog (view);
            }
        });
        img_video.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                tDialog (view);
            }
        });
        img_anh.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                tDialog (view);
            }
        });
        img_back.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent (getApplicationContext (), MainActivity.class);
                intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity (intent);
            }
        });
    }
    private void tDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder (view.getRootView ().getContext ());
        builder.setTitle ("Thông báo");
        builder.setMessage ("Tính năng đang được phát triển ,  mời bạn thử lại sau!");
        builder.setPositiveButton ("Đồng ý", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {

            }
        });
        builder.show ();

    }

    private void initView ( ) {
        img_send= findViewById (R.id.img_send);
        img_file= findViewById (R.id.img_file);
        img_anh= findViewById (R.id.img_anh);
        img_video= findViewById (R.id.img_video);
        img_back=findViewById (R.id.img_quaylai);
    }


}