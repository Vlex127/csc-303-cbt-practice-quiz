import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = createQuiz();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                displayWelcome();
                String choice = prompt(scanner, "Select option: ");

                if (choice.equals("1")) {
                    quiz.run(scanner);
                    prompt(scanner, "Press Enter to return to the menu...");
                } else if (choice.equals("2")) {
                    System.out.println("Goodbye!");
                    running = false;
                } else {
                    System.out.println("Invalid option. Please enter 1 or 2.");
                }
            }
        }
    }

    private static void displayWelcome() {
        System.out.println();
        System.out.println("=========================================");
        System.out.println("  Computer-Based Testing Practice Quiz");
        System.out.println("=========================================");
        System.out.println("1. Start Practice Quiz");
        System.out.println("2. Exit");
    }

    private static String prompt(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static Quiz createQuiz() {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new MultipleChoiceQuestion(
                "Which keyword is used by a class to implement an interface?",
                new String[] {"class", "implements", "extends", "new"},
                2));

        quiz.addQuestion(new TrueFalseQuestion(
                "A Java interface can contain private instance fields.",
                false));

        quiz.addQuestion(new FillBlankQuestion(
                "The keyword used to hide fields and expose them through public methods is __________.",
                "encapsulation"));

        quiz.addQuestion(new MultipleChoiceQuestion(
                "Which collection stores elements in insertion order and allows duplicates?",
                new String[] {"HashSet", "ArrayList", "TreeSet", "Map"},
                2));

        quiz.addQuestion(new TrueFalseQuestion(
                "A class can implement more than one interface.",
                true));

        quiz.addQuestion(new FillBlankQuestion(
                "The interface method in this project that evaluates a student's response is __________.",
                "checkAnswer"));

        quiz.addQuestion(new MultipleChoiceQuestion(
                "Which access modifier makes a field visible only inside its own class?",
                new String[] {"public", "protected", "private", "default"},
                3));

        quiz.addQuestion(new TrueFalseQuestion(
                "Polymorphism lets a Question variable refer to a MultipleChoiceQuestion object.",
                true));

        quiz.addQuestion(new FillBlankQuestion(
                "The Java class used to store questions in this project is __________.",
                "ArrayList",
                "array list"));

        return quiz;
    }
}
