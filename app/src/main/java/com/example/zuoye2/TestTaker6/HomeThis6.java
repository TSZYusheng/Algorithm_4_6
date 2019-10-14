package com.example.zuoye2.TestTaker6;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zuoye2.R;
import com.example.zuoye2.TestTaker4.HomeThis4;
import com.example.zuoye2.TestTaker5.HomeThis5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HomeThis6 extends AppCompatActivity{
    private Intent intent;
    private TextView mOutputTV1;
    private TextView mOutputTV2;
    private EditText mIntputET;
    private Button mOutputBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homethis6_layout);
        initView();
        Task1();
        Task2();
        mOutputBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pay = Integer.valueOf(mIntputET.getText().toString())-3000;
                double money;
                    if(pay!=0){
                        if(pay>1500){
                            money=1500*0.05;
                            money=money+(pay-1500)*0.1;
                            if(pay>4500){
                                money=money+(pay-4500)*0.2;
                                if(pay>9000){
                                    money=money+(pay-9000)*0.25;
                                    if(pay>35000){
                                        money=money+(pay-9000)*0.3;
                                        if(pay>55000){
                                            money=money+(pay-55000)*0.35;
                                            if(pay>80000){
                                                money=money+(pay-80000)*0.45;
                                                mIntputET.setText("你应缴纳的个人所得税为"+money);
                                            }else {
                                                mIntputET.setText("你应缴纳的个人所得税为"+money);
                                            }
                                        }else {
                                            mIntputET.setText("你应缴纳的个人所得税为"+money);
                                        }
                                    }else {
                                        mIntputET.setText("你应缴纳的个人所得税为"+money);
                                    }
                                }else {
                                    mIntputET.setText("你应缴纳的个人所得税为"+money);
                                }
                            }else {
                                mIntputET.setText("你应缴纳的个人所得税为"+money);
                            }
                        } else {
                            money=pay*0.05;
                            mIntputET.setText("你应缴纳的个人所得税为"+money);
                        }
                    }else {
                        mIntputET.setText("你应缴纳的个人所得税为0");
                    }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.TaskMenu4:
                intent = new Intent(HomeThis6.this, HomeThis4.class);
                startActivity(intent);
                break;
            case R.id.TaskMenu5:
                intent = new Intent(HomeThis6.this, HomeThis5.class);
                startActivity(intent);
                break;
            case R.id.TaskMenu6:
                intent = new Intent(HomeThis6.this, HomeThis6.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    public void Task1() {
        double Array[] = {9.8, 12, 45, 67, 23, 1.98, 2.55, 45};
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array.length - i - 1; j++) {
                if (Array[j] > Array[j + 1]) {
                    double num = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = num;
                }
            }

        }
        double sum = 0;
        for (int i = 0; i < Array.length; i++) {

            sum += Array[i];
        }
        sum = sum / Array.length;
        mOutputTV1.setText("最大值：" + Array[Array.length - 1] + "   最小值：" + Array[0] + "   平均值：" + sum);

    }

    public void Task2() {
        String a[] = {"FEDCBA"};
        for (int i = 0; i < a.length; i++) {
            mOutputTV2.setText(a[i]);
        }
        File file = new File("/storage/emulated/0/WriteArr.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(a[0]);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        mOutputTV1 = (TextView) findViewById(R.id.OutputTV1);
        mOutputTV2 = (TextView) findViewById(R.id.OutputTV2);
        mIntputET = (EditText) findViewById(R.id.IntputET);
        mOutputBTN = (Button) findViewById(R.id.OutputBTN);

    }


}
