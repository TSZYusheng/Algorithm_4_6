package com.example.zuoye2.TestTaker4;

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
import com.example.zuoye2.TestTaker5.HomeThis5;
import com.example.zuoye2.TestTaker6.HomeThis6;

import java.util.ArrayList;

public class HomeThis4 extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private EditText mIntputET1;
    private Button mOutputBTN1;
    private EditText mIntputET2;
    private Button mOutputBTN2;
    private EditText mIntputET3;
    private Button mOutputBTN3;
    private TextView mOutputTV;
    private ArrayList<Integer> results= new ArrayList<>();
    private int dontPassLine;
    private int pass;
    private int medium;
    private int good1;
    private int good2;
    private String Student[][]=new String[5][3];
    private int jishu=0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.TaskMenu4:
                intent = new Intent(HomeThis4.this, HomeThis4.class);
                startActivity(intent);
                break;
            case R.id.TaskMenu5:
                intent = new Intent(HomeThis4.this, HomeThis5.class);
                startActivity(intent);
                break;
            case R.id.TaskMenu6:
                intent = new Intent(HomeThis4.this, HomeThis6.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homethis4_layout);
        initView();
    }

    private void initView() {
        mIntputET1 = (EditText) findViewById(R.id.IntputET1);
        mOutputBTN1 = (Button) findViewById(R.id.OutputBTN1);
        mIntputET2 = (EditText) findViewById(R.id.IntputET2);
        mOutputBTN2 = (Button) findViewById(R.id.OutputBTN2);
        mIntputET3 = (EditText) findViewById(R.id.IntputET3);
        mOutputBTN3 = (Button) findViewById(R.id.OutputBTN3);
        mOutputTV = (TextView) findViewById(R.id.OutputTV);
        mOutputBTN1.setOnClickListener(this);
        mOutputBTN2.setOnClickListener(this);
        mOutputBTN3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.OutputBTN1:
                submit1();
                break;
            case R.id.OutputBTN2:
                submit2();
                break;
            case R.id.OutputBTN3:
                submit3();
                break;
        }
    }
    public void submit1(){
    String IntputET1String = mIntputET1.getText().toString().trim();
    if (TextUtils.isEmpty(IntputET1String)||!(Integer.valueOf(IntputET1String)>=2&&Integer.valueOf(IntputET1String)<=10)) {
        Toast.makeText(this, "请输入2到10的整数", Toast.LENGTH_SHORT).show();
        return;
    }else {
        int n = Integer.valueOf(IntputET1String);
        int sum=2;
        int sum1=3;
        for (int i=2;i<=n;i++){
            sum=sum*2;
            sum1+=sum;
        }
        mIntputET1.setText(sum1+"");
    }
}
    public void submit2() {
        String IntputET2String = mIntputET2.getText().toString().trim();
        if (TextUtils.isEmpty(IntputET2String)) {
            Toast.makeText(this, "录入成绩", Toast.LENGTH_SHORT).show();
            return;
        }else {
            if (Integer.valueOf(IntputET2String)==-1){
                for (int i = 0; i < results.size(); i++) {
                    int result =  results.get(i);
                    switch (result/10){
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            dontPassLine +=1;
                            break;
                        case 6:
                            pass +=1;
                            break;
                        case 7:
                            medium +=1;
                            break;
                        case 8:
                            good1 +=1;
                            break;
                        case 9:
                        case 10:
                            good2 +=1;
                            break;
                    }
                }
                mIntputET2.setText("不及格："+ dontPassLine +"  及格："+ pass +"  中等："+ medium +"  良好："+ good1 +"  优秀："+ good2);
                results=new ArrayList<>();
                dontPassLine=0;
                medium=0;
                pass=0;
                good1=0;
                good2=0;
            }else {
                results.add(Integer.valueOf(IntputET2String));
                mIntputET2.setText("");
            }
        }
    }
    public void submit3(){
        String IntputET3String = mIntputET3.getText().toString().trim();
        if (TextUtils.isEmpty(IntputET3String)) {
            Toast.makeText(this, "录入学号-姓名-年龄", Toast.LENGTH_SHORT).show();
            return;
        }else {
            if (jishu<=4){
                mOutputTV.setText("");
                String[] split = IntputET3String.split("-");
                if (split.length!=3){
                    Toast.makeText(this, "录入学号-姓名-年龄", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    for (int i=0;i<=split.length-1;i++){
                        Student[jishu][i]=split[i];
                    }
                    jishu++;
                    mIntputET3.setText("");
                }
            }else {
                for (int i=0;i<Student.length-1;i++){
                    for (int j=0;j<Student.length-1-i;j++){
                        if (Integer.valueOf(Student[j][0])>Integer.valueOf(Student[j+1][0])){
                            int id=Integer.valueOf(Student[j][0]);
                            String  name=Student[j][1];
                            String age=Student[j][2];
                            Student[j][0]=Student[j+1][0];
                            Student[j][1]=Student[j+1][1];
                            Student[j][2]=Student[j+1][2];
                            Student[j+1][0]=id+"";
                            Student[j+1][1]=name;
                            Student[j+1][2]=age;
                        }
                    }
                }
                int sum=0;

                for (int i=0;i<=Student.length-1;i++){
                    Student[i][2]=String.valueOf(Integer.valueOf(Student[i][2])+1);
                    if(Integer.valueOf( Student[i][2])>20){
                        sum++;
                    }
                    mOutputTV.append("学号："+Student[i][0]+"  姓名："+Student[i][1]+"  年龄："+Student[i][2]+"\n");

                }
                mOutputTV.append("年龄大于20的人数："+sum);
                jishu=0;

            }
        }

    }
}
