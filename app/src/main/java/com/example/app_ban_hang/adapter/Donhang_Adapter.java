package com.example.app_ban_hang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_ban_hang.R;
import com.example.app_ban_hang.model.Donhang;

import java.util.List;

public class Donhang_Adapter  extends RecyclerView.Adapter<Donhang_Adapter.MyViewHolder>{
    Context context;
    List<Donhang> donhangList;
    private RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool ();
    public Donhang_Adapter (Context context, List<Donhang> donhangList) {
        this.context = context;
        this.donhangList = donhangList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_donhang,parent,false);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder (@NonNull MyViewHolder holder, int position) {
        Donhang donhang = donhangList.get (position);
        holder.txtDohang.setText ("Đơn hàng: " +donhang.getId ());
        LinearLayoutManager layoutManager = new LinearLayoutManager (
                holder.recyclerView_donhang.getContext (),
                LinearLayoutManager.VERTICAL,false
        );
        layoutManager.setInitialPrefetchItemCount (donhang.getITEM ().size ());
        //adapter item chi tiet
            Donhang_chitite_Adapter donhang_chitite_adapter = new Donhang_chitite_Adapter (donhang.getITEM ());
            holder.recyclerView_donhang.setLayoutManager (layoutManager);
            holder.recyclerView_donhang.setAdapter (donhang_chitite_adapter);
            holder.recyclerView_donhang.setRecycledViewPool (recycledViewPool);
    }

    @Override
    public int getItemCount ( ) {
        return donhangList.size ();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtDohang;
        RecyclerView recyclerView_donhang;
        public MyViewHolder (@NonNull View itemView) {
            super (itemView);
            txtDohang=itemView.findViewById (R.id.txt_donhang);
            recyclerView_donhang = itemView.findViewById (R.id.recycleview_donhang);
        }
    }
}
