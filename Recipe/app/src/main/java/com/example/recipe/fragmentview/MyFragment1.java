package com.example.recipe.fragmentview;

import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.example.recipe.R;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyFragment1 extends Fragment {

    private List<Fruit> menudatas;
    private ListView list_menu;
    private FragmentManager fManager;

    public MyFragment1() {
    }


    public MyFragment1(FragmentManager fManager, List<Fruit> menudatas) {
        this.fManager = fManager;
        this.menudatas = menudatas;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content1, container, false);
        menudatas = new LinkedList<>();
        initFruits();
        list_menu = (ListView) view.findViewById(R.id.list_menu);
        MyMenuAdapter menuAdapter = new MyMenuAdapter(getActivity(), R.layout.fg_content1, menudatas);
        list_menu.setAdapter(menuAdapter);
       list_menu.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id){
                Fruit fruit = menudatas.get(position);
                Toast.makeText(getActivity(),fruit.getName(),Toast.LENGTH_SHORT).show();
            }


        });
        return view;

    }

    private void initFruits(){
        menudatas = new LinkedList<>();
        menudatas.clear();
        Fruit apple = new Fruit("鱼香肉丝",R.drawable.yuxiangrousi);
        menudatas.add(apple);
        Fruit banana = new Fruit("青椒肉丝",R.drawable.qingjiaorousi);
        menudatas.add(banana);
        Fruit orange = new Fruit("麻婆豆腐",R.drawable.mapodoufu);
        menudatas.add(orange);
        Fruit watermelon = new Fruit("冷吃兔",R.drawable.lengchitu);
        menudatas.add(watermelon);
        Fruit pear = new Fruit("红烧肉",R.drawable.hongshaorou);
        menudatas.add(pear);
//            Fruit grape = new Fruit("Grape",R.drawable.grape_pic);
//            fruitList.add(grape);
//            Fruit pineapple = new Fruit("Pineapple",R.drawable.pineapple_pic);
//            fruitList.add(pineapple);
//            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry_pic);
//            fruitList.add(strawberry);
//            Fruit cherry = new Fruit("Cherry",R.drawable.cherry_pic);
//            fruitList.add(cherry);
//            Fruit mango = new Fruit("Mango",R.drawable.mango_pic);
//            fruitList.add(mango);


    }
}