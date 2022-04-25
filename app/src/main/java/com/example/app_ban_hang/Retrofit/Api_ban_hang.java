package com.example.app_ban_hang.Retrofit;

import com.example.app_ban_hang.model.New_Product;
import com.example.app_ban_hang.model.New_Product_Model;
import com.example.app_ban_hang.model.User_model;
import com.example.app_ban_hang.model.type_product_model;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_ban_hang {
    //GET DATA
    @GET("get_type_product.php")
     Observable<type_product_model> get_type_product ();

    @GET("get_new_product.php")
    Observable<New_Product_Model> get_new_product();
    //POST DATA
    @POST("detail.php")
    @FormUrlEncoded
    Observable<New_Product_Model> get_ok(
      @Field ("page") int page,
      @Field ("type") int type
    );
    @POST("dangky.php")
    @FormUrlEncoded
    Observable<User_model> dangky(
            @Field ("email") String email,
            @Field ("pass") String pass,
            @Field ("username") String username,
            @Field ("mobile") String mobile

    );
    @POST("dangnhap.php")
    @FormUrlEncoded
    Observable<User_model> dangnhap(
            @Field ("email") String email,
            @Field ("pass") String pass

    );

    @POST("reset.php")
    @FormUrlEncoded
    Observable<User_model> resetpass(
            @Field ("email") String email


    );
}
