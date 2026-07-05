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
    }

public void markAsFavorite(int index) {
    if (index < 0 || index >= questions.size()) {
        System.out.println("❌ Invalid Question Number!");
        return;
    }
        Question q = questions.get(index);
        q.setFavorite(true);
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

}