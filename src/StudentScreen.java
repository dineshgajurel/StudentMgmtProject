
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;

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



public class StudentScreen extends JFrame {

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
	private JComboBox searchKey;
	private JLabel lblNewLabel_10;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Desktop\\New folder (3)\\Student-Management-System-project.jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 538);
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
		contentPane.add(getSearchKey());
		contentPane.add(getLblNewLabel_10());
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
				StudentScreen studScrs=(StudentScreen)WindowManager.ui.get("StudentScreen");
				studScrs.dispose();
				LoginScreen loginScr=(LoginScreen)WindowManager.ui.get("LoginScreen");
				loginScr.setVisible(true);
				
				
					JOptionPane.showMessageDialog(null, "you have just logged out from the system.. See you later miss/mrs/miss "+activeUser.getText());
				}
			});
			logout.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\New folder (3)\\logout_button_green.png"));
			logout.setBounds(644, 10, 38, 38);
		}
		return logout;
	}

	private JPanel getStudentForm() {
		if (studentForm == null) {
			studentForm = new JPanel();
			studentForm.setBorder(new TitledBorder(null, "Student Form",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			studentForm.setBounds(10, 45, 524, 153);
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
			lblNewLabel_1.setBounds(169, 28, 58, 14);
		}
		return lblNewLabel_1;
	}

	private JTextField getBirthDate() {
		if (birthDate == null) {
			birthDate = new JTextField();
			birthDate.setBounds(237, 25, 99, 20);
			birthDate.setColumns(10);
		}
		return birthDate;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Roll No:");
			lblNewLabel_2.setBounds(353, 25, 52, 14);
		}
		return lblNewLabel_2;
	}

	private JTextField getRollNo() {
		if (rollNo == null) {
			rollNo = new JTextField();
			rollNo.setBounds(415, 25, 77, 20);
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
			ButtonGroup btngrp = new ButtonGroup();
			btngrp.add(getMale());
			btngrp.add(getFemale());

		}
		return genderPanel;
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
			address.setBounds(250, 112, 109, 23);
			address.setColumns(10);
		}
		return address;
	}

	private JButton getSave() {
		if (save == null) {
			save = new JButton("");
			save.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\New folder (3)\\images.png"));
			save.setBounds(415, 116, 37, 23);
			save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String name=new String(nameTxt.getText());
					String birthdate=new String(birthDate.getText());
					String roll=new String(rollNo.getText());
					String f=new String(faculty.getText());
					String sem=new String(semester.getText());
					String c=new String(college.getText());
					String a=new String(address.getText());
				Student student =new Student();
				student.setAddress(a);
				student.setBirthdate(birthdate);
				try {
					StudentDao stdDao=new StudentDao();
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
		return save;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {
					{ null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null, null }, },
					new String[] { "ID", "Name", "Roll No", "Date of Birth",
							"Address", "Faculty", "Semester", "College Name" }));
			table.getColumnModel().getColumn(5).setPreferredWidth(56);
		}
		return table;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 278, 806, 153);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Student Management System\r\n\r\n\r\n");
			lblNewLabel_5.setForeground(new Color(30, 144, 255));
			lblNewLabel_5.setBounds(187, 219, 173, 23);
		}
		return lblNewLabel_5;
	}

	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Database Section\r\n");
			lblNewLabel_6.setForeground(new Color(30, 144, 255));
			lblNewLabel_6.setBounds(397, 219, 137, 23);
		}
		return lblNewLabel_6;
	}

	private JLabel getLblSave() {
		if (lblSave == null) {
			lblSave = new JLabel("Save:");
			lblSave.setBounds(369, 116, 37, 23);
		}
		return lblSave;
	}

	private JButton getExit() {
		if (exit == null) {
			exit = new JButton("");
			exit.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\New folder (3)\\images (6).jpg"));
			exit.setBounds(764, 434, 31, 31);
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
			lblExitProgram.setBounds(644, 442, 110, 23);
		}
		return lblExitProgram;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Copy Right  \u00A9 Gajurel Dinesh 2016");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 13));
			lblNewLabel_7.setBounds(307, 439, 227, 31);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("Welcome To  The Student Management System\r\n\r\n");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_8.setBounds(10, 11, 315, 27);
			lblNewLabel_8.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					lblNewLabel_8.setForeground(new Color(30, 144, 255));
					
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));				}
			});
			
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\New folder (3)\\Student-Management-System-project.jpg"));
			lblNewLabel_9.setBounds(539, 53, 310, 141);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblSearchBy() {
		if (lblSearchBy == null) {
			lblSearchBy = new JLabel("Search By:");
			lblSearchBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSearchBy.setBounds(38, 253, 78, 20);
		}
		return lblSearchBy;
	}
	private JComboBox getSearchKey() {
		if (searchKey == null) {
			searchKey = new JComboBox();
			searchKey.setModel(new DefaultComboBoxModel(new String[] {"ID", "Name", "Roll No", "Date Of Birth", "Address", "College Name", "Faculty", "Semester"}));
			searchKey.setBounds(126, 246, 114, 27);
		}
		return searchKey;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("Student Management System(SMS)\r\n");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 13));
			lblNewLabel_10.setBounds(307, 465, 211, 23);
		}
		return lblNewLabel_10;
	}
}
