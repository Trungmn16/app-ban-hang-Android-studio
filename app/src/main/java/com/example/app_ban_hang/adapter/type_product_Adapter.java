package com.example.app_ban_hang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.app_ban_hang.R;
import com.example.app_ban_hang.model.type_product;

import java.util.List;

public class type_product_Adapter extends BaseAdapter {
    List<type_product> array;
    Context context;

    public type_product_Adapter (Context context ,List<type_product> array) {
        this.array = array;
        this.context = context;
    }

    @Override
    public int getCount ( ) {
        return array.size ();
    }

    @Override
    public Object getItem (int i) {
        return null;
    }

    @Override
    public long getItemId (int i) {
        return 0;
    }
    public class Viewholder{
        TextView txtname;
        ImageView imgImage;

    }

    @Override
    public View getView (int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder =null;
        if (view==null){
            viewholder= new Viewholder ();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate (R.layout.item_product,null);
            viewholder.txtname=view.findViewById (R.id.item_name);
            viewholder.imgImage=view.findViewById (R.id.item_image);
            view.setTag (viewholder);

        }else {
            viewholder = (Viewholder) view.getTag ();

        }
        viewholder.txtname.setText (array.get (i).getName ());
        Glide.with (context).load (array.get (i).getImage ()).into (viewholder.imgImage);
        return  view;
    }

}
