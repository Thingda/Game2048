package com.cskaoyan.lan.mygame2048;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OptionActivity extends ActionBarActivity implements View.OnClickListener {

    private Button bt_option_back ;
    private Button bt_option_done ;
    private Button bt_option_setline ;
    private Button bt_option_settarget;
    private TextView tv_option_line;
    private TextView tv_option_target;

    private  int line;
    private int target;
    private MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);


        //初始化textview
        tv_option_line = (TextView) findViewById(R.id.tv_option_line);
        tv_option_target = (TextView) findViewById(R.id.tv_option_target);


        //初始化button
        bt_option_back      = (Button) findViewById(R.id.bt_option_back);
        bt_option_done      = (Button) findViewById(R.id.bt_option_done);
        bt_option_setline   = (Button) findViewById(R.id.bt_option_setline);
        bt_option_settarget = (Button) findViewById(R.id.bt_option_settarget);

       bt_option_back     .setOnClickListener(this);
       bt_option_done     .setOnClickListener(this);
       bt_option_setline  .setOnClickListener(this);
       bt_option_settarget.setOnClickListener(this);

        app = (MyApplication) getApplication();

        line=app.getLineNumber();
        target=app.getTarget();

        //根据application里去获取sharedPreference取得之前用户保存的设置
        bt_option_setline.setText(line+"");
        bt_option_settarget.setText(target+"");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bt_option_setline:

                setline();
                break;
            case R.id.bt_option_settarget:

                setTarget();
                break;

            case R.id.bt_option_back:
                finish();
                break;

            case R.id.bt_option_done:
                done();
                break;
        }
    }

    private void done() {
        app.setLineNumber(line);
        app.setTarget(target);
        finish();
    }

    private void setline() {

        final String[] itmes ={"4","5","6"};


     new    AlertDialog.Builder(this)
             .setTitle("Change line")
             .setItems(itmes, new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {

                      line = Integer.parseInt(itmes[which]);
                      bt_option_setline.setText(line+"");

                 }
             })
             .show();

    }

    private void setTarget() {

        final String[] itmes ={"1024","2048","4096"};

        new    AlertDialog.Builder(this)
                .setTitle("Change Target")
                .setItems(itmes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                          target = Integer.parseInt(itmes[which]);
                          bt_option_settarget.setText(target+"");

                    }
                })
                .show();
    }
}
