import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleQuestionGenerator implements QuestionGenerator {

    private int numberOfQuestions;
    Random random = new Random();

    private static List<Question> questions = new ArrayList<>();

    static{
        questions.add(new Question("Czy a to a?", true));
        questions.add(new Question("2+5 = 8", false));
        questions.add(new Question("Czy cat to pies?", false));
        questions.add(new Question("Czy 2 do 10 to 1024", true));
        questions.add(new Question("2+9=12 ? ", false));
    }

    public SimpleQuestionGenerator(){
        this.numberOfQuestions = questions.size();
    }
    public SimpleQuestionGenerator(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }


    public static List<Question> getQuestions() {
        return questions;
    }

    public List<Question> generateQuestions(){
        return questions.subList(0,numberOfQuestions);
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
}
