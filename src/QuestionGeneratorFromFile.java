import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class QuestionGeneratorFromFile implements QuestionGenerator {


    @Override
    public List<Question> generateQuestions() {
        String fileName = "questions.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toString)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splits;
        List<Question> questions = new ArrayList<>();

        for(String line: list){
            splits = line.split("\\?");
            Question question = new Question(splits[0]+ "?");
            String secondPart = splits[1].trim();
           question.setTrue(QuestionEnum.valueOf(secondPart).isCorrect());
           questions.add(question);

        }
        System.out.println(questions);
        return questions;
    }

    public static void main(String[] args) {
        QuestionGeneratorFromFile questionFileGenerator = new QuestionGeneratorFromFile();
        questionFileGenerator.generateQuestions();
    }
}
