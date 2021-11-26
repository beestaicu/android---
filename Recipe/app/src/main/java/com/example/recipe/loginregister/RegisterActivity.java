package com.example.recipe.loginregister;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recipe.R;


public class RegisterActivity extends AppCompatActivity {
    EditText et_user;
    EditText et_psw;
    EditText et_psw_again;
    String code_register;
    String psw_register;
    String pass_again;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button return_main = findViewById(R.id.return_main);
        return_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.setClass(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(in);
            }
        });
       Button register=(Button)findViewById(R.id.btn_register);
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 register();
             }
         });

    }
    public void register() {
        et_user = findViewById(R.id.et_user_code);
        et_psw = findViewById(R.id.et_psw);
        et_psw_again = findViewById(R.id.et_psw_again);
        code_register = et_user.getText().toString();
        psw_register = et_psw.getText().toString();
        pass_again = et_psw_again.getText().toString();
        MySQLiteOpenHelper dbHelper = new MySQLiteOpenHelper(RegisterActivity.this,
                "sys_user", 2);
        // 调用getReadableDatabase()方法创建或打开一个可以读的数据库
        SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();

         //查询
        Cursor cursor2 = sqliteDatabase.query("user", null, null, null, null, null, null);
        //查询
//        int id=0;
        String user_code = null;
        String user_pass = null;
        String user_pass_again = null;

        //将光标移动到下一行，从而判断该结果集是否还有下一条数据
        //如果有则返回true，没有则返回false
        if (cursor2.moveToFirst()) {
            for (int i = 0; i < cursor2.getCount(); i++) {
                cursor2.move(i);
                 int id = cursor2.getInt(0);
                user_code = cursor2.getString(1);
                user_pass = cursor2.getString(2);
                user_pass_again = cursor2.getString(3);
                //输出查询结果
                System.out.println("id:" + id + "  查询到的数据是:账号 " + user_code + "  密码" + user_pass + "  再次输入密码" + user_pass_again);
                if(user_code.equals(code_register)){
                   midToast("账号已经存在,请重新注册",1000);
                   //清空
                   et_user.setText("");
                    System.out.println("***********************");
                }else
                if(code_register.isEmpty()||psw_register.isEmpty()){
                    midToast("注册账号和密码不能为空", 2000);
                }else if (psw_register.equals(pass_again)) {
                    midToast("注册成功,请登录", 2000);
                    Intent it2 = new Intent();
                    it2.setClass(RegisterActivity.this, LoginActivity.class);
                    RegisterActivity.this.startActivity(it2);
                    // 创建ContentValues对象
                    ContentValues values3 = new ContentValues();

                    // 向该对象中插入键值对
                    values3.put("user_code", code_register);
                    values3.put("user_pass", psw_register);
                    values3.put("user_pass_again", pass_again);
                    // 调用insert()方法将数据插入到数据库当中
                    System.out.println("插入数据");
                    sqliteDatabase.insert("user", null, values3);
                    System.out.println("cursor.getCount()"+cursor2.getCount());
                } else if(psw_register!=pass_again){
                    midToast("注册失败，请核对密码", 2000);
                    System.out.println("删除数据");
                    //清空
                    et_psw.setText("");
                    et_psw_again.setText("");
                }
            }
            cursor2.close();
        }
//        if(user_code.equals(code_register)){
//            Toast.makeText(RegisterActivity.this, "账号已存在请重新注册", Toast.LENGTH_SHORT).show();
////                    et_user.setText("");
////                    String sql="delete from user where id="+id;
////                    sqliteDatabase.execSQL(sql);
//        }

        sqliteDatabase.close();
    }
    private void midToast(String str, int showTime)
    {
        Toast toast = Toast.makeText(RegisterActivity.this, str, showTime);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM , 0, 0);  //设置显示位置
        toast.show();
    }
    }