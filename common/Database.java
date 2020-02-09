package common;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// title, time, ingredients, instructions, image

public class Database{
    private JSONObject recipes = new JSONObject();
    private List<String> name = new ArrayList<>();
    private List<Integer> time = new ArrayList<>();
    private List<Map<String, Double>> ingredients = new ArrayList<>();
    private List<List<String>> instructions = new ArrayList<>();
    private List<String> image = new ArrayList<>();

    public Database(){
        JSONParser jsonParser = new JSONParser();

        try{
            Object obj = jsonParser.parse(new FileReader("/Users/cwlroda/Desktop/ICHack20/test.json"));
            recipes = (JSONObject) obj;

            //for(int i=6663; i<24180; i++){
                JSONObject tmp = (JSONObject)recipes.get(Integer.toString(6663));
                name.add(String.valueOf(tmp.get("Name")));
                JSONObject tmp2 = (JSONObject)tmp.get("Ingredients");
                //Map<String, Double> tmp3 = new HashMap<>();
                System.out.println(tmp2);
                List<String> l = new ArrayList<>();

                String[] keys = JSONObject.getNames(tmp2);

                for(String key : tmp2.keySet()){

                }
                l.add(ArrayList.valueOf(tmp2.get(key)))
                /* JSONObject tmp3 = (JSONObject)tmp2.get("q1");
                String tmp4 = String.valueOf(tmp3.get("question"));
                System.out.println(tmp4); */
            //}

            //for(int i=0; i<name.size(); i++){
            System.out.println(name.get(0));
            //}

            System.exit(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ParseException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getSize(){
        return recipes.size();
    }

    public String getName(int index){
        return name.get(index);
    }

    public int getTime(int index){
        return time.get(index);
    }

    public Map<String, Double> getIngredients(int index){
        return ingredients.get(index);
    }

    public List<String> getInstructions(int index){
        return instructions.get(index);
    }

    public String getImage(int index){
        return image.get(index);
    }
}