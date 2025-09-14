package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createStudent {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_crud";
        String user = "root";
        String password = "@Durant333";

        String query = "SELECT * FROM students";

        // Connection conn = null;

        // try {

        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        // finally {
        // }

    }
}
