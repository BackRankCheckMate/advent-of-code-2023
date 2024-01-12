package Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class CubeConundrum2 {
    static int getNumericValue ( String line )  {
        int n = 0;
        for (char c : line.trim().toCharArray()) {
            if ( c >= 48 && c <= 57 ) 
                n = n*10+ Character.getNumericValue(c);
        }
        return n;
    }


    static int[] furtherDisection ( String line ) {
        int maxArr[] = {0,0,0};
        int red = 0, green = 0, blue = 0;
        String dis3[] = line.split(",");
        for (String string : dis3) {
            if( string.contains("red")) {
                red = getNumericValue(string);
                if ( red > maxArr[0])
                    maxArr[0] = red;
            } else if ( string.contains("green")) {
                green = getNumericValue(string);
                if ( green > maxArr[1])
                    maxArr[1] = green;
            } else {
                blue = getNumericValue(string);
                if ( blue > maxArr[2])
                    maxArr[2] = blue;
            }
        }
        return maxArr;
    }

    static int dissection(String line ) {
        int maxArr[] = {0,0,0};
        int tempArr[] = {0,0,0};
        int result = 0;
        String dis1[] = line.split(":");
        String dis2[] = dis1[1].split(";");
        for (String string : dis2) {
            tempArr = furtherDisection(string);
            for (int i = 0; i < maxArr.length; i++) {
                if ( maxArr[i] < tempArr[i] )
                    maxArr[i] = tempArr[i];
            }
        }

        result = maxArr[0] * maxArr[1] * maxArr[2];
        return result;
        // System.out.println("========");
    }

    public static void main(String[] args) {
        int n = 0;
        int sum = 0;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\kafle\\OneDrive\\Desktop\\advent-of-code-2023\\Day2\\input.txt"));

            String line;

            while ( (line = bfr.readLine())!=null ) {
                n = dissection(line);
                sum += n;
            }
            System.out.println(sum);
            bfr.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
