package com.example.someapp;

import androidx.annotation.NonNull;

import java.util.HashMap;

class Recipe {

    private String name;
    private HashMap<String, Integer> ingredients;
    private HashMap<String, Integer> equipments;
    private int time;

    public Recipe(String name) {
        this(name, null, null, 0);
    }

    public Recipe(String name,
                  HashMap<String, Integer> ingredients,
                  HashMap<String, Integer> equipments,
                  int time) {
        this.name = name;
        this.ingredients = ingredients;
        this.equipments = equipments;
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
        sb.append("Time: ");
        sb.append(time);
        // TODO: can have a function to change this to hour and min
        sb.append(" min");

        return sb.toString();
    }

}
