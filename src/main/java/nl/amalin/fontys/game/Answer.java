package nl.amalin.fontys.game;

/**
 * The Answer class represents an answer in the game, including its text and score.
 */
public class Answer {

    private String answerText;
    private int answerScore;

    /**
     * Sets the text for this answer.
     *
     * @param answerText the text to set for this answer
     */
    public void setAnswerText(String answerText){
        this.answerText = answerText;
    }

    /**
     * Gets the text of this answer.
     *
     * @return the text of this answer
     */
    public String getAnswerText(){
        return answerText;
    }

    /**
     * Sets the score for this answer.
     *
     * @param answerScore the score to set for this answer
     */
    public void setAnswerScore(int answerScore){
        this.answerScore = answerScore;
    }

    /**
     * Gets the score of this answer.
     *
     * @return the score of this answer
     */
    public int getAnswerScore(){
        return answerScore;
    }
}