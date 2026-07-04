package service;

import model.Question;

import java.util.ArrayList;

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
}