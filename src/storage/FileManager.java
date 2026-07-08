package storage;

import model.Question;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE_NAME = "questions.txt";

    // Save all questions to file
    public void saveQuestions(ArrayList<Question> questions) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Question question : questions) {

                writer.write(
                        question.getQuestion() + "|" +
                                question.getTopic() + "|" +
                                question.getDifficulty() + "|" +
                                question.getCompany() + "|" +
                                question.isFavorite()
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("✅ Questions saved successfully!");

        } catch (IOException e) {

            System.out.println("❌ Error saving questions.");
        }
    }


    // Load all questions from file
    public ArrayList<Question> loadQuestions() {

        ArrayList<Question> questions = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                Question question = new Question(
                        data[0],
                        data[1],
                        data[2],
                        data[3]
                );

                // Restore favorite status
                question.setFavorite(Boolean.parseBoolean(data[4]));

                questions.add(question);
            }

            reader.close();

            System.out.println("✅ Questions loaded successfully!");

        } catch (IOException e) {

            System.out.println("📂 No previous questions found.");
        }

        return questions;
    }
}

