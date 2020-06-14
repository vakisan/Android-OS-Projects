import java.util.ArrayList;
import java.util.Random;

public class MainActivity {

    int currentQuestionIndex;
    int totalCorrect;
    int totalQuestions;

    ArrayList<Question> questions;

    public void startNewGame() {
        this.questions = new ArrayList<Question>();
        Question question1 = new Question(921238, "How tall is the Eiffel tower?", "1024 ft", "1063 ft", "1124 ft",
                "1163 ft", 1);
        Question question2 = new Question(107343, "Who invented the computer algorithm", "Charles Babbage",
                "John Carmack", "Alan Turing", "Ada Lovelace", 3);
        Question question3 = new Question(748294, "What is the name for the patch of skin found on your elbow?",
                "Elbow Skin", "Fascia Elbora", "Wenis", "Todd", 2);
        this.questions.add(question1);
        this.questions.add(question2);
        this.questions.add(question3);
        this.totalCorrect = 0;
        this.totalQuestions = this.questions.size();
        this.currentQuestionIndex = 0;
    }

    public Question chooseNewQuestion() {
        Question firstQuestion = chooseNewQuestion();
        this.currentQuestionIndex = this.generateRandomNumber(this.totalQuestions);
        Question currentQuestion = getCurrentQuestion();
        // displayQuestion(firstQuestion);
        // displayQuestionsRemaining(questions.size());
        System.out.println(this.questions.size());
        if (this.questions.size() <= 0) {
            System.out.println("Game Over");
            getGameOverMessage(this.totalCorrect, this.totalQuestions);
            startNewGame();
        } else {
            chooseNewQuestion();
        }
        return currentQuestion;
    }

    public Question getCurrentQuestion() {
        return this.questions.get(this.currentQuestionIndex);
    }

    public void onAnswerSubmission() {
        if (getCurrentQuestion().correctAnswer == getCurrentQuestion().playerAnswer) {
            totalCorrect++;
        }
        this.questions.remove(this.currentQuestionIndex);
        // TODO: uncomment after implementing displayQuestion()
        // displayQuestion(getCurrentQuestion());
    }

    public int generateRandomNumber(int max) {
        Random number = new Random();
        return number.nextInt(max);
    }

    public String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if (totalCorrect == totalQuestions) {
            return "You got all " + totalCorrect + " right! You won!";
        } else {
            return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
        }
    }

    public static void main(String[] args) {
        MainActivity m = new MainActivity();
        System.out.println(m.generateRandomNumber(3));
    }
}