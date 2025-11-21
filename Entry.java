package student;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entry {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Entry window = new Entry();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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

        // Student Button
        JButton studentBttn = new JButton("I am a student");
        studentBttn.addActionListener(e -> {
        	
        	
            LogIn_Frame login = new LogIn_Frame();
            login.setVisible(true);
            frame.dispose(); 
            
            
        });
        studentBttn.setBackground(new Color(51, 153, 153));
        studentBttn.setFont(new Font("Arial", Font.PLAIN, 14));
        studentBttn.setBounds(77, 117, 287, 54);
        frame.getContentPane().add(studentBttn);

        // Business Owner Button
        JButton btnBusiness = new JButton("I am a business owner");
        btnBusiness.addActionListener(e -> {
        	
        	
            BusinessLogIn bLogIn = new BusinessLogIn();
            bLogIn.setVisible(true);
            frame.dispose(); 
            
            
        });
        btnBusiness.setBackground(new Color(51, 153, 153));
        btnBusiness.setFont(new Font("Arial", Font.PLAIN, 14));
        btnBusiness.setBounds(77, 183, 287, 54);
        frame.getContentPane().add(btnBusiness);

        // Labels
        JLabel lblTitle = new JLabel("Select your Role");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(170, 88, 150, 30);
        frame.getContentPane().add(lblTitle);

        JLabel websiteName = new JLabel("PRESYONG KAPIYU");
        websiteName.setHorizontalAlignment(SwingConstants.CENTER);
        websiteName.setForeground(new Color(51, 51, 153));
        websiteName.setFont(new Font("Apple SD Gothic Neo", Font.BOLD | Font.ITALIC, 28));
        websiteName.setBounds(90, 6, 264, 46);
        frame.getContentPane().add(websiteName);

        JLabel lblFindTheBest = new JLabel("find the best deals");
        lblFindTheBest.setFont(new Font("Chalkboard SE", Font.ITALIC, 13));
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
