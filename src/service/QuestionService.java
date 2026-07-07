package service;

import model.Question;
import storage.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class QuestionService {

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
}