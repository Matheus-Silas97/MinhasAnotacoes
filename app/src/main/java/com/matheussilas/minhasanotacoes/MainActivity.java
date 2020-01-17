package com.matheussilas.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Annotation preferences;
    private EditText editAnnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnnotation = findViewById(R.id.editAnnotation);

        preferences = new Annotation(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editAnnotation.getText().toString().equals("")) {
                    Snackbar.make(view, "Digite a anotação", Snackbar.LENGTH_SHORT).show();
                } else {
                    preferences.saveAnnotation(editAnnotation.getText().toString());
                    Snackbar.make(view, "Anotação Salva", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        String annotation = preferences.recoverAnnotation();
        if (!annotation.equals("")) {
            editAnnotation.setText(annotation);
        }
    }
}
