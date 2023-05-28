package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public double covert_cels_to_far(double temp)
    { double y = (temp * 9/5) + 32;
        return Math.round(y*100.0)/100.0;
    }

    public double covert_cels_to_kelv(double temp) {
        double y=temp + 273.15;
        return Math.round(y*100.0)/100.0;
    }

    public double covert_far_to_cels(double temp) {
        double y = (temp - 32) * 5 / 9;
        return Math.round(y*100.0)/100.0;
    }

    public double covert_far_to_kelv(double temp) {
        double y = (temp - 32) * 5 / 9 + 273.15;
        return Math.round(y*100.0)/100.0;
    }

    public double covert_kelv_to_cels(double temp){
        double y = temp - 273.15;
        return Math.round(y*100.0)/100.0;
    }

    public double convert_kelv_to_far(double temp){
        double y = (temp - 273.15) * 9/5 + 32;
        return Math.round(y*100.0)/100.0;
    }

    public double convert_cels_to_reo(double temp) {
        double y = temp * 4/5;
        return Math.round(y*100.0)/100.0;
    }

    public double convert_far_to_reo(double temp)
    {
        double y = (temp-32)*4/9;
        return Math.round(y*100.0)/100.0;
    }

    public double convert_kels_to_reo(double temp)
{
    double y = (temp - 273.15)*0.8;
    return Math.round(y*100.0)/100.0;
}
    public double convert_reo_to_cels(double temp)
    {
        double y = temp*5/4;
        return Math.round(y*100.0)/100.0;
    }
    public double convert_reo_to_far(double temp)
    {
        double y = temp * 2.25 + 32;
        return Math.round(y*100.0)/100.0;
    }
    public double convert_reo_to_kelv(double temp)
    {
        double y = (temp / 0.8) + 273.15;
        return Math.round(y*100.0)/100.0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText celsius = findViewById(R.id.editTextNumber);
        celsius.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    ImageView img = findViewById(R.id.FirstObject);
                    int a = getResources().getIdentifier("rectangle_not_click", "drawable", getApplicationContext().getPackageName());
                    img.setImageResource(a);
                    ImageView icon = findViewById(R.id.Temp1);
                    int b = getResources().getIdentifier("icon_temp_not_click", "drawable", getApplicationContext().getPackageName());
                    icon.setImageResource(b);
                    TextView text = findViewById(R.id.textView);
                    text.setTextColor(Color.parseColor("#000000"));
                }
                else
                {
                    TextView text = findViewById(R.id.textView);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    ImageView img = findViewById(R.id.FirstObject);
                    int a = getResources().getIdentifier("rectangle_click", "drawable", getApplicationContext().getPackageName());
                    img.setImageResource(a);
                    ImageView icon = findViewById(R.id.Temp1);
                    int b = getResources().getIdentifier("icon_temp_click", "drawable", getApplicationContext().getPackageName());
                    icon.setImageResource(b);
                    celsius.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                            if (event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                            {
                                double temp = Double.parseDouble(celsius.getText().toString());
                                EditText a1 = findViewById(R.id.editTextNumber2);
                                a1.setText(String.valueOf(covert_cels_to_far(temp)));
                                a1 = findViewById(R.id.editTextNumber3);
                                a1.setText(String.valueOf(covert_cels_to_kelv(temp)));
                                a1 = findViewById(R.id.editTextNumber4);
                                a1.setText(String.valueOf(convert_cels_to_reo(temp)));
                                return true;
                            }
                            return false;
                        }
                    });
                }
            }
        });
        EditText fahrenheit = findViewById(R.id.editTextNumber2);
        fahrenheit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    ImageView img = findViewById(R.id.SecondObject);
                    int a = getResources().getIdentifier("rectangle_not_click", "drawable", getApplicationContext().getPackageName());
                    img.setImageResource(a);
                    ImageView icon = findViewById(R.id.Temp2);
                    int b = getResources().getIdentifier("icon_temp_not_click", "drawable", getApplicationContext().getPackageName());
                    icon.setImageResource(b);
                    TextView text = findViewById(R.id.textView2);
                    text.setTextColor(Color.parseColor("#000000"));
                }
                else
                {
                    TextView text = findViewById(R.id.textView2);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    ImageView img = findViewById(R.id.SecondObject);
                    int a = getResources().getIdentifier("rectangle_click", "drawable", getApplicationContext().getPackageName());
                    img.setImageResource(a);
                    ImageView icon = findViewById(R.id.Temp2);
                    int b = getResources().getIdentifier("icon_temp_click", "drawable", getApplicationContext().getPackageName());
                    icon.setImageResource(b);
                    fahrenheit.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                            if (event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                            {
                                double temp = Double.parseDouble(fahrenheit.getText().toString());
                                EditText a1 = findViewById(R.id.editTextNumber);
                                a1.setText(String.valueOf(covert_far_to_cels(temp)));
                                a1 = findViewById(R.id.editTextNumber3);
                                a1.setText(String.valueOf(covert_far_to_kelv(temp)));
                                a1 = findViewById(R.id.editTextNumber4);
                                a1.setText(String.valueOf(convert_far_to_reo(temp)));
                                return true;
                            }
                            return false;
                        }
                    });
                }
            }
        });
        EditText kelvin = findViewById(R.id.editTextNumber3);
        kelvin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    ImageView img = findViewById(R.id.ThirdObject);
                    int a = getResources().getIdentifier("rectangle_not_click", "drawable", getApplicationContext().getPackageName());
                    img.setImageResource(a);
                    ImageView icon = findViewById(R.id.Temp3);
                    int b = getResources().getIdentifier("icon_temp_not_click", "drawable", getApplicationContext().getPackageName());
                    icon.setImageResource(b);
                    TextView text = findViewById(R.id.textView4);
                    text.setTextColor(Color.parseColor("#000000"));
                }
                else
                {
                    TextView text = findViewById(R.id.textView4);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    ImageView img = findViewById(R.id.ThirdObject);
                    int a = getResources().getIdentifier("rectangle_click", "drawable", getApplicationContext().getPackageName());
                    img.setImageResource(a);
                    ImageView icon = findViewById(R.id.Temp3);
                    int b = getResources().getIdentifier("icon_temp_click", "drawable", getApplicationContext().getPackageName());
                    icon.setImageResource(b);
                    kelvin.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                            if (event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                            {
                                double temp = Double.parseDouble(kelvin.getText().toString());
                                EditText a1 = findViewById(R.id.editTextNumber2);
                                a1.setText(String.valueOf(convert_kelv_to_far(temp)));
                                a1 = findViewById(R.id.editTextNumber);
                                a1.setText(String.valueOf(covert_kelv_to_cels(temp)));
                                a1 = findViewById(R.id.editTextNumber4);
                                a1.setText(String.valueOf(convert_kels_to_reo(temp)));
                                return true;
                            }
                            return false;
                        }
                    });
                }
            }
        });
        EditText reaumur = findViewById(R.id.editTextNumber4);
        reaumur.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    ImageView img = findViewById(R.id.FourthObject);
                    int a = getResources().getIdentifier("rectangle_not_click", "drawable", getApplicationContext().getPackageName());
                    img.setImageResource(a);
                    ImageView icon = findViewById(R.id.Temp4);
                    int b = getResources().getIdentifier("icon_temp_not_click", "drawable", getApplicationContext().getPackageName());
                    icon.setImageResource(b);
                    TextView text = findViewById(R.id.textView8);
                    text.setTextColor(Color.parseColor("#000000"));
                }
                else
                {
                    TextView text = findViewById(R.id.textView8);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    ImageView img = findViewById(R.id.FourthObject);
                    int a = getResources().getIdentifier("rectangle_click", "drawable", getApplicationContext().getPackageName());
                    img.setImageResource(a);
                    ImageView icon = findViewById(R.id.Temp4);
                    int b = getResources().getIdentifier("icon_temp_click", "drawable", getApplicationContext().getPackageName());
                    icon.setImageResource(b);
                    reaumur.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                            if (event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                            {
                                double temp = Double.parseDouble(reaumur.getText().toString());
                                EditText a1 = findViewById(R.id.editTextNumber2);
                                a1.setText(String.valueOf(convert_reo_to_far(temp)));
                                a1 = findViewById(R.id.editTextNumber3);
                                a1.setText(String.valueOf(convert_reo_to_kelv(temp)));
                                a1 = findViewById(R.id.editTextNumber);
                                a1.setText(String.valueOf(convert_reo_to_cels(temp)));
                                return true;
                            }
                            return false;
                        }
                    });
                }
            }
        });
    }
}