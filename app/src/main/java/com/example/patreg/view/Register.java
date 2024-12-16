package com.example.patreg.view;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.patreg.R;

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
            String patientDetails = String.format(
                    "Name: %s %s\nDOB: %s\nWeight: %s\nShoe Size: %s",
                    firstName.getText().toString(),
                    lastName.getText().toString(),
                    dob.getText().toString(),
                    weight.getText().toString(),
                    shoeSize.getText().toString()
            );
            Toast.makeText(this, patientDetails, Toast.LENGTH_SHORT).show();
        });
    }
}
