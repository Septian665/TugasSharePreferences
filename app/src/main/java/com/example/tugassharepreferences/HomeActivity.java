package com.example.tugassharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView textView_name,textView_email;
    Button btn_exit;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="TugasShare";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView_name = findViewById(R.id.Text_name);
        textView_email = findViewById(R.id.Text_email);
        btn_exit = findViewById(R.id.btn_exit);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);

        if(name != null && email != null){
            textView_name.setText("Name : " + name);
            textView_email.setText("Email : "+email);
        }

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this,"Sign Out Successfully",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}