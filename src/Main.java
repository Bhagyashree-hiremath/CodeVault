import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("          CODEVAULT");
            System.out.println("====================================");
            System.out.println("1. Add Question");
            System.out.println("2. View Questions");
            System.out.println("3. Search Question");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Add Question feature coming soon...");
                    break;

                case 2:
                    System.out.println("View Questions feature coming soon...");
                    break;

                case 3:
                    System.out.println("Search Question feature coming soon...");
                    break;

                case 4:
                    System.out.println("Thank you for using CodeVault!");
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 4);

        sc.close();
    }
}