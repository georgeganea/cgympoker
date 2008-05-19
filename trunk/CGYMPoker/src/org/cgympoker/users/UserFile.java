package org.cgympoker.users;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class UserFile {

    public static void createUserFile(String user, String pass) {
        FileOutputStream out; 
        // declare a file output object
        PrintStream p;
        // declare a print stream object 
        try { 
            // Create a new file output stream
            // connected to "myfile.txt" 
            
            out = new FileOutputStream(user); 
            // Connect print stream to the output stream 
            p = new PrintStream( out );
            p.println (pass); 
            p.close(); 
        }
        catch (Exception e) { 
            e.printStackTrace();
           // System.err.println ("Error writing to file"); 
        }
    } 
    
    public static boolean checkPass(String user, String pass){
              
               FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(user);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
               
        
               
       
            String password = reader.readLine();
            System.out.println("|"+password+"=="+pass+"|"+password.compareTo(pass));
            return (password.compareTo(pass) == 0);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    
}


 }
               
           
     
 



 