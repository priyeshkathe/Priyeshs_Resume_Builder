package com.example.resumebuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText etName, etEmail, etUniversity, etEducation, etSkills, etProjects, etExperience, etAchievements;
    private ImageView imgProfile;
    private Button btnUploadImage, btnSubmit;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize UI components
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etUniversity = findViewById(R.id.et_university);
        etEducation = findViewById(R.id.et_education);
        etSkills = findViewById(R.id.et_skills);
        etProjects = findViewById(R.id.et_projects);
        etExperience = findViewById(R.id.et_experience);
        etAchievements = findViewById(R.id.et_achievements);
        imgProfile = findViewById(R.id.img_profile);
        btnUploadImage = findViewById(R.id.btn_upload_image);
        btnSubmit = findViewById(R.id.btn_submit);

        // Image Picker
        ActivityResultLauncher<Intent> imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        imageUri = result.getData().getData();
                        imgProfile.setImageURI(imageUri);
                    }
                });

        btnUploadImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            imagePickerLauncher.launch(intent);
        });

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String university = etUniversity.getText().toString().trim();
            String education = etEducation.getText().toString().trim();
            String skills = etSkills.getText().toString().trim();
            String projects = etProjects.getText().toString().trim();
            String experience = etExperience.getText().toString().trim();
            String achievements = etAchievements.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || university.isEmpty() || education.isEmpty() ||
                    skills.isEmpty() || projects.isEmpty() || experience.isEmpty() || achievements.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("university", university);
                intent.putExtra("education", education);
                intent.putExtra("skills", skills);
                intent.putExtra("projects", projects);
                intent.putExtra("experience", experience);
                intent.putExtra("achievements", achievements);

                if (imageUri != null) {
                    intent.putExtra("imageUri", imageUri.toString());
                }

                startActivity(intent);
            }
        });
    }
}
