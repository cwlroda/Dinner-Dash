package com.example.someapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        TextView tv = findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        String ingrds;
        String equips;
        String facts;
        if (extras != null) {
            ingrds = extras.getString("ingredients");
//            equips = extras.getString("equipments");
//            facts = extras.getString("factors");

            Map<String, Double> ingredients = getIngredients(ingrds);
//            Map<String, Double> equipments = getEquipments(equips);
//            Map<String, Integer> factors = getFactors(facts);

            Recipe recipe = magic_algorithm(ingredients);

            tv.setText(renderRecipe(recipe));
        }
    }

    private Recipe magic_algorithm(Map<String, Double> ingredients) {
        // TODO: put into weiloon's magic algorithm
        return new Recipe("Tomato Soup");
    }

    private String renderRecipe(Recipe recipe) {
        return recipe.toString();
    }

    private Map<String, Double> getIngredients(String items) {
        Map<String, Double> map = new HashMap<>();

        String[] lines = items.split("\n");
        // can ignore the first two lines - bc it is "Ingredient ... Quantity\n"
        for (int i = 2; i < lines.length; i++) {
            String[] tokens = lines[i].split("[ \t]+");
            if (tokens[0] != null && tokens[1] != null) {
                map.put(tokens[0], Double.parseDouble(tokens[1]));
            }
        }

        return map;
    }

//    private Map<String, Double> getEquipments(String equips) {
//        return null;
//    }
//
//    private Map<String, Integer> getFactors(String facts) {
//        return null;
//    }

}
