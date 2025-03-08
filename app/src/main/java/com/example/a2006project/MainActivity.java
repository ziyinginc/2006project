package com.example.a2006project;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Spinner by ID
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
                Toast.makeText(MainActivity.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case when nothing is selected (optional)
            }
        });

        // Get references to the ImageViews
        ImageView imageView1 = findViewById(R.id.imageView3);
        //ImageView imageView2 = findViewById(R.id.imageView2);

        // Set onClick listeners for each image
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Activity for imageView1
                Intent intent = new Intent(MainActivity.this, SecondActivity.class); // Replace with your target activity
                startActivity(intent);
            }
        });

        /*imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Activity for imageView2
                Intent intent = new Intent(MainActivity.this, MainActivity.class); // Replace with your target activity
                startActivity(intent);
            }
        });*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu resource file
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Get reference to SearchView
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        // Set up a listener for the search query
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // You can perform an action when the user submits the query
                Toast.makeText(MainActivity.this, "Search submitted: " + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // You can perform an action when the query text changes
                Toast.makeText(MainActivity.this, "Search text changed: " + newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

