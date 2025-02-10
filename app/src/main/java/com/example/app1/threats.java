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

public class threats extends AppCompatActivity {

    private Button on;
    private Button vs;
    private Button cc;
    private Button eif;
    private Button pd;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_threats);

        on = findViewById(R.id.button6);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(threats.this, ocean_noise.class);
                startActivity(intent);
            }
        });

        vs = findViewById(R.id.button7);
        vs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(threats.this, vessel_strikes.class);
                startActivity(intent);
            }
        });

        cc = findViewById(R.id.button8);
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(threats.this, climate_change.class);
                startActivity(intent);
            }
        });

        eif = findViewById(R.id.button9);
        eif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(threats.this, Entanglement_in_fishing.class);
                startActivity(intent);
            }
        });

        pd = findViewById(R.id.button10);
        pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(threats.this, plastic_debris.class);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.button16);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(threats.this, awareness.class);
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