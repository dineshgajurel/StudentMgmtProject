import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.Student;
import dao.StudentDao;

import java.awt.event.MouseAdapter;

public class StudentScreen extends JFrame {
	//static int id;
	Student student = new Student();
	private JPanel contentPane;
	private JLabel lblActiveUser;
	private JLabel activeUser;
	private JButton logout;
	private JPanel studentForm;
	private JLabel lblNewLabel;
	private JTextField nameTxt;
	private JLabel lblNewLabel_1;
	private JTextField birthDate;
	private JLabel lblNewLabel_2;
	private JTextField rollNo;
	private JLabel lblFaculty;
	private JTextField faculty;
	private JLabel lblNewLabel_3;
	private JTextField semester;
	private JLabel lblNewLabel_4;
	private JTextField college;
	private JPanel genderPanel;
	private JRadioButton male;
	private JLabel lblLogOut;
	private JRadioButton female;
	private JLabel lblAddress;
	private JTextField address;
	private JButton save;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	static StudentScreen frame = new StudentScreen();
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblSave;
	private JButton exit;
	private JLabel lblExitProgram;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblSearchBy;
	private JComboBox searchby;
	private JLabel lblNewLabel_10;
	private JLabel message;
	private JLabel lblBravoNowYou;
	private JLabel lblSearchKey;
	private JTextField searchkey;
	private JButton search;
	private JLabel lblDeleteRecentlyAdded;
	private JButton btnY;
	private JLabel lblsmssmssmssmssmssms;
	private JLabel lblYyyymmdd;
	private JButton btnViewAll;
	private JButton btnEdit;
	private JLabel lblEdit;
	private JButton edit;
	private JButton cancel;
	private JButton btnClear;
	private JTextField i;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public StudentScreen() {
		setTitle("Student Management System(SMS)  \u00A9 Gajurel Dinesh  2016");
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"C:\\Users\\DELL\\Desktop\\New folder (3)\\Student-Management-System-project.jpg"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 589);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblActiveUser());
		contentPane.add(getActiveUser());
		contentPane.add(getLogout());
		contentPane.add(getStudentForm());
		contentPane.add(getLblLogOut());
		contentPane.add(getScrollPane());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getLblNewLabel_6());
		contentPane.add(getExit());
		contentPane.add(getLblExitProgram());
		contentPane.add(getLblNewLabel_7());
		contentPane.add(getLblNewLabel_8());
		contentPane.add(getLblNewLabel_9());
		contentPane.add(getLblSearchBy());
		contentPane.add(getSearchby());
		contentPane.add(getLblNewLabel_10());
		contentPane.add(getMessage());
		contentPane.add(getLblBravoNowYou());
		contentPane.add(getLblSearchKey());
		contentPane.add(getSearchkey());
		contentPane.add(getSearch());
		contentPane.add(getLblDeleteRecentlyAdded());
		contentPane.add(getBtnY());
		contentPane.add(getLblsmssmssmssmssmssms());
		contentPane.add(getBtnViewAll());
		contentPane.add(getBtnEdit());
		contentPane.add(getBtnClear());

		try {
			// new StudentDao();
			showAllStudents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JLabel getLblActiveUser() {
		if (lblActiveUser == null) {
			lblActiveUser = new JLabel("Active User:");
			lblActiveUser.setBounds(335, 11, 78, 23);
		}
		return lblActiveUser;
	}

	public JLabel getActiveUser() {
		if (activeUser == null) {
			activeUser = new JLabel();
			activeUser.setText("User");

			activeUser.setForeground(new Color(30, 144, 255));
			activeUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
			activeUser.setBounds(416, 11, 78, 23);

		}
		return activeUser;
	}

	private JButton getLogout() {
		if (logout == null) {
			logout = new JButton("");
			logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentScreen studScrs = (StudentScreen) WindowManager.ui
							.get("StudentScreen");
					studScrs.dispose();
					LoginScreen loginScr = (LoginScreen) WindowManager.ui
							.get("LoginScreen");
					loginScr.setVisible(true);

					JOptionPane.showMessageDialog(null,
							"you have just logged out from the system.. See you later miss/mrs/miss "
									+ activeUser.getText());
				}
			});
			logout.setIcon(new ImageIcon(
					"C:\\Users\\DELL\\Desktop\\New folder (3)\\logout_button_green.png"));
			logout.setBounds(644, 10, 38, 38);
			// logout.addMouseMotionListener(new MouseMotionListener() {
			//
			// @Override
			// public void mouseMoved(MouseEvent e) {
			//
			// JOptionPane.showMessageDialog(null,
			// "This will redirect you to the login page and terinates your current session ");
			//
			// }
			//
			// @Override
			// public void mouseDragged(MouseEvent e) {
			// // TODO Auto-generated method stub
			//
			// }
			// });
		}

		return logout;
	}

	private JPanel getStudentForm() {
		if (studentForm == null) {
			studentForm = new JPanel();
			studentForm.setBorder(new TitledBorder(null, "Student Form",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			studentForm.setBounds(10, 45, 524, 162);
			studentForm.setLayout(null);
			studentForm.add(getLblNewLabel());
			studentForm.add(getNameTxt());
			studentForm.add(getLblNewLabel_1());
			studentForm.add(getBirthDate());
			studentForm.add(getLblNewLabel_2());
			studentForm.add(getRollNo());
			studentForm.add(getLblFaculty());
			studentForm.add(getFaculty());
			studentForm.add(getLblNewLabel_3());
			studentForm.add(getSemester());
			studentForm.add(getLblNewLabel_4());
			studentForm.add(getCollege());
			studentForm.add(getGenderPanel());
			studentForm.add(getLblAddress());
			studentForm.add(getAddress());
			studentForm.add(getSave());
			studentForm.add(getLblSave());
			studentForm.add(getLblYyyymmdd());
			studentForm.add(getLblEdit());
			studentForm.add(getEdit());
			studentForm.add(getCancel());
			studentForm.add(getI());
		}
		return studentForm;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Name");
			lblNewLabel.setBounds(10, 28, 37, 14);
		}
		return lblNewLabel;
	}

	private JTextField getNameTxt() {
		if (nameTxt == null) {
			nameTxt = new JTextField();
			nameTxt.setBounds(57, 25, 102, 20);
			nameTxt.setColumns(10);
		}
		return nameTxt;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Birth Date");
			lblNewLabel_1.setBounds(169, 25, 58, 12);
		}
		return lblNewLabel_1;
	}

	private JTextField getBirthDate() {
		if (birthDate == null) {
			birthDate = new JTextField();
			birthDate.setBounds(261, 25, 97, 24);
			birthDate.setColumns(10);
		}
		return birthDate;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Roll No:");
			lblNewLabel_2.setBounds(368, 25, 53, 14);
		}
		return lblNewLabel_2;
	}

	private JTextField getRollNo() {
		if (rollNo == null) {
			rollNo = new JTextField();
			rollNo.setBounds(431, 25, 83, 20);
			rollNo.setColumns(10);
		}
		return rollNo;
	}

	private JLabel getLblFaculty() {
		if (lblFaculty == null) {
			lblFaculty = new JLabel("Faculty");
			lblFaculty.setBounds(10, 63, 46, 14);
		}
		return lblFaculty;
	}

	private JTextField getFaculty() {
		if (faculty == null) {
			faculty = new JTextField();
			faculty.setBounds(57, 60, 86, 20);
			faculty.setColumns(10);
		}
		return faculty;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Semester");
			lblNewLabel_3.setBounds(153, 63, 58, 14);
		}
		return lblNewLabel_3;
	}

	private JTextField getSemester() {
		if (semester == null) {
			semester = new JTextField();
			semester.setBounds(216, 60, 77, 20);
			semester.setColumns(10);
		}
		return semester;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("College Name\r\n");
			lblNewLabel_4.setBounds(303, 63, 80, 14);
		}
		return lblNewLabel_4;
	}

	private JTextField getCollege() {
		if (college == null) {
			college = new JTextField();
			college.setBounds(393, 60, 121, 20);
			college.setColumns(10);
		}
		return college;
	}

	private JPanel getGenderPanel() {
		if (genderPanel == null) {
			genderPanel = new JPanel();
			genderPanel.setBorder(new TitledBorder(null, "Gender",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			genderPanel.setBounds(20, 91, 151, 60);
			genderPanel.setLayout(null);
			genderPanel.add(getMale());
			genderPanel.add(getFemale());
			btngrp();

		}
		return genderPanel;
	}
	
	public ButtonGroup btngrp(){
			ButtonGroup btngrp = new ButtonGroup();
			btngrp.add(getMale());
			btngrp.add(getFemale());
			return btngrp;
			}

	private JRadioButton getMale() {
		if (male == null) {
			male = new JRadioButton("Male\r\n");
			male.setBounds(7, 21, 58, 23);
		}
		return male;
	}

	private JLabel getLblLogOut() {
		if (lblLogOut == null) {
			lblLogOut = new JLabel("Log Out");
			lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblLogOut.setBounds(575, 11, 70, 27);
		}
		return lblLogOut;
	}

	private JRadioButton getFemale() {
		if (female == null) {
			female = new JRadioButton("Female");
			female.setBounds(78, 21, 67, 23);
		}
		return female;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(181, 116, 53, 14);
		}
		return lblAddress;
	}

	private JTextField getAddress() {
		if (address == null) {
			address = new JTextField();
			address.setBounds(250, 112, 102, 23);
			address.setColumns(10);
		}
		return address;
	}

	private JButton getSave() {
		if (save == null) {
			save = new JButton("");
			save.setIcon(new ImageIcon(
					"C:\\Users\\DELL\\Desktop\\New folder (3)\\images.png"));
			save.setBounds(393, 116, 37, 20);
			// save.addActionListener(new ActionListener() {
			//
			// @Override
			// public void actionPerformed(ActionEvent e) {
			//
			//
			// String n=new String(nameTxt.getText());
			// String b=new String (birthDate.getText());
			// String r=new String(rollNo.getText());
			// String f=new String(faculty.getText());
			// String s=new String(semester.getText());
			// String c=new String(college.getText());
			// String a=new String(address.getText());
			// String o=new String("E/D");
			// String g="";
			//
			// if(male.isSelected()){
			// g=new String("Male");
			// }
			// if(female.isSelected()){
			// g=new String("Female");
			// }
			//
			//
			// Object[] row = {"N/A", n, r,b, a, f,s,c,g,o };
			//
			// DefaultTableModel model = (DefaultTableModel)table.getModel();
			// model.addRow(row);
			//
			//
			// birthDate.setText("");
			// nameTxt.setText("");
			// rollNo.setText("");
			// faculty.setText("");
			// semester.setText("");
			// semester.setText("");
			// college.setText("");
			// address.setText("");
			//
			//
			// //JOptionPane.showMessageDialog(null,"Do u really think data is submitted??r u commedy me?");
			// message.setText("Mr/mrs/miss  "
			// +activeUser.getText()+"  Do u really think data is submitted?? hahahah r u commedy me?");
			//
			// //student.setBirthdate(birthdate);
			// try {
			// StudentDao stdDao=new StudentDao();
			// } catch (ClassNotFoundException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// } catch (SQLException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }
			//
			//
			//
			// }
			//
			//
			// });

			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {

						String g = "";
						if (male.isSelected() | female.isSelected()) {
							g = "selected";
						}

						if (nameTxt.getText().equals("")) {

							showMessage("Name field can't be blank");
							
						} else if (birthDate.getText().equals("")) {

							showMessage(" Birth Date field can't be blank");
						} else if (rollNo.getText().equals("")) {

							showMessage("Roll No field can't be blank");
						} else if (faculty.getText().equals("")) {

							showMessage("Faculty field can't be blank");
						} else if (semester.getText().equals("")) {

							showMessage("Semester field can't be blank");
						} else if (college.getText().equals("")) {

							showMessage("College Name field can't be blank");
						} else if (g.equals("")) {
							showMessage("Gender should be selected");

						} else if (address.getText().equals("")) {

							showMessage("Address field can't be blank");
						} else {
							Student stud = getStudentFormData();
							StudentDao stdDao = new StudentDao();
							stdDao.saveStudent(stud);
							DefaultTableModel model = (DefaultTableModel) table
									.getModel();
							int c = model.getRowCount();

							showAllStudents();
							DefaultTableModel model1 = (DefaultTableModel) table
									.getModel();
							int c1 = model1.getRowCount();

							System.out.println("Previous no of row in table="+c);
							System.out.println("No of row after adding data ="+c1);
							if (c1 > c) {
								showMessage("Data added Succesfully");
							} else {
								message.setText("Data cannot be added due to internal database error");
							}
							
							clearform();
							
						
						
						}

					} catch (ParseException | SQLException
							| ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

		}
		return save;
	}

	private void showAllStudents() throws ClassNotFoundException, SQLException {

		/*** Clear Table data ***/
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Clear Table

		/** fetch all students record ***/
		StudentDao studDao = new StudentDao();
		List<Student> studentList = studDao.getAllStudents();
		for (Student stud : studentList) {
			System.out.println(stud);
			model.addRow(new Object[] { stud.getId(), stud.getName(),
					stud.getRollno(), stud.getBirthdate(), stud.getAddress(),
					stud.getFaculty(),

					stud.getSemester(), stud.getCollege(), stud.getGender(), });
		}
	}

	private void showSearchedStudents(String skey, String sby)
			throws ClassNotFoundException, SQLException {

		/*** Clear Table data ***/
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Clear Table

		/** fetch searched students record ***/
		StudentDao studDao = new StudentDao();
		List<Student> studentList = studDao.getSearchedStudents(skey, sby);
		for (Student stud : studentList) {
			System.out.println(stud);
			model.addRow(new Object[] { stud.getId(), stud.getName(),
					stud.getRollno(), stud.getBirthdate(), stud.getAddress(),
					stud.getFaculty(),

					stud.getSemester(), stud.getCollege(), stud.getGender(), });
		}
	}

	private Student getStudentFormData() throws ParseException {
		Student stud = new Student();
		stud.setName(nameTxt.getText());
		// stud.setBirthdate(new SimpleDateFormat("YYYY-MM-DD").parse(birthDate
		// .getText()));
		stud.setBirthdate(birthDate.getText());
		stud.setRollno(rollNo.getText());
		stud.setFaculty(faculty.getText());
		stud.setSemester(semester.getText());
		stud.setCollege(college.getText());
		if (male.isSelected()) {
			stud.setGender("M");
		} else if (female.isSelected()) {
			stud.setGender("F");
		}
		stud.setAddress(address.getText());
		return stud;
	}
	
	private Student getUpdateStudentFormData() throws ParseException {
	
		Student stud = new Student();
		String s=i.getText();
		int in=Integer.parseInt(s);
		stud.setId(in);
		stud.setName(nameTxt.getText());
		// stud.setBirthdate(new SimpleDateFormat("YYYY-MM-DD").parse(birthDate
		// .getText()));
		stud.setBirthdate(birthDate.getText());
		stud.setRollno(rollNo.getText());
		stud.setFaculty(faculty.getText());
		stud.setSemester(semester.getText());
		stud.setCollege(college.getText());
		if (male.isSelected()) {
			stud.setGender("M");
		} else if (female.isSelected()) {
			stud.setGender("F");
		}
		stud.setAddress(address.getText());
		return stud;
	}

	
	
	

	private JTable getTable() {
		// int id=1;
		// String name="Dinesh Gajurel";
		// String roll="12";
		// String dob="2051/08/18";
		// String add="Kushuti";
		// String faculty="Bsc.csit";
		// String sem="7th";
		// String col="Patan multiple campus";
		//

		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {

			}, new String[] { "ID", "Name", "Roll No", "Date of Birth",
					"Address", "Faculty", "Semester", "College Name", "Gender",
					"Edit/Delete" }));
			table.getColumnModel().getColumn(5).setPreferredWidth(56);

		}
		return table;
		
//		int row = table.getSelectedRow();
//		int column = table.getColumnCount();
//		for(int i = 0; i < column; i++) {
//		    System.out.println(table.getValueAt(row, i));
//		}
		
		
		
	}
	
	
	
	
	
	
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			scrollPane.setBounds(21, 317, 806, 153);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Student Management System\r\n\r\n\r\n");
			lblNewLabel_5.setForeground(new Color(30, 144, 255));
			lblNewLabel_5.setBounds(50, 232, 173, 23);
		}
		return lblNewLabel_5;
	}

	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Database Section\r\n");
			lblNewLabel_6.setForeground(new Color(30, 144, 255));
			lblNewLabel_6.setBounds(617, 232, 137, 23);
		}
		return lblNewLabel_6;
	}

	private JLabel getLblSave() {
		if (lblSave == null) {
			lblSave = new JLabel("Save:");
			lblSave.setBounds(357, 112, 37, 23);
		}
		return lblSave;
	}

	private JButton getExit() {
		if (exit == null) {
			exit = new JButton("");
			exit.setIcon(new ImageIcon(
					"C:\\Users\\DELL\\Desktop\\New folder (3)\\images (6).jpg"));
			exit.setBounds(766, 491, 31, 31);
			exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exit;
	}

	private JLabel getLblExitProgram() {
		if (lblExitProgram == null) {
			lblExitProgram = new JLabel("Exit Program");
			lblExitProgram.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblExitProgram.setBounds(644, 499, 110, 23);
		}
		return lblExitProgram;
	}

	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Copy Right  \u00A9 Gajurel Dinesh 2016");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 13));
			lblNewLabel_7.setBounds(307, 469, 227, 31);
		}
		return lblNewLabel_7;
	}

	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel(
					"Welcome To  The Student Management System\r\n\r\n");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_8.setBounds(10, 11, 315, 27);
			lblNewLabel_8.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseMoved(MouseEvent e) {
					lblNewLabel_8.setForeground(new Color(30, 144, 255));

				}

				@Override
				public void mouseDragged(MouseEvent e) {
					lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
				}
			});

		}
		return lblNewLabel_8;
	}

	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9
					.setIcon(new ImageIcon(
							"C:\\Users\\DELL\\Desktop\\New folder (3)\\Student-Management-System-project.jpg"));
			lblNewLabel_9.setBounds(539, 53, 276, 162);
		}
		return lblNewLabel_9;
	}

	private JLabel getLblSearchBy() {
		if (lblSearchBy == null) {
			lblSearchBy = new JLabel("Search By:");
			lblSearchBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSearchBy.setBounds(35, 260, 70, 20);
		}
		return lblSearchBy;
	}

	private JComboBox getSearchby() {
		if (searchby == null) {
			searchby = new JComboBox();
			searchby.setModel(new DefaultComboBoxModel(new String[] { "ID",
					"Name", "Roll No", "Date Of Birth", "Address",
					"College Name", "Faculty", "Semester", "Gender" }));
			searchby.setBounds(108, 259, 115, 21);
			searchby.setSelectedItem("Name");
		}
		return searchby;
	}

	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("Student Management System(SMS)\r\n");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 13));
			lblNewLabel_10.setBounds(307, 500, 211, 23);
		}
		return lblNewLabel_10;
	}

	private JLabel getMessage() {
		if (message == null) {
			message = new JLabel("");

			message.setForeground(Color.RED);
			message.setBounds(243, 209, 497, 27);
		}
		return message;
	}

	private JLabel getLblBravoNowYou() {
		if (lblBravoNowYou == null) {
			lblBravoNowYou = new JLabel(
					"Bravo! Now you can search  data according to your requirements (Just by  using category)");
			lblBravoNowYou.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
					11));
			lblBravoNowYou.setForeground(new Color(0, 51, 153));
			lblBravoNowYou.setBounds(308, 251, 519, 29);
		}
		return lblBravoNowYou;
	}

	private JLabel getLblSearchKey() {
		if (lblSearchKey == null) {
			lblSearchKey = new JLabel("Search Key:");
			lblSearchKey.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSearchKey.setBounds(35, 290, 78, 23);
		}
		return lblSearchKey;
	}

	private JTextField getSearchkey() {
		if (searchkey == null) {
			searchkey = new JTextField();
			searchkey.setBounds(108, 283, 120, 23);
			searchkey.setColumns(10);
		}
		return searchkey;
	}

	private JButton getSearch() {
		if (search == null) {
			search = new JButton("Search");
			search.setBounds(228, 283, 78, 23);
			search.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// message.setText("Sorry!  Working on it ..");
					String skey = new String(searchkey.getText());
					String sby = "";
					String s = (String) searchby.getSelectedItem();
					if (s.equals("Date Of Birth")) {
						sby = "birthdate";
					} else if (s.equals("College Name")) {

						sby = "college";
					} else if(s.equals("Roll No")){
						
						sby="rollno";
					}else {
						sby = s.toLowerCase();
					}
					try {
						showSearchedStudents(skey, sby);
						DefaultTableModel model = (DefaultTableModel) table
								.getModel();
						int row = model.getRowCount();
						if (row == 0) {
							showMessage("No data where " + s
									+ " includes  " + skey);
						} else {
							showMessage("Here your searched data where  "
									+ s + " includes " + skey);
						}
						searchby.setSelectedItem("Name");
						searchkey.setText("");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		}
		return search;
	}

	private JLabel getLblDeleteRecentlyAdded() {
		if (lblDeleteRecentlyAdded == null) {
			lblDeleteRecentlyAdded = new JLabel(
					"Edit/Delete data from the selected row??");
			lblDeleteRecentlyAdded.setForeground(Color.RED);
			lblDeleteRecentlyAdded.setBounds(416, 280, 252, 26);
		}
		return lblDeleteRecentlyAdded;
	}

	private JButton getBtnY() {
		if (btnY == null) {
			btnY = new JButton("Delete\r\n");
			btnY.setBounds(757, 283, 70, 23);
			
			btnY.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int row = table.getSelectedRow();
					Integer a=0;
					//int column = table.getColumnCount();
					for(int i = 0; i < 1; i++) {
					    
					     a=(int)table.getValueAt(row, i);
					    
					}
					
					
					
					try {
						StudentDao stdDao = new StudentDao();
						stdDao.deleteStudent(a);
						DefaultTableModel model = (DefaultTableModel) table
								.getModel();
						int c = model.getRowCount();
						showAllStudents();
						
						
						int c1 = model.getRowCount();
						if(c>c1){
							showMessage("Data is deleted with id =" +a);
							
						}
						System.out.println("Data deleted with id=" +a);
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
				}
			});
		
		}
		return btnY;
	}

	private JLabel getLblsmssmssmssmssmssms() {
		if (lblsmssmssmssmssmssms == null) {
			lblsmssmssmssmssmssms = new JLabel(
					"..........SMS........................SMS..............................SMS.........................SMS....................................................................");
			lblsmssmssmssmssmssms.setForeground(Color.MAGENTA);
			lblsmssmssmssmssmssms.setBounds(241, 236, 360, 14);
		}
		return lblsmssmssmssmssmssms;
	}

	private JLabel getLblYyyymmdd() {
		if (lblYyyymmdd == null) {
			lblYyyymmdd = new JLabel("(YYYY-MM-DD)");
			lblYyyymmdd.setBounds(169, 38, 82, 14);
		}
		return lblYyyymmdd;
	}
	private JButton getBtnViewAll() {
		if (btnViewAll == null) {
			btnViewAll = new JButton("View All");
			btnViewAll.setBounds(307, 283, 94, 23);
			btnViewAll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
try {
	showAllStudents();
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}					
				}
			});
		}
		return btnViewAll;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("edit");
			btnEdit.setBounds(678, 283, 70, 23);
			btnEdit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					
					save.setVisible(false);
					lblSave.setVisible(false);
					edit.setVisible(true);
					lblEdit.setVisible(true);
					cancel.setVisible(true);
					
					int row = table.getSelectedRow();
					
					String a="";
					String s="";
					Integer int1=0;
					
					//int column = table.getColumnCount();
					
					for(int i = 0; i < 1; i++) {
					    
					     int1=(Integer)table.getValueAt(row, i);
					    s =int1.toString();
					    
					}
					i.setText(s);
					
					
					for(int i = 1; i < 2; i++) {
					    
					     a=(String)table.getValueAt(row, i);
					    
					}
					nameTxt.setText(a);
					
					for(int i = 2; i < 3; i++) {
					    
					     a=(String)table.getValueAt(row, i);
					    
					}
					rollNo.setText(a);
					for(int i = 3; i < 4; i++) {
					    
					     a=(String)table.getValueAt(row, i);
					    
					}
					birthDate.setText(a);
					for(int i = 4; i < 5; i++) {
					    
					     a=(String)table.getValueAt(row, i);
					    
					}
					address.setText(a);
					for(int i = 5; i < 6; i++) {
					    
					     a=(String)table.getValueAt(row, i);
					    
					}
					faculty.setText(a);
					for(int i = 6; i < 7; i++) {
					    
					     a=(String)table.getValueAt(row, i);
					    
					}
					semester.setText(a);
					for(int i = 7; i < 8; i++) {
					    
					     a=(String)table.getValueAt(row, i);
					    
					}
					college.setText(a);
					for(int i = 8; i < 9; i++) {
					    
					     a=(String)table.getValueAt(row, i);
					    
					}
					
					if(a.equals("M")){
						
					male.setSelected(true);
					
					}
					else if(a.equals("F")){
						
						female.setSelected(true);
					}
					
					showMessage("You selected the data with id= "+s+" to edit. ");
				}
				
			});
		}
		return btnEdit;
	}
	private JLabel getLblEdit() {
		if (lblEdit == null) {
			lblEdit = new JLabel("Edit");
			lblEdit.setBounds(368, 116, 46, 14);
			lblEdit.setVisible(false);
			
		}
		return lblEdit;
	}
	private JButton getEdit() {
		if (edit == null) {
			edit = new JButton("");
			edit.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\New folder (3)\\images.png"));
			edit.setBounds(393, 116, 37, 20);
			edit.setVisible(false);
			edit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						
						
						String g = "";
						if (male.isSelected() | female.isSelected()) {
							g = "selected";
						}

						if (nameTxt.getText().equals("")) {

							showMessage("Name field can't be blank");
							
						} else if (birthDate.getText().equals("")) {

							showMessage(" Birth Date field can't be blank");
						} else if (rollNo.getText().equals("")) {

							showMessage("Roll No field can't be blank");
						} else if (faculty.getText().equals("")) {

							showMessage("Faculty field can't be blank");
						} else if (semester.getText().equals("")) {

							showMessage("Semester field can't be blank");
						} else if (college.getText().equals("")) {

							showMessage("College Name field can't be blank");
						} else if (g.equals("")) {
							showMessage("Gender should be selected");

						} else if (address.getText().equals("")) {

							showMessage("Address field can't be blank");
						}else{
						
						Student stud = getUpdateStudentFormData();
						StudentDao stdDao = new StudentDao();
						stdDao.updateStudent(stud);
						showAllStudents();
						clearform();
						lblEdit.setVisible(false);
						lblSave.setVisible(true);
						edit.setVisible(false);
						save.setVisible(true);
						showMessage("Data edited successfully");
						}
						
					} catch (ParseException|SQLException|ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
		return edit;
	}
	private JButton getCancel() {
		if (cancel == null) {
			cancel = new JButton("Cancel");
			cancel.setBounds(440, 112, 74, 23);
			
			cancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					clearform();
					i.setVisible(false);
					lblEdit.setVisible(false);
					edit.setVisible(false);
					save.setVisible(true);
					lblSave.setVisible(true);
					//cancel.setVisible(false);
					
				}
			});
		}
		return cancel;
	}
public void clearform(){
	i.setText("");
	nameTxt.setText("");
	birthDate.setText("");
	rollNo.setText("");
	college.setText("");
	semester.setText("");
	address.setText("");
	faculty.setText("");
	btngrp().clearSelection();
}
public void showMessage(String m){
	message.setText(m);
	btnClear.setVisible(true);
	
}
	
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("clear");
			btnClear.setForeground(Color.RED);
			btnClear.setBounds(174, 212, 64, 20);
			btnClear.setVisible(false);
			btnClear.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					message.setText("");
					btnClear.setVisible(false);
					
				}
			});
			
			
		}
		return btnClear;
	}
	private JTextField getI() {
		if (i == null) {
			i = new JTextField();
			i.setBounds(104, 11, 46, 12);
			i.setColumns(10);
			i.setVisible(false);
		}
		return i;
	}
}
