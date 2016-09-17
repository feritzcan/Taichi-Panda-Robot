package panels;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;

import javax.swing.ImageIcon;
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

public class newRobot extends JPanel {
	private JTextField coordX;
	private JTextField coordY;
	Robot r;

	/**
	 * Create the panel.
	 */
	public newRobot(final String robot) {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		try {
			r=new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("girisPaneli",robot);
			}
		});
		btnHome.setBounds(6, 436, 117, 29);
		add(btnHome);
		JTextArea txtrBuradakiAyarlarBir = new JTextArea();
		txtrBuradakiAyarlarBir.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		txtrBuradakiAyarlarBir.setWrapStyleWord(true);
		txtrBuradakiAyarlarBir.setForeground(Color.BLACK);
		txtrBuradakiAyarlarBir.setRows(10);
		txtrBuradakiAyarlarBir.setLineWrap(true);
		txtrBuradakiAyarlarBir.setText("1)Finish any map that drops your target soul or pill.\n\n2) Try again until the item drops.\n\n3)When item drops, move your mouse like in the example to white point.\n\n4)Write mouse coordinates in to the boxes.\n\n5) In the next step, you will add maps.\n\n");
		txtrBuradakiAyarlarBir.setEditable(false);
		txtrBuradakiAyarlarBir.setBounds(17, 16, 200, 229);
		txtrBuradakiAyarlarBir.setBorder(null);
		txtrBuradakiAyarlarBir.setBackground(new Color(0, 0, 0, 0));
		JScrollPane js=new JScrollPane(txtrBuradakiAyarlarBir);
		js.setBounds(6, 49, 253, 331);
		js.setOpaque(false);
		js.getViewport().setOpaque(false);
		js.setBorder(null);
		add(js);
		
		JButton DEVAM = new JButton("DEVAM");
		DEVAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ConnectionDerby.exist("pets",robot))
				{
					int[] cols=new int[10];
					for(int a=0;a<10;a++)
						cols[a]=(r.getPixelColor(Integer.parseInt(coordX.getText())+a, Integer.parseInt(coordY.getText())).getRGB());
					ConnectionDerby.executeUpdate("UPDATE  pets SET DROPX="+Integer.parseInt(coordX.getText())+",DROPY="+Integer.parseInt(coordY.getText())
							+",COL1="+cols[0]+",COL2="+cols[1]+",COL3="+cols[2]+",COL4="+cols[3]+",COL5="+cols[4]+
							",COL6="+cols[5]+",COL7="+cols[6]+",COL8="+cols[7]+",COL9="+cols[8]+",COL10="+cols[9]+"WHERE name='"+robot+"'");
					
				}
				else
				{
					int[] cols=new int[10];
					for(int a=0;a<10;a++)
						cols[a]=(r.getPixelColor(Integer.parseInt(coordX.getText())+a, Integer.parseInt(coordY.getText())).getRGB());
					ConnectionDerby.executeUpdate("INSERT INTO pets VALUES('"+robot+"',"+Integer.parseInt(coordX.getText())+","+Integer.parseInt(coordY.getText())
							+","+cols[0]+","+cols[1]+","+cols[2]+","+cols[3]+","+cols[4]+","+cols[5]+","+cols[6]+","+cols[7]+","+
							cols[8]+","+cols[9]+")");
				}
				
				
					mainFrame.redirect("setupLevels",robot);

			}
		});
		DEVAM.setBounds(383, 436, 117, 29);
		add(DEVAM);
		
		JLabel lblTalimatlar = new JLabel("Talimatlar");
		lblTalimatlar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTalimatlar.setForeground(Color.RED);
		lblTalimatlar.setBounds(38, 21, 184, 16);
		add(lblTalimatlar);
		
		coordX = new JTextField();
		coordX.setText("COORDX");
		coordX.setBounds(214, 392, 134, 28);
		add(coordX);
		coordX.setColumns(10);
		
		coordY = new JTextField();
		coordY.setText("COORDX");
		coordY.setColumns(10);
		coordY.setBounds(366, 392, 134, 28);
		add(coordY);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
		g.drawImage(new ImageIcon("img/soul.png").getImage(), 300, 30,250,250,null);
	}
}
