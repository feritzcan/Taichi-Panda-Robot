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

import java.awt.Component;

import javax.swing.Box;

import db.ConnectionDerby;

import java.awt.Dimension;
import java.util.HashMap;

public class selectSoul extends JPanel {
	private JTextField petsX;
	private JTextField petsY;
	private JTextField petX;
	private JTextField petY;
	private JLabel label;
	private JTextField plusX;
	private JTextField plusY;
	private JButton DEVAM;
	private JLabel lblRobotununAdi;
	private JTextField robotAdi;

	/**
	 * Create the panel.
	 */
	public selectSoul() {
		
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("girisPaneli",robotAdi.getText());
			}
		});
		btnHome.setBounds(6, 436, 117, 29);
		add(btnHome);
		
		JLabel lblPetButonununKoordinatlari = new JLabel("Coordinates of pet buton.");
		lblPetButonununKoordinatlari.setBounds(286, 6, 208, 42);
		add(lblPetButonununKoordinatlari);
		
		petsX = new JTextField();
		petsX.setText("COORDX");
		petsX.setBounds(239, 70, 91, 28);
		add(petsX);
		petsX.setColumns(10);
		
		petsY = new JTextField();
		petsY.setText("COORDX");
		petsY.setColumns(10);
		petsY.setBounds(380, 70, 91, 28);
		add(petsY);
		
		JLabel lblPetResmininOrtasi = new JLabel("Target pet,pill");
		lblPetResmininOrtasi.setBounds(286, 166, 186, 29);
		add(lblPetResmininOrtasi);
		
		petX = new JTextField();
		petX.setText("COORDX");
		petX.setColumns(10);
		petX.setBounds(239, 207, 91, 28);
		add(petX);
		
		petY = new JTextField();
		petY.setText("COORDX");
		petY.setColumns(10);
		petY.setBounds(380, 207, 91, 28);
		add(petY);
		
		label = new JLabel("+ button (soul or pill)");
		label.setBounds(264, 275, 208, 29);
		add(label);
		
		plusX = new JTextField();
		plusX.setText("COORDX");
		plusX.setColumns(10);
		plusX.setBounds(239, 316, 91, 28);
		add(plusX);
		
		plusY = new JTextField();
		plusY.setText("COORDX");
		plusY.setColumns(10);
		plusY.setBounds(380, 316, 91, 28);
		add(plusY);
		
		DEVAM = new JButton("DONE!");
		DEVAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(plusX.equals("")||plusY.equals("")||petX.equals("")||petY.equals("")
						||petsX.equals("")||petsY.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Hic bir alan bos birakilamaz.");
					return;
				}
				if(ConnectionDerby.exist("robots", robotAdi.getText())==false)
				ConnectionDerby.executeUpdate("INSERT INTO robots VALUES('"+robotAdi.getText()+"')");
				else
				{
					JOptionPane.showMessageDialog(null, "This robot name exist..");
					return;
				}
				if(ConnectionDerby.exist("gameButtons","pets"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(petsX.getText())+",buttonY="+Integer.parseInt(petsY.getText())
							+"WHERE name='pets'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('pets',"+Integer.parseInt(petsX.getText())+","+Integer.parseInt(petsY.getText())+")");
				}
			
				if(ConnectionDerby.exist("pets",robotAdi.getText()))
				{
					System.out.println("degiss");

					ConnectionDerby.executeUpdate("UPDATE  pets SET petX="+Integer.parseInt(petX.getText())+",petY="+Integer.parseInt(petsY.getText())
							+"WHERE name='"+robotAdi.getText()+"'");
				}
				else
				{
					System.out.println("eklee");
					ConnectionDerby.executeUpdate("INSERT INTO pets VALUES('"+robotAdi.getText()+"',"+Integer.parseInt(petX.getText())+","+Integer.parseInt(petY.getText())
							+",null,null,null,null,null,null,null,null,null,null,null,null)");
				}
				if(ConnectionDerby.exist("plus",robotAdi.getText()))
				{
					ConnectionDerby.executeUpdate("UPDATE  plus SET plusX="+Integer.parseInt(petX.getText())+",plusY="+Integer.parseInt(petY.getText())
							+"WHERE name='"+robotAdi.getText()+"'");
				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO plus  VALUES('"+robotAdi.getText()+"',"+Integer.parseInt(plusX.getText())+","+Integer.parseInt(plusY.getText())+")");
				}
				mainFrame.redirect("setupLevels",robotAdi.getText());
				if(ConnectionDerby.exist("settings","petbuton"))
				{
					ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='petbuton'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO settings  VALUES('petbuton',false)");
				}
				ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='petbuton'");
			}
		});
		DEVAM.setBounds(355, 436, 117, 29);
		add(DEVAM);
		
		lblRobotununAdi = new JLabel("Robot Name:");
		lblRobotununAdi.setBounds(184, 356, 177, 29);
		add(lblRobotununAdi);
		
		robotAdi = new JTextField();
		robotAdi.setBounds(184, 395, 134, 28);
		add(robotAdi);
		robotAdi.setColumns(10);
		
		if(ConnectionDerby.petbuton())
		{
			HashMap<String, Integer> map=ConnectionDerby.getpetbuton();
			petsX.setText(""+map.get("petsX"));
			petsY.setText(""+map.get("petsY"));


		}

	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
		g.drawImage(new ImageIcon("img/pets.png").getImage(), 20, 30,200,100,null);
		g.drawImage(new ImageIcon("img/pet.png").getImage(), 20, 160,100,100,null);
		g.drawImage(new ImageIcon("img/plus.png").getImage(), 20, 280,100,100,null);
	}
}
