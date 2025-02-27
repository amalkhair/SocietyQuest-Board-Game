package nl.amalin.fontys.game;

public class Answer {

    private String answerText;
    private int answerScore;

    public void setAnswerText(String answerText){
        this.answerText = answerText;
    }

    public String getAnswerText(){
        return answerText;
    }

    public void setAnswerScore(int answerScore){
        this.answerScore = answerScore;
    }

    public int getAnswerScore(){
        return answerScore;
    }
}
