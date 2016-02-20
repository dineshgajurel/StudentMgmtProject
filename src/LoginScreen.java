import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JCheckBox;

import dao.UserDao;
import model.User;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JPanel TopPanel;
	private JPanel LeftPanel;
	private JPanel BottomPanel;
	private JPanel RightPanel;
	private JPanel Centerpanel;
	private JPanel LoginPanel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	static JTextField username;
	JPasswordField password;
	private JLabel status;
	private JButton signin;
	private JButton cancel;

	/**
	 * Launch the application.
	 */
	static LoginScreen frame = new LoginScreen();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JCheckBox chckbxRememberMe;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblStudentManagementSystem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thread.sleep(10000);
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				
					WindowManager.ui.put("LoginScreen", frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		setTitle("Login @ Student Management System(SMS)");
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"C:\\Users\\DELL\\Desktop\\New folder (3)\\key-login-form-22847438.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTopPanel(), BorderLayout.NORTH);
		contentPane.add(getLeftPanel(), BorderLayout.WEST);
		contentPane.add(getBottomPanel(), BorderLayout.SOUTH);
		contentPane.add(getRightPanel(), BorderLayout.EAST);
		contentPane.add(getCenterpanel(), BorderLayout.CENTER);
	}

	private JPanel getTopPanel() {
		if (TopPanel == null) {
			TopPanel = new JPanel();
			TopPanel.setBackground(new Color(100, 149, 237));
			TopPanel.setForeground(Color.BLUE);
		}
		return TopPanel;
	}

	private JPanel getLeftPanel() {
		if (LeftPanel == null) {
			LeftPanel = new JPanel();
			LeftPanel.setBackground(new Color(100, 149, 237));
			LeftPanel.setForeground(Color.BLUE);
		}
		return LeftPanel;
	}

	private JPanel getBottomPanel() {
		if (BottomPanel == null) {
			BottomPanel = new JPanel();
			BottomPanel.setBackground(new Color(100, 149, 237));
			BottomPanel.setForeground(Color.BLUE);
		}
		return BottomPanel;
	}

	private JPanel getRightPanel() {
		if (RightPanel == null) {
			RightPanel = new JPanel();
			RightPanel.setBackground(new Color(100, 149, 237));
			RightPanel.setForeground(Color.BLUE);
		}
		return RightPanel;
	}

	private JPanel getCenterpanel() {
		if (Centerpanel == null) {
			Centerpanel = new JPanel();
			Centerpanel.setBackground(new Color(152, 251, 152));
			Centerpanel.setLayout(null);
			Centerpanel.add(getLoginPanel());
			Centerpanel.add(getStatus());
			Centerpanel.add(getSignin());
			Centerpanel.add(getCancel());
			Centerpanel.add(getLblNewLabel());
			Centerpanel.add(getLblNewLabel_2());
			Centerpanel.add(getLblNewLabel_3());
			Centerpanel.add(getLblStudentManagementSystem());
		}
		return Centerpanel;
	}

	private JPanel getLoginPanel() {
		if (LoginPanel == null) {
			LoginPanel = new JPanel();
			LoginPanel.setBorder(new TitledBorder(null, "Log In",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			LoginPanel.setBounds(20, 32, 375, 168);
			LoginPanel.setLayout(null);
			LoginPanel.add(getLblUsername(), "2, 2, fill, center");
			LoginPanel.add(getLblPassword(), "2, 4, fill, center");
			LoginPanel.add(getUsername(), "4, 2, fill, fill");
			LoginPanel.add(getPassword(), "4, 4, fill, fill");
			LoginPanel.add(getLblNewLabel_1());
			LoginPanel.add(getChckbxRememberMe());
		}
		return LoginPanel;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setBounds(16, 39, 66, 14);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(16, 82, 66, 14);
		}
		return lblPassword;
	}

	private JTextField getUsername() {
		if (username == null) {
			username = new JTextField();
			username.setBounds(86, 30, 151, 32);
			username.setColumns(10);
		}
		return username;
	}

	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setEchoChar('*');
			password.setBounds(86, 73, 151, 32);
		}
		return password;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setForeground(new Color(128, 128, 0));
			status.setBounds(30, 211, 387, 20);
		}
		return status;
	}

	private JButton getSignin() {
		if (signin == null) {
			signin = new JButton("Sign In");
			signin.setBounds(20, 237, 81, 23);
			signin.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (username.getText().equals("")
							&& password.getPassword().equals("")) {
						status.setText("username and password can't be blank.");
					} else {
						String pass = new String(password.getPassword());
						String usr = new String(username.getText());
						User user = new User();
						user.setUsername(usr);
						user.setPassword(pass);

						UserDao userDao = new UserDao();
						boolean valid;
						try {
							valid = userDao.validateUser(user);

							if (valid) {
								SwitchWindow();
								JOptionPane.showMessageDialog(null,
										"you have successfully entered to the system. Mr/mrs/miss "
												+ username.getText());
							} else if (username.getText().equals("")
									&& pass.equals("")) {
								status.setText("username and password can't be blank.");
							} else {
								status.setText(username.getText()
										+ "  is not valid username or password is wrong");
								password.setText("");

							}

						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}

			});
		}
		return signin;
	}

	private JButton getCancel() {
		if (cancel == null) {
			cancel = new JButton("");
			cancel.setIcon(new ImageIcon(
					"C:\\Users\\DELL\\Desktop\\New folder (3)\\images (6).jpg"));
			cancel.setBounds(345, 242, 32, 29);
			cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return cancel;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(
					"Student Management  System  >>>   Login Panel\r\n\r\n");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setForeground(new Color(112, 128, 144));
			lblNewLabel.setBounds(20, 11, 344, 19);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
			lblNewLabel_1.setForeground(new Color(64, 224, 208));
			lblNewLabel_1.setIcon(new ImageIcon(
					"C:\\Users\\DELL\\Desktop\\New folder (3)\\enter-key.png"));
			lblNewLabel_1.setBounds(238, 11, 134, 154);
		}
		return lblNewLabel_1;
	}

	private JCheckBox getChckbxRememberMe() {
		if (chckbxRememberMe == null) {
			chckbxRememberMe = new JCheckBox("Remember me");
			chckbxRememberMe.setBounds(50, 126, 113, 23);
		}
		return chckbxRememberMe;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Cancel");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(301, 242, 38, 19);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Copy Right  \u00A9 Gajurel Dinesh 2016");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
			lblNewLabel_3.setBounds(124, 251, 167, 20);
		}
		return lblNewLabel_3;
	}

	private JLabel getLblStudentManagementSystem() {
		if (lblStudentManagementSystem == null) {
			lblStudentManagementSystem = new JLabel(
					"Student  Management System(SMS)");
			lblStudentManagementSystem.setFont(new Font("Tahoma", Font.ITALIC,
					10));
			lblStudentManagementSystem.setBounds(124, 270, 167, 12);
		}
		return lblStudentManagementSystem;
	}

	private void SwitchWindow() {
		clearScreen();
		StudentScreen studScr = new StudentScreen();
		studScr.getActiveUser().setText(username.getText().toUpperCase());
		;
		studScr.setVisible(true);
		WindowManager.ui.put("StudentScreen", studScr);
		LoginScreen loginScr = (LoginScreen) WindowManager.ui
				.get("LoginScreen");
		loginScr.setVisible(false);
	}

	public void clearScreen() {
		password.setText("");
		status.setText("");
	}
}
