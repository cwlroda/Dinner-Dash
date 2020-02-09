package common;

import common.Database;

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

    public void run(){
        Database db = new Database();
        int index=0;

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
                // pass to jenny
            }
        }
    }

    public void print(){
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args){
        Map<String, Double> a = new HashMap<String, Double>();
        int b = 0;
        Algorithm A = new Algorithm(a, b);
        A.run();
    }
}