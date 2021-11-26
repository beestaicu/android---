package com.example.recipe.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recipe.R;
import com.example.recipe.fragmentview.MainActivity;
import com.example.recipe.mysql.MysqlActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText edit_username;
    private EditText edit_password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button usemysql=(Button)findViewById(R.id.usemysql);
        usemysql.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent it2 = new Intent();
        it2.setClass(LoginActivity.this, MysqlActivity.class);
        Toast.makeText(LoginActivity.this, "数据库管理", Toast.LENGTH_SHORT).show();
        LoginActivity.this.startActivity(it2);
    }
});

        Button tv_register = findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                MySQLiteOpenHelper dbHelper6 = new MySQLiteOpenHelper(LoginActivity.this,
//                        "sys_user", 2);
//                // 调用getReadableDatabase()方法创建或打开一个可以读的数据库
//                SQLiteDatabase sqliteDatabase6 = dbHelper6.getWritableDatabase();
                Intent it = new Intent();
                it.setClass(LoginActivity.this, RegisterActivity.class);
                Toast.makeText(LoginActivity.this, "欢迎来到注册页面", Toast.LENGTH_SHORT).show();
                LoginActivity.this.startActivity(it);
            }
        });


        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verification();
            }
        });

    }
    public void verification() {
        edit_username = findViewById(R.id.et_user_name);
        edit_password = findViewById(R.id.et__user_psw);
        String code = edit_username.getText().toString();
        String pass = edit_password.getText().toString();
        MySQLiteOpenHelper dbHelper = new MySQLiteOpenHelper(LoginActivity.this,
                "sys_user", 2);
        // 调用getReadableDatabase()方法创建或打开一个可以读的数据库
        SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();

        Cursor cursor2 = sqliteDatabase.query("user", null, null, null, null, null, null);
        String user_code = null;
        String user_pass = null;
        //将光标移动到下一行，从而判断该结果集是否还有下一条数据
        //如果有则返回true，没有则返回false
        if (cursor2.moveToFirst()) {
            for (int i = 0; i < cursor2.getCount(); i++) {
                cursor2.move(i);
                user_code = cursor2.getString(1);
                user_pass = cursor2.getString(2);
                //输出查询结果
                System.out.println("user_code " + user_code + "------user_pass" + user_pass);
                if (code.equals(user_code) && pass.equals(user_pass)) {
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (code.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
               }
//                else if (code != user_code || pass != user_pass) {
//             Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
//            startActivity(intent2);
//                    Toast.makeText(LoginActivity.this, "账号与密码输入不正确，请先注册或者重新输入", Toast.LENGTH_SHORT).show();
//                }
            }
                cursor2.close();

        }
        dbHelper.close();
    }
}