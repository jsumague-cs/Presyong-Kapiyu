package student;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entry {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entry window = new Entry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Entry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton studentBttn = new JButton("I am a student");
		studentBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn_Frame login = new LogIn_Frame();
				login.setVisible(true);
			
			}
		});
		studentBttn.setBackground(new Color(51, 153, 153));
		studentBttn.setFont(new Font("Arial", studentBttn.getFont().getStyle(), studentBttn.getFont().getSize()));
		studentBttn.setBounds(77, 117, 287, 54);
		frame.getContentPane().add(studentBttn);
		
		JButton btnIAmA = new JButton("I am a bussiness owner");
		btnIAmA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BusinessLogIn bLogIn = new BusinessLogIn();
				bLogIn.setVisible(true);

			}
		});
		btnIAmA.setBackground(new Color(51, 153, 153));
		btnIAmA.setBounds(77, 183, 287, 54);
		frame.getContentPane().add(btnIAmA);
		
		JLabel lblNewLabel = new JLabel("Select your Role");
		lblNewLabel.setFont(new Font("Arial", lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize()));
		lblNewLabel.setBounds(170, 88, 108, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel WebsiteName = new JLabel("PRESYONG KAPIYU");
		WebsiteName.setHorizontalAlignment(SwingConstants.CENTER);
		WebsiteName.setForeground(new Color(51, 51, 153));
		WebsiteName.setFont(new Font("Apple SD Gothic Neo", Font.BOLD | Font.ITALIC, 28));
		WebsiteName.setBounds(90, 6, 264, 46);
		frame.getContentPane().add(WebsiteName);
		
		JLabel lblFindTheBest = new JLabel("find the best deals");
		lblFindTheBest.setFont(new Font("Chalkboard SE", lblFindTheBest.getFont().getStyle() | Font.ITALIC, 13));
		lblFindTheBest.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindTheBest.setForeground(Color.BLACK);
		lblFindTheBest.setBounds(134, 43, 177, 16);
		frame.getContentPane().add(lblFindTheBest);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 102));
		separator.setBounds(6, 64, 438, 12);
		frame.getContentPane().add(separator);
	}
}
