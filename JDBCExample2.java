package jdbc;
import java.util.Scanner;
import java.sql.*;
public class JDBCExample2 {
   private int rno;
   private String sname;
   private String branch;
   private int fees;
   static Statement st;
   public static void connect() throws ClassNotFoundException,SQLException
   {
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","");
	   st = conn.createStatement();
   }
   
   public static void insert(int rno,String sname,String branch, int fees) throws SQLException
   {
	   int res=st.executeUpdate("insert into student(rno,sname,branch,fees) values('"+rno+"','"+sname+"','"+branch+"','"+fees+"')");
       if(res!=0)
       {
    	   System.out.println("Data Inserted Successfully");
       }
       else
       {
    	   System.out.println("Problem in data Insertion");
       }
   
   
   }
   public static void update(int rno,String sname,String branch, int fees) throws SQLException
   {
	   int res=st.executeUpdate("update student set sname='"+sname+"',branch='"+branch+"',fees='"+fees+"' where rno='"+rno+"'");
       if(res!=0)
       {
    	   System.out.println("Data updated Successfully");
       }
       else
       {
    	   System.out.println("Problem in data updation");
       }
   
   
   }
   
   
   public static void delete(int rno) throws SQLException
   {
	   int res=st.executeUpdate("delete from student where rno='"+rno+"'");
       if(res!=0)
       {
    	   System.out.println("Data deleted Successfully");
       }
       else
       {
    	   System.out.println("Problem in data deletion");
       }
   
   
   }
   
   public static void showdata() throws SQLException
   {
	   ResultSet res = st.executeQuery("select * from student");
	   while(res.next())
	   {
		   System.out.println(res.getInt(1)+ "," + res.getString(2) + " ," + res.getString(3) + " "+ res.getInt(4));
	   }
   }
   
   public static void main(String args[]) throws Exception
   {
	  Scanner sc = new Scanner(System.in);
	  JDBCExample2.connect();
	  int r,f;
	  String sname,branch;
	  System.out.println("Enter rno");
	  r = sc.nextInt();
	  System.out.println("Enter name");
	  sname = sc.next();
	  System.out.println("Enter branch");
	  branch = sc.next();
	  System.out.println("Enter fees");
	  f = sc.nextInt();
	  JDBCExample2.insert(r, sname, branch, f);
	  JDBCExample2.showdata();
	 
	   
	   
   }
   
}
