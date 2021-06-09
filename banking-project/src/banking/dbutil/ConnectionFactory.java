package banking.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {

	public static final String URL = "jdbc:mysql://localhost:3306/bank_db";
	public static final String USER = "Mekelle";
	public static final String PASS = "july2011";
	
	public static Connection getConnection() throws SQLException {		
			return DriverManager.getConnection(URL, USER, PASS);	
	}
}
