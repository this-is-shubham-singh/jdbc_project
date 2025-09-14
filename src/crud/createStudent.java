package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class createStudent {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_crud";
        String user = "root";
        String password = "@Durant333";

        String query = "insert into students (name, course) values (?, ?)";
        Connection conn = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("enter name");
        String name = sc.next();

        System.out.println("enter course");
        String course = sc.next();

        try {

            // connection
            conn = DriverManager.getConnection(url, user, password);

            // create prepared statement
            PreparedStatement pr = conn.prepareStatement(query);

            // set values in prepared statement 
            pr.setString(1, name);
            pr.setString(2, course);

            pr.executeUpdate();

            System.out.println("data inserted");

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
            sc.close();
        }

    }
}
