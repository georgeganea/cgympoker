package org.cgympoker.users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class UserFile {

    public static void createUserFile(String user, String pass,String firstName, String lastName, String eMail) {
        try { 
            PrintStream outStream = new PrintStream(new FileOutputStream(user+".cgym"));
            outStream.println(pass); 
            outStream.println(firstName);
            outStream.println(lastName);
            outStream.println(eMail);
            outStream.close(); 
        }
        catch (Exception e) { 
            e.printStackTrace(); 
        }
    } 
    
    public static boolean checkPass(String user, String pass){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(user+".cgym"));
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
               
           
     
 



 