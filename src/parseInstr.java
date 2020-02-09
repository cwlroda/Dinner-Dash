import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class parseInstr {

  public static void main(String[] args) {
    String dirPath = "./input";
    File dir = new File(dirPath);

    File[] filesInDir = dir.listFiles();

    System.out.println("size of filesInDir: " + filesInDir.length);

    for (File file : filesInDir) {
      // read file

      String fileName = file.getName();

      if (fileName.contains(".txt")) {
        StringBuffer instructionsBuffer = new StringBuffer();

        try {

          BufferedReader br = new BufferedReader(new FileReader(file));
          while (br.ready()) {
            instructionsBuffer.append(br.readLine());
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

        System.out.println("instructions: " + instructionsBuffer.toString());

        String instructions = instructionsBuffer.toString();

        List<String> instrList = Arrays.asList(instructions.split("\\."));

        System.out.println(instrList);

        List<List<String>> outParams = new ArrayList<>();

        for (String instr : instrList) {
          List<String> indivInstrs = new ArrayList<>();

          indivInstrs.add(instr);
          indivInstrs.add(Integer.toString(calcTime(instr)));
          indivInstrs.add(Boolean.toString(isIdle(instr)));
          indivInstrs.add(checkResources(instr));

          outParams.add(indivInstrs);
        }

        for (List<String> indivInstr : outParams) {
          System.out.println(indivInstr);
        }
      
      String fileJson = fileName.replace(".txt", ".json");
      File outputFile = new File("./output/"+fileJson);

      try{
        PrintWriter printWriter = new PrintWriter(new FileWriter(outputFile));
        printWriter.print("instructions = {");
        for(List<String> str : outParams) {
          String ins0 = str.get(0);
          String ins1 = str.get(1);
          String ins2 = str.get(2);
          String ins3 = str.get(3);

          printWriter.print(ins0 + ":{" + ins1 + ", " + ins2 + ", " + ins3 + "}");
        }
        printWriter.print("}");
        printWriter.close();

        boolean fileCreated = outputFile.createNewFile();
        assert(fileCreated);
      } catch (Exception e) {
        e.getStackTrace();
      }
      
    }
    }
  }

  private static String checkResources(String resources) {
    String[] appliances = {"oven", "steamer", "pan", "skillet", "microwave", "cooker"};

      for (String appliance : appliances) {
        if (resources.contains(appliance)) {
          return appliance;
        }
      }
      return null;
  }


  private static boolean isIdle(String idle) {
    String[] idlewords = {"stew", "bake", "preheat", "steam", "boil", "cook", "blend"};

        for (String idleword : idlewords) {
          if (idle.contains(idleword)) {
            return true;
          }
        }
        return false;
  }

  private static int calcTime(String instr) {
    instr = instr.trim();
    boolean containsOven = instr.contains("oven");
    String[] instrAsList = instr.split(", | ");
    int finalTime = 0;

    if (containsOven) {
      boolean containsMins = instr.contains("minutes");
      //System.out.println(text.indexOf(word));
      if (containsMins) {
        finalTime += getMinutesString(instrAsList);
      } else {
        boolean containsPreheat = instr.contains("preheat");
        if (containsPreheat) {
          finalTime += 10;
        }
      }
    } else {
      boolean containsMins = instr.contains("minutes");
      //System.out.println(text.indexOf(word));
      if (containsMins) {
        finalTime += getMinutesString(instrAsList);
      } else {
        String[] keywords = {"stir", "mix", "cut", "whisk", "beat", "saute", "rinse"};

        for (String keyword : keywords) {
          if (instr.contains(keyword)) {
            finalTime += 3;
          }
        }
      }
    }

    return finalTime;
  }

  private static int getMinutesString(String[] instrAsList) {
    int minsIndex = 1;

    for (int i = 0; i < instrAsList.length; i++) {
      if (instrAsList[i].equals("minutes")) {
        minsIndex = i;
      }
    }

    String noOfMins = instrAsList[minsIndex - 1];
    return Integer.valueOf(noOfMins);
  }
}