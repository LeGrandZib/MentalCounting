package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        associateOpenActivityToButton(R.id.score, Score_Activity.class);
        associateOpenActivityToButton(R.id.play_button, Play_Activity.class);
    }

    private void associateOpenActivityToButton(int id,Class activity){
        Button button = findViewById(id);
        button.setOnClickListener(view -> openActivity(activity));

    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}