package com.example.inclassmad_assignment02;
/*
 * @author : Sathish Kumar Balasubramnian  @Student Id : 801114629
 * @author : Gokul Nithin Kumar Rajkumar @Student Id : 801082252
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_length1;
    private TextView tv_length2;
    private TextView tv_shape;
    private EditText et_result;

    private Button button_calculate;
    private Button button_clear;
    private ImageView iv_triangle;
    private ImageView iv_square;
    private ImageView iv_circle;
    private EditText et_length1;
    private EditText et_length2;
    private String selectedShape ;
    double length1;
    double length2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");
        selectedShape = " ";
        tv_length1    = findViewById(R.id.textView_length1);
        tv_length2    = findViewById(R.id.textView_length2);
        et_length1 = findViewById(R.id.editText_length1);
        et_length2 = findViewById(R.id.editText_length2);
        et_result = findViewById(R.id.editText_result);
        tv_shape = findViewById(R.id.textView_selctedShape);
        button_calculate = findViewById(R.id.button_calculate);
        button_clear = findViewById(R.id.button_clear);
        iv_triangle = findViewById(R.id.imageView_triangle);
        iv_square = findViewById(R.id.imageView_square);
        iv_circle = findViewById(R.id.imageView_circle);

        clearButton();

        length1 = 0.0;
        length2 = 0.0;

        String tempLength1 = et_length1.getText().toString();
        String tempLength2 = et_length2.getText().toString();
        if (tempLength1!=null && !tempLength1.equals(""))
            length1 = Double.parseDouble(tempLength1);
        if (tempLength2!=null && !tempLength2.equals(""))
            length2 = Double.parseDouble(tempLength2);

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });

        iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "triangle";
                tv_shape.setText("Triangle");
                tv_shape.setError(null);
                tv_length1.setVisibility(View.VISIBLE);
                tv_length2.setVisibility(View.VISIBLE);
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.VISIBLE);

            }
        });

        iv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "circle";
                tv_shape.setText("Circle");
                tv_shape.setError(null);
                tv_length1.setVisibility(View.VISIBLE);
                tv_length2.setVisibility(View.INVISIBLE);
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);

            }
        });

        iv_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "square";
                tv_shape.setText("Square");
                tv_length1.setVisibility(View.VISIBLE);
                tv_length2.setVisibility(View.INVISIBLE);
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);

            }
        });


        button_calculate.setOnClickListener(new View.OnClickListener() {
            double result = 0.0;
            @Override
            public void onClick(View view) {
                if(et_length1.getText().toString().equals("")){
                    et_length1.setError("Hey I need a value!");
                }else{
                    length1 = Double.parseDouble(et_length1.getText().toString());
                }
                if(et_length2.getText().toString().equals("")){
                    et_length2.setError("Hey I need a value!");
                }else{
                    length2 = Double.parseDouble(et_length2.getText().toString());
                }
                if(selectedShape == ""){
                    tv_shape.setError("Please select a shape");
                }else{
                    tv_shape.setError(null);
                }
                switch (selectedShape){
                    case "triangle":
                        result = 0.5*length1*length2;
                        et_result.setText(result+"");
                        break;
                    case "circle":
                        result = 3.1416*length1*length1;
                        et_result.setText(result+"");
                        break;
                    case "square":
                        result = length1*length1;
                        et_result.setText(result+"");
                }
            }
        });

    }

    public void clearButton(){

        et_length1.setVisibility(View.VISIBLE);
        et_length2.setVisibility(View.VISIBLE);
        et_length1.setText("");
        et_length2.setText("");
        tv_shape.setText("Select a shape");
        et_result.setText("");
        selectedShape = "";
        length1 = 0.0;
        length2 = 0.0;
        tv_length1.setVisibility(View.VISIBLE);
        tv_length2.setVisibility(View.VISIBLE);


    }
}