package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;

public class Queries {
// sa sign up 
    public static boolean signUp(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();

            // Check if username already exists
            String checkQuery = "SELECT * FROM user_login WHERE username = ?";
            PreparedStatement check = con.prepareStatement(checkQuery);
            check.setString(1, username);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                return false; // user already exists
            }

            // Insert new account
            String insertQuery = "INSERT INTO user_login (username, password_) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(insertQuery);
            pst.setString(1, username);
            pst.setString(2, password);

            int rows = pst.executeUpdate();

            return rows > 0; // success if 1 row inserted

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


// sa login
    public static boolean loginUser(String username, String password) {
    	

        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM user_login WHERE username = ? AND password_ = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

        	System.out.println("Connected to DB: " + con.getCatalog());
            
            ResultSet rs = pst.executeQuery();

            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
