package student;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DBConnection;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class LogIn_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn_Frame frame = new LogIn_Frame();
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
	public LogIn_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	 
		
	// START NG CONTENTS NG JFRAME
		txtUser = new JTextField();
		txtUser.setBounds(158, 105, 212, 31);
		txtUser.setToolTipText("");
		txtUser.setForeground(new Color(0, 0, 0));
		txtUser.setFont(new Font("Helvetica", Font.PLAIN, 13));
		contentPane.add(txtUser);
		txtUser.setColumns(15);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 140, 212, 31);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(98, 112, 32, 16);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(83, 148, 63, 16);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		contentPane.add(lblPassword);
		
		JLabel WebsiteName = new JLabel("PRESYONG KAPIYU");
		WebsiteName.setBounds(88, 30, 264, 46);
		WebsiteName.setForeground(new Color(51, 51, 153));
		WebsiteName.setHorizontalAlignment(SwingConstants.CENTER);
		WebsiteName.setFont(new Font("Apple SD Gothic Neo", Font.BOLD | Font.ITALIC, 28));
		contentPane.add(WebsiteName);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(205, 183, 117, 29);
		
	// LOGIN BUTTON
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				        String user = txtUser.getText().trim();
				        String pass = String.valueOf(passwordField.getPassword()).trim();

				        // Empty field check
				        if (user.isEmpty() || pass.isEmpty()) {
				            JOptionPane.showMessageDialog(null,
				                "Please enter both username and password.",
				                "Missing Input",
				                JOptionPane.WARNING_MESSAGE
				            );
				            return;
				        }

				        // Call function from Queries.java
				        boolean isLoggedIn = Queries.loginUser(user, pass);

				        if (isLoggedIn) {
				            JOptionPane.showMessageDialog(null, "Login successful!");

				            // Go to Main Frame  
				            new Main_Frame().setVisible(true);
				            dispose();

				        } else {
				            JOptionPane.showMessageDialog(null,
				                "Invalid username or password.",
				                "Login Failed",
				                JOptionPane.ERROR_MESSAGE
				            );
				        }
				    }
				});


		btnNewButton.setFont(new Font("Arial", btnNewButton.getFont().getStyle(), btnNewButton.getFont().getSize()));
		contentPane.add(btnNewButton);
		
		JLabel lblFindTheBest = new JLabel("find the best deals");
		lblFindTheBest.setBounds(134, 69, 177, 16);
		lblFindTheBest.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindTheBest.setForeground(new Color(0, 0, 0));
		lblFindTheBest.setFont(new Font("Chalkboard SE", lblFindTheBest.getFont().getStyle() | Font.ITALIC, 13));
		contentPane.add(lblFindTheBest);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account yet?");
		lblNewLabel_1.setFont(new Font("Arial", lblNewLabel_1.getFont().getStyle(), 11));
		lblNewLabel_1.setBounds(97, 216, 141, 16);
		contentPane.add(lblNewLabel_1);
		
		
	// SIGNUP BUTTON
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp();
				signup.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(51, 51, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.setBounds(250, 217, 72, 16);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("≡");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entry enter = new Entry();
				enter.setVisible(true);
				LogIn_Frame.this.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 24));
		btnNewButton_2.setBounds(6, 6, 46, 31);
		contentPane.add(btnNewButton_2);

	}
	}
