package com.example.app_ban_hang.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.model.item;

import java.util.List;

public class Donhang_chitite_Adapter  extends RecyclerView.Adapter<Donhang_chitite_Adapter.MyViewHolder> {

    List<item> itemList;

    public Donhang_chitite_Adapter (List<item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_chitiet_donhang,parent,false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder (@NonNull MyViewHolder holder, int position) {
            item Item = itemList.get (position);
            holder.txt_chitiet_tensp.setText (Item.getTensp ()+"");
    }

    @Override
    public int getItemCount ( ) {
        return itemList.size ();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_chitietdonhang;
        TextView txt_chitiet_tensp , txt_chitiet_soluongsp;
        public MyViewHolder (@NonNull View itemView) {
            super (itemView);
            img_chitietdonhang = itemView.findViewById (R.id.img_item_donhang);
            txt_chitiet_tensp = itemView.findViewById (R.id.item_tensp_donhang);
            txt_chitiet_soluongsp = itemView.findViewById (R.id.item_soluongsp_donhang);
        }
    }
}
