public class Test {
    public Test() {
        System.out.println("AndroidOS Booting Up...");
    }

    public void runQuizApp() {
        // Create three questions here
        Question question1 = new Question(921238, "How tall is the Eiffel tower?", "1024 ft", "1063 ft", "1124 ft",
                "1163 ft", 1);
        System.out.println(question1.toString());
        Question question2 = new Question(107343, "Who invented the computer algorithm", "Charles Babbage",
                "John Carmack", "Alan Turing", "Ada Lovelace", 3);
        System.out.println(question2.toString());
        Question question3 = new Question(748294, "What is the name for the patch of skin found on your elbow?",
                "Elbow Skin", "Fascia Elbora", "Wenis", "Todd", 2);
        System.out.println(question3.toString());

    }

    public static void main(String[] args) {
        MainActivity mainActivity = new MainActivity();
        mainActivity.startNewGame();
        System.out.println("Questions remaining: " + mainActivity.totalQuestions);
        Question currentQuestion = mainActivity.getCurrentQuestion();
        printQuestion(currentQuestion);
        // Play the game!
        currentQuestion.playerAnswer = 4;
        mainActivity.onAnswerSubmission();
        currentQuestion = mainActivity.getCurrentQuestion();
        printQuestion(currentQuestion);
        currentQuestion.playerAnswer = 4;
        mainActivity.onAnswerSubmission();
        currentQuestion = mainActivity.getCurrentQuestion();
        printQuestion(currentQuestion);
        currentQuestion.playerAnswer = 4;
        mainActivity.onAnswerSubmission();
    }

    static void printQuestion(Question question) {
        System.out.println("Question: " + question.questionText);
        System.out.println("Option 1: " + question.answer0);
        System.out.println("Option 2: " + question.answer1);
        System.out.println("Option 3: " + question.answer2);
        System.out.println("Option 4: " + question.answer3);
    }
}