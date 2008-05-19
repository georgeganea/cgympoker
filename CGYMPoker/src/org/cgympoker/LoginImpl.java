package org.cgympoker;


import org.cgympoker.users.UserFile;

public class LoginImpl implements Login{

    public Server login(String user, String pass)  {
        System.out.println("am apelat o metoda de pe server");
        //System.out.println(UserFile.checkPass(user, pass));
        if (UserFile.checkPass(user, pass)){
            System.out.println("iese pe aici");
            return new ServerImpl();
        }
        
        else {
            System.out.println("e false");
            return null;
        }
    }

    public Server createAccount(String user, String pass, String firstName, String lastName, String eMail){
        UserFile.createUserFile(user, pass);
        return new ServerImpl();
    }

   

}
