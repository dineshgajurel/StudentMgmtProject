package main;
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

import main.StudentScreen;
import java.awt.Font;
import javax.swing.JCheckBox;

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
	public static JTextField username;
	private JPasswordField password;
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Desktop\\Student-Management-System-project.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 328);
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
		}
		return Centerpanel;
	}
	private JPanel getLoginPanel() {
		if (LoginPanel == null) {
			LoginPanel = new JPanel();
			LoginPanel.setBorder(new TitledBorder(null, "Log In", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			LoginPanel.setBounds(20, 34, 411, 150);
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
			lblUsername.setBounds(16, 39, 60, 14);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(16, 82, 60, 14);
		}
		return lblPassword;
	}
	private JTextField getUsername() {
		if (username == null) {
			username = new JTextField();
			username.setBounds(103, 30, 134, 32);
			username.setColumns(10);
		}
		return username;
	}
	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setEchoChar('*');
			password.setBounds(103, 73, 134, 32);
		}
		return password;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("Status:");
			status.setBounds(137, 195, 154, 23);
		}
		return status;
	}
	private JButton getSignin() {
		if (signin == null) {
			signin = new JButton("Sign In");
			signin.setBounds(30, 217, 89, 23);
			signin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
StudentScreen stdscr=new StudentScreen();
stdscr.setVisible(true);
frame.setVisible(false);
JOptionPane.showMessageDialog(null, "you have successfully entered to the system. Mr/mrs/miss "+username.getText());


				}
			});
		}
		return signin;
	}
	private JButton getCancel() {
		if (cancel == null) {
			cancel = new JButton("Cancel");
			cancel.setBounds(339, 217, 82, 23);
		}
		return cancel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Student Management  System  >>>   Login Panel\r\n\r\n");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setForeground(new Color(112, 128, 144));
			lblNewLabel.setBounds(20, 11, 299, 23);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBackground(new Color(0, 206, 209));
			lblNewLabel_1.setForeground(new Color(64, 224, 208));
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\login_key.jpg"));
			lblNewLabel_1.setBounds(238, 11, 163, 128);
		}
		return lblNewLabel_1;
	}
	private JCheckBox getChckbxRememberMe() {
		if (chckbxRememberMe == null) {
			chckbxRememberMe = new JCheckBox("Remember me");
			chckbxRememberMe.setBounds(18, 116, 113, 23);
		}
		return chckbxRememberMe;
	}
}
