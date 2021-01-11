package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","");
		Statement st = conn.createStatement();
		ResultSet x = st.executeQuery("select * from student");
	    while(x.next()){
			System.out.println(x.getString(1) + " "+x.getString(2) +x.getString(3) + " "+x.getString(4));
		}

		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		

	}

}
