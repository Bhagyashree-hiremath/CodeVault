package service;

import model.Question;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionService {

    // List to store all questions
    private ArrayList<Question> questions = new ArrayList<>();

    // Add a new question
    public void addQuestion(Question question) {
        questions.add(question);
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

                System.out.println("✅ Question updated successfully!");

                return;
            }
        }

        System.out.println("❌ Question ID not found!");
    }

    // Delete a question
    public void deleteQuestion(int id) {

        for (Question question : questions) {

            if (question.getId() == id) {

                questions.remove(question);

                System.out.println("✅ Question deleted successfully!");

                return;
            }
        }

        System.out.println("❌ Question ID not found!");
    }

    public void markAsFavorite(int id) {

        for (Question question : questions) {

            if (question.getId() == id) {

                question.setFavorite(true);

                System.out.println("⭐ Question marked as favorite!");

                return;
            }
        }

        System.out.println("❌ Question ID not found!");

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

        System.out.println("\n========== CODEVAULT DASHBOARD ==========");

        System.out.println("📚 Total Questions : " + questions.size());

        int favoriteCount = 0;

        for (Question question : questions) {
            if (question.isFavorite()) {
                favoriteCount++;
            }
        }

        System.out.println("⭐ Favorite Questions : " + favoriteCount);
    }

}