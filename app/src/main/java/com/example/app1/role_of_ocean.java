package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class role_of_ocean extends AppCompatActivity {

    private Button top;
    private Button ec;
    private Button sof;
    private Button many;
    private Button holi;
    private Button jobs;
    private Button pro;

    private Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_role_of_ocean);

        top = findViewById(R.id.button17);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(role_of_ocean.this, the_ocean_produces.class);
                startActivity(intent);
            }
        });

        ec = findViewById(R.id.button18);
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(role_of_ocean.this, Earth_climate.class);
                startActivity(intent);
            }
        });

        sof = findViewById(R.id.button23);
        sof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(role_of_ocean.this, source_of_food.class);
                startActivity(intent);
            }
        });

        many = findViewById(R.id.button22);
        many.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(role_of_ocean.this, many_creatures.class);
                startActivity(intent);
            }
        });

        holi = findViewById(R.id.button21);
        holi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(role_of_ocean.this, holidays.class);
                startActivity(intent);
            }
        });

        jobs = findViewById(R.id.button20);
        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(role_of_ocean.this,com.example.app1.jobs.class);
                startActivity(intent);
            }
        });

        pro = findViewById(R.id.button19);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(role_of_ocean.this, properties.class);
                startActivity(intent);
            }
        });

        backbtn = findViewById(R.id.button61);
        backbtn.setOnClickListener(V -> {
            Intent intent = new Intent(role_of_ocean.this, awareness.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}