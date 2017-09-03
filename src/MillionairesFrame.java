import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MillionairesFrame extends JFrame implements ActionListener {

    private List<Question> questionList = new ArrayList<>();
    private QuestionGenerator questionGenerator;
    private int currentQuestionIndex;
    private JLabel questionLabel;
    private User user;
    private JButton yesButton;
    private JButton noButton;

    public QuestionGenerator getQuestionGenerator() {
        return questionGenerator;
    }

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public MillionairesFrame(int width) {
        setSize(width, width);
        setTitle("Millionaires");
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setQuestionGenerator(new QuestionGeneratorFromFile());
        setQuestionList(getQuestionGenerator().generateQuestions());
        addLabelAndButtonsToFrame();
        user = new User();
    }

    public void addLabelAndButtonsToFrame() {
        questionLabel = new JLabel(questionList.get(currentQuestionIndex).getText(), SwingConstants.CENTER);
        add(questionLabel);
        yesButton = new JButton("TAK");
        yesButton.addActionListener(this);
        noButton = new JButton("NIE");
        noButton.addActionListener(this);
        add(yesButton);
        add(noButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new MillionairesFrame(500);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton)e.getSource();
        Question currentQuestion = questionList.get(currentQuestionIndex);

        if(clickedButton == yesButton && currentQuestion.isTrue())
            user.addPoint();
        if(clickedButton == noButton && !currentQuestion.isTrue())
            user.addPoint();

        if (currentQuestionIndex < questionList.size() - 1) {
            currentQuestionIndex++;
            setLabelTitle();
        }
        else{
            noButton.setEnabled(false);
            yesButton.setEnabled(false);
            JOptionPane.showMessageDialog(null,"Zdobyta ilość punktów: " + user.getNumberofPoints());
        }
        System.out.println(user.getNumberofPoints());
    }

    public void setLabelTitle() {
        questionLabel.setText(questionList.get(currentQuestionIndex).getText());
    }

}