package com.example.a2006project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Toast;

public class FavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        Spinner spinner = findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set a listener to detect item selection
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Show a toast message when an item is selected
                String selectedItem = parentView.getItemAtPosition(position).toString();
                Toast.makeText(FavActivity.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected (optional)
            }
        });

        TextView textView = findViewById(R.id.textView10);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(FavActivity.this, SecondActivity.class);
                startActivity(intent);  // Start the activity
            }
        });

        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(FavActivity.this, MainActivity.class);
                startActivity(intent);  // Start the activity
            }
        });

    }

}