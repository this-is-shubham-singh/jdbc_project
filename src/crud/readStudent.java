package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class readStudent {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/jdbc_crud";
        String user = "root";
        String password = "@Durant333";

        String query = "SELECT * FROM students";

        Connection conn = null;

        try {

            // connection
            conn = DriverManager.getConnection(url, user, password);

            // create statement
            Statement stmt = conn.createStatement();

            // execute query
            ResultSet rs = stmt.executeQuery(query);

            // process result
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("course"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
