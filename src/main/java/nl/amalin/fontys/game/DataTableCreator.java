package nl.amalin.fontys.game;

import java.sql.*;

/**
 * The DataTableCreator class is responsible for creating the database tables and inserting initial data for the game.
 */
public class DataTableCreator {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:game.db"; // Database file

        // SQL statement for creating the question table
        String createTableQuestion = "CREATE TABLE IF NOT EXISTS question ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "question_text TEXT NOT NULL"
                + ");";

        // SQL statement for creating the answer table
        String createTableAnswer = "CREATE TABLE IF NOT EXISTS answer ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "qid INTEGER NOT NULL, "
                + "answer_text TEXT NOT NULL, "
                + "score INTEGER NOT NULL, "
                + "FOREIGN KEY (qid) REFERENCES question(id) ON DELETE CASCADE"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Execute the SQL statement to create the question table
            stmt.execute(createTableQuestion);
            System.out.println("Table question created successfully.");

            // Execute the SQL statement to create the answer table
            stmt.execute(createTableAnswer);
            System.out.println("Table answer created successfully.");

            // SQL statement for inserting initial questions into the question table
            String insertQuestions = "INSERT INTO question (question_text) VALUES "
                    + "('What is racism?'),"
                    + "('What is a common cause of homelessness?'),"
                    + "('What material takes the longest to decompose?'),"
                    + "('What is the most common form of human trafficking worldwide?'),"
                    + "('How many people worldwide experience hunger?'),"
                    + "('Which disease is most linked to smoking?'),"
                    + "('What is cyberbullying?'),"
                    + "('What is a leading cause to hunger?'),"
                    + "('Which of the following is not a source of social problems?'),"
                    + "('What is not a major cause of climate change?'),"
                    + "('Where is child labor most common?'),"
                    + "('Which country hosts the largest number of refugees?'),"
                    + "('What is not the cause of water scarcity?'),"
                    + "('What is the largest source of air pollution?'),"
                    + "('How much of the human population has mental health issues?'),"
                    + "('What is the most common type of cybercrime?'),"
                    + "('Which country has the highest number of civilian-owned guns?'),"
                    + "('What is the main reason fake news spreads online?'),"
                    + "('Which sector is most affected by job loss due to AI?'),"
                    + "('What is a major contributor to income inequality?'),"
                    + "('What is the most common cause of drug addiction?'),"
                    + "('Which disease has been eradicated worldwide through vaccination?'),"
                    + "('What is the main reason for the rise in sea levels?'),"
                    + "('Which factor most contributes to digital divide?'),"
                    + "('What is a major cause of deforestation in tropical areas?');";

            // SQL statement for inserting initial answers into the answer table
            String insertAnswers = "INSERT INTO answer (qid, answer_text, score) VALUES "
                    + "(1, 'Racism based on gender', 0),"
                    + "(1, 'Racism based on race', 10),"
                    + "(1, 'Racism based on religion', 0),"
                    + "(2, 'Owning a house', 0),"
                    + "(2, 'Overconsumption', 0),"
                    + "(2, 'Losing a job', 10),"
                    + "(3, 'Plastic', 10),"
                    + "(3, 'Metal', 0),"
                    + "(3, 'Wood', 0),"
                    + "(4, 'Forced Labor', 10),"
                    + "(4, 'Organ trafficking', 0),"
                    + "(4, 'Drug trafficking', 0),"
                    + "(5, '500 million', 0),"
                    + "(5, '1 billion', 0),"
                    + "(5, '745 million', 10),"
                    + "(6, 'Lung cancer', 10),"
                    + "(6, 'Pneumonia', 0),"
                    + "(6, 'Asthma', 0),"
                    + "(7, 'Illegal hacking', 0),"
                    + "(7, 'Online harassment', 10),"
                    + "(7, 'In person bullying', 0),"
                    + "(8, 'War and conflict', 10),"
                    + "(8, 'Overpopulation', 0),"
                    + "(8, 'Lack of farmland', 0),"
                    + "(9, 'Hate crimes', 0),"
                    + "(9, 'Media propaganda', 0),"
                    + "(9, 'Technical Advancements', 10),"
                    + "(10, 'Volcanoes', 10),"
                    + "(10, 'Deforestation', 0),"
                    + "(10, 'Transportation', 0),"
                    + "(11, 'Retail industry', 0),"
                    + "(11, 'Fashion boutiques', 0),"
                    + "(11, 'Factories and farms', 10),"
                    + "(12, 'USA', 0),"
                    + "(12, 'Iran', 10),"
                    + "(12, 'Turkey', 0),"
                    + "(13, 'Water infrastructure', 0),"
                    + "(13, 'Air humidity', 10),"
                    + "(13, 'Climate change', 0),"
                    + "(14, 'Factories and vehicles', 10),"
                    + "(14, 'Global warming', 0),"
                    + "(14, 'Forest fires', 0),"
                    + "(15, 'One out of 4', 10),"
                    + "(15, 'One out of 2', 0),"
                    + "(15, 'One out of 10', 0),"
                    + "(16, 'Online bullying', 0),"
                    + "(16, 'Identity theft', 10),"
                    + "(16, 'Hacking into companies', 0),"
                    + "(17, 'USA', 10),"
                    + "(17, 'Yemen', 0),"
                    + "(17, 'China', 0),"
                    + "(18, 'Social media algorithms', 10),"
                    + "(18, 'Artificial Intelligence', 0),"
                    + "(18, 'People cannot spot fake news', 0),"
                    + "(19, 'Healthcare', 0),"
                    + "(19, 'Education', 0),"
                    + "(19, 'Manufacturing', 10),"
                    + "(20, 'Choosing not to work', 0),"
                    + "(20, 'Lacks of jobs in the market', 10),"
                    + "(20, 'Lack of education', 0),"
                    + "(21, 'Peer pressure', 0),"
                    + "(21, 'Mental health disorder', 10),"
                    + "(21, 'Social media influence', 0),"
                    + "(22, 'Polio', 10),"
                    + "(22, 'Tuberculosis', 0),"
                    + "(22, 'Corona', 0),"
                    + "(23, 'Melting glaciers and ice sheets', 10),"
                    + "(23, 'Increased rainfall', 0),"
                    + "(23, 'Ocean water expansion', 0),"
                    + "(24, 'High costs of digital devices', 0),"
                    + "(24, 'People’s reluctance to use technology', 10),"
                    + "(24, 'Lack of internet infrastructure', 0),"
                    + "(25, 'Agricultural expansion', 10),"
                    + "(25, 'Natural forest fires', 0),"
                    + "(25, 'Urban expansion', 0);";

            // Uncomment the following lines to execute the insert statements
            // stmt.execute(insertQuestions);
            // stmt.execute(insertAnswers);

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}