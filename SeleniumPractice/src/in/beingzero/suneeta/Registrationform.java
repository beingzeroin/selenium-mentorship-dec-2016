package in.beingzero.suneeta;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrationform {

	private JFrame frame;
	JLabel lblNewLabel;
	JLabel lblResult ;
	private JTextField txtUsername;
	private JLabel lblNewLabel_1;
	private JPasswordField pfPassword;
	private JPasswordField psConfirmpassword;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrationform window = new Registrationform();
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
	public Registrationform() {
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
		
		txtUsername = new JTextField();
		txtUsername.setBounds(106, 24, 239, 22);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
	    lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(20, 27, 74, 16);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(24, 73, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(106, 70, 239, 22);
		frame.getContentPane().add(pfPassword);
		
		psConfirmpassword = new JPasswordField();
		psConfirmpassword.setBounds(106, 116, 239, 22);
		frame.getContentPane().add(psConfirmpassword);
		
		lblNewLabel_2 = new JLabel("Confirm");
		lblNewLabel_2.setBounds(24, 119, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pwd = pfPassword.getText();
				String repwd = psConfirmpassword.getText();
				
				if(pwd.equals(repwd))
				{
					lblResult.setText("ACCEPTED ");
				}
				else
					
				{
					lblResult.setText("MISMATCH DETECTED ");
				}
			}
		});
		btnNewButton.setBounds(106, 167, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		lblResult = new JLabel("Result");
		lblResult.setBounds(116, 224, 229, 16);
		frame.getContentPane().add(lblResult);
	}
}
