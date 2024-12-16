package com.example.patreg.view;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.patreg.R;
import com.example.patreg.api.PatientApi;
import com.example.patreg.adapter.RetrofitClient;
import com.example.patreg.model.Patient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText firstName = findViewById(R.id.firstName);
        EditText lastName = findViewById(R.id.lastName);
        EditText dob = findViewById(R.id.dob);
        EditText weight = findViewById(R.id.weight);
        EditText shoeSize = findViewById(R.id.shoeSize);

        Button takePhotoButton = findViewById(R.id.takePhotoButton);
        Button submitButton = findViewById(R.id.submitButton);

        takePhotoButton.setOnClickListener(v -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        });

        submitButton.setOnClickListener(v -> {
            Patient patient = new Patient(
                    firstName.getText().toString(),
                    lastName.getText().toString(),
                    dob.getText().toString(),
                    Double.parseDouble(weight.getText().toString()),
                    Double.parseDouble(shoeSize.getText().toString())
            );

            PatientApi api = RetrofitClient.getClient().create(PatientApi.class);
            Call<String> call = api.registerPatient(patient);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(Register.this, "Patient registered successfully in the Patreg application!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Register.this, "Registration failed.Please look out for the errors,alter and try to resubmit", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(Register.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
