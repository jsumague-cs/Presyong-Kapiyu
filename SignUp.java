package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.border.MatteBorder;

import database.DBConnection;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	
	Connection con = DBConnection.getConnection();

	
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel WebsiteName = new JLabel("PRESYONG KAPIYU");
		WebsiteName.setBounds(84, 26, 241, 24);
		WebsiteName.setHorizontalAlignment(SwingConstants.CENTER);
		WebsiteName.setForeground(new Color(51, 51, 153));
		WebsiteName.setFont(new Font("Apple SD Gothic Neo", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(WebsiteName);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(62, 110, 75, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Create a new account to start your budget meal hunt!");
		lblNewLabel_1.setFont(new Font("Arial", lblNewLabel_1.getFont().getStyle(), 11));
		lblNewLabel_1.setBounds(77, 51, 264, 24);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Helvetica", Font.PLAIN, 13));
		textField.setColumns(15);
		textField.setBounds(140, 104, 232, 31);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 147, 232, 31);
		contentPane.add(passwordField);
		
		JLabel lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setBounds(32, 154, 115, 16);
		contentPane.add(lblCreatePassword);
		
		JButton btnNewButton = new JButton("Create new account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {


				    	        String user = textField.getText();
				    	        String pass = String.valueOf(passwordField.getPassword());

				    	        if (user.isEmpty() || pass.isEmpty()) {
				    	            JOptionPane.showMessageDialog(null, "Please fill all fields.");
				    	            return;
				    	        }

				    	        boolean created = Queries.signUp(user, pass);

				    	        if (created) {
				    	            JOptionPane.showMessageDialog(null, "Account created! You can now log in.");
				    	            
				    	            LogIn_Frame log = new LogIn_Frame();
				    	            log.setVisible(true);
				    	            dispose();
				    	        } else {
				    	            JOptionPane.showMessageDialog(null, "Username already exists!");
				    	        }
				    	    }
				    	});

			}
		});
		btnNewButton.setFont(new Font("Arial", btnNewButton.getFont().getStyle(), btnNewButton.getFont().getSize()));
		btnNewButton.setBounds(114, 190, 185, 29);
		contentPane.add(btnNewButton);

	}
}
