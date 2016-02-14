package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnectionTest {

	public static void main(String[] args) {
try {
	Class.forName("com.mysql.jdbc.Driver");//load driver
	//connect to the required database
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
	Statement stmt=con.createStatement();//create statement
	ResultSet rs=stmt.executeQuery("select *from user");//execute query
	//fetch the result
	while(rs.next()){
		System.out.println(rs.getInt("id") +" "+
				rs.getString("username") + " "+
		rs.getString("password"));
		
	}
	con.close();
	
	
} catch (Exception e) {
	e.printStackTrace();
}
	}

}
