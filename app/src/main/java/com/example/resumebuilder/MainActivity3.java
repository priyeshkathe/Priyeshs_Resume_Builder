package com.example.resumebuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private TextView tvName, tvEmail, tvUniversity, tvEducation, tvSkills, tvProjects, tvExperience, tvAchievements;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Initialize UI components
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvUniversity = findViewById(R.id.tv_university);
        tvEducation = findViewById(R.id.tv_education);
        tvSkills = findViewById(R.id.tv_skills);
        tvProjects = findViewById(R.id.tv_projects);
        tvExperience = findViewById(R.id.tv_experience);
        tvAchievements = findViewById(R.id.tv_achievements);
        imgProfile = findViewById(R.id.img_profile);

        // Get data from Intent
        Intent intent = getIntent();
        tvName.setText( intent.getStringExtra("name"));
        tvEmail.setText(intent.getStringExtra("email"));
        tvUniversity.setText("Currently studing in university: " + intent.getStringExtra("university"));
        tvEducation.setText("in and past Education: " + intent.getStringExtra("education"));
        tvSkills.setText("Technical Skills and the Other skills: " + intent.getStringExtra("skills"));
        tvProjects.setText("Projects working on and the past projects: " + intent.getStringExtra("projects"));
        tvExperience.setText("Experience and past qualification: " + intent.getStringExtra("experience"));
        tvAchievements.setText("Achievements: " + intent.getStringExtra("achievements"));

        // Load Profile Image
        String imageUri = intent.getStringExtra("imageUri");
        if (imageUri != null) {
            imgProfile.setImageURI(Uri.parse(imageUri));
        }
    }
}