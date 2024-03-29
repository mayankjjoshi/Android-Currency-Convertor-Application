package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    double fromValue = 0.0;
    String fromUnit = "";
    double toValue = 0.0;
    String toUnit = "";

    private List<String> units = Arrays.asList(
            "INR","CAD","SLR",
            "USD");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initComponents();
    }

    public void initComponents() {
        Collections.sort(units);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, units);
        binding.fromUnit.setAdapter(arrayAdapter);
        binding.toUnit.setAdapter(arrayAdapter);

        binding.convertButton.setOnClickListener(view -> {

            // get The Value
            try {
                fromValue = Double.parseDouble(binding.fromValue.getText().toString());
                fromUnit = binding.fromUnit.getSelectedItem().toString();
                toUnit = binding.toUnit.getSelectedItem().toString();

                convertValue();
                // fromValue = Double.parseDouble(binding.fromValue.getText().toString());
                // Spinner fromU = (Spinner) findViewById(R.id.fromUnit);
                // fromUnit = fromU.getSelectedItem().toString();
                // fromUnit = binding.fromUnit.getSelectedItem().toString();
                // Spinner toU = (Spinner) findViewById(R.id.toUnit);
                // toUnit = toU.getSelectedItem().toString();
                // toUnit = binding.toUnit.getSelectedItem().toString();
                // convertValue();

            } catch (Exception e) {
                // Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            }

        });
    }

    // Logic to convert currency
    private void convertValue() {

        try {
            if (fromUnit.equalsIgnoreCase("INR") && toUnit.equalsIgnoreCase("USD")) {
                toValue = fromValue/83.37;
            }
            else if (fromUnit.equalsIgnoreCase("INR") && toUnit.equalsIgnoreCase("CAD")) {
                toValue = fromValue * 0.016;
            }
            else if (fromUnit.equalsIgnoreCase("INR") && toUnit.equalsIgnoreCase("SLR")) {
                toValue = fromValue * 3.61;
            }
            else if (fromUnit.equalsIgnoreCase("INR") && toUnit.equalsIgnoreCase("INR")) {
                Toast.makeText(this, "Must Select Two Different Currency", Toast.LENGTH_SHORT).show();
            }
            else if (fromUnit.equalsIgnoreCase("CAD") && toUnit.equalsIgnoreCase("INR")) {
                toValue = fromValue * 61.38;
            }
            else if (fromUnit.equalsIgnoreCase("CAD") && toUnit.equalsIgnoreCase("SLR")) {
                toValue = fromValue * 221.49;
            }
            else if (fromUnit.equalsIgnoreCase("CAD") && toUnit.equalsIgnoreCase("USD")) {
                toValue = fromValue * 0.74;
            }
            else if (fromUnit.equalsIgnoreCase("CAD") && toUnit.equalsIgnoreCase("CAD")) {
                Toast.makeText(this, "Must Select Two Different Currency", Toast.LENGTH_SHORT).show();
            }
            else if (fromUnit.equalsIgnoreCase("SLR") && toUnit.equalsIgnoreCase("INR")) {
                toValue = fromValue * 0.28;
            }
            else if (fromUnit.equalsIgnoreCase("SLR") && toUnit.equalsIgnoreCase("CAD")) {
                toValue = fromValue * 0.0045;
            }
            else if (fromUnit.equalsIgnoreCase("SLR") && toUnit.equalsIgnoreCase("USD")) {
                toValue = fromValue * 0.0033;
            }
            else if (fromUnit.equalsIgnoreCase("SLR") && toUnit.equalsIgnoreCase("SLR")) {
                Toast.makeText(this, "Must Select Two Different Currency", Toast.LENGTH_SHORT).show();
            }
            else if (fromUnit.equalsIgnoreCase("USD") && toUnit.equalsIgnoreCase("INR")) {
                toValue = fromValue*83.37;
            }
            else if (fromUnit.equalsIgnoreCase("USD") && toUnit.equalsIgnoreCase("CAD")) {
                toValue = fromValue * 1.36;
            }
            else if (fromUnit.equalsIgnoreCase("USD") && toUnit.equalsIgnoreCase("SLR")) {
                toValue = fromValue * 300.9;
            }
            else if (fromUnit.equalsIgnoreCase("USD") && toUnit.equalsIgnoreCase("USD")) {
                Toast.makeText(this, "Must Select Two Different Currency", Toast.LENGTH_SHORT).show();
            }
            binding.toValue.setText(String.valueOf(toValue));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}