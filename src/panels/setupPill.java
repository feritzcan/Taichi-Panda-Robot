package panels;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import db.ConnectionDerby;

public class setupPill extends JPanel {
	private JTextField cantaX;
	private JTextField cantaY;
	private JTextField pillX;
	private JTextField pillY;
	private JLabel label_1;
	private JTextField kullanX;
	private JTextField S;
	private JLabel lblKapat;
	private JTextField pkapatX;
	private JTextField pkapatY;
	private JTextField bkapatx;
	private JTextField bkapatY;
	private JLabel label_2;
	private JButton btnKaydet;
	private JButton btnIptal;

	/**
	 * Create the panel.
	 */
	public setupPill() {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		JLabel lblanta = new JLabel("Backpack:");
		lblanta.setBounds(62, 32, 90, 16);
		add(lblanta);
		
		cantaX = new JTextField();
		cantaX.setText("COORD X");
		cantaX.setBounds(164, 26, 73, 28);
		add(cantaX);
		cantaX.setColumns(10);
		
		cantaY = new JTextField();
		cantaY.setText("COORD Y");
		cantaY.setColumns(10);
		cantaY.setBounds(249, 26, 73, 28);
		add(cantaY);
		
		JLabel label = new JLabel("Pill:");
		label.setBounds(62, 98, 61, 16);
		add(label);
		
		pillX = new JTextField();
		pillX.setText("COORD X");
		pillX.setColumns(10);
		pillX.setBounds(135, 92, 73, 28);
		add(pillX);
		
		pillY = new JTextField();
		pillY.setText("COORD X");
		pillY.setColumns(10);
		pillY.setBounds(220, 92, 73, 28);
		add(pillY);
		
		label_1 = new JLabel("Use pill(1)");
		label_1.setBounds(190, 142, 103, 16);
		add(label_1);
		
		kullanX = new JTextField();
		kullanX.setText("COORD X");
		kullanX.setColumns(10);
		kullanX.setBounds(153, 170, 73, 28);
		add(kullanX);
		
		S = new JTextField();
		S.setText("COORD Y");
		S.setColumns(10);
		S.setBounds(239, 170, 73, 28);
		add(S);
		
		lblKapat = new JLabel("Close(2)");
		lblKapat.setBounds(371, 142, 103, 16);
		add(lblKapat);
		
		pkapatX = new JTextField();
		pkapatX.setText("COORD X");
		pkapatX.setColumns(10);
		pkapatX.setBounds(324, 170, 73, 28);
		add(pkapatX);
		
		pkapatY = new JTextField();
		pkapatY.setText("COORD Y");
		pkapatY.setColumns(10);
		pkapatY.setBounds(409, 170, 73, 28);
		add(pkapatY);
		
		bkapatx = new JTextField();
		bkapatx.setText("COORD X");
		bkapatx.setColumns(10);
		bkapatx.setBounds(153, 367, 73, 28);
		add(bkapatx);
		
		bkapatY = new JTextField();
		bkapatY.setText("COORD Y");
		bkapatY.setColumns(10);
		bkapatY.setBounds(248, 367, 73, 28);
		add(bkapatY);
		
		label_2 = new JLabel("Close backpack");
		label_2.setBounds(170, 313, 152, 16);
		add(label_2);
		
		btnKaydet = new JButton("SAVE");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cantaX.equals("")||cantaY.equals("")||pillX.equals("")||pillY.equals("")
						||kullanX.equals("")||S.equals("")||pkapatX.equals("")
						||pkapatY.equals("")||bkapatx.equals("")||bkapatY.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Hic bir alan bos birakilamaz.");
					return;
				}
				if(ConnectionDerby.exist("gameButtons","backpackOpen"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(cantaX.getText())+",buttonY="+Integer.parseInt(cantaY.getText())
							+"WHERE name='backpackOpen'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('backpackOpen',"+Integer.parseInt(cantaX.getText())+","+Integer.parseInt(cantaY.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","pill"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(pillX.getText())+",buttonY="+Integer.parseInt(pillY.getText())
							+"WHERE name='pilll'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('pill',"+Integer.parseInt(pillX.getText())+","+Integer.parseInt(pillY.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","pillUse"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(kullanX.getText())+",buttonY="+Integer.parseInt(S.getText())
							+"WHERE name='pillUse'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('pillUse',"+Integer.parseInt(kullanX.getText())+","+Integer.parseInt(S.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","pillClose"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(pkapatX.getText())+",buttonY="+Integer.parseInt(pkapatY.getText())
							+"WHERE name='pillClose'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('pillClose',"+Integer.parseInt(pkapatX.getText())+","+Integer.parseInt(pkapatY.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","backpackClose"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(bkapatx.getText())+",buttonY="+Integer.parseInt(bkapatY.getText())
							+"WHERE name='backpackClose'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('backpackClose',"+Integer.parseInt(bkapatx.getText())+","+Integer.parseInt(bkapatY.getText())+")");
				}
				
				ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='pillSettings'");
				
				mainFrame.redirect("setupPanel", "");
				



			}
		});
		btnKaydet.setBounds(377, 465, 117, 29);
		add(btnKaydet);
		
		btnIptal = new JButton("CANCEL");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("setupPanel", "");

			}
		});
		btnIptal.setBounds(248, 465, 117, 29);
		add(btnIptal);
		
	
		

	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
		g.drawImage(new ImageIcon("img/backpack.png").getImage(),0,26 , 40, 40, this);
		g.drawImage(new ImageIcon("img/pill.png").getImage(),0,80 , 40, 40, this);
		g.drawImage(new ImageIcon("img/kullan.png").getImage(),0,140 , 150, 120, this);
		g.drawImage(new ImageIcon("img/kapat.png").getImage(),0,300 , 100, 200, this);


	}
}
