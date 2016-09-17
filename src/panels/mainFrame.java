package panels;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Driver;

import control.GamePlay;
import db.ConnectionDerby;


public class mainFrame extends JFrame {

	public  static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame("Taichi Robot by Ferit Özcan eu-s63 FNTC-VANDAN");
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
	public mainFrame(String s) {
		super(s);
		
	        
	        
	        
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 550);
		ConnectionDerby db=new ConnectionDerby();

		db.connectDB();
		db.createTables();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.add(new girisPaneli());
		contentPane.add(new Coordinates());
		setContentPane(contentPane);
		
		
	}
	
	public static void redirect(String panel,String name)
	{
		if(panel=="setupBegin")
		{
			contentPane.removeAll();
			contentPane.add(new setupBegin());
			contentPane.add(new Coordinates());
			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="selectSoul")
		{
			contentPane.removeAll();
			contentPane.add(new selectSoul());
			contentPane.add(new Coordinates());
			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="setupPill")
		{
			contentPane.removeAll();
			contentPane.add(new setupPill());
			contentPane.add(new Coordinates());

			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="setupPanel")
		{
			contentPane.removeAll();
			contentPane.add(new setupPanel());
			contentPane.add(new Coordinates());

			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="setupUpgrade")
		{
			contentPane.removeAll();
			contentPane.add(new setupUpgrade());
			contentPane.add(new Coordinates());

			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="setupPlay")
		{
			contentPane.removeAll();
			contentPane.add(new setupPlay());
			contentPane.add(new Coordinates());

			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="setupPlay2")
		{
			contentPane.removeAll();
			contentPane.add(new setupPlay2());
			contentPane.add(new Coordinates());

			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="setupLevels")
		{
			contentPane.removeAll();
			contentPane.add(new setupLevels(name));
			contentPane.add(new Coordinates());

			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="newRobot")
		{
			contentPane.removeAll();
			contentPane.add(new newRobot( name));
			contentPane.add(new Coordinates());

			contentPane.repaint();
			contentPane.revalidate();	
		}
		if(panel=="girisPaneli")
		{
			contentPane.removeAll();
			contentPane.add(new girisPaneli());
			contentPane.add(new Coordinates());

			contentPane.repaint();
			contentPane.revalidate();	
		}
	}

}
