package model;

public class Question {
    private static int nextId = 101;
    private int id;
    private String question;
    private String topic;
    private String difficulty;
    private String company;
    private boolean favorite;

    public Question(String question, String topic, String difficulty, String company) {
        this.id = nextId++;

        this.question = question;
        this.topic = topic;
        this.difficulty = difficulty;
        this.company = company;
        this.favorite = false;
    }

    // Getters
    public int getId() {
        return id;
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

    public boolean isFavorite() {
        return favorite;
    }


    // Setters
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    @Override
    public String toString() {
        return "ID : " + id +
                "\nQuestion : " + question +
                "\nTopic : " + topic +
                "\nDifficulty : " + difficulty +
                "\nCompany : " + company +
                "\nFavorite : " + favorite;
    }
}