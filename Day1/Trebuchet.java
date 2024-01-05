package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class Trebuchet {
    
    public static Integer searchFromFirst ( String line, String arr[], Dictionary<String, Integer> values ) {
        String temp = "";

        for (char c : line.toCharArray()) {
            temp += c;
            for(int i = 0; i < arr.length; i++ ) {
                if( temp.contains(arr[i])) 
                    return values.get(arr[i]);
                
                else if ( c >= 48 && c <= 57 ) 
                    return Character.getNumericValue(c); 
            }
                   
        }
        return null;
    }

    public static Integer searchFromLast ( String line, String arr[], Dictionary<String, Integer> values ) {
        String temp = "";
        for (char c : line.toCharArray()) {
            temp = c + temp;
            
            for(int i = 0; i < arr.length; i++ ) {
                if( temp.contains(arr[i])) 
                    return values.get(arr[i]);
                else if( c >= 48 && c <=57 ) 
                return Character.getNumericValue(c);
            }
        }
        return null;
    }

    public static void main(String[] args) {

         Dictionary<String, Integer> numbers = new Hashtable<>();
         numbers.put("zero", 0);
         numbers.put("one", 1);
         numbers.put("two", 2);
         numbers.put("three", 3);
         numbers.put("four", 4);
         numbers.put("five", 5);
         numbers.put("six", 6);
         numbers.put("seven", 7);
         numbers.put("eight", 8);
         numbers.put("nine", 9);
         
        String arr[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"," zero"};

        try {
            int a = 0, b = 0, num =0, sum = 0;
            StringBuilder sb;
            BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\kafle\\OneDrive\\Desktop\\advent-of-code-2023\\Day1\\input.txt"));
            String line;   

            // int control = 0;

            while ((line = bfr.readLine()) != null) {
                a =  searchFromFirst(line, arr, numbers);  
                sb = new StringBuilder(line);
                b = searchFromLast(sb.reverse().toString(), arr, numbers);
                num = a*10 + b;
                sum += num;  
                
                // if(control == 1) 
                //     break;         
                // control++;         
            }
            
            System.out.println(sum);
            
            bfr.close();
        }              
        catch (IOException e) {
            System.out.println(e);
        }     
    }    
}
