package com.example.app_ban_hang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class New_Product_Adapter extends RecyclerView.Adapter<New_Product_Adapter.MyViewHolder> {
    Context context;
    List<New_Product> array;

    public New_Product_Adapter (Context context, List<New_Product> array) {
        this.context = context;
        this.array = array;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_new_product,parent,false);

        return new MyViewHolder (item);
    }

    @Override
    public void onBindViewHolder (@NonNull MyViewHolder holder, int position) {
        New_Product new_product = array.get (position);
        holder.txt_name.setText (new_product.getName ());
        DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");
        holder.txt_price.setText ("Giá: " + decimalFormat.format (Double.parseDouble (new_product.getPrice ()))+" VND");
        Glide.with (context).load (new_product.getImage ()).into (holder.imagesp);
        holder.setItemClickListener (new ItemClickListener () {
            @Override
            public void onClick (View view, int pos, boolean isLongClick) {
                if(!isLongClick){
                    //click

                    Intent intent = new Intent (context, ChitietActivity.class);
                    intent.putExtra ("chitiet",new_product);
                    intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity (intent);
                }
            }
        });
    }

    @Override
    public int getItemCount ( ) {
        return array.size ();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_name , txt_price;
        ImageView imagesp;
        private  ItemClickListener itemClickListener;
        public MyViewHolder (@NonNull View itemView) {
            super (itemView);
            txt_name= itemView.findViewById (R.id.itemsp_ten);
            txt_price= itemView.findViewById (R.id.itemsp_gia);
            imagesp= itemView.findViewById (R.id.itemsp_image);
            itemView.setOnClickListener (this);
        }

        public void setItemClickListener (ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick (View view) {
            itemClickListener.onClick (view,getAdapterPosition (),false);
        }
    }
}
