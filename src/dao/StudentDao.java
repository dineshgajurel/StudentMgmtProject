package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Student;

public class StudentDao {

	private Connection conn = null;

	public StudentDao() throws ClassNotFoundException, SQLException {
		conn = MySqlConnection.getConnection();
	}

	public void saveStudent(Student stud) throws SQLException {

		PreparedStatement stat = conn
				.prepareStatement("INSERT INTO student (id, name, address, birthdate, rollno, faculty, semester, college, gender) VALUES (?,?,?,?,?,?,?,?,?)");
		stat.setInt(1, stud.getId());// 1 specifies the first parameter in the
										// query
		stat.setString(2, stud.getName());
		stat.setString(3, stud.getAddress());
		// stat.setDate(4, new java.sql.Date(stud.getBirthdate().getTime()));
		stat.setString(4, stud.getBirthdate());
		stat.setString(5, stud.getRollno());
		stat.setString(6, stud.getFaculty());
		stat.setString(7, stud.getSemester());
		stat.setString(8, stud.getCollege());
		stat.setString(9, stud.getGender());
		System.out.println(",,,"+stud.getName());

		stat.executeUpdate();
		
	}
	public void updateStudent(Student stud) throws SQLException {

		PreparedStatement stat = conn
				.prepareStatement("update student set name=?,address=?,birthdate=?,rollno=?,faculty=?,semester=?,college=?,gender=? where id =?");
		
		stat.setString(1, stud.getName());
		stat.setString(2, stud.getAddress());
		// stat.setDate(4, new java.sql.Date(stud.getBirthdate().getTime()));
		stat.setString(3, stud.getBirthdate());
		stat.setString(4, stud.getRollno());
		stat.setString(5, stud.getFaculty());
		stat.setString(6, stud.getSemester());
		stat.setString(7, stud.getCollege());
		stat.setString(8, stud.getGender());
		stat.setInt(9, stud.getId());
		

		stat.executeUpdate();
		
		
	}

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("select * from student");
			while (rs.next()) {// Loop Each Row

				Student stud = copyResultToStudent(rs);
				students.add(stud);

				// System.out.println(stud);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return students;
	}

	public List<Student> getSearchedStudents(String skey, String sby) {
		List<Student> students = new ArrayList<Student>();

		System.out.println("Search by=" + sby);

		System.out.println("search key=" + skey);
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("select * from student where "
					+ sby + " like '%" + skey + "%'");

			while (rs.next()) {// Loop Each Row

				Student stud = copyResultToStudent(rs);
				students.add(stud);

				// System.out.println(stud);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return students;
	}

	public Student copyResultToStudent(ResultSet rs) throws SQLException,
			ParseException {
		Student stud = new Student();
		stud.setId(rs.getInt("id"));
		stud.setName(rs.getString("name"));

		String bdayStr = rs.getString("birthdate");
		// Date bday = new SimpleDateFormat("YYYY-MM-DD").parse(bdayStr);
		stud.setBirthdate(bdayStr);

		stud.setRollno(rs.getString("rollno"));
		stud.setFaculty(rs.getString("faculty"));
		stud.setSemester(rs.getString("semester"));
		stud.setCollege(rs.getString("college"));
		stud.setGender(rs.getString("gender"));
		stud.setAddress(rs.getString("address"));

		return stud;
	}
	
	
	public void deleteStudent(int a){
		try {
			String query = "delete from student where id = ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, a);
		 
		      // execute the preparedstatement
		      preparedStmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}