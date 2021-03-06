package com.example.someapp.query;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.Iterator;

// title, time, ingredients, instructions, image

public class Database {
    private JSONObject recipes = new JSONObject();
    private List<String> name = new ArrayList<>();
    private List<Integer> time = new ArrayList<>();
    private List<Map<String, Double>> ingredients = new ArrayList<>();
    private List<List<String>> instructions = new ArrayList<>();
    private List<String> image = new ArrayList<>();

    public Database() {
        JSONParser jsonParser = new JSONParser();

        try {
            Object obj = jsonParser.parse(new FileReader("dataBase.json"));
            recipes = (JSONObject) obj;

            for(int i=6663; i<24180; i++){
                JSONObject tmp = (JSONObject) recipes.get(Integer.toString(i));
                name.add(String.valueOf(tmp.get("Name")));
                JSONObject tmp2 = (JSONObject) tmp.get("Ingredients");
                //Map<String, Double> tmp3 = new HashMap<>();
                System.out.println(tmp2);
                List<String> l = new ArrayList<>();

                Iterator<String> keys = tmp2.keys();

                Map<String, Double> m = new HashMap<>();

                while (keys.hasNext()) {
                    String key = keys.next();
                    //JSONObject tmp4 = (JSONObject)tmp2.get(key);
                    List<String> tmp5 = new ArrayList<>();
                    String s = String.valueOf(tmp2.get(key));
                    String[] arrS = s.split("\"");

                    try {
                        if (arrS.length >= 2) {
                            m.put(key, Double.parseDouble(arrS[1]));
                        }
                    } catch (NumberFormatException e) {

                    }
                }

                ingredients.add(m);
                instructions.add(String.valueOf(tmp.get("Instructions")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return recipes.length();
    }

    public String getName(int index) {
        return name.get(index);
    }

    public int getTime(int index) {
        return time.get(index);
    }

    public Map<String, Double> getIngredients(int index) {
        return ingredients.get(index);
    }

    public String getInstructions(int index) {
        return instructions.get(index);
    }

    public String getImage(int index) {
        return image.get(index);
    }
}