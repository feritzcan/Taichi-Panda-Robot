package panels;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;

import java.awt.Font;

import javax.swing.border.BevelBorder;

import db.ConnectionDerby;


public class setupBegin extends JPanel {

	/**
	 * Create the panel.
	 */
	public setupBegin() {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("girisPaneli","");
			}
		});
		btnHome.setBounds(6, 393, 117, 29);
		add(btnHome);
		
		JTextArea txtrBuradakiAyarlarBir = new JTextArea();
		txtrBuradakiAyarlarBir.setWrapStyleWord(true);
		txtrBuradakiAyarlarBir.setEditable(false);
		txtrBuradakiAyarlarBir.setForeground(Color.BLACK);
		txtrBuradakiAyarlarBir.setRows(10);
		txtrBuradakiAyarlarBir.setLineWrap(true);
		txtrBuradakiAyarlarBir.setText("         The settings in here is not requiring to enter on every login unless coordinates are changed.\n   Example: You must set again when pill slot is changed.\n\t\n\t\tSETTINGS INSTRUCTIONS\n\n\t1)  Because this robot is just a piece of artificial intelligance that controls mouse, you must enter coordinates of things.\n\n\t2) You will see Mouse X: and Mouse Y: displaying current mouse coordinates under the robot. Just enter those coordinates as robot guides you.");
		txtrBuradakiAyarlarBir.setBounds(17, 16, 400, 229);
		txtrBuradakiAyarlarBir.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtrBuradakiAyarlarBir.setBackground(new Color(0, 0, 0, 0));
		JScrollPane js=new JScrollPane(txtrBuradakiAyarlarBir);
		js.setBounds(17, 45, 447, 297);
		js.setOpaque(false);
		js.getViewport().setOpaque(false);
		js.setBorder(null);
		add(js);
		
		final JCheckBox chckbxTekrarGosterme = new JCheckBox("Dont show again");
		chckbxTekrarGosterme.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		chckbxTekrarGosterme.setBounds(314, 445, 150, 23);
		add(chckbxTekrarGosterme);
		JButton START = new JButton("START");
		START.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("setupPanel","");
				
				if(chckbxTekrarGosterme.isSelected())
				{
					ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='ayarGosterme'");

					
				}
			}
		});
		START.setBounds(314, 393, 117, 29);
		add(START);
		
		

	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
	}
}
