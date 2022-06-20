package com.example.app_ban_hang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Retrofit.Api_ban_hang;
import com.example.app_ban_hang.Retrofit.RetrofitClient;
import com.example.app_ban_hang.Utils.utils;
import com.example.app_ban_hang.adapter.Donhang_Adapter;
import com.example.app_ban_hang.model.Donhang_Model;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class XemdonActivity extends AppCompatActivity {
    CompositeDisposable compositeDisposable = new CompositeDisposable ();
    Api_ban_hang api_ban_hang;
    RecyclerView recyclerView;
    Toolbar toolbar;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_xemdon);
        initView ();
        inittoolbar();
        getOder();




    }

    private void getOder ( ) {
        compositeDisposable.add (api_ban_hang.xemDonhang (utils.user_current.getId ())
                .subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (
                        donhangModel -> {
                       //     Toast.makeText (getApplicationContext (),"HIHI" + donhangModel.getResult ().get (0).getITEM ().get (1).getTensp (), Toast.LENGTH_LONG).show ();
                            Donhang_Adapter donhang_adapter =  new Donhang_Adapter (getApplicationContext (),donhangModel.getResult ());
                            recyclerView.setAdapter (donhang_adapter);
                        },throwable -> {
                            Toast.makeText (getApplicationContext (),throwable.getMessage () , Toast.LENGTH_LONG).show ();

                        }

                ));
    }

    private void inittoolbar ( ) {
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);

        toolbar.setNavigationOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                finish ();
            }
        });

    }

    private void initView ( ) {
        api_ban_hang = RetrofitClient.getInstane (utils.BASE_URL).create (Api_ban_hang.class);
        recyclerView = findViewById (R.id.recycleview_xemdon);
        LinearLayoutManager layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager (layoutManager);
        toolbar = findViewById (R.id.toolbar_Xemdon);

    }

    @Override
    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();
    }
}