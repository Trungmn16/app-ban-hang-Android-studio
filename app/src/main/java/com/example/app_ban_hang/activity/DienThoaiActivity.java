package com.example.app_ban_hang.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Retrofit.Api_ban_hang;
import com.example.app_ban_hang.Retrofit.RetrofitClient;
import com.example.app_ban_hang.Utils.utils;
import com.example.app_ban_hang.adapter.Dien_thoai_Adapter;
import com.example.app_ban_hang.model.New_Product;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DienThoaiActivity extends AppCompatActivity {
    Toolbar toolbar;

    RecyclerView recyclerView;
    Api_ban_hang apiBanHang;
    CompositeDisposable compositeDisposable = new CompositeDisposable ();
    int page =1;
    int type;
    Dien_thoai_Adapter adapter_dt;

    List<New_Product> Product_List;
    LinearLayoutManager linearLayoutManager;
    Handler handler = new Handler ();
    boolean isLoading = false;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dien_thoai);
        apiBanHang = RetrofitClient.getInstane (utils.BASE_URL).create (Api_ban_hang.class);
        type=getIntent ().getIntExtra ("type",1);

        Anhxa();
        ActionToolBar();

        getDatax (page);
        addEventLoad();

    }



    private void getDatax (int page ) {
        compositeDisposable.add ((apiBanHang.get_ok (page,type))
        .subscribeOn (Schedulers.io ())
        .observeOn (AndroidSchedulers.mainThread ())
        .subscribe (
                newProductModel -> {
                    if(newProductModel.isSuccess ()){
                        if(adapter_dt==null){
                            Product_List = newProductModel.getResult ();
                            adapter_dt = new Dien_thoai_Adapter (getApplicationContext (),Product_List);
                            recyclerView.setAdapter (adapter_dt);

                        }else {
                            int vitri= Product_List.size ()-1;
                            int soluongadd = newProductModel.getResult ().size ();
                            for (int i =0;i<soluongadd;i++){
                                Product_List.add (newProductModel.getResult ().get (i));
                            }
                            adapter_dt.notifyItemRangeInserted (vitri,soluongadd);

                        }

                    } else {
                        Toast.makeText (getApplicationContext (),"het du lieu",Toast.LENGTH_LONG).show ();
                        isLoading=true;
                    }

                },
                throwable -> {
                    Toast.makeText (getApplicationContext (), "don't connect to sever", Toast.LENGTH_SHORT).show ();
                }
        ));
    }

    private void addEventLoad ( ) {
        recyclerView.addOnScrollListener (new RecyclerView.OnScrollListener () {
            @Override
            public void onScrollStateChanged (@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged (recyclerView, newState);
            }

            @Override
            public void onScrolled (@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled (recyclerView, dx, dy);
                if (isLoading==false){
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition ()== Product_List.size ()-1){
                        isLoading=true;
                        LoadMore();

                    }
                }
            }
        });
    }

    private void LoadMore ( ) {
        handler.post (new Runnable () {
            @Override
            public void run ( ) {
                //add null
                Product_List.add (null);
                adapter_dt.notifyItemInserted (Product_List.size ()-1);
            }
        });
        handler.postDelayed (new Runnable () {
            @Override
            public void run ( ) {
                //remover null
                Product_List.remove (Product_List.size ()-1);
                adapter_dt.notifyItemRemoved (Product_List.size ());
                page=page+1;
                getDatax (page);
                adapter_dt.notifyDataSetChanged ();
                isLoading = false;
            }
        },2000);
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



    private void Anhxa ( ) {
        toolbar = findViewById (R.id.toolbar_dienthoai);
        recyclerView = findViewById (R.id.recycleview_dienthoai);
        linearLayoutManager = new LinearLayoutManager (this,LinearLayoutManager.VERTICAL,false);
    //    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager (linearLayoutManager);
        recyclerView.setHasFixedSize (true);

        Product_List = new ArrayList<> ();
    }

    @Override
    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();

    }
}