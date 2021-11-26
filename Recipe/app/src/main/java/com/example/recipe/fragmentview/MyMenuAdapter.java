package com.example.recipe.fragmentview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipe.R;

import java.util.List;

public class MyMenuAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public MyMenuAdapter(Context context, int textViewResourceId, List<Fruit> menudatas){
        super(context,textViewResourceId,menudatas);
        resourceId = textViewResourceId;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit = getItem(position); //获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) convertView.findViewById(R.id.img_icon);
            viewHolder.fruitName =(TextView) convertView.findViewById(R.id.txt_aSpeak);
           convertView.setTag(viewHolder);// 将ViewHolder存储在View中。
        }else
        {
            viewHolder=(ViewHolder)convertView.getTag(); //重新获取ViewHolder

        }
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        return convertView;
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }

}

