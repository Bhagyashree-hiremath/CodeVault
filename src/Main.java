import model.Question;
import service.QuestionService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuestionService service = new QuestionService();

        int choice = 0;

        do {

            System.out.println("\n==========================================");
            System.out.println("           📚 CODEVAULT");
            System.out.println(" Interview Question Management System");
            System.out.println("==========================================");
            System.out.println("1. Add Question");
            System.out.println("2. View Questions");
            System.out.println("3. Search by Topic");
            System.out.println("4. Search by Company");
            System.out.println("5. Mark Question as Favorite");
            System.out.println("6. View Favorite Questions");
            System.out.println("7. Dashboard");
            System.out.println("8. Update Question");
            System.out.println("9. Delete Question");
            System.out.println("10. Exit");
            System.out.println("==========================================");

            try {
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter a valid number.");
                sc.nextLine();
                continue;
            }

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

                    service.viewQuestions();

                    break;

                case 3:

                    System.out.print("Enter Topic: ");
                    String searchTopic = sc.nextLine();

                    service.searchByTopic(searchTopic);

                    break;

                case 4:

                    System.out.print("Enter Company: ");
                    String searchCompany = sc.nextLine();

                    service.searchByCompany(searchCompany);

                    break;

                case 5:

                    System.out.print("Enter Question ID: ");
                    int favoriteId = sc.nextInt();
                    sc.nextLine();

                    service.markAsFavorite(favoriteId);

                    break;

                case 6:

                    service.viewFavoriteQuestions();

                    break;

                case 7:

                    service.showDashboard();

                    break;

                case 8:

                    System.out.print("Enter Question ID: ");
                    int updateId = sc.nextInt();
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
                            updateId,
                            newQuestion,
                            newTopic,
                            newDifficulty,
                            newCompany
                    );

                    break;

                case 9:

                    System.out.print("Enter Question ID: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    service.deleteQuestion(deleteId);

                    break;

                case 10:

                    System.out.println("\n====================================");
                    System.out.println("Thank you for using CodeVault ❤️");
                    System.out.println("====================================");

                    break;

                default:

                    System.out.println("❌ Invalid Choice!");
            }

        } while (choice != 10);

        sc.close();
    }
}