package com.driver;

import java.util.Arrays;
import java.util.HashSet;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {

        return emailId;
    }

    public String getPassword() {

        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(password.equals(oldPassword)){
            boolean haveLower=false;
            boolean haveUpper=false;
            boolean haveDigit=false;
            boolean havespl=false;
           HashSet<Character>set=new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&','*', '(', ')', '-', '+'));
        for(char i: newPassword.toCharArray()){
            if(Character.isLowerCase(i)){
                haveLower=true;
            }
            if(Character.isUpperCase(i)){
                haveUpper=true;
            }
            if(Character.isDigit(i)){
                haveDigit=true;
            }
            if(set.contains(i)){
                havespl=true;
            }
        }
        if((havespl == true && haveDigit == true && haveLower == true && haveUpper ==true) && newPassword.length()>=8){
            password=newPassword;
        }

        }
    }
}
