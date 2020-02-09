package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

//import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// title, time, ingredients, instructions, image

public class Database{
    private List<List<String>> recipes = new ArrayList<>();

    public Database(){
        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader("*.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray recipes = (JSONArray) obj;
            System.out.println(recipes);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getSize(){
        return recipes.size();
    }

    public List<String> getRecipe(int index){
        return recipes.get(index);
    }
}