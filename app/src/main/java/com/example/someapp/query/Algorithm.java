package com.example.someapp.query;

import com.example.someapp.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Algorithm{
    private static Map<String, Double> ingredients = new HashMap<String, Double>();
    private static int time=0;
    private List<List<String>> result = new ArrayList<>();

    public Algorithm(Map<String, Double> a, int b){
        ingredients = a;
        time = b;
    }

    public Recipe run(){
        Database db = new Database();

        for(int i=0; i<db.getSize(); i++){
            Map<String, Double> db_ingredients = new HashMap<String, Double>();
            db_ingredients = db.getIngredients(i);

            boolean isValid = true;
            Map<String, Double> comp_ingrd = ingredients;
            for (String key : db_ingredients.keySet()) {
                if (comp_ingrd.containsKey(key)) {
                    comp_ingrd.put(key, comp_ingrd.get(key)-db_ingredients.get(key));
                    if (comp_ingrd.get(key) < 0) {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                String name = db.getName(i);
                Map<String, Double> ingredients = db.getIngredients(i);
                Map<String, Double> equipments = new HashMap<>();
                equipments.put("pan", 1.0);
                equipments.put("pot", 1.0);
                String instructions = db.getInstructions(i).get(0);
                int time = db.getTime(i);
                return new Recipe(name, ingredients, equipments, instructions, time);
            }
        }
        return new Recipe();
    }

    public void print(){
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

}