package model;

public class Question {

    private String question;
    private String topic;
    private String difficulty;
    private String company;

    public Question(String question, String topic, String difficulty, String company) {
        this.question = question;
        this.topic = topic;
        this.difficulty = difficulty;
        this.company = company;
    }

    public String getQuestion() {
        return question;
    }

    public String getTopic() {
        return topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Question : " + question +
               "\nTopic : " + topic +
               "\nDifficulty : " + difficulty +
               "\nCompany : " + company;
    }
}