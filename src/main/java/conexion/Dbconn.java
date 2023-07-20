package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
	static Connection connection = null;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/prevencion_riesgos?" + 
			                                  "user=usuario&password=usuario");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("DrvError: " + ex.getErrorCode());
		}
      return connection;
	}
}

/*	
	public static String url = "jdbc:mysql://localhost:3306/prevencion_riesgos";
	public static String user = "usuario";
	public static String password = "usuario";
	public static String driver = "com.mysql.cj.jdbc.Driver";
	*/
