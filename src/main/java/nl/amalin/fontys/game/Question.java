package nl.amalin.fontys.game;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private int questionNumber;
    private String questionText;
    private final List<Answer> answersList = new ArrayList<>();

    public void setQuestionNumber(int questionNumber){
        this.questionNumber = questionNumber;
    }

    public int getQuestionNumber(){
        return questionNumber;
    }

    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }

    public String getQuestionText(){
        return questionText;
    }

    public void setAnswers(Answer answer) {
        answersList.add(answer);

    }

    public List<Answer> getAnswersList(){
        return answersList;
    }

    public int getAnswerAmount(){
        return answersList.size();
    }
}
