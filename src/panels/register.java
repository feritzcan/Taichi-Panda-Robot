package panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.SQLException;

public class register extends JPanel {
	private JTextField USER;
	private JTextField pw;

	/**
	 * Create the panel.
	 */
	public register() {

		setBounds(0, 0, 300, 300);
		setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(6, 47, 91, 16);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(6, 109, 91, 24);
		add(lblPassword);
		
		USER = new JTextField();
		USER.setBounds(96, 41, 134, 28);
		add(USER);
		USER.setColumns(10);
		
		pw = new JTextField();
		pw.setBounds(96, 107, 134, 28);
		add(pw);
		pw.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

						Connection conn=null;
						while(conn==null)
			       conn =(Connection) DriverManager.getConnection("jdbc:mysql://eu-cdbr-azure-north-e.cloudapp.net/ferit", "b5244810ad4dd1","ebee6b05");
			        
			        Statement st=(Statement) conn.createStatement();
									st.executeUpdate("INSERT INTO users VALUES('"+USER.getText()+"','"+pw.getText()+"')");
					
									conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRegister.setBounds(143, 182, 117, 29);
		add(btnRegister);
	}

}
