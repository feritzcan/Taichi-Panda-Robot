package panels;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;

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

public class setupUpgrade extends JPanel {
	private JTextField cantaX;
	private JTextField cantaY;
	private JTextField itemX;
	private JTextField itemY;
	private JLabel label_1;
	private JTextField upgradeX;
	private JTextField upgradeY;
	private JTextField addX;
	private JTextField addY;
	private JLabel label_2;
	private JButton btnKaydet;
	private JButton btnIptal;
	private JTextField boxX;
	private JTextField boxY;
	private JLabel lblGelistir;
	private JTextField fortifyX;
	private JTextField fortifyY;
	private JTextField quickX;
	private JTextField quickY;
	private JLabel label_5;
	private JTextField qfConfirm;
	private JTextField qfConfirmY;

	/**
	 * Create the panel.
	 */
	public setupUpgrade() {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		JLabel lblanta = new JLabel("Çanta:");
		lblanta.setBounds(62, 32, 61, 16);
		add(lblanta);
		
		cantaX = new JTextField();
		cantaX.setText("COORD X");
		cantaX.setBounds(117, 26, 73, 28);
		add(cantaX);
		cantaX.setColumns(10);
		
		cantaY = new JTextField();
		cantaY.setText("COORD Y");
		cantaY.setColumns(10);
		cantaY.setBounds(202, 26, 73, 28);
		add(cantaY);
		
		JLabel label = new JLabel("Item:");
		label.setBounds(62, 98, 61, 16);
		add(label);
		
		itemX = new JTextField();
		itemX.setText("COORD X");
		itemX.setColumns(10);
		itemX.setBounds(117, 92, 73, 28);
		add(itemX);
		
		itemY = new JTextField();
		itemY.setText("COORD X");
		itemY.setColumns(10);
		itemY.setBounds(202, 92, 73, 28);
		add(itemY);
		
		label_1 = new JLabel("Upgrade Secenegi");
		label_1.setBounds(190, 142, 175, 16);
		add(label_1);
		
		upgradeX = new JTextField();
		upgradeX.setText("COORD X");
		upgradeX.setColumns(10);
		upgradeX.setBounds(153, 170, 73, 28);
		add(upgradeX);
		
		upgradeY = new JTextField();
		upgradeY.setText("COORD Y");
		upgradeY.setColumns(10);
		upgradeY.setBounds(239, 170, 73, 28);
		add(upgradeY);
		
		addX = new JTextField();
		addX.setText("COORD X");
		addX.setColumns(10);
		addX.setBounds(153, 229, 73, 28);
		add(addX);
		
		addY = new JTextField();
		addY.setText("COORD Y");
		addY.setColumns(10);
		addY.setBounds(242, 229, 73, 28);
		add(addY);
		
		label_2 = new JLabel("Otomatik Ekleme");
		label_2.setBounds(163, 201, 152, 16);
		add(label_2);
		
		btnKaydet = new JButton("KAYDET");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cantaX.equals("")||cantaY.equals("")||itemX.equals("")||itemY.equals("")
						||upgradeX.equals("")||upgradeY.equals(""))
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
				if(ConnectionDerby.exist("gameButtons","upItem"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(itemX.getText())+",buttonY="+Integer.parseInt(itemY.getText())
							+"WHERE name='upItem'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('upItem',"+Integer.parseInt(itemX.getText())+","+Integer.parseInt(itemY.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","upgrade"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(upgradeX.getText())+",buttonY="+Integer.parseInt(upgradeY.getText())
							+"WHERE name='upgrade'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('upgrade',"+Integer.parseInt(upgradeX.getText())+","+Integer.parseInt(upgradeY.getText())+")");
				}
				
				if(ConnectionDerby.exist("gameButtons","upAdd"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(addX.getText())+",buttonY="+Integer.parseInt(addY.getText())
							+"WHERE name='upAdd'");
				}
				else 
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('upAdd',"+Integer.parseInt(addX.getText())+","+Integer.parseInt(addY.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","upBox"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(boxX.getText())+",buttonY="+Integer.parseInt(boxY.getText())
							+"WHERE name='upBox'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('upBox',"+Integer.parseInt(boxX.getText())+","+Integer.parseInt(boxY.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","fortify"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(fortifyX.getText())+",buttonY="+Integer.parseInt(fortifyY.getText())
							+"WHERE name='fortify'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('fortify',"+Integer.parseInt(fortifyX.getText())+","+Integer.parseInt(fortifyY.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","qfortify"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(quickX.getText())+",buttonY="+Integer.parseInt(quickY.getText())
							+"WHERE name='qfortify'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('qfortify',"+Integer.parseInt(quickX.getText())+","+Integer.parseInt(quickY.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","qfConfirm"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(qfConfirm.getText())+",buttonY="+Integer.parseInt(qfConfirmY.getText())
							+"WHERE name='qfConfirm'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('qfConfirm',"+Integer.parseInt(qfConfirm.getText())+","+Integer.parseInt(qfConfirmY.getText())+")");
				}
				
				if(ConnectionDerby.exist("pets","admin_box"))
				{
					Robot r=null;
					try {
						r = new Robot();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int[] cols=new int[10];
					for(int a=0;a<10;a++)
						cols[a]=(r.getPixelColor(Integer.parseInt(boxX.getText())+a, Integer.parseInt(boxY.getText())).getRGB());
					ConnectionDerby.executeUpdate("UPDATE  pets SET DROPX="+Integer.parseInt(boxX.getText())+",DROPY="+Integer.parseInt(boxY.getText())
							+",COL1="+cols[0]+",COL2="+cols[1]+",COL3="+cols[2]+",COL4="+cols[3]+",COL5="+cols[4]+
							",COL6="+cols[5]+",COL7="+cols[6]+",COL8="+cols[7]+",COL9="+cols[8]+",COL10="+cols[9]+"WHERE name='admin_box'");
					
				}
				else
				{
					Robot r=null;
					try {
						r = new Robot();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int[] cols=new int[10];
					for(int a=0;a<10;a++)
						cols[a]=(r.getPixelColor(Integer.parseInt(boxX.getText())+a, Integer.parseInt(boxY.getText())).getRGB());
					
					
					ConnectionDerby.executeUpdate("INSERT INTO  pets  values('admin_box',"+Integer.parseInt(boxX.getText())+","+Integer.parseInt(boxY.getText())+",null,null"
							+","+cols[0]+","+cols[1]+","+cols[2]+","+cols[3]+","+cols[4]+
							","+cols[5]+","+cols[6]+","+cols[7]+","+cols[8]+","+cols[9]+")");
				}
				
				ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='upgradeSettings'");
				
				mainFrame.redirect("setupPanel", "");
				



			}
		});
		btnKaydet.setBounds(377, 465, 117, 29);
		add(btnKaydet);
		
		btnIptal = new JButton("IPTAL");
		btnIptal.setBounds(248, 465, 117, 29);
		add(btnIptal);
		
		JLabel label_3 = new JLabel("En soldaki item kutusu.");
		label_3.setBounds(153, 287, 331, 16);
		add(label_3);
		
		JLabel lblTamamDendigindeKutu = new JLabel("Tamam dendiginde kutu ekranda gorunur olsun!!");
		lblTamamDendigindeKutu.setBounds(153, 303, 322, 16);
		add(lblTamamDendigindeKutu);
		
		boxX = new JTextField();
		boxX.setText("COORD X");
		boxX.setColumns(10);
		boxX.setBounds(153, 331, 73, 28);
		add(boxX);
		
		boxY = new JTextField();
		boxY.setText("COORD Y");
		boxY.setColumns(10);
		boxY.setBounds(239, 331, 73, 28);
		add(boxY);
		
		lblGelistir = new JLabel("GELISTIR");
		lblGelistir.setBounds(190, 371, 175, 28);
		add(lblGelistir);
		
		fortifyX = new JTextField();
		fortifyX.setText("COORD X");
		fortifyX.setColumns(10);
		fortifyX.setBounds(153, 411, 73, 28);
		add(fortifyX);
		
		fortifyY = new JTextField();
		fortifyY.setText("COORD Y");
		fortifyY.setColumns(10);
		fortifyY.setBounds(239, 411, 73, 28);
		add(fortifyY);
		
		JLabel label_4 = new JLabel("QUICK FORTIFY");
		label_4.setForeground(Color.RED);
		label_4.setBounds(345, 32, 111, 16);
		add(label_4);
		
		quickX = new JTextField();
		quickX.setText("COORD X");
		quickX.setColumns(10);
		quickX.setBounds(315, 60, 73, 28);
		add(quickX);
		
		quickY = new JTextField();
		quickY.setText("COORD Y");
		quickY.setColumns(10);
		quickY.setBounds(400, 60, 73, 28);
		add(quickY);
		
		label_5 = new JLabel("QUICK FORTIFY CONFIRM");
		label_5.setForeground(Color.RED);
		label_5.setBounds(302, 98, 173, 16);
		add(label_5);
		
		qfConfirm = new JTextField();
		qfConfirm.setText("COORD X");
		qfConfirm.setColumns(10);
		qfConfirm.setBounds(329, 126, 73, 28);
		add(qfConfirm);
		
		qfConfirmY = new JTextField();
		qfConfirmY.setText("COORD Y");
		qfConfirmY.setColumns(10);
		qfConfirmY.setBounds(421, 126, 73, 28);
		add(qfConfirmY);
		
	
		

	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
		g.drawImage(new ImageIcon("img/backpack.png").getImage(),0,26 , 40, 40, this);
		g.drawImage(new ImageIcon("img/item.png").getImage(),0,80 , 40, 40, this);
		g.drawImage(new ImageIcon("img/upgrade.png").getImage(),0,140 , 80, 60, this);
		g.drawImage(new ImageIcon("img/add.png").getImage(),0,220 , 80, 60, this);
		g.drawImage(new ImageIcon("img/uplus.png").getImage(),0,290 , 40, 40, this);
		g.drawImage(new ImageIcon("img/fortify.png").getImage(),0,380 , 80, 60, this);



	}
}
