package com.ciazhar.sqlitedatabaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, collage;
    DatabaseConfig database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.main_input_name);
        collage = (EditText) findViewById(R.id.main_input_collage);

        database = new DatabaseConfig(this);
    }

    public void save(View view) {
        database.insertData(name.getText().toString(),collage.getText().toString());
    }

    public void load(View view) {
        database.getAll();
    }
}
