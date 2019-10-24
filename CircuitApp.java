/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100629476
 */
import java.io.*;
import java.util.*;

public class CircuitApp {
  public static double calculate(double R1, double R2, double R3, double R4, double R5, double R6) {
    return ((R1 + R2)*R4*R6)/((R3 + R4)*R1*R5)  ;
  }
  
  public static void main(String args[]) {
    
    
    String fileName = null;
    
    if(args.length > 0) {
      System.out.println("Reading filename: "+args[0]);

      try {
        PrintWriter goodOnes = new PrintWriter("good.txt", "UTF-8");
        FileInputStream stream = new FileInputStream(args[0]);
        BufferedReader badOnes = new BufferedReader(new InputStreamReader(stream));
        
        System.out.println("Saving good designs to good.txt");
        System.out.println("The following are bad designs:");
      
        String line = "";
        
      	while ((line = badOnes.readLine()) != null) {
            String[] numbers = line.split("\t");
      		
            if(CircuitApp.calculate(
                    Double.parseDouble(numbers[0]), 
                    Double.parseDouble(numbers[1]), 
                    Double.parseDouble(numbers[2]), 
                    Double.parseDouble(numbers[3]), 
                    Double.parseDouble(numbers[4]), 
                    Double.parseDouble(numbers[5])
            ) == 7.5) {
      		goodOnes.println(line);
            } else {
      		 System.out.println(line);
            }
      	}
      	badOnes.close();
      	goodOnes.close();
      } catch(FileNotFoundException e) {
        System.out.println("File does not exist");
      } catch(UnsupportedEncodingException e) {
        System.out.println("Encoding error");
      } catch(IOException e) {
        System.out.println("IO Exception"); 
      }
    } else {
      System.out.println("Please input a file name as an argument");
    }
  }
}

