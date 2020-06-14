public class Question {

    int correctAnswer;
    int playerAnswer;
    int imageId;
    String questionText;
    String answer0;
    String answer1;
    String answer2;
    String answer3;

    public Question(int imageIdentifier, String questionString, String answerZero, String answerOne, String answerTwo,
            String answerThree, int correctAnswerIndex) {
        this.playerAnswer = -1;
        this.imageId = imageIdentifier;
        this.questionText = questionString;
        this.answer0 = answerZero;
        this.answer1 = answerOne;
        this.answer2 = answerTwo;
        this.answer3 = answerThree;
        this.correctAnswer = correctAnswerIndex;
    }

    public String toString() {
        String displayQuestion = this.imageId + " " + this.questionText + "\n" + this.answer0 + "\n" + this.answer1
                + "\n" + this.answer2 + "\n" + this.answer3;
        return displayQuestion;
    }

    public boolean isCorrect() {
        if (this.playerAnswer == this.correctAnswer) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Question question1 = new Question(921238, "How tall is the Eiffel tower?", "1024 ft", "1063 ft", "1124 ft",
                "1163 ft", 1);
        System.out.println(question1.toString());
    }
}