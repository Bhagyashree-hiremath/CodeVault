package auth;

import java.util.Scanner;

public class Login {

    private final String USERNAME = "bhagya";
    private final String PASSWORD = "123456";

    public boolean login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("         WELCOME TO CODEVAULT");
        System.out.println("========================================");

        System.out.print("Username : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {

            System.out.println("\nLogin Successful!\n");

            return true;
        }

        System.out.println("\nInvalid Username or Password!");

        return false;
    }
}
