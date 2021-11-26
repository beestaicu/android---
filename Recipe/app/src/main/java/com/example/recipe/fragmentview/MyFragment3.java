package com.example.recipe.fragmentview;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recipe.R;
import com.example.recipe.jishiqi.OneActivity;
import com.example.recipe.jishiqi.TwoActivity;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment3 extends Fragment {
Button jishiqi;
Button daijishi;

    public MyFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content3, container, false);
        jishiqi=view.findViewById(R.id.jishiqi);
        daijishi=view.findViewById(R.id.daojishiqi);
        jishiqi.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.setClass(getActivity(), OneActivity.class);
                startActivity(intent1);
            }
        });
        daijishi.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               Intent intent2=new Intent();
                intent2.setClass(getActivity(), TwoActivity.class);
                startActivity(intent2);
            }
        });
        Log.e("HEHE", "第三个");
        return view;
}
}