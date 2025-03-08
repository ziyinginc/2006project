package com.example.a2006project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1); // This links to your layout file

        // Get the ProgressBar reference
        progressBar = findViewById(R.id.progressBar);
        // Start the timer for 3 seconds and transition to the next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // After 3 seconds, hide the ProgressBar and go to the next activity
                progressBar.setVisibility(View.GONE); // Hide ProgressBar
                Intent intent = new Intent(Activity1.this, MainActivity.class);  // Replace with your next activity
                startActivity(intent);
                finish();  // Close the current activity (MainActivity)
            }
        }, 3000);
    }
}
