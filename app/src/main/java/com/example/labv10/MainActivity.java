package com.example.labv10;


import android.os.Bundle;

import android.app.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText xEditText;
    private EditText aEditText;
    private CheckBox checkBox;
    private LinearLayout graphLayout;
    private GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graphView = findViewById(R.id.graph_view);
        xEditText = findViewById(R.id.x_edit_text);
        aEditText = findViewById(R.id.a_edit_text);
        checkBox = findViewById(R.id.checkbox);
        graphLayout = findViewById(R.id.graph_layout);
        xEditText.setText("-5.0");
        aEditText.setText("1.0");
        graphView.setVisibility(View.GONE);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                graphView.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });
    }

    private void calculateResult() {
        String xString = xEditText.getText().toString();
        String aString = aEditText.getText().toString();

        if (xString.isEmpty() || aString.isEmpty()) {
            return;
        }

        double xValue = Double.parseDouble(xString);
        double aValue = Double.parseDouble(aString);

        double result = calculateFunction(xValue, aValue);

        TextView resultTextView = findViewById(R.id.result_text_view);
        resultTextView.setText("Result: " + result);

        graphView.updateGraph(xValue, aValue);
    }

    private double calculateFunction(double x, double a) {
        return (3 + Math.pow(x, 3)) / (7 * Math.pow(a, 2) + x / 2);
    }
}