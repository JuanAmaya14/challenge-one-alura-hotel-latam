package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ESTABLECE CONEXION CON LA BASE DE DATOS
public class Conexion {

	private final static String URL = "jdbc:mysql://127.0.0.1:3306/hotel_alura";

	private final static String USER = "root";

	private final static String PASSWORD = "admin";

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL, USER, PASSWORD);

	}

	public static void close(Connection conn) throws SQLException {

		conn.close();

	}

	public static void close(PreparedStatement stmt) throws SQLException {

		stmt.close();

	}

	public static void close(Statement sttm) throws SQLException {

		sttm.close();

	}

	public static void close(ResultSet rs) throws SQLException {

		rs.close();

	}
}
