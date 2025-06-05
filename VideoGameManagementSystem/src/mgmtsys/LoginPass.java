package mgmtsys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPass extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPass frame = new LoginPass();
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
	public LoginPass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(52, 69, 58, 14);
		contentPane.add(lblNewLabel);
		
		uname = new JTextField();
		uname.setBounds(120, 66, 86, 20);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(52, 98, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName=uname.getText();
				String password=pass.getText();
				if(userName.equals("rishi06") && password.equals("rishi"))
				{
					JOptionPane.showMessageDialog(null, "Login successfull!"); 
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter correct credentials!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(101, 137, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Connect to GameCentralDB");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(39, 11, 201, 31);
		contentPane.add(lblNewLabel_2);
		
		pass = new JPasswordField();
		pass.setBounds(120, 97, 86, 20);
		contentPane.add(pass);
	}
}
