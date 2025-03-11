package nl.amalin.fontys.game;

import java.util.ArrayList;
import java.util.List;

/**
 * The Question class represents a question in the game, including its text, number, and associated answers.
 */
public class Question {

    private int questionNumber;
    private String questionText;
    private final List<Answer> answersList = new ArrayList<>();

    /**
     * Sets the question number.
     *
     * @param questionNumber the number to set for this question
     */
    public void setQuestionNumber(int questionNumber){
        this.questionNumber = questionNumber;
    }

    /**
     * Gets the question number.
     *
     * @return the question number
     */
    public int getQuestionNumber(){
        return questionNumber;
    }

    /**
     * Sets the question text.
     *
     * @param questionText the text to set for this question
     */
    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }

    /**
     * Gets the question text.
     *
     * @return the question text
     */
    public String getQuestionText(){
        return questionText;
    }

    /**
     * Adds an answer to the list of answers for this question.
     *
     * @param answer the answer to add
     */
    public void setAnswers(Answer answer) {
        answersList.add(answer);
    }

    /**
     * Gets the list of answers for this question.
     *
     * @return the list of answers
     */
    public List<Answer> getAnswersList(){
        return answersList;
    }

    /**
     * Gets the number of answers for this question.
     *
     * @return the number of answers
     */
    public int getAnswerAmount(){
        return answersList.size();
    }
}
