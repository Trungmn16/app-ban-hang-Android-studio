package com.example.app_ban_hang.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.ConnectivityDiagnosticsManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Retrofit.Api_ban_hang;
import com.example.app_ban_hang.Retrofit.RetrofitClient;
import com.example.app_ban_hang.Utils.utils;
import com.example.app_ban_hang.adapter.New_Product_Adapter;
import com.example.app_ban_hang.adapter.type_product_Adapter;
import com.example.app_ban_hang.model.Donhang;
import com.example.app_ban_hang.model.New_Product;
import com.example.app_ban_hang.model.New_Product_Model;
import com.example.app_ban_hang.model.type_product;
import com.example.app_ban_hang.model.type_product_model;
import com.google.android.material.navigation.NavigationView;
import com.nex3z.notificationbadge.NotificationBadge;

import android.Manifest.permission;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewhome;
    ListView listViewhome;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    type_product_Adapter type_product_adapter;
    List<type_product> array_type_product;
    CompositeDisposable compositeDisposable = new CompositeDisposable ();
    Api_ban_hang api_ban_hang;
    List<New_Product> array_new;
    New_Product_Adapter new_product_adapter;
    NotificationBadge notificationBadge;
    FrameLayout frameLayout;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        api_ban_hang = RetrofitClient.getInstane (utils.BASE_URL).create (Api_ban_hang.class);
        anhxa();
        ActionBar();

       if(isConnected (this)){

           actionviewflipper();
           Get_Type_Product();
           get_new_product();
           get_EventClick();
       }else {
           Toast.makeText (getApplicationContext (),"no internet ! Please reconnect",Toast.LENGTH_LONG).show ();
       }

    }

    private void get_EventClick ( ) {
        listViewhome.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent home = new Intent (getApplicationContext (), MainActivity.class);
                        startActivity (home);
                        break;
                    case 1:
                        Intent smartphone = new Intent (getApplicationContext (),DienThoaiActivity.class);
                        smartphone.putExtra ("type",1);
                        startActivity (smartphone);
                        break;
                    case 2:
                        Intent laptop = new Intent (getApplicationContext (),DienThoaiActivity.class);
                        laptop.putExtra ("type",2 );
                        startActivity (laptop);
                        break;

                    case 5:
                        Intent Donhang = new Intent (getApplicationContext (),XemdonActivity.class);

                        startActivity (Donhang);
                        break;
                }
            }
        });
    }

    private void get_new_product ( ) {
        compositeDisposable.add (api_ban_hang.get_new_product ()
        .subscribeOn (Schedulers.io ())
        .observeOn (AndroidSchedulers.mainThread ())
        .subscribe (
                new_product_model -> {
                    if (new_product_model.isSuccess ()){
                        array_new = new_product_model.getResult ();
                        new_product_adapter = new New_Product_Adapter (getApplicationContext (),array_new);
                        recyclerViewhome.setAdapter (new_product_adapter);
                    }
                },
                throwable -> {
                    Toast.makeText (getApplicationContext (),"Không kết nối được với sever"+throwable.getMessage (),Toast.LENGTH_LONG).show ();
                }
        ));

    }

    private void Get_Type_Product ( ) {

        compositeDisposable.add (api_ban_hang.get_type_product ()
        .subscribeOn (Schedulers.io ())
        .observeOn (AndroidSchedulers.mainThread ())
        .subscribe (

                typeProductModel -> {
                    if (typeProductModel.isSuccess ()){
                      array_type_product = typeProductModel.getResult ();
                        //create adapter
                        type_product_adapter = new type_product_Adapter  (getApplicationContext(),array_type_product);
                        listViewhome.setAdapter (type_product_adapter);
                    }
                }

        ));

    }

    private void actionviewflipper ( ) {
        List<String> ads = new ArrayList<> ();
        ads.add ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzJWH1FSN0gnAbe_QymjLm5PYNQV8pbUyKJUoDuxeoaka0PmS55tmi-j___B5cR999hU4&usqp=CAU");
        ads.add ("https://printgo.vn/uploads/media/792227/mau-banner-quang-cao-dep-2_1623041398.jpg");
        ads.add ("https://thietkehaithanh.com/wp-content/uploads/2019/01/thietkehaithanh-banner-laptop.png");
        ads.add ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMR1MCf05n4PabSmggPfLZPXEAfyFnhGeljQ&usqp=CAU");
        ads.add ("https://nguyencongpc.vn/media/news/534.jpg");
        for(int i = 0 ; i <ads.size () ; i++){
            ImageView imgview = new ImageView (getApplicationContext ());
            Glide.with (getApplicationContext ()).load(ads.get (i)).into (imgview);
            imgview.setScaleType (ImageView.ScaleType.FIT_XY);
            viewFlipper.addView (imgview);



        }
        viewFlipper.setFlipInterval (3000);
        viewFlipper.setAutoStart (true);
        Animation slide_in = AnimationUtils.loadAnimation (getApplicationContext (),R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation (getApplicationContext (), R.anim.slide_out_right);
        viewFlipper.setInAnimation (slide_in);
        viewFlipper.setOutAnimation (slide_out);
    }

    private void ActionBar () {
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        toolbar.setNavigationIcon (android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                drawerLayout.openDrawer (GravityCompat.START);
            }
        });
    }

    private void anhxa ( ) {
        toolbar = (Toolbar) findViewById (R.id.Toolbarhome);
        viewFlipper = (ViewFlipper) findViewById (R.id.Viewlipper);
        recyclerViewhome = (RecyclerView) findViewById (R.id.recycleview);
        listViewhome =  (ListView) findViewById (R.id.listviewhome);
        navigationView = (NavigationView) findViewById (R.id.navigationview);
        drawerLayout =(DrawerLayout) findViewById (R.id.drawerlayout);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager (this,2);
        recyclerViewhome.setLayoutManager (layoutManager);
        recyclerViewhome.setHasFixedSize (true);
        notificationBadge = findViewById (R.id.menu_sl);
        frameLayout=findViewById (R.id.frame_giohang);
        //create list
        array_type_product = new ArrayList<> ();
        array_new = new ArrayList<> ();
        if(utils.manggiohang==null){
            utils.manggiohang= new ArrayList<> ();
        }else {
            int totalitem = 0;
            for (int i = 0 ; i<utils.manggiohang.size ();i++){
                totalitem = totalitem + utils.manggiohang.get (i).getSoluong ();

            }
            notificationBadge.setText (String.valueOf (totalitem));
        }
        frameLayout.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent giohang = new Intent (getApplicationContext (),Gio_Hang_Activity.class);
                startActivity (giohang);
            }
        });



    }

    @Override
    protected void onResume ( ) {
        super.onResume ();
        int totalitem = 0;
        for (int i = 0 ; i<utils.manggiohang.size ();i++){
            totalitem = totalitem + utils.manggiohang.get (i).getSoluong ();

        }
        notificationBadge.setText (String.valueOf (totalitem));
    }

    private boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService (Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifi = connectivityManager.getNetworkInfo (ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo (ConnectivityManager.TYPE_MOBILE);
        if ((wifi !=null && wifi.isConnected ())||(mobile !=null && mobile.isConnected ())){
            return true;

        }else {
            return false;
        }

    }

    @Override
    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();
    }
}