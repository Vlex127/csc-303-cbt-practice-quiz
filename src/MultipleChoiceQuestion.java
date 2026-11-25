public class MultipleChoiceQuestion implements Question {
    private final String questionText;
    private final String[] options;
    private final int correctOptionIndex;

    public MultipleChoiceQuestion(String questionText, String[] options, int correctOptionIndex) {
        if (questionText == null || questionText.isBlank()) {
            throw new IllegalArgumentException("Question text cannot be empty.");
        }
        if (options == null || options.length < 2) {
            throw new IllegalArgumentException("A multiple-choice question needs at least two options.");
        }
        for (String option : options) {
            if (option == null || option.isBlank()) {
                throw new IllegalArgumentException("Options cannot be empty.");
            }
        }
        if (correctOptionIndex < 1 || correctOptionIndex > options.length) {
            throw new IllegalArgumentException("Correct option index is out of range.");
        }

        this.questionText = questionText.trim();
        this.options = options.clone();
        this.correctOptionIndex = correctOptionIndex - 1;
    }

    @Override
    public void displayQuestion() {
        System.out.println("[" + getQuestionType() + "] " + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println("  " + (i + 1) + ". " + options[i]);
        }
    }

    @Override
    public boolean checkAnswer(String answer) {
        if (answer == null || answer.isBlank()) {
            return false;
        }

        String trimmedAnswer = answer.trim();
        try {
            int selectedOption = Integer.parseInt(trimmedAnswer);
            return selectedOption == correctOptionIndex + 1;
        } catch (NumberFormatException ignored) {
            return matchesOptionText(trimmedAnswer);
        }
    }

    private boolean matchesOptionText(String answer) {
        for (String option : options) {
            if (option.equalsIgnoreCase(answer)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getCorrectAnswer() {
        return options[correctOptionIndex];
    }

    @Override
    public String getQuestionType() {
        return "Multiple Choice";
    }
}
