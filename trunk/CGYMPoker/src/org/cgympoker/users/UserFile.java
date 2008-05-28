package org.cgympoker.users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class UserFile {

    public static boolean createUserFile(String user, String pass,String firstName, String lastName, String eMail) {
        try { 
            File file = new File(user+".cgym");
            if (file.exists()){
                return false;
            }
            PrintStream outStream = new PrintStream(new FileOutputStream(user+".cgym"));
            outStream.println(pass); 
            outStream.println(firstName);
            outStream.println(lastName);
            outStream.println(eMail);
            outStream.close();
            return true;
        }
        catch (Exception e) { 
            e.printStackTrace(); 
            return false;
        }
    } 
    
    public static boolean checkPass(String user, String pass){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(user+".cgym"));
            String password = reader.readLine();
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
               
           
     
 



 