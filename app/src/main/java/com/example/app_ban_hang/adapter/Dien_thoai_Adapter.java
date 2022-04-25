package com.example.app_ban_hang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_ban_hang.Interface.ItemClickListener;
import com.example.app_ban_hang.R;
import com.example.app_ban_hang.activity.ChitietActivity;
import com.example.app_ban_hang.model.New_Product;

import java.text.DecimalFormat;
import java.util.List;

public class Dien_thoai_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<New_Product> array;
    private static final int VIEW_TYPE_DATA =0;
    private static final int VIEW_TYPE_LOADING =1;

    public Dien_thoai_Adapter (Context context, List<New_Product> array) {
        this.context = context;
        this.array = array;
    }




    public void onBindViewHolder (@NonNull MyViewHolder holder, int position) {
        New_Product new_product= array.get (position);
            holder.product_name.setText (new_product.getName ());
        DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");
       holder.product_price.setText ("Giá: " + decimalFormat.format (Double.parseDouble (new_product.getPrice ()))+" VND");
        holder.description.setText (new_product.getDescription ());
        Glide.with (context).load (new_product.getImage ()).into (holder.img_product);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
       if (viewType==VIEW_TYPE_DATA){
           View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_dien_thoai,parent,false);
           return new MyViewHolder(view);
       }else{
           View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_loading,parent, false);
            return  new LoadingViewHolder (view);
       }


    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder, int position) {
                if(holder instanceof MyViewHolder){
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            New_Product newProduct = array.get (position);
            myViewHolder.product_name.setText (newProduct.getName ().trim ());
            DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");
            myViewHolder.product_price.setText ("Giá: " + decimalFormat.format (Double.parseDouble (newProduct.getPrice ()))+" VND");
            myViewHolder.description.setText (newProduct.getDescription ());

            Glide.with (context).load (newProduct.getImage ()).into (myViewHolder.img_product);
            myViewHolder.setItemClickListener (new ItemClickListener () {
                @Override
                public void onClick (View view, int pos, boolean isLongClick) {
                    if(!isLongClick){
                        //click

                        Intent intent = new Intent (context, ChitietActivity.class);
                        intent.putExtra ("chitiet",newProduct);
                        intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity (intent);
                    }
                }
            });
        }else {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate (true);
        }

    }

    @Override
    public int getItemViewType (int position) {
        return array.get (position) ==null ?VIEW_TYPE_LOADING:VIEW_TYPE_DATA;
    }

    @Override
    public int getItemCount ( ) {
        return array.size ();
    }

//

//    @NonNull
//    @Override
//    public Dien_thoai_Adapter.MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_dien_thoai,parent,false);
//
//        return new MyViewHolder (view);
//    }
//
//    @Override
//    public void onBindViewHolder (@NonNull Dien_thoai_Adapter.MyViewHolder holder, int position) {
//            New_Product new_product= array.get (position);
//            holder.product_name.setText (new_product.getName ());
//        DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");
//        holder.product_price.setText ("Giá: " + decimalFormat.format (Double.parseDouble (new_product.getPrice ()))+" VND");
//        holder.description.setText (new_product.getDescription ());
//        Glide.with (context).load (new_product.getImage ()).into (holder.img_product);
//    }
//
//    @Override
//    public int getItemCount ( ) {
//        return 0;
//    }
//
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView product_name , product_price , description ;
        ImageView img_product;
        private ItemClickListener itemClickListener;
        public MyViewHolder (@NonNull View itemView) {
            super (itemView);
            product_name = itemView.findViewById (R.id.item_dt_ten);
            product_price = itemView.findViewById (R.id.item_dt_gia);
            description = itemView.findViewById (R.id.item_dt_mota);

            img_product = itemView.findViewById (R.id.item_dt_image);
            itemView.setOnClickListener (this);

        }
        public void setItemClickListener (ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public void onClick (View view) {
            itemClickListener.onClick (view,getAdapterPosition (),false);
        }
    }
    public class LoadingViewHolder extends RecyclerView.ViewHolder{
        ProgressBar progressBar;

        public LoadingViewHolder (@NonNull View itemView) {
            super (itemView);
            progressBar = itemView.findViewById (R.id.progressbar);
        }
    }

}
