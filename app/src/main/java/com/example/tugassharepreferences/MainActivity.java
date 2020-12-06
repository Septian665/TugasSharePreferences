package com.example.tugassharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EditText_name,EditText_email;
    Button btn_save;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="TugasShare";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText_name = findViewById(R.id.edittext_name);
        EditText_email = findViewById(R.id.edittext_email);
        btn_save = findViewById(R.id.btn_save);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


        String name = sharedPreferences.getString(KEY_NAME,null);
        if(name != null){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,EditText_name.getText().toString());
                editor.putString(KEY_EMAIL,EditText_email.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Sign in Success", Toast.LENGTH_SHORT).show();
            }
        });

    }
}