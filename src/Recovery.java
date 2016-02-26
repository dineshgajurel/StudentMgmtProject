import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.User;
import dao.UserDao;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class Recovery extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblWelcomeToThe;
	private JLabel lblYouCanSee;
	private JLabel lblUsername;
	private JTextField username;
	private JLabel lblEmail;
	private JTextField email;
	private JButton ok;
	private JLabel label1;
	private JTextField password;
	private JLabel lblYourPasswodWill;
	private JLabel lblTheCobinationOf;
	private JButton btnBackToLogin;
	private JLabel label;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Recovery frame = new Recovery();
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
	public Recovery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.WEST);
		contentPane.add(getPanel_2(), BorderLayout.SOUTH);
		contentPane.add(getPanel_3(), BorderLayout.EAST);
		contentPane.add(getPanel_4(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.BLUE);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.BLUE);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.BLUE);
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.BLUE);
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.add(getLblWelcomeToThe());
			panel_4.add(getLblYouCanSee());
			panel_4.add(getLblUsername());
			panel_4.add(getUsername());
			panel_4.add(getLblEmail());
			panel_4.add(getEmail());
			panel_4.add(getOk());
			panel_4.add(getLabel1());
			panel_4.add(getPassword());
			panel_4.add(getLblYourPasswodWill());
			panel_4.add(getLblTheCobinationOf());
			panel_4.add(getBtnBackToLogin());
			panel_4.add(getLabel());
		}
		return panel_4;
	}
	private JLabel getLblWelcomeToThe() {
		if (lblWelcomeToThe == null) {
			lblWelcomeToThe = new JLabel("Welcome To the Password Recovery Section");
			lblWelcomeToThe.setForeground(Color.BLUE);
			lblWelcomeToThe.setBounds(64, 11, 304, 30);
		}
		return lblWelcomeToThe;
	}
	private JLabel getLblYouCanSee() {
		if (lblYouCanSee == null) {
			lblYouCanSee = new JLabel("You can See your password by providing valid username and Email");
			lblYouCanSee.setForeground(Color.BLUE);
			lblYouCanSee.setBounds(10, 46, 404, 24);
		}
		return lblYouCanSee;
	}
	
	
	private void showSearchedUser(String uname,String em) throws ClassNotFoundException, SQLException,
	ParseException {


UserDao userDao = new UserDao();
String pass = userDao.getSearchedUser(uname,em);
password.setText(pass);



}



	
	
	
	
	
	
	
	
	
	
	
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setBounds(20, 87, 96, 24);
		}
		return lblUsername;
	}
	private JTextField getUsername() {
		if (username == null) {
			username = new JTextField();
			username.setBounds(126, 81, 124, 30);
			username.setColumns(10);
		}
		return username;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setBounds(20, 122, 55, 30);
			
		}
		return lblEmail;
	}
	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setBounds(126, 122, 124, 30);
			email.setColumns(10);
		}
		return email;
	}
	private JButton getOk() {
		if (ok == null) {
			ok = new JButton("OK");
			ok.setBounds(255, 126, 55, 23);
			ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				String	uname=username.getText();
				String em=email.getText();
				try {
					showSearchedUser(uname, em);
					
					if(password.getText().equals("")){
						
						lblTheCobinationOf.setVisible(true);
						label1.setVisible(false);
						password.setVisible(false);
						
					}else{
						
						lblTheCobinationOf.setVisible(false);
						label1.setVisible(true);
						password.setVisible(true);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
		}
		return ok;
	}
	private JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("Your Password\r\n");
			label1.setForeground(Color.RED);
			label1.setBounds(20, 185, 96, 36);
			label1.setVisible(false);
		}
		return label1;
	}
	private JTextField getPassword() {
		if (password == null) {
			password = new JTextField();
			password.setBounds(125, 188, 125, 30);
			password.setColumns(10);
			password.setVisible(false);
		}
		return password;
	}
	private JLabel getLblYourPasswodWill() {
		if (lblYourPasswodWill == null) {
			lblYourPasswodWill = new JLabel("Your passwod will be displayed below(for the valid Username and Email)");
			lblYourPasswodWill.setForeground(Color.GRAY);
			lblYourPasswodWill.setBounds(10, 160, 415, 23);
			
		}
		return lblYourPasswodWill;
	}
	private JLabel getLblTheCobinationOf() {
		if (lblTheCobinationOf == null) {
			lblTheCobinationOf = new JLabel("The cobination of your Username and Email is not valid.");
			lblTheCobinationOf.setForeground(Color.RED);
			lblTheCobinationOf.setBounds(64, 181, 318, 36);
			lblTheCobinationOf.setVisible(false);
		}
		return lblTheCobinationOf;
	}
	private JButton getBtnBackToLogin() {
		if (btnBackToLogin == null) {
			btnBackToLogin = new JButton("Back to Login");
			btnBackToLogin.setBounds(130, 229, 120, 36);
			btnBackToLogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Recovery rec=(Recovery)WindowManager.ui.get("Recovery");
					rec.dispose();
					LoginScreen login=(LoginScreen)WindowManager.ui.get("LoginScreen");
					login.setVisible(true);
				}
			});
		}
		return btnBackToLogin;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\java-ws\\StudManagProj\\resource\\images\\images (2).jpg"));
			label.setBounds(424, 11, 163, 239);
		}
		return label;
	}
}
