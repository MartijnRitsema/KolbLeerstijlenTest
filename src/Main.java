import java.util.Scanner;
import java.util.Random;

class KolbLeerstijlenTest {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);

        final boolean isTesting = true; // for test purposes this is true, if you need real answers set this to false

        Questions questions = new Questions(); // Create an instance of Questions
        String[] question = questions.question; // Access the question array

        // Array to store answers
        String[] userAnswers = new String[question.length];

        Random random = new Random();

        // mutation
        for (int i = 0; i < question.length; i++) {
            System.out.println(question[i]);
            System.out.print("Answer (yes/no): ");
            String answer;

            if (isTesting) {
                answer = (random.nextBoolean()) ? "yes" : "no";
            } else {
                answer = scanner.nextLine().toLowerCase();
            }

            if (answer.equals("yes") || answer.equals("no")) {
                userAnswers[i] = answer;
            } else {
                System.out.println("Invalid answer. Answer 'yes' or 'no'.");
                i--; // Stays on the same question
            }
        }

        // output
        System.out.println();

        int[] activistQuestionNumbers = {2, 4, 6, 10, 17, 23, 24, 32, 34, 38, 40, 43, 45, 48, 58, 64, 71, 72, 74, 79};
        int[] theoristQuestionNumbers = {1, 3, 8, 12, 14, 18, 20, 22, 26, 30, 42, 47, 51, 57, 61, 63, 68, 75, 77, 78};
        int[] reflectorQuestionNumbers = {7, 13, 15, 16, 25, 28, 29, 31, 33, 36, 39, 41, 46, 52, 55, 60, 62, 66, 67, 76};
        int[] pragmatistQuestionNumbers = {5, 9, 11, 19, 21, 27, 35, 37, 44, 49, 50, 53, 54, 56, 59, 65, 69, 70, 73, 80};

        System.out.println();
        System.out.println("--------------------------------------------------------");
        int activistScore = countMatches(userAnswers, activistQuestionNumbers);
        System.out.println("The activist score = " + activistScore);
        int theoristScore = countMatches(userAnswers, theoristQuestionNumbers);
        System.out.println("The theorist score = " + theoristScore);
        int reflectorScore = countMatches(userAnswers, reflectorQuestionNumbers);
        System.out.println("The reflector score = " + reflectorScore);
        int pragmatistScore = countMatches(userAnswers, pragmatistQuestionNumbers);
        System.out.println("The pragmatist score = " + pragmatistScore);
        System.out.println();

        // Determine preference for activist style based on scores
        determineActivistPreference(activistScore);
        determineTheoristPreference(theoristScore);
        determineReflectorPreference(reflectorScore);
        determinePragmatistPreference(pragmatistScore);
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println();
        LearningStyleInfo.printLearningStyles();
    }
    public class LearningStyleInfo {
        public static void printLearningStyles() {
            System.out.println("Learning Style Explanation:");
            System.out.println();
            for (LearningStyle style : LearningStyle.values()) {
                System.out.println(style.name() + "\n" + style.getDescription() + "\n");
            }
        }
    }
    public static void determineActivistPreference(int score) {
        String preferenceLevel;
        if (score >= 13 && score <= 20) {
            preferenceLevel = "Very strong preference";
        } else if (score >= 11 && score <= 12) {
            preferenceLevel = "Strong preference";
        } else if (score >= 7 && score <= 10) {
            preferenceLevel = "Moderate preference";
        } else if (score >= 4 && score <= 6) {
            preferenceLevel = "Low preference";
        } else {
            preferenceLevel = "Very low preference";
        }
        System.out.println("Activist preference: " + preferenceLevel);
    }
    public static void determineReflectorPreference(int score) {
        String preferenceLevel;
        if (score >= 18 && score <= 20) {
            preferenceLevel = "Very strong preference";
        } else if (score >= 15 && score <= 17) {
            preferenceLevel = "Strong preference";
        } else if (score >= 12 && score <= 14) {
            preferenceLevel = "Moderate preference";
        } else if (score >= 9 && score <= 11) {
            preferenceLevel = "Low preference";
        } else {
            preferenceLevel = "Very low preference";
        }
        System.out.println("Reflector preference: " + preferenceLevel);
    }
    public static void determineTheoristPreference(int score) {
        String preferenceLevel;
        if (score >= 16 && score <= 20) {
            preferenceLevel = "Very strong preference";
        } else if (score >= 14 && score <= 15) {
            preferenceLevel = "Strong preference";
        } else if (score >= 11 && score <= 13) {
            preferenceLevel = "Moderate preference";
        } else if (score >= 8 && score <= 10) {
            preferenceLevel = "Low preference";
        } else {
            preferenceLevel = "Very low preference";
        }
        System.out.println("Theorist preference: " + preferenceLevel);
    }
    public static void determinePragmatistPreference(int score) {
        String preferenceLevel;
        if (score >= 17 && score <= 20) {
            preferenceLevel = "Very strong preference";
        } else if (score >= 15 && score <= 16) {
            preferenceLevel = "Strong preference";
        } else if (score >= 12 && score <= 14) {
            preferenceLevel = "Moderate preference";
        } else if (score >= 9 && score <= 11) {
            preferenceLevel = "Low preference";
        } else {
            preferenceLevel = "Very low preference";
        }
        System.out.println("Pragmatist preference: " + preferenceLevel);
    }
    public static int countMatches(String[] answers, int[] questionNumbers) {
        int counter = 0;
        for (int i : questionNumbers) {
            int index = i - 1;
            if ("yes".equals(answers[index])) {
                counter++;
            }
        }
        return counter;
    }

}




