package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


import model.User;

public class UserDao {
	
	public boolean validateUser(User user) throws ClassNotFoundException,
			SQLException {

		Connection con = MySqlConnection.getConnection();
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select *from user where username='"
				+ user.getUsername() + "' and password='" + user.getPassword()
				+ "' ");
		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}
	public void save(User user) throws ClassNotFoundException, SQLException{
		
		
		int id=(user.getId());
		String username=(user.getUsername());
		String password=(user.getPassword());
		String fullName=(user.getFullName());
	String email=	(user.getEmail());
		String gender=(user.getGender());
		String userType=(user.getUserType());
		
		
		Connection con = MySqlConnection.getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into user(id,username,password,email,fullname,gender,usertype) values(?,?,?,?,?,?,?) ");
		stmt.setInt(1, id);
		stmt.setString(2, username);
		stmt.setString(3, password);
		stmt.setString(4, email);
		stmt.setString(5, fullName);
		stmt.setString(6, gender);
		stmt.setString(7, userType);
		stmt.execute();
		
		
	}
	public List<User> getAllUser() throws ClassNotFoundException, SQLException, ParseException{
		List<User> users =new ArrayList<User>();
		
		Connection con=MySqlConnection.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select *from user");
		while (rs.next()){
			User user = copyResultToUser(rs);
			users.add(user);
			
		}
		
		
		return users;
	}
	
	
	
	public User copyResultToUser(ResultSet rs) throws SQLException,
	ParseException {
User user = new User();
user.setId(rs.getInt("id"));
user.setFullName(rs.getString("fullname"));
user.setUsername(rs.getString("username"));
user.setPassword(rs.getString("password"));
user.setEmail(rs.getString("email"));
user.setGender(rs.getString("gender"));
user.setUserType(rs.getString("usertype"));


return user;
}
	
	
	
	
	
public String getSearchedUser(String uname,String em) throws ClassNotFoundException, SQLException, ParseException{
		
		
		Connection con=MySqlConnection.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from user where username='"+uname+"' and email = '"+em+"'");
		
		String pass="";
		while(rs.next()){
			 pass=rs.getString("password");
			
		}
		
		
		return pass;
	}
	
	
	

}