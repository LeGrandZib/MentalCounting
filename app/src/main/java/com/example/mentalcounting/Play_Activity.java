package com.example.mentalcounting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mentalcounting.services.OperationServices;
import com.example.mentalcounting.models.operationModel;

public class Play_Activity extends AppCompatActivity {

    private TextView textView;
    private operationModel model;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        this.textView = findViewById(R.id.operation_text);

        associateServiceToButton(R.id.response_button);
        associateResetServiceToButton(R.id.new_op_button);

        model = OperationServices.generateOperation();

        updateOperationInView(model);

        editText =findViewById(R.id.input_number);
        operationModel finalModel = model;

        findViewById(R.id.success_text).setVisibility(View.GONE);
        findViewById(R.id.fail_text).setVisibility(View.GONE);
        findViewById(R.id.error_text).setVisibility(View.GONE);
    }


    private void associateServiceToButton(int id){
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().length()>0) {
                    findViewById(R.id.error_text).setVisibility(View.GONE);
                    if (OperationServices.resolveOperation(model, String.valueOf(editText.getText()))) {
                        findViewById(R.id.success_text).setVisibility(View.VISIBLE);
                        findViewById(R.id.fail_text).setVisibility(View.GONE);

                        model = OperationServices.generateOperation();
                        updateOperationInView(model);

                    } else {
                        findViewById(R.id.success_text).setVisibility(View.GONE);
                        findViewById(R.id.fail_text).setVisibility(View.VISIBLE);
                    }
                    editText.setText("");
                }
                else{
                    findViewById(R.id.error_text).setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void associateResetServiceToButton(int id){
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model = OperationServices.generateOperation();
                updateOperationInView(model);
            }
        });
    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void updateOperationInView(operationModel model) {
        String value = getString(R.string.operation_template, model.getFirstValue(), model.getOperator(), model.getSecondValue());
        this.textView.setText(value);
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