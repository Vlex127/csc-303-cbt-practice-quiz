public interface Question {
    void displayQuestion();

    boolean checkAnswer(String answer);

    String getCorrectAnswer();

    String getQuestionType();
}
