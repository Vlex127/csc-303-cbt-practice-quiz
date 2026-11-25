public class TrueFalseQuestion implements Question {
    private final String questionText;
    private final boolean correctAnswer;

    public TrueFalseQuestion(String questionText, boolean correctAnswer) {
        if (questionText == null || questionText.isBlank()) {
            throw new IllegalArgumentException("Question text cannot be empty.");
        }
        this.questionText = questionText.trim();
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void displayQuestion() {
        System.out.println("[" + getQuestionType() + "] " + questionText);
        System.out.println("  1. True");
        System.out.println("  2. False");
    }

    @Override
    public boolean checkAnswer(String answer) {
        if (answer == null || answer.isBlank()) {
            return false;
        }

        String normalizedAnswer = answer.trim().toLowerCase();
        if (normalizedAnswer.equals("true") || normalizedAnswer.equals("t") || normalizedAnswer.equals("1")) {
            return correctAnswer;
        }
        if (normalizedAnswer.equals("false") || normalizedAnswer.equals("f") || normalizedAnswer.equals("2")) {
            return !correctAnswer;
        }
        return false;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer ? "True" : "False";
    }

    @Override
    public String getQuestionType() {
        return "True / False";
    }
}
