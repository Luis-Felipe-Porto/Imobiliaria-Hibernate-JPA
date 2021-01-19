package br.com.LabBdII.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnetionFactory {
	public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/corretora?useTimezone=true&serverTimezone=UTC", "root", "admin");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
