package com.example.patreg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.patreg.api.ApiClient;
import com.example.patreg.model.Patient;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button registerButton;
    private EditText firstName, lastName, dob, weight, shoeSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        registerButton = findViewById(R.id.registerButton);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        dob = findViewById(R.id.dob);
        weight = findViewById(R.id.weight);
        shoeSize = findViewById(R.id.shoeSize);

        // On click of register button
        registerButton.setOnClickListener(v -> registerPatient());
    }

    private void registerPatient() {
        // Validate if all fields are filled
        if (firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() ||
                dob.getText().toString().isEmpty() || weight.getText().toString().isEmpty() ||
                shoeSize.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Prepare patient data
        Patient patient = new Patient(
                firstName.getText().toString(),
                lastName.getText().toString(),
                dob.getText().toString(),
                Double.parseDouble(weight.getText().toString()),
                Double.parseDouble(shoeSize.getText().toString())
        );


        new Thread(() -> {
            try {
                String response = ApiClient.sendGetRequest();
                runOnUiThread(() -> {
                    // If successful, show success message
                    Toast.makeText(MainActivity.this, "Patient Registered: " + response, Toast.LENGTH_SHORT).show();
                });
            } catch (IOException e) {
                runOnUiThread(() -> {
                    // Handle failure
                    Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        }).start();
    }
}
