package nl.amalin.fontys.game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnector {
    private String url = "jdbc:sqlite:game.db"; // Database file

    public List<Question> questionList(){

        List<Question> list = new ArrayList<>();
        String selectSQL = "SELECT * FROM question";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("question_text"));
                Question question = new Question();
                question.setQuestionNumber(rs.getInt("id"));
                question.setQuestionText(rs.getString("question_text"));
                list.add(question);

            }

        } catch (SQLException e){

        }
        return null;
    }
}
