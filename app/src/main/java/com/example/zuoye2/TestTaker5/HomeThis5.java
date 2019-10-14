package com.example.zuoye2.TestTaker5;

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
import com.example.zuoye2.TestTaker6.HomeThis6;

public class HomeThis5 extends AppCompatActivity {
    private Intent intent;
    private TextView mOutputTV1;
    private TextView mOutputTV2;
    private TextView mOutputTV3;
    private TextView mOutputTV4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homethis5_layout);
        initView();
        for (int i = 100; i <= 1000; i++) {
            if (prime(i) && prime(i + 2)) {
                mOutputTV1.append(i + "和" + (i + 2) + "是姐妹素数" + "   ");
            }
        }
        int sum=noRecursive(2)+noRecursive(4)+noRecursive(5);
        int sum1=Recursive(2)+Recursive(4)+Recursive(5);
        mOutputTV2.setText("非递归："+sum);
        mOutputTV3.setText("递归："+sum1);
        double Area[]=new double[3];
        Triangle triangle = new Triangle(5,8);
        Area[0] = triangle.calArea();
        Rectangle rectangle = new Rectangle(5, 4);
        Area[1] = rectangle.calArea();
        Circle circle = new Circle(5);
        Area[2] = circle.calArea();
        for (int i=0;i<Area.length;i++){
            switch (i){
                case 0:
                    mOutputTV4.append("三角形："+Area[i]+"\n");
                    break;
                case 1:
                    mOutputTV4.append("矩形："+Area[i]+"\n");
                    break;
                case 2:
                    mOutputTV4.append("圆："+Area[i]+"\n");
                    break;

            }
        }
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
                intent = new Intent(HomeThis5.this, HomeThis4.class);
                startActivity(intent);
                break;
            case R.id.TaskMenu5:
                intent = new Intent(HomeThis5.this, HomeThis5.class);
                startActivity(intent);
                break;
            case R.id.TaskMenu6:
                intent = new Intent(HomeThis5.this, HomeThis6.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    private void initView() {
        mOutputTV1 = (TextView) findViewById(R.id.OutputTV1);
        mOutputTV2 = (TextView) findViewById(R.id.OutputTV2);
        mOutputTV3 = (TextView) findViewById(R.id.OutputTV3);
        mOutputTV4 = (TextView) findViewById(R.id.OutputTV4);
    }

    public boolean prime(int n) {
        boolean flag = true;
        for (int j = 2; j <= n; j++) {
            if (n % j == 0 && n != j) {
                flag = false;
                break;
            }
        }


        return flag;
    }

    public int noRecursive(int n) {
        int sum=1;
        for (int i=1;i<=n;i++){
            sum*=i;
        }
    return sum;
    }
    public int Recursive(int n){
        if(n==1){
            return 1;
        }
        return Recursive(n-1)*n;
        }



    }




