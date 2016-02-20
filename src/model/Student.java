package model;

import java.util.Date;

public class Student {
	private int id = 0;
	private String name;
	private String birthdate;
	private String rollno;
	private String faculty;
	private String semester;
	private String college;
	private String gender;
	private String address;
	private String editDelete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public Date getBirthdate() {
	// return birthdate;
	// }
	// public void setBirthdate(Date birthdate) {
	// this.birthdate = birthdate;
	// }
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEditDelete() {
		return editDelete;
	}

	public void setEditdelete(String editDelete) {
		this.editDelete = editDelete;
	}

	@Override
	public String toString() {

		return id + ":" + name + " " + birthdate + " " + rollno + " " + faculty
				+ " " + semester + " " + college + " " + gender + " " + address
				+ "";
	}

}
