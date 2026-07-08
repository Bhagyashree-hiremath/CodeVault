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
            System.out.println("5. Search by Difficulty");
            System.out.println("6. Mark Question as Favorite");
            System.out.println("7. View Favorite Questions");
            System.out.println("8. Dashboard");
            System.out.println("9. Update Question");
            System.out.println("10. Delete Question");
            System.out.println("11. Practice Random Question");
            System.out.println("12. Topic Statistics");
            System.out.println("13. Exit");
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

                    System.out.print("Enter Question: ");
                    String question = sc.nextLine();

                    System.out.print("Enter Topic: ");
                    String topic = sc.nextLine();

                    System.out.print("Enter Difficulty: ");
                    String difficulty = sc.nextLine();

                    System.out.print("Enter Company: ");
                    String company = sc.nextLine();

                    service.addQuestion(new model.Question(question, topic, difficulty, company));
                    break;

                case 2:
                    service.viewQuestions();
                    break;

                case 3:
                    System.out.print("Enter Topic: ");
                    service.searchByTopic(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Company: ");
                    service.searchByCompany(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Difficulty: ");
                    service.searchByDifficulty(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Question ID: ");
                    int favId = sc.nextInt();
                    sc.nextLine();
                    service.markAsFavorite(favId);
                    break;

                case 7:
                    service.viewFavoriteQuestions();
                    break;

                case 8:
                    service.showDashboard();
                    break;

                case 9:

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

                case 10:
                    System.out.print("Enter Question ID: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    service.deleteQuestion(deleteId);
                    break;

                case 11:
                    service.practiceRandomQuestion();
                    break;

                case 12:
                    service.showTopicStatistics();
                    break;

                case 13:
                    System.out.println("\n====================================");
                    System.out.println("Thank you for using CodeVault ❤️");
                    System.out.println("====================================");
                    break;

                default:
                    System.out.println("❌ Invalid Choice!");
            }

        } while (choice != 13);

        sc.close();
    }
}