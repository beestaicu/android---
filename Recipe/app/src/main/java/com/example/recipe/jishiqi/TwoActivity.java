package com.example.recipe.jishiqi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipe.R;
import com.example.recipe.fragmentview.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputet;
    private Button get, startTime, stopTime;
    Button tuichu;
    private TextView time;
    private int i = 0;
    private Timer timer = null;
    private TimerTask task = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daojishi_activity);

        initView();
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(TwoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        inputet = findViewById(R.id.input);
        get = findViewById(R.id.get);
        startTime = findViewById(R.id.starttime);
        stopTime = findViewById(R.id.stoptime);
        time = findViewById(R.id.time);
        tuichu=findViewById(R.id.tuichu);
        get.setOnClickListener(this);
        startTime.setOnClickListener(this);
        stopTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get:
                time.setText(inputet.getText().toString());
                i = Integer.parseInt(inputet.getText().toString());
                break;
            case R.id.starttime:
                startTime();
                break;
            case R.id.stoptime:
                stopTime();
                break;
            default:
                break;
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            time.setText(msg.arg1 + "");
            startTime();
        };
    };

    public void startTime() {
        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                if (i > 0) {  //????????????????????????0
                    i--;
                    Message message = mHandler.obtainMessage();
                    message.arg1 = i;
                    mHandler.sendMessage(message);
                }
            }
        };
        timer.schedule(task, 1000);
    }
    public void stopTime(){
        timer.cancel();
    }
}

