package io.android.banktsf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.android.banktsf.R;
import io.android.banktsf.user_list;

public class MainActivity extends AppCompatActivity {

    Button view_users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_users = findViewById(R.id.view_users);

        view_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, user_list.class));
                finish();
            }
        });

    }
}