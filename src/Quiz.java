import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private final List<Question> questions = new ArrayList<>();
    private int score;

    public void addQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null.");
        }
        questions.add(question);
    }

    public void run(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner cannot be null.");
        }
        if (questions.isEmpty()) {
            System.out.println("No questions have been added to this quiz.");
            return;
        }

        score = 0;
        System.out.println();
        System.out.println("Practice Quiz");
        System.out.println("=============");

        int questionNumber = 1;
        for (Question question : questions) {
            System.out.println();
            System.out.println("Question " + questionNumber + " of " + questions.size());
            question.displayQuestion();
            System.out.print("Your answer: ");

            String answer = scanner.nextLine();
            if (question.checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. Correct answer: " + question.getCorrectAnswer());
            }
            questionNumber++;
        }

        displayResults();
    }

    public int getScore() {
        return score;
    }

    private void displayResults() {
        int totalQuestions = questions.size();
        int wrongAnswers = totalQuestions - score;
        double percentage = score * 100.0 / totalQuestions;

        System.out.println();
        System.out.println("Results");
        System.out.println("=======");
        System.out.println("Total questions: " + totalQuestions);
        System.out.println("Correct answers: " + score);
        System.out.println("Wrong answers:   " + wrongAnswers);
        System.out.printf("Percentage score: %.1f%%%n", percentage);
    }
}
