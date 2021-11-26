package com.example.recipe.fragmentview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recipe.R;
import com.example.recipe.notepade.NotePadActivity;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment2 extends Fragment {

    public MyFragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content2, container, false);
        Button jishiben=view.findViewById(R.id.jishiben);
        jishiben.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), NotePadActivity.class);
                startActivity(intent);
            }
        });
        Log.e("HEHE", "第二个");
        return view;
    }
}