package com.example.someapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        TextView tv = findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        String items;
        if (extras != null) {
            items = extras.getString("items");
            Recipe recipe = magic_algorithm(items);
            tv.setText(renderRecipe(recipe));
        }
    }

    private Recipe magic_algorithm(String items) {
        // TODO: put into weiloon's magic algorithm
        return new Recipe("Tomato Soup");
    }

    private String renderRecipe(Recipe recipe) {
        return recipe.toString();
    }

}
