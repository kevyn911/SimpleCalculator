package com.example.hpelitebook.calculator_vl;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity  extends Activity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private Button copy;
    private Button paste;
    private TextView info;
    private TextView result;
    private TextView memory;
    private Button sqrt;
    private Button sqr;
    private Button factor;
    private Button dot;
    private Button clearall;



    private final char ADDITION = '+';
    private final char SUBSTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';



    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private double res = Double.NaN;
    private double tmp1 = Double.NaN;
    private double tmp2 = Double.NaN;
    private char ACTION;

    public long factorial (long x)
    {
            long fact = 1;
            for (long i = 2; i <= x; i++)
                fact *= i;
            return fact;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(info.getText().toString()) || info.getText().equals("-")){
                    info.setText(null);
                }
                else {
                    ACTION = ADDITION;
                    compute();
                    result.setText(String.valueOf(val1) + "+");
                    info.setText(null);
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(info.getText().toString()) || info.getText().equals("-")){
                    info.setText("-");
                }
                else {
                    compute();
                    ACTION = SUBSTRACTION;
                    result.setText(String.valueOf(val1) + "-");
                    info.setText(null);
                }
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(info.getText().toString())) memory.setText(info.getText().toString());
                else if (Double.isNaN(res)) memory.setText(String.valueOf(0));
                else memory.setText(String.valueOf(res));
            }
        });
        paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (memory.getText().equals("_")) info.setText(null);
                else info.setText(memory.getText());
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(info.getText().toString()) || info.getText().equals("-")){
                    info.setText(null);
                }
                else {
                    tmp2 = Double.parseDouble(info.getText().toString());
                    if (tmp2<0) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "X повинен бути > 0!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 400);
                        toast.show();
                        info.setText(null);
                        tmp2 = Double.NaN;
                    }
                    else {
                        tmp1 = Math.sqrt(tmp2);
                        info.setText(String.valueOf(tmp1));
                        res = tmp1;
                    }
                }
            }
        });
        sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(info.getText().toString()) || info.getText().equals("-")){
                    info.setText(null);
                }
                else {
                    tmp2 = Double.parseDouble(info.getText().toString());
                    tmp1 = tmp2 * tmp2;
                    info.setText(String.valueOf(tmp1));
                    res = tmp1;
                }
            }
        });
        factor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(info.getText().toString()) || info.getText().equals("-")){
                    info.setText(null);
                }
                else {
                    tmp2 = Double.parseDouble(info.getText().toString());
                    if (tmp2<0) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "X повинен бути > 0!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 400);
                        toast.show();
                        info.setText(null);
                        tmp2 = Double.NaN;
                    }
                    else {
                    tmp1 = factorial((int) tmp2);
                    info.setText(String.valueOf(tmp1));
                    result.setText(null);
                    res = tmp1;
                    }
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(info.getText().toString()) || info.getText().equals("-")){
                    info.setText(null);
                }
                else {
                    compute();
                    ACTION = MULTIPLICATION;
                    result.setText(String.valueOf(val1) + "*");
                    info.setText(null);
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(info.getText().toString()) || info.getText().equals("-")){
                    info.setText(null);
                }
                else {
                    compute();
                    ACTION = DIVISION;
                    result.setText(String.valueOf(val1) + "/");
                    info.setText(null);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    compute();
                    ACTION = EQU;
                    res = val1;
                    info.setText(String.valueOf(res));
                    result.setText(null);
                    val1 = Double.NaN;
                    val2 = Double.NaN;
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (info.getText().toString().contains(".")) info.setText(info.getText().toString());
                else if (TextUtils.isEmpty(info.getText().toString())) info.setText("0.");
                else
                info.setText(info.getText()+".");
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    res = Double.NaN;
                    tmp1 = Double.NaN;
                    tmp2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
        clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                res = Double.NaN;
                tmp1 = Double.NaN;
                tmp2 = Double.NaN;
                info.setText(null);
                result.setText(null);
            }
        });
    }


    private void setupUIViews(){

        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        zero = (Button)findViewById(R.id.btn0);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        mul = (Button)findViewById(R.id.btnmul);
        div = (Button)findViewById(R.id.btndivide);
        equal = (Button)findViewById(R.id.btnequal);
        clear = (Button)findViewById(R.id.btnclear);
        info = (TextView)findViewById(R.id.tvControl);
        result = (TextView)findViewById(R.id.tvResult);
        copy = (Button)findViewById(R.id.btncopy);
        paste = (Button)findViewById(R.id.btnpaste);
        memory = (TextView)findViewById(R.id.tvMemory);
        sqrt = (Button)findViewById(R.id.btnsqrt);
        sqr = (Button)findViewById(R.id.btnsqr);
        factor = (Button)findViewById(R.id.btnfact);
        dot = (Button)findViewById(R.id.btndot);
        clearall = (Button)findViewById(R.id.btnclearall);



    }

    private void compute(){


        if(!Double.isNaN(val1)){


                val2 = Double.parseDouble(info.getText().toString());

                switch (ACTION) {
                    case ADDITION:
                        val1 += val2;
                        break;
                    case SUBSTRACTION:
                        val1 -= val2;
                        break;
                    case MULTIPLICATION:
                        val1 *= val2;
                        break;

                    case DIVISION:
                        val1 /= val2;
                        break;

                    case EQU:
                        break;

                }
        }
        else{
            if(TextUtils.isEmpty(info.getText().toString())) val1=0;
            else
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}

