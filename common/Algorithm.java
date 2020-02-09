package common;

import common.Database;

import java.io.Reader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Algorithm{
    private static List<List<String>> ingredients = new ArrayList<>();
    private static int time;
    private List<List<String>> result = new ArrayList<>();

    public Algorithm(List<List<String>> a, int b){
        ingredients = a;
        time = b;
    }

    public void run(){
        Database db = new Database();
        int index=0;

        for(int i=0; i<db.getSize(); i++){
            List<String> recipe = db.getRecipe(i);
            //System.out.println(recipe.get(2).get(0));

            /* for(int j=0; j<recipe.size(); j++){
                System.out.println(recipe.get(j));
            } */

            /* if(Integer.parseInt(recipe.get(1)) > ingredients.size()){
                continue; d
            } */

            // else{
            if(recipe.get(2).contains(ingredients.get(0).get(0))){
                result.add(recipe);
                index++;
            }
            // }
        }
    }

    public void print(){
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args){
        List<List<String>> input = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        String line;
        int time = 1;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter ingredient");
        tmp.add(in.nextLine());
        System.out.println("Enter quantity");
        tmp.add(in.nextLine());

        while(true){
            if(!in.hasNextLine()){
                break;
            }

            List<String> temp = new ArrayList<>();

            System.out.println("Enter ingredient");
            temp.add(in.nextLine());
            System.out.println("Enter quantity");
            temp.add(in.nextLine());

            input.add(tmp);
        }

        Algorithm A = new Algorithm(input, time);
        A.run();
        A.print();
    }
}