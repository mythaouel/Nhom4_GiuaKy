package com.n04.g701.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.n04.g701.R;
import com.n04.g701.model.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int item_layout;
    private List<Product> products;

    public ProductAdapter(Context context, int item_layout, List<Product> products) {
        this.context = context;
        this.item_layout = item_layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get( i );
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            view = inflater.inflate( item_layout,null );
            holder.imvThumb = view.findViewById( R.id.imvThumb );
            holder.txtName = view.findViewById( R.id.txtName );
            holder.txtPrice = view.findViewById( R.id.txtPrice );
            view.setTag( holder );
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Product p = products.get( i );
        holder.txtName.setText( p.getProductName() );
        holder.txtPrice.setText( String.valueOf( p.getProductPrice() ) );

        //Conver byte array -> bitmap
        byte[] photo = p.getProductThumb();
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
        holder.imvThumb.setImageBitmap( bitmap );
        return view;
    }

    private static class ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtPrice;
    }
}
