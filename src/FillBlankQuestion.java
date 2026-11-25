import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class FillBlankQuestion implements Question {
    private final String questionText;
    private final String correctAnswer;
    private final Set<String> acceptableAnswers = new HashSet<>();

    public FillBlankQuestion(String questionText, String correctAnswer, String... alternateAnswers) {
        if (questionText == null || questionText.isBlank()) {
            throw new IllegalArgumentException("Question text cannot be empty.");
        }
        if (correctAnswer == null || correctAnswer.isBlank()) {
            throw new IllegalArgumentException("Correct answer cannot be empty.");
        }

        this.questionText = questionText.trim();
        this.correctAnswer = correctAnswer.trim();
        addAnswer(this.correctAnswer);

        if (alternateAnswers != null) {
            for (String alternateAnswer : alternateAnswers) {
                addAnswer(alternateAnswer);
            }
        }
    }

    private void addAnswer(String answer) {
        if (answer != null) {
            String normalizedAnswer = normalize(answer);
            if (!normalizedAnswer.isEmpty()) {
                acceptableAnswers.add(normalizedAnswer);
            }
        }
    }

    private static String normalize(String answer) {
        return answer.trim().replaceAll("\\s+", " ").toLowerCase(Locale.ROOT);
    }

    @Override
    public void displayQuestion() {
        System.out.println("[" + getQuestionType() + "] " + questionText);
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer != null && acceptableAnswers.contains(normalize(answer));
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String getQuestionType() {
        return "Fill in the Blank";
    }
}
