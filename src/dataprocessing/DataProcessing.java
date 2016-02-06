/*
 * Use to separate rating.dat into two set: male and female by looking into another file
 * users.dat to see if the user ID is male or female.
 */

package dataprocessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author YU LI
 */
public class DataProcessing {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        PrintWriter writer = new PrintWriter("output.dat", "UTF-8");
        try (BufferedReader br = new BufferedReader(new FileReader("ratings.dat"))) {
        String line;
        int count = 1; 
        
    while ((line = br.readLine()) != null) {
        String delims = "::";
        String[] tokens = line.split(delims);
        
        System.out.println("count = " + count);
        int userID = Integer.parseInt(tokens[0]); 
        if (userID == count)
        {
            System.out.println("inside if count");
        }
        else 
        {   
            count++; 
        }
        //Read user information from user.dat
        try (BufferedReader br1 = new BufferedReader(new FileReader("users.dat"))) {
            String lineIWant = null; 
            for(int i = 0; i < count; i++)
            { 
                lineIWant = br1.readLine();
            }
           
           String delims1 = "::";
           String[] tokens1 = lineIWant.split(delims1);
           if (tokens1[1].equals("M"))
                {
                    writer.println(line);               
                }     
        } 
    }
    writer.close();
   }
  }
}
    
