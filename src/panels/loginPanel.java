package panels;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginPanel extends JPanel {
	private JTextField textField;
	private JPasswordField pw;

	/**
	 * Create the panel.
	 */
	public static Connection conn;
	public loginPanel() {

		
		setLayout(null);
		setBounds(0, 00, 500, 500);
		
		JLabel user = new JLabel("USERNAME");
		user.setBounds(6, 244, 116, 22);
		add(user);
		
		JLabel label = new JLabel("PASSWORD");
		label.setBounds(6, 288, 116, 22);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(105, 241, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		pw = new JPasswordField();
		pw.setColumns(10);
		pw.setBounds(105, 285, 134, 28);
		add(pw);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(login())
				{
					mainFrame.redirect("girisPaneli", "");
				}
				else
					System.out.println("not");
			}
		});
		btnLogin.setBounds(6, 335, 117, 29);
		add(btnLogin);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					JFrame frame = new JFrame ("Yeni Bolum");
				
	            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new register());
	            frame.pack();
	            frame.setSize(300,300);
	            frame.setVisible (true);
			}
		});
		btnRegister.setBounds(122, 335, 117, 29);
		add(btnRegister);
	}
	
	
	public boolean login()
	{
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

					
			        conn =DriverManager.getConnection("jdbc:mysql://eu-cdbr-azure-north-e.cloudapp.net/ferit", "b5244810ad4dd1","ebee6b05");
			        
			        Statement st=(Statement) loginPanel.conn.createStatement();
				
					ResultSet rs = st.executeQuery("SELECT count(*) FROM users WHERE username='"+textField.getText()+"' AND password='"+pw.getText()+"'");
					int count=0;
					if (rs.next())
						count=rs.getInt(1);
					if(count!=0)
					{
						conn.close();
						return true;
					}
					
					
					
				}
				
			    catch(SQLException e)
			    {
			        System.out.println("There is an error with the SQL database: " + e.getMessage());
			    }
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		 try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return false;
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg2.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
	}

}
