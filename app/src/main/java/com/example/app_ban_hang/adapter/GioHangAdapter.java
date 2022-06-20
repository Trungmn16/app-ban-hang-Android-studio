package com.example.app_ban_hang.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_ban_hang.Interface.Image_clicklistener;
import com.example.app_ban_hang.R;
import com.example.app_ban_hang.Utils.utils;
import com.example.app_ban_hang.activity.ChitietActivity;
import com.example.app_ban_hang.activity.DangkiActivity;
import com.example.app_ban_hang.activity.Gio_Hang_Activity;
import com.example.app_ban_hang.activity.LienheActivity;
import com.example.app_ban_hang.activity.MainActivity;
import com.example.app_ban_hang.activity.reset_pass_activity;
import com.example.app_ban_hang.model.Envenbus.Tinh_Tong_Event;
import com.example.app_ban_hang.model.Giohang;
import com.example.app_ban_hang.model.New_Product;

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;
import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.MyViewHolder> {
    New_Product sanPhamMoi;
        Context context;
        List<Giohang> giohangList;
        int poss ;




    public GioHangAdapter (Context context, List<Giohang> giohangList) {
        this.context = context;
        this.giohangList = giohangList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_giohang,parent,false);
        return new MyViewHolder (view);
    }

    public void Remove_product(View view, int pos){
        AlertDialog.Builder builder = new AlertDialog.Builder (view.getRootView ().getContext ());
        builder.setTitle ("Thông báo");
        builder.setMessage ("Bạn có muốn xoá sản phẩm này khỏi giỏ hàng không");
        builder.setPositiveButton ("Đồng ý", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {
                utils.manggiohang.remove (pos);
                notifyDataSetChanged ();
                EventBus.getDefault ().postSticky (new Tinh_Tong_Event ());
            }
        });
        builder.setNegativeButton ("Huỷ", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss ();
            }
        });
        builder.show ();
        notifyDataSetChanged ();
    }

    @Override
    public void onBindViewHolder (@NonNull MyViewHolder holder, int position) {

        Giohang giohang = giohangList.get (position);
        holder.item_giohang_tensp.setText (giohang.getTensp ());
        holder.item_giohang_soluong.setText (giohang.getSoluong ()+" ");
        Glide.with (context).load (giohang.getHinhsp ()).into (holder.item_giohang_img);
        DecimalFormat decimalFormat = new DecimalFormat ("###,###,###");
        holder.item_giohang_gia.setText (decimalFormat.format (giohang.getGiasp ()));
        long gia = giohang.getSoluong ()*giohang.getGiasp ();
        holder.item_giohang_giaten.setText (decimalFormat.format (gia));
        holder.setImage_clicklistener (new Image_clicklistener () {
            @Override
            public void onImageClick (View view, int pos, int giatri) {
                poss = pos;
                Log.d ("TAG","onImageClick"+pos+"..."+giatri);
                if(giatri==1){
                    if(giohangList.get (pos).getSoluong ()>1){
                        int soluongmoi = giohangList.get (pos).getSoluong ()-1;
                        giohangList.get (pos).setSoluong (soluongmoi);

                        holder.item_giohang_soluong.setText (giohangList.get (pos).getSoluong ()+" ");
                        long gia = giohangList.get (pos).getSoluong ()*giohangList.get (pos).getGiasp ();
                        holder.item_giohang_giaten.setText (decimalFormat.format (gia));
                        EventBus.getDefault ().postSticky (new Tinh_Tong_Event ());
                    }
                    else if (giohangList.get (pos).getSoluong ()==1){
                        Remove_product (view, pos);
                }
                }else if(giatri==2){
                    if (giohangList.get (pos).getSoluong ()<=11){
                        int soluongmoi = giohangList.get (pos).getSoluong ()+1;
                        giohangList.get (pos).setSoluong (soluongmoi);
                        if(soluongmoi>10){
                            AlertDialog.Builder builder = new AlertDialog.Builder (view.getRootView ().getContext ());
                            builder.setTitle ("Thông báo");
                            builder.setMessage ("Sản phẩm vượt quá số lượng cho phép . Nếu bạn vẫn muốn mua hãy liên hệ với chủ shop");
                            builder.setPositiveButton ("Đồng ý", new DialogInterface.OnClickListener () {
                                @Override
                                public void onClick (DialogInterface dialogInterface, int i) {

                                    Intent intent = new Intent (context, LienheActivity.class);
                                    intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.startActivity (intent);
                                }
                            });
                            builder.setNegativeButton ("Huỷ", new DialogInterface.OnClickListener () {
                                @Override
                                public void onClick (DialogInterface dialogInterface, int i) {
                                    int soluongmoi = giohangList.get (pos).getSoluong ();
                                    giohangList.get (pos).setSoluong (soluongmoi=10);

                                    dialogInterface.dismiss ();
                                    holder.item_giohang_soluong.setText (giohangList.get (pos).getSoluong ()+" ");
                                }
                            });
                            builder.show ();


                        }

                    }

                }

            }
        });
        

    }

    @Override
    public int getItemCount ( ) {
        return giohangList.size ();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView item_giohang_img, img_tru,img_cong;

        Image_clicklistener image_clicklistener;
        TextView item_giohang_tensp, item_giohang_gia, item_giohang_soluong,item_giohang_giaten;
        public MyViewHolder (@NonNull View itemView) {
            super (itemView);
            item_giohang_img = itemView.findViewById (R.id.item_giohang_img);
            item_giohang_tensp = itemView.findViewById (R.id.item_giohang_tensp);
            item_giohang_gia = itemView.findViewById (R.id.item_giohang_gia);
            item_giohang_soluong = itemView.findViewById (R.id.item_giohang_soluong);
            item_giohang_giaten = itemView.findViewById (R.id.item_giohang_giatien);
            img_tru = itemView.findViewById (R.id.item_giohang_tru);
            img_cong = itemView.findViewById (R.id.item_giohang_cong);

            //event click

            img_cong.setOnClickListener (this);
            img_tru.setOnClickListener (this);
            itemView.setOnLongClickListener (this);
        }

        public void setImage_clicklistener (Image_clicklistener image_clicklistener) {
            this.image_clicklistener = image_clicklistener;
        }

        @Override
        public void onClick (View view) {
            if(view==img_tru){
                image_clicklistener.onImageClick (view , getAdapterPosition (),1);
                //1 tru
            }else if(view==img_cong){
                image_clicklistener.onImageClick (view,getAdapterPosition (),2);
            }
        }


        @Override
        public boolean onLongClick (View view ) {

            Remove_product (view, poss);
            return true;
        }
    }
}
