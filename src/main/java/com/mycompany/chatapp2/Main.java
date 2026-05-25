/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp2;
import com.mycompany.chatapp2.Login;
/**
 *
 * @author mosia
 */
import java.util.Scanner;

public class Main {

    private static boolean loginSuccess;
    public static void main(String[] args){
         // Step 10: This step is where the program interacts with the user
        // A scanner is created or inputed to be able to allow the user to insert values/personal details information.
        Scanner input = new Scanner(System.in);

        

        // Variables that are being stored / declared.
        String username = null;
        String password = null;
        String phone = null;
        String firstName = null;
        String lastName = null;

        // -------- USER REGISTRATION --------
        boolean loggedRegistration = false;

        while (!loggedRegistration) {
            System.out.println("=== USER REGISTRATION ===");
            
             System.out.print("Enter firstName : ");
             firstName = input.nextLine();
             
             System.out.print("Enter lastName : ");
             lastName = input.nextLine();
             
            // Username
            System.out.print("Enter a username: ");
            username = input.nextLine();
            
            Login templogin = new Login(username, "", "", firstName,lastName);
                    
            if (!templogin.checkUserName(username)) {
                System.out.println("Username is not correctly formatted;please ensure that your contains an underscore and is no more than five characters in length.");
                continue; // go back to start of loop
            }
            System.out.println("Username successfully captured");

            // Password
            System.out.print("Enter a password: ");
            password = input.nextLine();

            if (!templogin.checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted;please ensure that the password contains at least eight characters ,a capital letter,a number, and special character.");
                continue;
            }
            System.out.println("Password successfully captured.");

            System.out.print("Enter cell phone number (+27...): ");
            phone = input.nextLine();

            if (!templogin.checkCellPhoneNumber(phone)) {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
                continue;
            }
            System.out.println("Cell phone number successfully added.");
        
            Login login = new Login(username, password, phone, firstName, lastName);
            // Register user
           
            String result = login.registerUser("firstName","lastName",username);
            System.out.println(result);
           //here the loop is now being exitted,the loop stop /Exit
            loggedRegistration = true; 
        }
        
        Login login = new Login(username, password, phone, firstName, lastName);

        // -------- USER LOGIN --------
        boolean signIn = false;

        while (!signIn) {
            System.out.println("\n=== USER LOGIN ===");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();
            
            
            boolean success = login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus(success));

            String message = login.returnLoginStatus(success);
            

            if (success) {
                // The loop is going to stop only when the login is correct.
                signIn = true;
            }
        }
    }
}