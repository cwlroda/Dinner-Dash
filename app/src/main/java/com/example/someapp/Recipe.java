package com.example.someapp;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Map;

public class Recipe {

    private String name;
    private Map<String, Double> ingredients;
    private Map<String, Double> equipments;
    private String instructions;
    private int time;

    public Recipe() {
        this("Water");
    }

    public Recipe(String name) {
        this(name, null, null, null, 0);
    }

    public Recipe(String name,
                  Map<String, Double> ingredients,
                  Map<String, Double> equipments,
                  String instructions,
                  int time) {
        this.name = name;
        this.ingredients = ingredients;
        this.equipments = equipments;
        this.instructions = instructions;
        this.time = time;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append('\n');
        sb.append('\n');

        sb.append("Ingredients: ");
        if (ingredients != null) {
            sb.append('\n');
            for (String key : ingredients.keySet()) {
                sb.append("     " + key + ":      " + ingredients.get(key));
                sb.append('\n');
            }
        } else {
            sb.append("none!");
        }

        sb.append('\n');
        sb.append('\n');
        sb.append("Equipments: ");
        if (equipments != null) {
            sb.append('\n');
            for (String key : equipments.keySet()) {
                sb.append("     " + key + ":      " + equipments.get(key));
                sb.append('\n');
            }
        } else {
            sb.append("none!");
        }

        sb.append('\n');
        sb.append('\n');
        sb.append("Instructions: ");
        if (instructions != null) {
            sb.append('\n');
            sb.append(instructions);
        } else {
            sb.append("none!");
        }

        sb.append('\n');
        sb.append('\n');
        sb.append("Time: ");
        sb.append(time);
        // TODO: can have a function to change this to hour and min
        sb.append(" min");

        return sb.toString();
    }

}
