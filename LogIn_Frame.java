package student;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Frame MF = new Main_Frame();
				MF.setVisible(true);
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

	}
}
