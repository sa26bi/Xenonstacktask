package xenonstack_ass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
public class dbConnection {
		public static Connection createConnect() {
			Connection con = null;
			String url="jdbc:mysql://localhost:3306/auth_xenonstack";
			String uname = "root";
			String pass = "admin";
			
			try {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				con = DriverManager.getConnection(url, uname, pass);
				System.out.println("Post establishing a DB connection - " +con);
				
			}
			catch(SQLException e)
			{
				System.out.println("Error Occurred");
				e.printStackTrace();
			}
			return con;
			
		}

	}




