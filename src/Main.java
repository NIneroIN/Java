import java.io.File;
import java.sql.*;

public class Main {
    private static Connection connection;

    public static void main(String[] args) throws Exception {
        ParseCSV a = new ParseCSV();
        Country[] list = a.Parser(new File("csv.csv"));

        final String database = "test.db";
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + database);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS countries ("
                    + " name       TEXT ,"
                    + " region     TEXT ,"
                    + " measure    INTEGER"
                    + ")");

            for(Country s : list) {
                PreparedStatement insertStmt = connection.prepareStatement(
                        "INSERT INTO countries(name, region, measure) VALUES(?, ?, ?)");
                insertStmt.setString(1, s.getName());
                insertStmt.setString(2, s.getRegion());
                insertStmt.setInt(3, s.getGenerosityRatio());
                insertStmt.execute();
            }

            ResultSet example2 = statement.executeQuery(
                    "SELECT name, min(measure) FROM countries " +
                            "WHERE region in ('Eastern Europe', 'Middle East and North Africa')");
            System.out.println("Cтрана с самым низким показателем щедрости среди" +
                    " \"Middle East and Northern Africa\"" +
                    " и \"Central and Eastern Europe\": " + example2.getString("name"));

            ResultSet example3 = statement.executeQuery(
                    "SELECT name, measure " +
                            "FROM (SELECT name, region, measure FROM countries " +
                            "WHERE region in ('Sub-Saharan Africa', 'Southern Asia')) " +
                            "WHERE measure in (SELECT ROUND(avg(measure) + 0.5, 0) FROM countries)");
            System.out.println("Страна с самым средним показателем среди " +
                    "\"Southeastern Asia\" и \"Sub-Saharan Africa\": " + example3.getString("name"));
            showAllUsers();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {}
            }
        }
    }

    private static void showAllUsers() throws SQLException {
        LineChart chart = new LineChart(
                "Показатель щедрости" ,
                "Показатель щедрости в разных регионах мира"
        );
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM countries");
        while (rs.next()) {
            chart.dataset.addValue(rs.getInt("measure"), rs.getString("region"), rs.getString("name"));
        }
        chart.pack( );
        chart.setVisible( true );
    }
}
