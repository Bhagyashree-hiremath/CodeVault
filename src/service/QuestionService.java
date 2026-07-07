package service;

import model.Question;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import storage.FileManager;
import java.util.Map;
public class QuestionService {


    // List to store all questions
    private FileManager fileManager = new FileManager();
    private ArrayList<Question> questions = new ArrayList<>();
    public QuestionService(){
    questions = fileManager.loadQuestions();
}

    // Add a new question
    public void addQuestion(Question question) {

        questions.add(question);

        fileManager.saveQuestions(questions);

        System.out.println("✅ Question added successfully!");
    }

    // View all questions
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

    // Search questions by topic
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
            System.out.println("No questions found for topic: " + topic);
        }
    }

    public void searchByCompany(String company) {

        boolean found = false;

        System.out.println("\n========== COMPANY SEARCH ==========");

        for (Question question : questions) {

            if (question.getCompany().equalsIgnoreCase(company)) {

                System.out.println(question);
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No questions found for company: " + company);
        }
    }

    // Update question
    public void updateQuestion(int index, String question, String topic,
                               String difficulty, String company) {

        if (index < 0 || index >= questions.size()) {
            System.out.println("❌ Invalid Question Number!");
            return;
        }

        Question q = questions.get(index);

        q.setQuestion(question);
        q.setTopic(topic);
        q.setDifficulty(difficulty);
        q.setCompany(company);

        System.out.println("✅ Question Updated Successfully!");
        fileManager.saveQuestions(questions);
    }

    // Delete a question
    public void deleteQuestion(int index) {

        if (index < 0 || index >= questions.size()) {
            System.out.println("❌ Invalid Question Number!");
            return;
        }

        Question deletedQuestion = questions.remove(index);

        System.out.println("✅ Question Deleted Successfully!");
        System.out.println("Deleted Question:");
        System.out.println(deletedQuestion);
        questions.remove(index);
        fileManager.saveQuestions(questions);
    }
    public void markAsFavorite(int index) {

        if (index < 0 || index >= questions.size()) {
            System.out.println("❌ Invalid Question Number!");
            return;
        }

        Question q = questions.get(index);
        q.setFavorite(true);

        // Save updated data to file
        fileManager.saveQuestions(questions);

        System.out.println("⭐ Question marked as favorite!");
    }


    // View all favorite questions
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

    public void showDashboard() {
        System.out.println("\n==========================================");
        System.out.println("        📊 CODEVAULT DASHBOARD");
        System.out.println("==========================================");

        System.out.println("📚 Total Questions : " + questions.size());
        int favoriteCount = 0;

        for (Question question : questions) {
            if (question.isFavorite()) {
                favoriteCount++;
            }
        }
        System.out.println("⭐ Favorite Questions : " + favoriteCount);

        HashSet<String> companies = new HashSet<>();

        for (Question question : questions) {
            companies.add(question.getCompany());
        }

        System.out.println("🏢 Companies Covered : " + companies.size());


        int easyCount = 0;
        int mediumCount = 0;
        int hardCount = 0;

        for (Question q : questions) {

            String difficulty = q.getDifficulty();

            if (difficulty.equalsIgnoreCase("Easy")) {
                easyCount++;
            } else if (difficulty.equalsIgnoreCase("Medium")) {
                mediumCount++;
            } else if (difficulty.equalsIgnoreCase("Hard")) {
                hardCount++;
            }
        
            // Top Company
            HashMap<String, Integer> companyCount = new HashMap<>();

            for (Question question : questions) {
                String company = question.getCompany();
                companyCount.put(company, companyCount.getOrDefault(company, 0) + 1);
            }

            String topCompany = "";
            int maxCount = 0;

            for (Map.Entry<String, Integer> entry : companyCount.entrySet()) {

                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    topCompany = entry.getKey();
                }
            }

            System.out.println("🏆 Top Company : " + topCompany +
                    " (" + maxCount + " Questions)");
        }

        System.out.println("Easy   : " + easyCount);
        System.out.println("Medium : " + mediumCount);
        System.out.println("Hard   : " + hardCount);


        HashMap<String, Integer> companyCount = new HashMap<>();

        for (Question question : questions) {

            String company = question.getCompany();

            companyCount.put(company,
                    companyCount.getOrDefault(company, 0) + 1);
        }

        String topCompany = "";
        int maxCount = 0;

        for (
                String company : companyCount.keySet()) {

            int count = companyCount.get(company);

            if (count > maxCount) {
                maxCount = count;
                topCompany = company;
            }
        }
        System.out.println("🏆 Top Company : " + topCompany + " (" + maxCount + " Questions)");

    }
}