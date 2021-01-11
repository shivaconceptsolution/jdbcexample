package jdbc;


import java.sql.*;



public class JDBCEXAMPLE {

	public static void main(String[] args) {
		try
		{
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","");
		Statement st = conn.createStatement();
		int x = st.executeUpdate("insert into student values(1003,'ramesh','CS',56000)");
	//	int x = st.executeUpdate("update student set sname='kamla',branch='EC' where rno=1002");
	//	int x = st.executeUpdate("delete from student  where rno=1002");
		if(x!=0){
			System.out.println("Data Inserted Successfully");
		}
		else
		{
			System.out.println("Data NOT Inserted Successfully");
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		
		

	}

}
