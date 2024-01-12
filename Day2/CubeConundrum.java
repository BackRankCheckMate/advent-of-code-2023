package Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class CubeConundrum {

    /**
     * 
     * @param line
     * @return the game number i.e if input is Game 1, returns 1
     */

    static int getNumericValue ( String line )  {
        int n = 0;
        for (char c : line.trim().toCharArray()) {
            if ( c >= 48 && c <= 57 ) 
                n = n*10+ Character.getNumericValue(c);
        }
        return n;
    }

    /**
     * 
     * @param line
     * @return boolean value after checking whether the more than the valid cubes were taken out at any game
     */
    static boolean checkForValidity ( String line ) {
        boolean flag = true;
        int red = 0, green = 0, blue = 0;
        if ( line.contains("red")) {
            red = getNumericValue(line);
        } else if ( line.contains("green")) {
            green = getNumericValue(line);
        } else {
            blue = getNumericValue(line);
        }
        if ( red > 12 || green > 13 || blue > 14) {
            flag = false;
        }
        return flag;
    }

    /**
     * 
     * @param line
     * scraps the data further on the basis of spaces, last method where the data is further divided
     */
    static boolean perSetData ( String line ) {
        boolean valid = true;
        String perSetCubes[] = line.trim().split(",");
        for (String string : perSetCubes) {
            // System.out.println(string);
            valid = checkForValidity(string);
            if ( valid == false) 
                break;
        }
        return valid;
    } 

    /**
     * 
     * @param line
     * disects the data passed into data sets i.e. separates the data on the basis of semicolons
     */
    static boolean dataSetDisection ( String line ) {
        boolean valid = true;
        String dataSet[] = line.trim().split(";");
        for (String string : dataSet) {
            valid = perSetData(string);
            if ( valid == false ) {
                break;
            }
        }
        return valid;
    }

    /**
     * 
     * @param line
     * divides the line read from the file into two parts on the basis of colon, passes the second part of data to dataSetDisection()
     */
    static int initialDataDisection ( String line ) {
        
        boolean valid;
        String initialDisectedData[] = line.split(":");

        int gameIndex = getNumericValue(initialDisectedData[0]);

        valid = dataSetDisection(initialDisectedData[1]);
        
        if ( valid  ) {
            return gameIndex;
        }
        
        return 0;
        
        // System.out.println(gameIndex);
        // System.out.println("==================================================================================================");
    }

    public static void main(String[] args) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\kafle\\OneDrive\\Desktop\\advent-of-code-2023\\Day2\\input.txt"));

            String line;
            int sum = 0;
            while ((line = bfr.readLine())!=null) {
                int n = initialDataDisection(line);
                sum += n;
            }
            System.out.println(sum);

            bfr.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}