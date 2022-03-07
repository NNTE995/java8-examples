package StudentManagement.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebasJCDBC {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/schoolhib?useSSL=false";
		String username = "root";
		String password = "nnte995";
		
		try {
			System.out.println("Connected to: "+ jdbcUrl);
			Connection myConeccion = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection Succesful!");
		} catch (Exception e) {
			System.out.println("Connection falided!");
			e.printStackTrace();
		}
	}
}