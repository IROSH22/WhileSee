package com.example.app1;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class awareness extends AppCompatActivity {

    private Button first;
    private Button two;
    private Button three;
    private Button fore;
    private Button five;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_awareness);

        // navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_awareness);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.side_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_awareness) {
                return true; // Stay on the same page, no need to navigate
            } else if (itemId == R.id.bottom_map) {
                startActivity(new Intent(getApplicationContext(), map.class)); // Class name should start with uppercase
                overridePendingTransition(R.anim.side_in_right, R.anim.slide_out_left);
                finish();
                return true;

            } else if (itemId == R.id.bottom_chat) {
                startActivity(new Intent(getApplicationContext(), Chat.class)); // Ensure Chat class exists
                overridePendingTransition(R.anim.side_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }

            return false;
        });

        first = findViewById(R.id.button);
        first.setOnClickListener(v -> {
            Intent intent = new Intent(awareness.this, threats.class);
            startActivity(intent);
        });

        two = findViewById(R.id.button2);
        two.setOnClickListener(v -> {
            Intent intent = new Intent(awareness.this, marine_conservation.class);
            startActivity(intent);
        });

        three = findViewById(R.id.button3);
        three.setOnClickListener(v -> {
            Intent intent = new Intent(awareness.this, role_of_ocean.class);
            startActivity(intent);
        });

        fore = findViewById(R.id.button4);
        fore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(awareness.this, sustainable_practices_main.class);
                startActivity(intent);
            }
        });

        five = findViewById(R.id.button5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(awareness.this, call_to_actions_main.class);
                startActivity(intent);
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}