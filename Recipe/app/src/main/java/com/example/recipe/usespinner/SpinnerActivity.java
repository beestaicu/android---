package com.example.recipe.usespinner;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.recipe.R;
import com.example.recipe.fragmentview.MainActivity;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //对话框的代码
    Button baocun;
    private View view_custom;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    private Spinner spin_one;
    private Spinner spin_two;
    private Context mContext;
    //判断是否为刚进去时触发onItemSelected的标志
    private boolean one_selected = false;
    private boolean two_selected = false;
    private ArrayList<Hero> mData = null;
    private BaseAdapter myAdadpter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_user);
        mData = new ArrayList<Hero>();
        bindViews();

        mContext = SpinnerActivity.this;
        System.out.println("11111111111111111");
        baocun=(Button)findViewById(R.id.baocunxiugai);
        //对话框部分的代码
        //初始化Builder
        System.out.println("2222222222222222");
        builder = new AlertDialog.Builder(mContext);

        //加载自定义的那个View,同时设置下
        System.out.println("333333333333333333");
        final LayoutInflater inflater = SpinnerActivity.this.getLayoutInflater();
        view_custom = inflater.inflate(R.layout.view_dialog_custom, null,false);
        builder.setView(view_custom);
        builder.setCancelable(false);
        alert = builder.create();

        System.out.println("4444444444444444");
        view_custom.findViewById(R.id.btn_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });
        System.out.println("555555555555555555");
        view_custom.findViewById(R.id.btn_blog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "保存修改", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(SpinnerActivity.this,MainActivity.class);
                SpinnerActivity.this.startActivity(intent);
                alert.dismiss();
            }
        });
        System.out.println("77777777");
        view_custom.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "对话框已关闭~", Toast.LENGTH_SHORT).show();
                alert.dismiss();
            }
        });




        baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("666666666666666666666");
                alert.show();
            }
        });
    }


    private void bindViews() {
        System.out.println("bindViews say:*********************");
        spin_one = (Spinner) findViewById(R.id.spin_one);
        spin_two = (Spinner) findViewById(R.id.spin_two);
        mData.add(new Hero(R.drawable.xiaodangjia,"男生"));
        mData.add(new Hero(R.drawable.zhoumeili,"女生"));
        myAdadpter = new MyAdapter<Hero>(mData, R.layout.item_spin_hero) {
            @Override
            public void bindView(ViewHolder holder, Hero obj) {
                holder.setImageResource(R.id.img_touxiang,obj.gethIcon());
                holder.setText(R.id.txt_sex, obj.gethName());
            }
        };
        spin_two.setAdapter(myAdadpter);
        spin_one.setOnItemSelectedListener(this);
        spin_two.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spin_one:
                if(one_selected){
                    Toast.makeText(mContext,"您的省份是" + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
                }else one_selected = true;
                break;
            case R.id.spin_two:
                if(two_selected){
                    TextView txt_name = (TextView) view.findViewById(R.id.txt_sex);
                    Toast.makeText(mContext,"您选择的性别是" + txt_name.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }else two_selected = true;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
