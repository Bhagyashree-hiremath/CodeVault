package service;
import model.Question;
import storage.FileManager;

import java.util.*;
import java.io.*;
import java.util.Random;


public class QuestionService {
    Scanner in = new Scanner(System.in);

    private FileManager fileManager = new FileManager();
    private ArrayList<Question> questions = new ArrayList<>();

    public QuestionService() {
        questions = fileManager.loadQuestions();
    }

    // Add Question
    public void addQuestion(Question question) {

        questions.add(question);

        fileManager.saveQuestions(questions);

        System.out.println("✅ Question added successfully!");
    }

    // View Questions
    public void viewQuestions() {

        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        System.out.println("\n========== ALL QUESTIONS ==========");

        for (Question question : questions) {
            System.out.println(question);
            System.out.println("----------------------------------");
        }
    }

    // Search by Topic
    public void searchByTopic(String topic) {

        boolean found = false;

        for (Question question : questions) {

            if (question.getTopic().equalsIgnoreCase(topic)) {

                System.out.println(question);
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No questions found for topic: " + topic);
        }
    }

    // Search by Company
    public void searchByCompany(String company) {

        boolean found = false;

        for (Question question : questions) {

            if (question.getCompany().equalsIgnoreCase(company)) {

                System.out.println(question);
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No questions found for company: " + company);
        }
    }
    // Search questions by difficulty
    public void searchByDifficulty(String difficulty) {

        boolean found = false;

        System.out.println("\n========== DIFFICULTY SEARCH ==========");

        for (Question question : questions) {

            if (question.getDifficulty().equalsIgnoreCase(difficulty)) {

                System.out.println(question);
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No questions found with difficulty: " + difficulty);
        }
    }

    // Update Question
    public void updateQuestion(int id,
                               String question,
                               String topic,
                               String difficulty,
                               String company) {

        for (Question q : questions) {

            if (q.getId() == id) {

                q.setQuestion(question);
                q.setTopic(topic);
                q.setDifficulty(difficulty);
                q.setCompany(company);

                fileManager.saveQuestions(questions);

                System.out.println("✅ Question updated successfully!");

                return;
            }
        }

        System.out.println("❌ Question ID not found!");
    }

    // Delete Question
    public void deleteQuestion(int id) {

        for (Question question : questions) {

            if (question.getId() == id) {

                questions.remove(question);

                fileManager.saveQuestions(questions);

                System.out.println("✅ Question deleted successfully!");

                return;
            }
        }

        System.out.println("❌ Question ID not found!");
    }

    // Mark as Favorite
    public void markAsFavorite(int id) {

        for (Question question : questions) {

            if (question.getId() == id) {

                question.setFavorite(true);

                fileManager.saveQuestions(questions);

                System.out.println("⭐ Question marked as favorite!");

                return;
            }
        }

        System.out.println("❌ Question ID not found!");
    }

    // View Favorite Questions
    public void viewFavoriteQuestions() {

        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        boolean found = false;

        System.out.println("\n========== FAVORITE QUESTIONS ==========");

        for (Question question : questions) {

            if (question.isFavorite()) {

                System.out.println(question);
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No favorite questions found.");
        }
    }
    // Dashboard
    public void showDashboard() {

        System.out.println("\n==========================================");
        System.out.println("        📊 CODEVAULT DASHBOARD");
        System.out.println("==========================================");

        // Total Questions
        System.out.println("📚 Total Questions : " + questions.size());

        // Favorite Questions
        int favoriteCount = 0;

        for (Question question : questions) {
            if (question.isFavorite()) {
                favoriteCount++;
            }
        }

        System.out.println("⭐ Favorite Questions : " + favoriteCount);

        // Companies Covered
        HashSet<String> companies = new HashSet<>();

        for (Question question : questions) {
            companies.add(question.getCompany());
        }

        System.out.println("🏢 Companies Covered : " + companies.size());

        // Difficulty Count
        int easyCount = 0;
        int mediumCount = 0;
        int hardCount = 0;

        for (Question question : questions) {

            String difficulty = question.getDifficulty();

            if (difficulty.equalsIgnoreCase("Easy")) {
                easyCount++;
            } else if (difficulty.equalsIgnoreCase("Medium")) {
                mediumCount++;
            } else if (difficulty.equalsIgnoreCase("Hard")) {
                hardCount++;
            }
        }

        System.out.println("🟢 Easy Questions   : " + easyCount);
        System.out.println("🟡 Medium Questions : " + mediumCount);
        System.out.println("🔴 Hard Questions   : " + hardCount);

        // Top Company
        HashMap<String, Integer> companyCount = new HashMap<>();

        for (Question question : questions) {

            String company = question.getCompany();

            companyCount.put(
                    company,
                    companyCount.getOrDefault(company, 0) + 1
            );
        }

        String topCompany = "N/A";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : companyCount.entrySet()) {

            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                topCompany = entry.getKey();
            }
        }

        System.out.println("🏆 Top Company : " + topCompany +
                " (" + maxCount + " Questions)");

        System.out.println("==========================================");
    }
    // Show Topic Statistics
    public void showTopicStatistics() {

        if (questions.isEmpty()) {
            System.out.println("❌ No questions available.");
            return;
        }

        HashMap<String, Integer> topicCount = new HashMap<>();

        // Count questions for each topic
        for (Question question : questions) {

            String topic = question.getTopic();

            topicCount.put(
                    topic,
                    topicCount.getOrDefault(topic, 0) + 1
            );
        }

        System.out.println("\n========== TOPIC STATISTICS ==========");

        // Display topic counts
        for (Map.Entry<String, Integer> entry : topicCount.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Find the most studied topic
        String topTopic = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : topicCount.entrySet()) {

            if (entry.getValue() > maxCount) {

                maxCount = entry.getValue();
                topTopic = entry.getKey();
            }
        }

        System.out.println("----------------------------------");
        System.out.println("📚 Most Studied Topic : " + topTopic +
                " (" + maxCount + " Questions)");
    }
    public void practiceRandomQuestion() {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        Question randomQuestion = questions.get(randomIndex);

        System.out.println("\n===== RANDOM QUESTION =====");
        System.out.println(randomQuestion);
    }
    public void sortQuestions() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n====== SORT QUESTIONS ======");
        System.out.println("1. Sort by Topic");
        System.out.println("2. Sort by Company");
        System.out.println("3. Sort by Difficulty");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                Collections.sort(questions,
                        Comparator.comparing(Question::getTopic));

                break;

            case 2:

                Collections.sort(questions,
                        Comparator.comparing(Question::getCompany));

                break;

            case 3:

                Collections.sort(questions,
                        Comparator.comparing(Question::getDifficulty));

                break;

            default:
                System.out.println("Invalid Choice!");
                return;
        }

        System.out.println("\nQuestions Sorted Successfully!\n");

        viewQuestions();
    }
    public void searchByKeyword() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Question question : questions) {

            if (question.getQuestion().toLowerCase().contains(keyword)
                    || question.getTopic().toLowerCase().contains(keyword)
                    || question.getCompany().toLowerCase().contains(keyword)) {

                System.out.println("-----------------------------------");
                System.out.println(question);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching questions found.");
        }
    }
    public void exportQuestions() {

        try {

            FileWriter writer = new FileWriter("CodeVault_Report.txt");

            writer.write("=========================================\n");
            writer.write("          CODEVAULT REPORT\n");
            writer.write("=========================================\n\n");

            for (Question question : questions) {

                writer.write(question.toString());
                writer.write("\n--------------------------------------\n");
            }

            writer.close();

            System.out.println("✅ Questions exported successfully!");
            System.out.println("📁 File Name : CodeVault_Report.txt");

        } catch (IOException e) {

            System.out.println("Error while exporting file.");
        }
    }
    public void showProgressTracker() {

        int easy = 0;
        int medium = 0;
        int hard = 0;
        int favorite = 0;

        HashSet<String> topics = new HashSet<>();
        HashSet<String> companies = new HashSet<>();

        for (Question q : questions) {

            topics.add(q.getTopic());
            companies.add(q.getCompany());

            if (q.getDifficulty().equalsIgnoreCase("Easy"))
                easy++;

            else if (q.getDifficulty().equalsIgnoreCase("Medium"))
                medium++;

            else if (q.getDifficulty().equalsIgnoreCase("Hard"))
                hard++;

            if (q.isFavorite())
                favorite++;
        }

        int total = questions.size();

        double progress = 0;

        if (total != 0) {
            progress = ((double) favorite / total) * 100;
        }

        System.out.println("\n=========================================");
        System.out.println("        📈 PROGRESS TRACKER");
        System.out.println("=========================================");

        System.out.println("📚 Total Questions      : " + total);
        System.out.println("🟢 Easy Questions       : " + easy);
        System.out.println("🟡 Medium Questions     : " + medium);
        System.out.println("🔴 Hard Questions       : " + hard);

        System.out.println("⭐ Favorite Questions   : " + favorite);

        System.out.println("📖 Topics Covered       : " + topics.size());

        System.out.println("🏢 Companies Covered    : " + companies.size());

        System.out.printf("🎯 Preparation Progress : %.2f%%\n", progress);

        System.out.println("=========================================");
    }
    public void quizMode() {

        if (questions.isEmpty()) {
            System.out.println("No questions available!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;

        System.out.println("\n========== QUIZ MODE ==========");

        for (int i = 1; i <= 5 && !questions.isEmpty(); i++) {

            Question q = questions.get(random.nextInt(questions.size()));

            System.out.println("\nQuestion " + i);
            System.out.println("--------------------------------");
            System.out.println(q.getQuestion());

            System.out.println("\nPress ENTER to reveal details...");
            sc.nextLine();

            System.out.println("Topic      : " + q.getTopic());
            System.out.println("Company    : " + q.getCompany());
            System.out.println("Difficulty : " + q.getDifficulty());

            System.out.print("\nDid you know this question? (y/n): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                score++;
            }
        }

        System.out.println("\n==================================");
        System.out.println("Quiz Completed!");
        System.out.println("Your Score : " + score + " / 5");
        System.out.println("==================================");
    }
    public void aboutCodeVault() {

        System.out.println("\n==================================================");
        System.out.println("                ABOUT CODEVAULT");
        System.out.println("==================================================");
        System.out.println("Application : CodeVault");
        System.out.println("Version     : 1.0");
        System.out.println("Developer   : Bhagyashree Hiremath");
        System.out.println();
        System.out.println("Description :");
        System.out.println("CodeVault is a Java-based Interview Question");
        System.out.println("Management System that helps users organize,");
        System.out.println("search, practice, and track interview questions.");
        System.out.println();
        System.out.println("Technologies Used:");
        System.out.println("• Java");
        System.out.println("• Object-Oriented Programming");
        System.out.println("• Collections Framework");
        System.out.println("• File Handling");
        System.out.println("• Git & GitHub");
        System.out.println("==================================================");
    }
    public void helpMenu() {

        System.out.println("\n================ HELP ================");
        System.out.println("1. Add interview questions.");
        System.out.println("2. Search by topic, company or keyword.");
        System.out.println("3. Practice using Quiz Mode.");
        System.out.println("4. Export questions to a report.");
        System.out.println("5. Track your preparation progress.");
        System.out.println("6. Mark important questions as Favorite.");
        System.out.println("======================================");
    }
    }

