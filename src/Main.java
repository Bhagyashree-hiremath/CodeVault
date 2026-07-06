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
            System.out.println("4. Search by Company");
            System.out.println("5. ⭐ Mark as Favorite");
            System.out.println("6. ⭐ View Favorite Questions");
            System.out.println("7. Update Question");
            System.out.println("8. Delete Question");
            System.out.println("9 Dashboard ");
            System.out.println("10. Exit");
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

                    System.out.print("Enter Company to Search: ");
                    String searchCompany = sc.nextLine();

                    service.searchByCompany(searchCompany);

                    break;
                case 5:

                    System.out.println("\n------ Mark as Favorite ------");

                    System.out.print("Enter Question Number (starting from 1): ");
                    int favIndex = sc.nextInt();
                    sc.nextLine();


                    service.markAsFavorite(favIndex - 1);


                    break;
                case 6:

                    System.out.println("\n------ Favorite Questions ------");

                    service.viewFavoriteQuestions();

                    break;
                case 7:

                    System.out.println("\n------ Update Question ------");

                    System.out.print("Enter Question Number (starting from 1): ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Question: ");
                    String newQuestion = sc.nextLine();

                    System.out.print("Enter New Topic: ");
                    String newTopic = sc.nextLine();

                    System.out.print("Enter New Difficulty: ");
                    String newDifficulty = sc.nextLine();

                    System.out.print("Enter New Company: ");
                    String newCompany = sc.nextLine();

                    service.updateQuestion(
                            index - 1,
                            newQuestion,
                            newTopic,
                            newDifficulty,
                            newCompany
                    );

                    break;
                case 8:

                    System.out.println("\n------ Delete Question ------");

                    System.out.print("Enter Question Number (starting from 1): ");
                    int deleteIndex = sc.nextInt();
                    sc.nextLine();

                    service.deleteQuestion(deleteIndex - 1);

                    break;
                case 9:

                    System.out.println("\n------ Dashboard ------");

                    service.showDashboard();
                    break;
                case 10:

                    System.out.println("\n====================================");
                    System.out.println("Thank you for using CodeVault ❤️");
                    System.out.println("====================================");

                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 10);


        sc.close();
    }
}