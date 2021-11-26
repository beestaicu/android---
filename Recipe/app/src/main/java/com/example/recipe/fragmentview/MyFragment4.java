package com.example.recipe.fragmentview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.example.recipe.R;
import com.example.recipe.usespinner.SpinnerActivity;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends Fragment {

    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content4, container, false);
        Button updateuser=view.findViewById(R.id.updateuser);
        updateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent();
                it.setClass(getContext(), SpinnerActivity.class);
               getActivity().startActivity(it);
            }
        });
        Log.e("HEHE", "第四个");
        return view;
    }
}