package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Trebuchet {

    public static Integer searchFromFirst ( String line ) {
        for (char c : line.toCharArray()) {
            if ( c >= 48 && c <= 57 ) 
                return Character.getNumericValue(c);    
        }
        return null;
    }

    public static Integer searchFromLast ( String line ) {
        for (char c : line.toCharArray()) {
            if( c >= 48 && c <=57 ) 
                return Character.getNumericValue(c);
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            int a = 0, b = 0, num =0, sum = 0;
            StringBuilder sb;
            BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\kafle\\OneDrive\\Desktop\\advent-of-code-2023\\Day1\\input.txt"));
            String line;   

            while ((line = bfr.readLine()) != null) {
                a =  searchFromFirst(line);  
                sb = new StringBuilder(line);
                b = searchFromLast(sb.reverse().toString());
                num = a*10 + b;
                sum += num;                
            }

            System.out.println(sum);
            
            bfr.close();
        }              
        catch (IOException e) {
            System.out.println(e);
        }     
    }    
}
