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
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import db.ConnectionDerby;
public class setupPlay2 extends JPanel {
	private JTextField tekrarX;
	private JTextField tekrary;
	private JTextField txtOnaylax;
	private JTextField txtOnaylay;
	private JTextField txtCardx;
	private JTextField txtCardy;
	private JLabel lblHerhangiBirKartin;
	private JButton btnBitti;
	private JButton btnIptal;
	private JTextField confirmx;
	private JTextField confirmy;

	/**
	 * Create the panel.
	 */
	public setupPlay2() {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		tekrarX = new JTextField();
		tekrarX.setText("TryAgainX");
		tekrarX.setBounds(211, 27, 134, 28);
		add(tekrarX);
		tekrarX.setColumns(10);
		
		tekrary = new JTextField();
		tekrary.setText("TryAgainY");
		tekrary.setBounds(360, 27, 134, 28);
		add(tekrary);
		tekrary.setColumns(10);
		
		txtOnaylax = new JTextField();
		txtOnaylax.setText("ConfirmX");
		txtOnaylax.setBounds(211, 81, 134, 28);
		add(txtOnaylax);
		txtOnaylax.setColumns(10);
		
		txtOnaylay = new JTextField();
		txtOnaylay.setText("ConfirmY");
		txtOnaylay.setBounds(360, 81, 134, 28);
		add(txtOnaylay);
		txtOnaylay.setColumns(10);
		
		txtCardx = new JTextField();
		txtCardx.setText("CardX");
		txtCardx.setBounds(6, 419, 80, 28);
		add(txtCardx);
		txtCardx.setColumns(10);
		
		txtCardy = new JTextField();
		txtCardy.setText("CardY");
		txtCardy.setBounds(108, 419, 80, 28);
		add(txtCardy);
		txtCardy.setColumns(10);
		
		lblHerhangiBirKartin = new JLabel("A card and CONFIRM button after it.");
		lblHerhangiBirKartin.setBounds(22, 387, 461, 20);
		add(lblHerhangiBirKartin);
		
		btnBitti = new JButton("DONE");
		btnBitti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtCardx.equals("")||txtCardy.equals("")||txtOnaylax.equals("")||txtOnaylay.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Hic bir alan bos birakilamaz.");
					return;
				}
				if(ConnectionDerby.exist("gameButtons","card"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(txtCardx.getText())+",buttonY="+Integer.parseInt(txtCardy.getText())
							+"WHERE name='card'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('card',"+Integer.parseInt(txtCardx.getText())+","+Integer.parseInt(txtCardy.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","confirm"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(confirmx.getText())+",buttonY="+Integer.parseInt(confirmy.getText())
							+"WHERE name='confirm'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('confirm',"+Integer.parseInt(confirmx.getText())+","+Integer.parseInt(txtCardy.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","tekrarDene"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(tekrarX.getText())+",buttonY="+Integer.parseInt(tekrary.getText())
							+"WHERE name='tekrarDene'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('tekrarDene',"+Integer.parseInt(tekrarX.getText())+","+Integer.parseInt(tekrary.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","cardConfirm"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(confirmx.getText())+",buttonY="+Integer.parseInt(confirmy.getText())
							+"WHERE name='cardConfirm'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('cardConfirm',"+Integer.parseInt(confirmx.getText())+","+Integer.parseInt(confirmy.getText())+")");
				}
				
				if(ConnectionDerby.exist("gameButtons","confirm"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(txtOnaylax.getText())+",buttonY="+Integer.parseInt(txtOnaylay.getText())
							+"WHERE name='confirm'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('cardConfirm',"+Integer.parseInt(confirmx.getText())+","+Integer.parseInt(confirmy.getText())+")");
				}
				
				ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='cardConfirm'");
				ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='card'");
				ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='playSettings2'");
				mainFrame.redirect("setupPanel", "");


			}
		});
		btnBitti.setBounds(377, 471, 117, 29);
		add(btnBitti);
		
		btnIptal = new JButton("cancel");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.redirect("setupPanel", "");
			}
		});
		btnIptal.setBounds(248, 471, 117, 29);
		add(btnIptal);
		
		confirmx = new JTextField();
		confirmx.setText("ConfirmX");
		confirmx.setColumns(10);
		confirmx.setBounds(252, 419, 80, 28);
		add(confirmx);
		
		confirmy = new JTextField();
		confirmy.setText("ConfirmY");
		confirmy.setColumns(10);
		confirmy.setBounds(377, 419, 80, 28);
		add(confirmy);
		
		if(ConnectionDerby.playSettings())
		{
	    	HashMap<String, Integer> map=ConnectionDerby.getSetupPlay2();
	    	confirmx.setText(""+map.get("cardConfirmX"));
	    	confirmy.setText(""+map.get("cardConfirmY"));
	    	txtCardx.setText(""+map.get("cardX"));
	    	txtCardy.setText(""+map.get("cardY"));
	    	txtOnaylax.setText(""+map.get("confirmX"));
	    	txtOnaylay.setText(""+map.get("confirmY"));
	    	tekrarX.setText(""+map.get("tekrarDeneX"));
	    	tekrary.setText(""+map.get("tekrarDeneY"));


		}
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
		g.drawImage(new ImageIcon("img/confirm.png").getImage(),0,0 , 160, 200, this);
		g.drawImage(new ImageIcon("img/card.png").getImage(),0,200 , 500, 180, this);




	}
}
