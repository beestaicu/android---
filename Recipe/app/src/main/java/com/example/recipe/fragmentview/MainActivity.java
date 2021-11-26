package com.example.recipe.fragmentview;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.recipe.R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Coder-pig on 2015/8/28 0028.
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {
    //1.定义不同颜色的菜单项的标识:
    final private int RED = 110;
    final private int GREEN = 111;
    final private int BLUE = 112;
    final private int YELLOW = 113;
    final private int GRAY = 114;
    final private int CYAN = 115;
    final private int BLACK = 116;


    //UI Objects
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;
//几个用于添加列表的常量
private List<Fruit> menudatas;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //主要部分的Java代码
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_channel.setChecked(true);
    }

    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_channel = (RadioButton) findViewById(R.id.rb_channel);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_better = (RadioButton) findViewById(R.id.rb_better);
        rb_setting = (RadioButton) findViewById(R.id.rb_setting);
        rg_tab_bar.setOnCheckedChangeListener(this);
        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_channel:
                vpager.setCurrentItem(PAGE_ONE);
                txt_topbar.setText("主页");
                break;
            case R.id.rb_message:
                vpager.setCurrentItem(PAGE_TWO);
                txt_topbar.setText("记事本");
                break;
            case R.id.rb_better:
                vpager.setCurrentItem(PAGE_THREE);
                txt_topbar.setText("计时器");
                break;
            case R.id.rb_setting:
                vpager.setCurrentItem(PAGE_FOUR);
                txt_topbar.setText("个人中心");
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_channel.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_message.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_better.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_setting.setChecked(true);
                    break;
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(1, RED, 4, "红色");
        menu.add(1, GREEN, 2, "绿色");
        menu.add(1, BLUE, 3, "蓝色");
        menu.add(1, YELLOW, 1, "黄色");
        menu.add(1, GRAY, 5, "灰色");
        menu.add(1, CYAN, 6, "蓝绿色");
        menu.add(1, BLACK, 7, "黑色");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case RED:
                Toast.makeText(MainActivity.this,"字体颜色设置为红色",Toast.LENGTH_SHORT).show();
              txt_topbar.setTextColor(Color.RED);
              rb_better.setTextColor(Color.RED);
              rb_channel.setTextColor(Color.RED);
              rb_message.setTextColor(Color.RED);
              rb_setting.setTextColor(Color.RED);
                break;
            case GREEN:
                Toast.makeText(MainActivity.this,"字体颜色设置为绿色",Toast.LENGTH_SHORT).show();
                txt_topbar.setTextColor(Color.GREEN);
                rb_better.setTextColor(Color.GREEN);
                rb_channel.setTextColor(Color.GREEN);
                rb_message.setTextColor(Color.GREEN);
                rb_setting.setTextColor(Color.GREEN);

                break;
            case BLUE:
                Toast.makeText(MainActivity.this,"字体颜色设置为蓝色",Toast.LENGTH_SHORT).show();
                txt_topbar.setTextColor(Color.BLUE);
                rb_better.setTextColor(Color.BLUE);
                rb_channel.setTextColor(Color.BLUE);
                rb_message.setTextColor(Color.BLUE);
                rb_setting.setTextColor(Color.BLUE);

                break;
            case YELLOW:
                Toast.makeText(MainActivity.this,"字体颜色设置为黄色",Toast.LENGTH_SHORT).show();
                txt_topbar.setTextColor(Color.YELLOW);
                rb_better.setTextColor(Color.YELLOW);
                rb_channel.setTextColor(Color.YELLOW);
                rb_message.setTextColor(Color.YELLOW);
                rb_setting.setTextColor(Color.YELLOW);

                break;
            case GRAY:
                Toast.makeText(MainActivity.this,"字体颜色设置为灰色",Toast.LENGTH_SHORT).show();
                txt_topbar.setTextColor(Color.GRAY);
                rb_better.setTextColor(Color.GRAY);
                rb_channel.setTextColor(Color.GRAY);
                rb_message.setTextColor(Color.GRAY);
                rb_setting.setTextColor(Color.GRAY);

                break;
            case CYAN:
                Toast.makeText(MainActivity.this,"字体颜色设置为青色",Toast.LENGTH_SHORT).show();
                txt_topbar.setTextColor(Color.CYAN);
                rb_better.setTextColor(Color.CYAN);
                rb_channel.setTextColor(Color.CYAN);
                rb_message.setTextColor(Color.CYAN);
                rb_setting.setTextColor(Color.CYAN);

                break;
            case BLACK:
                Toast.makeText(MainActivity.this,"字体颜色设置为黑色",Toast.LENGTH_SHORT).show();
                txt_topbar.setTextColor(Color.BLACK);
                rb_better.setTextColor(Color.BLACK);
                rb_channel.setTextColor(Color.BLACK);
                rb_message.setTextColor(Color.BLACK);
                rb_setting.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}