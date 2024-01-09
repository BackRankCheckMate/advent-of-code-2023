package Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class CubeConundrum {


    // reads only a single digit, need to rewrite this
    // possible idea: don't return immediately, n+n*10 first and then return the value
    // possible idea 2: convert String to character, then repeat possible idea 1 ( maybe not haha )
    public static Integer getNumericValue (String gameIndex) {
        for (char c : gameIndex.toCharArray()) {
            if ( c >= 48 && c <= 57 ) 
                return Character.getNumericValue(c); 
        }
        return null;
    }

    public static int classifyRecords ( String line ) {
        int sum = 0;
        int n = 0;
        int colorsArray[] = { 0, 0, 0};
        String[] parts = line.split(":",2); //  Game 1 | 7 blue, 6 green ...

        String[] furtherDivisionForIndexOnly = parts[0].split(" "); // Game | 1

        String gameIndexValue = furtherDivisionForIndexOnly[1];
        char[] gameIndexCharacter = gameIndexValue.toCharArray();
       
        for (char c : gameIndexCharacter) {
            n = n*10 + Character.getNumericValue(c);
        }
        
        

        String[] gameDataPerSet = parts[1].split(";",4);    //  7 blue, 6 green, 3 red      

        for (int i = 0; i < gameDataPerSet.length; i++) {
            colorsArray = storeGameDataRecords(gameDataPerSet[i]);
        }

        if(colorsArray[0] <= 12 && colorsArray[1] <=14 && colorsArray[2] <= 13)
            sum+=n;

        return sum;
  
    }


    // Reads only single value, need to rewrite getNumericValue function
    public static int[] storeGameDataRecords ( String gameDataPerSet ) {
        String[] individualSetValue = gameDataPerSet.split(",");  // 7 blue
        
        int colorsArray[] = { 0, 0, 0};

        for (int i = 0; i < individualSetValue.length; i++) {
            int n = getNumericValue(individualSetValue[i]);
            if ( individualSetValue[i].contains("red")) 
                colorsArray[0] += n;
            else if ( individualSetValue[i].contains("blue")) 
                colorsArray[1] += n;
            else if ( individualSetValue[i].contains("green"))
                colorsArray[2] += n;        
        }
        
        return colorsArray;
        
        // return false;
    }


    public static void main(String[] args) {
        try {
            int num = 0, sum = 0;
            BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\kafle\\OneDrive\\Desktop\\advent-of-code-2023\\Day2\\input.txt"));
            String line;


            while ( (line = bfr.readLine())!=null) {
                num = classifyRecords(line);
                sum += num;    
            }

            System.out.println(sum);
            bfr.close();
        } catch (Exception e) {
            System.out.println("exception");
            // TODO: handle exception
        }
    }
}
