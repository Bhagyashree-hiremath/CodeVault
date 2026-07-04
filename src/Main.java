import model.Question;
import service.QuestionService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuestionService service = new QuestionService();

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("           📚 CODEVAULT");
            System.out.println(" Interview Question Management System");
            System.out.println("==========================================");
            System.out.println("1. Add Question");
            System.out.println("2. View Questions");
            System.out.println("3. Search by Topic");
            System.out.println("4. Update Question (Coming Soon)");
            System.out.println("5. Delete Question (Coming Soon)");
            System.out.println("6. Exit");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {

                case 1:

                    System.out.println("\n------ Add New Question ------");

                    System.out.print("Enter Question: ");
                    String question = sc.nextLine();

                    System.out.print("Enter Topic: ");
                    String topic = sc.nextLine();

                    System.out.print("Enter Difficulty: ");
                    String difficulty = sc.nextLine();

                    System.out.print("Enter Company: ");
                    String company = sc.nextLine();

                    Question q = new Question(question, topic, difficulty, company);

                    service.addQuestion(q);

                    break;

                case 2:

                    System.out.println("\n------ All Questions ------");

                    service.viewQuestions();

                    break;

                case 3:

                    System.out.print("Enter Topic to Search: ");
                    String searchTopic = sc.nextLine();

                    service.searchByTopic(searchTopic);

                    break;

                case 4:

                    System.out.println("🚧 Update feature will be added soon.");

                    break;

                case 5:

                    System.out.println("🚧 Delete feature will be added soon.");

                    break;

                case 6:

                    System.out.println("\n====================================");
                    System.out.println("Thank you for using CodeVault ❤️");
                    System.out.println("====================================");

                    break;

                default:

                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}