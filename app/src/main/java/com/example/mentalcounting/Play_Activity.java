package com.example.mentalcounting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Play_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
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
            case R.id.reset_button:
                // nettoyer la base de donnée
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}