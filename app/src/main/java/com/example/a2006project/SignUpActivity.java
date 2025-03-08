package com.example.a2006project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private EditText userEdt, passEdt;
    private Button loginBtn, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageView imageView = findViewById(R.id.cancelBtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to SecondActivity
                Intent intent = new Intent(SignUpActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        initView();
        setVariable();
    }

        private void initView(){
            userEdt=findViewById(R.id.editTextTextUser);
            passEdt=findViewById(R.id.editTextTextPassword);
        }
        private void setVariable(){
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (userEdt.getText().toString().isEmpty() || passEdt.getText().toString().isEmpty()){
                        Toast.makeText(SignUpActivity.this,"Please fill in the required info", Toast.LENGTH_SHORT).show();
                    }else if (userEdt.getText().toString().equals("admin") && passEdt.getText().toString().equals("admin")){
                        startActivity(new Intent(SignUpActivity.this, FavActivity.class));
                    }
                }
            });
        }

}