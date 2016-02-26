import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.User;
import dao.UserDao;
import java.awt.Window.Type;

public class Register extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblFullName;
	private JLabel lblUsername;
	private JLabel yourPassword;
	private JLabel lblEmail;
	private JPanel userPanel;
	private JRadioButton admin;
	private JRadioButton general;
	private JTextField fullName;
	private JTextField username;
	private JTextField email;
	private JPanel Gender;
	private JRadioButton male;
	private JRadioButton female;
	private JPasswordField password;
	private JButton register;
	private JButton back;
	private JLabel message;
	private JCheckBox show;
	private JTextArea showPassword;
	private JButton btnCancel;
	private JButton btnHelp;
	private JLabel label;
	private JLabel lblListOfThe;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblStudentManagementSystemsms;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Register frame = new Register();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public Register() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.WEST);
		contentPane.add(getPanel_2(), BorderLayout.SOUTH);
		contentPane.add(getPanel_3(), BorderLayout.EAST);
		contentPane.add(getPanel_4(), BorderLayout.CENTER);
		try {
			showAllUser();
		} catch (ClassNotFoundException | SQLException | ParseException e) {

			e.printStackTrace();
		}

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.BLUE);
			panel.setForeground(Color.BLUE);
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.BLUE);
			panel_1.setForeground(Color.BLUE);
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.BLUE);
			panel_2.setForeground(Color.BLUE);
		}
		return panel_2;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.BLUE);
			panel_3.setForeground(Color.BLUE);
		}
		return panel_3;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.CYAN);
			panel_4.setForeground(Color.CYAN);
			panel_4.setLayout(null);
			panel_4.add(getPanel_5());
			panel_4.add(getBack());
			panel_4.add(getMessage());
			panel_4.add(getLabel());
			panel_4.add(getLblListOfThe());
			panel_4.add(getScrollPane_1());
			panel_4.add(getLblNewLabel());
			panel_4.add(getLblStudentManagementSystemsms());
			panel_4.add(getBtnHelp());
		}
		return panel_4;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBorder(new TitledBorder(null, "Register",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_5.setBounds(10, 11, 390, 293);
			panel_5.setLayout(null);
			panel_5.add(getLblFullName());
			panel_5.add(getLblUsername());
			panel_5.add(getYourPassword());
			panel_5.add(getLblEmail());
			panel_5.add(getUserPanel());
			panel_5.add(getFullName());
			panel_5.add(getUsername());
			panel_5.add(getEmail());
			panel_5.add(getGender());
			panel_5.add(getPassword());
			panel_5.add(getShow());
			panel_5.add(getShowPassword());
			panel_5.add(getBtnCancel());
			panel_5.add(getRegister());
		}
		return panel_5;
	}

	private JLabel getLblFullName() {
		if (lblFullName == null) {
			lblFullName = new JLabel("Full Name:\r\n");
			lblFullName.setBounds(20, 23, 76, 20);
		}
		return lblFullName;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setBounds(20, 60, 76, 26);
		}
		return lblUsername;
	}

	private JLabel getYourPassword() {
		if (yourPassword == null) {
			yourPassword = new JLabel("Password:");
			yourPassword.setBounds(20, 91, 76, 29);
		}
		return yourPassword;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setBounds(20, 131, 76, 32);
		}
		return lblEmail;
	}

	private JPanel getUserPanel() {
		if (userPanel == null) {
			userPanel = new JPanel();
			userPanel.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "User Type",
					TitledBorder.CENTER, TitledBorder.TOP, null, null));
			userPanel.setBounds(199, 170, 169, 79);
			userPanel.setLayout(null);
			userPanel.add(getAdmin());
			userPanel.add(getGeneral());
			btnGrp();
		}
		return userPanel;
	}

	private ButtonGroup btnGrp() {
		ButtonGroup btnGrp = new ButtonGroup();
		btnGrp.add(getAdmin());
		btnGrp.add(getGeneral());
		return btnGrp;

	}

	private JRadioButton getAdmin() {
		if (admin == null) {
			admin = new JRadioButton("Admin");
			admin.setBounds(30, 23, 121, 23);
		}
		return admin;
	}

	private JRadioButton getGeneral() {
		if (general == null) {
			general = new JRadioButton("General\r\n");
			general.setBounds(30, 49, 121, 23);
		}
		return general;
	}

	private JTextField getFullName() {
		if (fullName == null) {
			fullName = new JTextField();
			fullName.setBounds(106, 23, 190, 29);
			fullName.setColumns(10);
		}
		return fullName;
	}

	private JTextField getUsername() {
		if (username == null) {
			username = new JTextField();
			username.setColumns(10);
			username.setBounds(106, 57, 190, 29);
		}
		return username;
	}

	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setColumns(10);
			email.setBounds(106, 134, 190, 29);
		}
		return email;
	}

	private JPanel getGender() {
		if (Gender == null) {
			Gender = new JPanel();
			Gender.setLayout(null);
			Gender.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "Gender",
					TitledBorder.CENTER, TitledBorder.TOP, null, null));
			Gender.setBounds(30, 170, 169, 79);
			Gender.add(getMale());
			Gender.add(getFemale());
			btnGrp1();
		}
		return Gender;
	}

	private ButtonGroup btnGrp1() {
		ButtonGroup btnGrp = new ButtonGroup();
		btnGrp.add(getMale());
		btnGrp.add(getFemale());
		return btnGrp;
	}

	private JRadioButton getMale() {
		if (male == null) {
			male = new JRadioButton("Male\r\n");
			male.setBounds(30, 23, 121, 23);
		}
		return male;
	}

	private JRadioButton getFemale() {
		if (female == null) {
			female = new JRadioButton("Female\r\n");
			female.setBounds(30, 49, 121, 23);
		}
		return female;
	}

	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setBounds(106, 91, 190, 32);
		}
		return password;
	}

	private JButton getRegister() {
		if (register == null) {
			register = new JButton("Register");
			register.setBounds(227, 255, 108, 27);
			register.setForeground(Color.BLUE);
			register.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					actualPassword();
					String p = new String(password.getPassword());
					String g = "";
					String ut = "";
					if (male.isSelected() | female.isSelected()) {
						g = "selected";
					}
					if (admin.isSelected() | general.isSelected()) {
						ut = "selected";
					}
					if (fullName.getText().equals("")) {
						showMessage("Full Name Field can't be blank!");
					} else if (username.getText().equals("")) {
						showMessage("Username Field Can't be blank!");
					} else if (p.equals("")) {
						showMessage("Password field can't be blank!");

					} else if (email.getText().equals("")) {
						showMessage("Email field Can't be blank!");

					} else if (g.equals("")) {
						showMessage("Gender should be selected!");
					} else if (ut.equals("")) {
						showMessage("User Type should be selected");
					}
           
					else {
						
						User user = getUserForm();

						UserDao userDao = new UserDao();
						try {
							userDao.save(user);
							
							
							showAllUser();
							
							showMessage("Data added successfully");
						} catch (ClassNotFoundException|ParseException|SQLException e1) {
							e1.printStackTrace();
						}
						
						clearform();
						
						
						

					}
				}
			});
		}
		return register;
	}

	private void showMessage(String m) {
		message.setText(m);
		Timer t = new Timer(4000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message.setText("");
			}
		});
		t.setRepeats(false);
		t.start();
	}

	public User getUserForm() {

		User user = new User();
		String s = new String(password.getPassword());

		user.setUsername(username.getText());
		user.setPassword(s);
		user.setEmail(email.getText());
		user.setFullName(fullName.getText());

		if (male.isSelected()) {
			user.setGender("M");

		} else if (female.isSelected()) {
			user.setGender("F");
		}
		if (admin.isSelected()) {
			user.setUserType("Admin");

		} else if (general.isSelected()) {
			user.setUserType("General");
		}

		return user;
	}

	private JButton getBack() {
		if (back == null) {
			back = new JButton("Back To Login");
			back.setForeground(Color.BLUE);
			back.setBounds(349, 332, 150, 29);
			back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Register reg = (Register) WindowManager.ui.get("Register");
					reg.dispose();
					LoginScreen loginScr = (LoginScreen) WindowManager.ui
							.get("LoginScreen");
					loginScr.setVisible(true);
				}
			});

		}
		return back;
	}

	private JLabel getMessage() {
		if (message == null) {
			message = new JLabel("");
			message.setForeground(Color.RED);
			message.setBounds(127, 305, 273, 23);
		}
		return message;
	}

	private JCheckBox getShow() {
		if (show == null) {
			show = new JCheckBox("show");
			show.setBounds(305, 91, 63, 29);
			show.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (show.isSelected()) {
						String pass = new String(password.getPassword());
						showPassword.setVisible(true);
						showPassword.setText(pass);
						password.setVisible(false);
						
						

					}
					if (!show.isSelected()) {

						showPassword.setVisible(false);
						password.setVisible(true);
						// ok.setVisible(false);
						show.setSelected(false);
						password.setText(showPassword.getText());
						
					}

				}
			});
		}
		return show;
	}

	private JTextArea getShowPassword() {
		if (showPassword == null) {
			showPassword = new JTextArea();
			showPassword.setBounds(106, 93, 190, 29);
			showPassword.setVisible(false);

		}
		return showPassword;
	}

	private void actualPassword() {
		if (show.isSelected()) {
			password.setText(showPassword.getText());

		}

	}

	private void clearform() {
		fullName.setText("");
		username.setText("");
		email.setText("");
		password.setText("");
		password.setVisible(true);
		showPassword.setVisible(false);
		show.setSelected(false);
		btnGrp().clearSelection();
		btnGrp1().clearSelection();

	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setForeground(Color.BLUE);
			btnCancel.setBounds(86, 255, 89, 27);
			btnCancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					message.setText("");
					clearform();
				}
			});
		}
		return btnCancel;
	}

	private JButton getBtnHelp() {
		if (btnHelp == null) {
			btnHelp = new JButton("Help?");
			btnHelp.setForeground(Color.BLUE);
			btnHelp.setBounds(22, 332, 89, 29);
			btnHelp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showMessage("Working on it, Just for you !!");

				}
			});
		}
		return btnHelp;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(402, 11, 156, 283);
			label.setIcon(new ImageIcon("C:\\java-ws\\StudManagProj\\resource\\images\\mankey.jpg"));
		}
		return label;
	}

	private JLabel getLblListOfThe() {
		if (lblListOfThe == null) {
			lblListOfThe = new JLabel("Data Of All The Registered Users");
			lblListOfThe.setBounds(132, 347, 200, 22);
		}
		return lblListOfThe;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 386, 543, 113);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "ID", "Full Name", "Username", "Password",
							"Email", "Gender", "User Type" }));
		}
		return table;
	}

	private void showAllUser() throws ClassNotFoundException, SQLException,
			ParseException {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Clear Table

		/** fetch all students record ***/
		UserDao userDao = new UserDao();
		List<User> userList = userDao.getAllUser();
		for (User user : userList) {
			// System.out.println(user);
			model.addRow(new Object[] { user.getId(), user.getFullName(),
					user.getUsername(), user.getPassword(), user.getEmail(),
					user.getGender(), user.getUserType() });
		}

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Copy Right  \u00A9 Gajurel Dinesh 2016");
			lblNewLabel.setBounds(185, 510, 215, 14);
		}
		return lblNewLabel;
	}

	private JLabel getLblStudentManagementSystemsms() {
		if (lblStudentManagementSystemsms == null) {
			lblStudentManagementSystemsms = new JLabel(
					"Student  Management System(SMS)");
			lblStudentManagementSystemsms.setBounds(185, 535, 215, 14);
		}
		return lblStudentManagementSystemsms;
	}
}
