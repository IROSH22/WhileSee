package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class map extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map);

        // Initialize MapView
        mapView = findViewById(R.id.id_map);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);

        // Initialize Firebase Database Reference
        databaseReference = FirebaseDatabase.getInstance().getReference("pins");

        // Example for saving a pin to Firebase (replace latLng and pinId with actual values)
        LatLng latLng = new LatLng(6.842192, 79.862261);
        String pinId = databaseReference.push().getKey();
        Pin pin = new Pin(latLng.latitude, latLng.longitude, "New Pin");
        if (pinId != null) {
            databaseReference.child(pinId).setValue(pin);
        }

        // Example for reading pins from Firebase
        databaseReference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                for (DataSnapshot snapshot : task.getResult().getChildren()) {
                    Pin pinData = snapshot.getValue(Pin.class);
                    if (pinData != null) {
                        LatLng location = new LatLng(pinData.getLatitude(), pinData.getLongitude());
                        mapView.getMapAsync(googleMap -> googleMap.addMarker(new MarkerOptions().position(location).title(pinData.getTitle())));
                    }
                }
            }
        });

        // Initialize BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_map);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else if (itemId == R.id.bottom_awareness) {
                startActivity(new Intent(getApplicationContext(), awareness.class));
            } else if (itemId == R.id.bottom_chat) {
                startActivity(new Intent(getApplicationContext(), Chat.class));
            } else if (itemId == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), prifile_page.class));
            } else {
                return false;
            }
            overridePendingTransition(R.anim.side_in_right, R.anim.slide_out_left);
            finish();
            return true;
        });

        // Handle window insets for full-screen experience
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        // Configure Google Map settings
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);

        // Add a marker at Colombo and move the camera
        LatLng Kaluthara = new LatLng(6.590917, 79.961173);
        googleMap.addMarker(new MarkerOptions().position(Kaluthara).title("Marker in Kaluthara"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kaluthara, 15f));  // Zoom level set to 15f

        LatLng Panadura = new LatLng(6.715582, 79.901331);
        googleMap.addMarker(new MarkerOptions().position(Panadura).title("Marker in Panadura"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Panadura, 15f));  // Zoom level set to 15f

        LatLng Waikkala = new LatLng(7.274719, 79.852152);
        googleMap.addMarker(new MarkerOptions().position(Waikkala).title("Marker in Waikkala"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Waikkala, 15f));  // Zoom level set to 15f

        LatLng Bangadeniya = new LatLng(7.613877, 79.802530);
        googleMap.addMarker(new MarkerOptions().position(Bangadeniya).title("Marker in Bangadeniya"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bangadeniya, 15f));  // Zoom level set to 15f
    }

    // Handle MapView lifecycle methods
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }
        mapView.onSaveInstanceState(mapViewBundle);
    }
}
