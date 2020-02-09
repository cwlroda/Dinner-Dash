import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CopyFile
{
    public static void main(String[] args)
    {
        String dirPath = "./instructions";
        File dir = new File(dirPath);

        File[] filesInDir = dir.listFiles();

        System.out.println("size of filesInDir: " + filesInDir.length);

        for (File file : filesInDir) {
            // read file

            String fileName = file.getName();

            if(fileName.contains(".txt")) {
                StringBuffer instructionsBuffer = new StringBuffer();

                try{

                    BufferedReader br = new BufferedReader(new FileReader(file));
                    while(br.ready()) {
                        instructionsBuffer.append(br.readLine());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("instructions: " + instructionsBuffer.toString());
            
        String instructions = instructionsBuffer.toString();

        List<String> instrlist = Arrays.asList(instructions.split("."));

        System.out.println(instrlist);
    
        List<String[]> outParams = new ArrayList<>();
        for (int i = 0; i < instrlist.size(); i++) {
            String instr = instrlist.get(i);
            String[] param = new String[2];
            // calculate the time taken for one step
            param[0] = instr;
            param[1] = calcTime(instr);
            //param[2] = calcIdle(instr);
            //param[3] = calcResource(instr);
            outParams.add(param);
            }
        }
    }
}

    private static String calcTime(String instr) {
        
        boolean containsOven = instr.contains("oven");
        String[] instrAsList = instr.split(" ");

        if(containsOven){
            boolean containsMins = instr.contains("minutes");
            //System.out.println(text.indexOf(word));
            if(containsMins){
                int minsIndex = 1;
                for(int i = 0; i < instrAsList.length; i++) {
                    if (instrAsList[i].equals("minutes")) {
                        minsIndex = i;
                    }
                }

                String noOfMins = instrAsList[minsIndex - 1];
                return noOfMins;
            }
            else {
                boolean containsPreheat = instr.contains("preheat");
                if(containsPreheat){
                    return "10";
                }
    
                else {
                    return "0";
                }
            }
        }
        
        else {
            boolean containsMins = instr.contains("minutes");
            //System.out.println(text.indexOf(word));
            if(containsMins){
                int minsIndex = 1;
                for(int i = 0; i < instrAsList.length; i++) {
                    if (instrAsList[i].equals("minutes")) {
                        minsIndex = i;
                    }
                }

                String noOfMins = instrAsList[minsIndex - 1];
                return noOfMins;
            }

            else {
                String[] keywords = {"stew", "fry", "stir", "place"};

                for (String keyword : keywords) {
                    if (instr.contains(keyword)) {
                        return "5";
                    }
                }
                 return "0";
            }

        }
    }
        
/*
    private static String calcIdle(String intr) {
        return 0;
    }

    private static String calcResource(String intr) {
        
    }
*/

}
    