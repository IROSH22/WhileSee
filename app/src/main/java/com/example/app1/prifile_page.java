package com.example.app1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class prifile_page extends AppCompatActivity {

    private ImageView profileImage;
    private TextView userName;
    private TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prifile_page);


        // Initialize views
        profileImage = findViewById(R.id.profileImage);
        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);

        // Set profile data (this can come from Firebase or local storage)
        profileImage.setImageResource(R.drawable.profile_pic); // Example image
        userName.setText("John Doe");
        userEmail.setText("john.doe@example.com");




        // Initialize BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else if (itemId == R.id.bottom_awareness) {
                startActivity(new Intent(getApplicationContext(), awareness.class));
            } else if (itemId == R.id.bottom_map) {
                startActivity(new Intent(getApplicationContext(), map.class));
            }
            else if (itemId == R.id.bottom_chat) {
                startActivity(new Intent(getApplicationContext(), Chat.class));
            }else {
                return false;
            }

            overridePendingTransition(R.anim.side_in_right, R.anim.slide_out_left);
            finish();
            return true;
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}