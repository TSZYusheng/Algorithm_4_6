package com.example.zuoye2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zuoye2.TestTaker4.HomeThis4;
import com.example.zuoye2.TestTaker5.HomeThis5;
import com.example.zuoye2.TestTaker6.HomeThis6;

public class HomeThis extends AppCompatActivity implements View.OnClickListener {

    private Button mTask4;
    private Button mTask5;
    private Button mTask6;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homethis_layout);
        initView();

    }

    private void initView() {
        mTask4 = (Button) findViewById(R.id.Task4);
        mTask5 = (Button) findViewById(R.id.Task5);
        mTask6 = (Button) findViewById(R.id.Task6);

        mTask4.setOnClickListener(this);
        mTask5.setOnClickListener(this);
        mTask6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Task4:
                intent = new Intent(HomeThis.this, HomeThis4.class);
                startActivity(intent);

                break;
            case R.id.Task5:
                intent = new Intent(HomeThis.this, HomeThis5.class);
                startActivity(intent);
                break;
            case R.id.Task6:
                intent = new Intent(HomeThis.this, HomeThis6.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.TaskMenu4:
                intent = new Intent(HomeThis.this, HomeThis4.class);
                startActivity(intent);
                break;
            case R.id.TaskMenu5:
                intent = new Intent(HomeThis.this, HomeThis5.class);
                startActivity(intent);
                break;
            case R.id.TaskMenu6:
                intent = new Intent(HomeThis.this, HomeThis6.class);
                startActivity(intent);
                break;
        }
        return true;
    }



}
