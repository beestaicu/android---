package com.example.recipe.mysql;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recipe.R;
import com.example.recipe.loginregister.LoginActivity;
import com.example.recipe.loginregister.MySQLiteOpenHelper;

public class MysqlActivity extends AppCompatActivity implements View.OnClickListener {
    private Button query;
    private Button delete_database;
    private  Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mysql_activity);

        //绑定按钮

        query = (Button) findViewById(R.id.query);
        delete_database = (Button) findViewById(R.id.delete_database);
        insert=(Button)findViewById(R.id.insert);
        Button returntomain=findViewById(R.id.returntomain);

        //设置监听器
        query.setOnClickListener(this);
        delete_database.setOnClickListener(this);
        insert.setOnClickListener(this);
        returntomain.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击插入数据到数据库
            case R.id.insert:

                System.out.println("插入数据");

                // 创建SQLiteOpenHelper子类对象
                ////注意，一定要传入最新的数据库版本号
                MySQLiteOpenHelper dbHelper1 = new MySQLiteOpenHelper(MysqlActivity.this,
                        "sys_user", 2);
                // 调用getReadableDatabase()方法创建或打开一个可以读的数据库
                SQLiteDatabase sqliteDatabase1 = dbHelper1.getWritableDatabase();
                //查询
                Cursor cursor1 = sqliteDatabase1.query("user", null, null, null, null, null, null);

                ContentValues values3 = new ContentValues();

                // 向该对象中插入键值对
                values3.put("user_code", "xulong");
                values3.put("user_pass", "20000203");
                values3.put("user_pass_again", "20000203");
                // 调用insert()方法将数据插入到数据库当中
                System.out.println("插入数据");
                sqliteDatabase1.insert("user", null, values3);
                System.out.println("数据库数据行数：  "+cursor1.getCount());

                // sqliteDatabase.execSQL("insert into user (id,name) values (1,'carson')");

                //关闭数据库
                sqliteDatabase1.close();

                break;

            //点击查询数据库
            case R.id.query:

                System.out.println("查询数据");
                // 创建DatabaseHelper对象
                MySQLiteOpenHelper dbHelper2= new MySQLiteOpenHelper(MysqlActivity.this,
                        "sys_user", 2);
                // 调用getReadableDatabase()方法创建或打开一个可以读的数据库
                SQLiteDatabase sqliteDatabase2 = dbHelper2.getWritableDatabase();

                // 调用SQLiteDatabase对象的query方法进行查询
                // 返回一个Cursor对象：由数据库查询返回的结果集对象
                //查询
                Cursor cursor2 = sqliteDatabase2.query("user", null, null, null, null, null, null);
                //查询
                int id=0;
                String user_code = null;
                String user_pass = null;
                String user_pass_again = null;

                //将光标移动到下一行，从而判断该结果集是否还有下一条数据
                //如果有则返回true，没有则返回false
                if (cursor2.moveToFirst()) {
                    for (int i = 0; i < cursor2.getCount(); i++) {
                        cursor2.move(i);
                        id = cursor2.getInt(0);
                        user_code = cursor2.getString(1);
                        user_pass = cursor2.getString(2);
                        user_pass_again = cursor2.getString(3);
                        //输出查询结果
                        System.out.println("id:" + id + "     查询到的数据是:账号 " + user_code + "  密码" + user_pass + "  再次输入密码" + user_pass_again);
                    }
                    cursor2.close();
                }
                //关闭数据库
                sqliteDatabase2.close();

                break;
            //点击删除数据库
            case R.id.delete_database:

                System.out.println("删除数据库");

                MySQLiteOpenHelper dbHelper3 = new MySQLiteOpenHelper(MysqlActivity.this,
                        "sys_user", 2);
                // 调用getReadableDatabase()方法创建或打开一个可以读的数据库
                SQLiteDatabase sqliteDatabase3 = dbHelper3.getWritableDatabase();

                //删除名为test.db数据库
                deleteDatabase("sys_user");
                break;
            case R.id.returntomain:

                System.out.println("返回主页");
                Intent it3=new Intent().setClass(MysqlActivity.this, LoginActivity.class);
                startActivity(it3);
                break;
            default:
                break;

        }
    }
}
