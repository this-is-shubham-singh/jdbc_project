package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateStudent {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_crud";
        String user = "root";
        String password = "@Durant333";
        Connection conn = null;
        String query = "update students set course = ? where id = ?";
        Scanner sc = new Scanner(System.in);

        System.out.println("enter id to be updated");
        int id = sc.nextInt();

        System.out.println("enter course to be updated");
        String course = sc.next();

        try {

            // connection
            conn = DriverManager.getConnection(url, user, password);

            // prepared statement
            PreparedStatement pr = conn.prepareStatement(query);
            
            // set prepared statement values 
            pr.setString(1, course);
            pr.setInt(2, id);

            // execute update prepared statement 
            pr.executeUpdate();

            System.out.println("data updated");

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
