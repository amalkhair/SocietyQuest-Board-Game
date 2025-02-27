package nl.amalin.fontys.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.Font;

public class Game {
    // array declaration
    static int[] posX;
    static int[] posY;
    static int numberOfMistakes = 0;

    static void initializePositions(int count, int distance) {
        // array initialization
        posX = new int[count];
        posY = new int[count];
        //  steps loop
        // 15 = Fish distance from each gridline
        for (int i = 0; i < count; i++) {
            posX[i] = i * distance + 15;
            posY[i] = i * distance + 15;
        }
    }
    // determines initial position variables
    static int x_pos = 15, y_pos = 15, x_axis_start = 0, y_axis_start = 0, questionNumber = 0, playerScore = 0;

    public static void main(String[] args) {
//        DbConnector dbConnector = new DbConnector();
//
//        dbConnector.questionList();
//        System.exit(1);
        // 5 positions * 130 distance
        initializePositions(5, 130);
        URL urlDonald, urlCry = null;
        try {
            urlDonald = new URL("https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExd3cwN241cDlkcHB3bmY1aXJyZ2lyd2J1cDRnNWJ1ODkxejlqc2dlNSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Mjl0BsAgMGYTe/giphy.gif");
            urlCry = new URL("        https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExcnpvcXV4aGRrMmY4d2dqb2FieWt2cmxyeDl3azEzdnNscGplcnNkYiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/qQdL532ZANbjy/giphy.gif");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // Win/lose images
        ImageIcon donaldIcon = new ImageIcon(urlDonald);
        ImageIcon cryIcon = new ImageIcon(urlCry);

        // Maps
        //  Map containing questions and its index
        //Map<Integer, String> questions = new HashMap<>();

        List<Question> questionList = new ArrayList<>();


        // Map containing questions which each question has answers
        // HashMap answersAndScore =  a big map that has a question as the key, and another map as its value.
        // This value map contains each three keys and three values: the keys are each answer,
        // and the value are each scores. In short, in maps each answer choice along with the scores that determine
        // its truth value.

        try {
            // puts questions into map
            List<String> allLinesQuestions = Files.readAllLines(Paths.get("src/main/resources/questions.txt"));
            for (String line : allLinesQuestions) {
                System.out.println(line);
                // trims empty space
                if (!line.trim().isEmpty()) {
                    // splits
                    String[] q = line.split("#");

                    //questions.put(Integer.parseInt(q[0]), q[1]);
                    System.out.println(q[0]);
                    System.out.println(q[1]);
                    Question question = new Question();
                    question.setQuestionNumber(Integer.parseInt(q[0]));
                    question.setQuestionText(q[1]);

                    questionList.add(question);
                }
            }
            // this set of code under this will handle the answerAndScoreMap
            // Map in which the key is the question, and the value is another map containing the answers and its scores.
            // An answer has three elements: the number, the answer itself, and the score. That is what makes the
            // loop a little bit more complicated, because it is split into more parts.
            // example: 0#Deforestation#0 , 0#Burning fossil fuels#10 , 0#Agriculture#0
            // important sidenote: see comment on answerAndScore map.

            List<String> allLinesAnswersAndScore = Files.readAllLines(Paths.get("src/main/resources/answers.txt"));

            int questionNumber = -1;
            Question question = new Question();
            // a loop that puts the values into the previous mentioned maps
            for (String line : allLinesAnswersAndScore) {

                if (!line.trim().isEmpty()) {

                    String[] as = line.split("#");
                    String relatedQuestionNumber = as[0];

                    String answerText = as[1];
                    int answerScore = Integer.parseInt(as[2]);

                   Answer answer = new Answer();
                   answer.setAnswerText(answerText);
                   answer.setAnswerScore(answerScore);

                    int q_num = Integer.parseInt(relatedQuestionNumber);
                    if (questionNumber != q_num) {
                        questionNumber = q_num;
                        question = questionList.get(questionNumber);

                    }
                    question.setAnswers(answer);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //framework

        JFrame frame = new JFrame("Society Quest Game");
        int boardWidth = 20 * 32, boardHeight = 21 * 32;
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(boardWidth, boardHeight));

        SocietyQuest societyQuestGame = new SocietyQuest();
        societyQuestGame.setBounds(0, 0, boardWidth, boardHeight);

        PlayerPanel playerPanel = new PlayerPanel();
        playerPanel.setBounds(x_pos, y_pos, 100, 100);
        playerPanel.setOpaque(false);

        layeredPane.add(societyQuestGame, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(playerPanel, JLayeredPane.PALETTE_LAYER);

        frame.add(layeredPane, BorderLayout.CENTER);

        JButton startButton = new JButton("START GAME!");
        frame.add(startButton, BorderLayout.SOUTH);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loop_y_axis:
                for (int y_axis = y_axis_start; y_axis < posY.length; y_axis++) {
                    for (int x_axis = x_axis_start; x_axis < posX.length;) {
                        x_pos = posX[x_axis];
                        y_pos = posY[y_axis];
                        playerPanel.setBounds(x_pos, y_pos, 100, 100);

                        if (questionNumber == questionList.size()) break loop_y_axis;

                        Question question = questionList.get(questionNumber);

                        List<Answer> answers = question.getAnswersList();

                        Set<String> set = new HashSet<>();
                        for (Answer answer: answers){
                            set.add(answer.getAnswerText());
                        }

                        JComboBox<String> comboBox = new JComboBox<>(set.toArray(new String[0]));
                        comboBox.setPreferredSize(new Dimension(400, 30));

                        // Create the JLabel
                        JLabel label = new JLabel( questionList.get(questionNumber).getQuestionText());

                        label.setFont(new Font("Courier", Font.BOLD, 17));  // Font name, style, size

                        // Create the JOptionPane with the JComboBox
                        JOptionPane optionPane = new JOptionPane(new Object[] {label, comboBox}, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
                        JDialog dialog = optionPane.createDialog(frame, "Question");
                        optionPane.setPreferredSize(new Dimension(frame.getWidth(), optionPane.getPreferredSize().height));
                        System.out.println(frame.getX());
                        System.out.println(frame.getY() - dialog.getHeight());
                        dialog.setLocation(frame.getX(), frame.getY() - dialog.getHeight());
                        dialog.pack();
                        dialog.setVisible(true);

                        int result = (int) optionPane.getValue();
                        if (result == JOptionPane.CANCEL_OPTION) {
                            x_axis_start = x_axis;
                            y_axis_start = y_axis;
                            break loop_y_axis;
                        }
                        int score = 0;
                        String selectedAnswer = (String) comboBox.getSelectedItem();
                        for (Answer answer: answers){
                            if (answer.getAnswerText().equals(selectedAnswer)){
                               score = answer.getAnswerScore();
                               break;
                            }
                        }
//                        int score = av.get(selectedAnswer);

                        //wrong messages: popup with message and player turns into different form ("dies")
                        if (score == 0) {
                            numberOfMistakes++;
                            playerPanel.setImageLocation("src/main/resources/deadFish.png");
                            String message = "<html><span style='font-size:16px;'> Attempt: " + numberOfMistakes + ". Better luck next time!</span></html>";
                            JOptionPane.showMessageDialog(
                                    frame,
                                    message,
                                    "Whoops! Wrong!",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    cryIcon
                            );

                            // when the answer is right, the fish turns back to normal (or stays normal)
                        } else {
                            playerPanel.setImageLocation("src/main/resources/player1.png");
                            playerScore += score;
                            playerPanel.setScore(String.valueOf(playerScore));
                            x_axis++;
                            questionNumber++;
                        }
                        if (numberOfMistakes >4) {
                            x_axis_start = 0;
                            y_axis_start = 0;
                            numberOfMistakes = 0;
                            playerScore = 0;
                            x_pos = 15;
                            y_pos = 15;
                            playerPanel.setBounds(x_pos, y_pos, 100, 100);
                            playerPanel.setScore(String.valueOf(playerScore));
                            questionNumber = 0;
                            break loop_y_axis;
                        }
                    }

                    x_axis_start = 0;
                }

                // Winning message; when player finishes the game successfully with 250 points, a congratulations message pops up.
                if (playerScore == 250){

                    JOptionPane.showMessageDialog(
                            frame,
                            "CONGRATULATIONS! YOU FINISHED THIS GAME SUCCESSFULLY!\n You learned " +
                                    "about social issues. Hopefully it was educational!",
                            "YOU WON!",
                            JOptionPane.INFORMATION_MESSAGE,
                            donaldIcon
                    );
                } else {

                }
            }
        });

        frame.setVisible(true);
    }
}