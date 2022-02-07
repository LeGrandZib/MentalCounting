package com.example.mentalcounting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class Play_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        associateOpenActivityToButton(R.id.response_button, Score_Activity.class);
    }

    private void associateOpenActivityToButton(int id,Class activity){
        Button button = findViewById(id);
        button.setOnClickListener(view -> openActivity(activity));

    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.submit_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        // V1
        switch (id) {
            case R.id.submit_button:
                // ouvrir l activité de resultat
                Intent intent = new Intent(this, Score_Activity.class);
                startActivity(intent);
                break;
            case R.id.menu_button:
                //Retourne aux menu
                Intent intent_menu = new Intent(this, MainActivity.class);
                startActivity(intent_menu);
                break;
            case R.id.score_button:
                //Retourne aux menu
                Intent intent_score = new Intent(this, Score_Activity.class);
                startActivity(intent_score);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}