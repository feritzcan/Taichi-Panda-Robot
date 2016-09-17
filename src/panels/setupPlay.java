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

public class setupPlay extends JPanel {
	private JTextField BATTLE1X;
	private JTextField BATTLE1Y;
	private JTextField bt2x;
	private JTextField bt2y;
	private JTextField bt3x;
	private JTextField txtBattley;
	private JTextField txtBattlex;
	private JTextField txtBattley_1;
	private JTextField txtEnterx;
	private JTextField txtEntery;
	private JTextField autoX;
	private JTextField txtAutoplayy;
	private JButton next;
	private JButton cancel;
	
	/**
	 * Create the panel.
	 */
	public setupPlay() {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		BATTLE1X = new JTextField();
		BATTLE1X.setText("BATTLE1X");
		BATTLE1X.setBounds(201, 6, 134, 28);
		add(BATTLE1X);
		BATTLE1X.setColumns(10);
		
		BATTLE1Y = new JTextField();
		BATTLE1Y.setText("BATTLE1Y");
		BATTLE1Y.setBounds(347, 6, 134, 28);
		add(BATTLE1Y);
		BATTLE1Y.setColumns(10);
		
		bt2x = new JTextField();
		bt2x.setText("BATTLE2X");
		bt2x.setBounds(201, 46, 134, 28);
		add(bt2x);
		bt2x.setColumns(10);
		
		bt2y = new JTextField();
		bt2y.setText("BATTLE2Y");
		bt2y.setBounds(347, 46, 134, 28);
		add(bt2y);
		bt2y.setColumns(10);
		
		bt3x = new JTextField();
		bt3x.setText("BATTLE3X");
		bt3x.setBounds(201, 96, 134, 28);
		add(bt3x);
		bt3x.setColumns(10);
		
		txtBattley = new JTextField();
		txtBattley.setText("BATTLE3Y");
		txtBattley.setBounds(347, 96, 134, 28);
		add(txtBattley);
		txtBattley.setColumns(10);
		
		txtBattlex = new JTextField();
		txtBattlex.setText("BATTLE4X");
		txtBattlex.setBounds(201, 136, 134, 28);
		add(txtBattlex);
		txtBattlex.setColumns(10);
		
		txtBattley_1 = new JTextField();
		txtBattley_1.setText("BATTLE4Y");
		txtBattley_1.setBounds(347, 136, 134, 28);
		add(txtBattley_1);
		txtBattley_1.setColumns(10);
		
		txtEnterx = new JTextField();
		txtEnterx.setText("ENTERX");
		txtEnterx.setBounds(201, 248, 134, 28);
		add(txtEnterx);
		txtEnterx.setColumns(10);
		
		txtEntery = new JTextField();
		txtEntery.setText("ENTERY");
		txtEntery.setBounds(347, 248, 134, 28);
		add(txtEntery);
		txtEntery.setColumns(10);
		
		autoX = new JTextField();
		autoX.setText("AUTOPLAYX");
		autoX.setBounds(201, 358, 134, 28);
		add(autoX);
		autoX.setColumns(10);
		
		txtAutoplayy = new JTextField();
		txtAutoplayy.setText("AUTOPLAYY");
		txtAutoplayy.setBounds(347, 358, 134, 28);
		add(txtAutoplayy);
		txtAutoplayy.setColumns(10);
		
		next = new JButton("DEVAM");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(BATTLE1X.equals("")||BATTLE1Y.equals("")||bt2x.equals("")||bt2y.equals("")
						||bt3x.equals("")||txtBattlex.equals("")||txtBattley.equals("")
						||txtBattley_1.equals("")||txtEnterx.equals("")||txtEntery.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Hic bir alan bos birakilamaz.");
					return;
				}
				if(ConnectionDerby.exist("gameButtons","enter"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(txtEnterx.getText())+",buttonY="+Integer.parseInt(txtEntery.getText())
							+"WHERE name='enter'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('enter',"+Integer.parseInt(txtEnterx.getText())+","+Integer.parseInt(txtEntery.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","battle1"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(BATTLE1X.getText())+",buttonY="+Integer.parseInt(BATTLE1Y.getText())
							+"WHERE name='battle1'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('battle1',"+Integer.parseInt(BATTLE1X.getText())+","+Integer.parseInt(BATTLE1Y.getText())+")");
				}
				
				if(ConnectionDerby.exist("gameButtons","battle2"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(bt2x.getText())+",buttonY="+Integer.parseInt(bt2y.getText())
							+"WHERE name='battle2'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('battle2',"+Integer.parseInt(bt2x.getText())+","+Integer.parseInt(bt2y.getText())+")");
				}
				
				if(ConnectionDerby.exist("gameButtons","battle3"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(bt3x.getText())+",buttonY="+Integer.parseInt(txtBattley.getText())
							+"WHERE name='battle3'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('battle3',"+Integer.parseInt(bt3x.getText())+","+Integer.parseInt(txtBattley.getText())+")");
				}
				
				if(ConnectionDerby.exist("gameButtons","battle4"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(txtBattlex.getText())+",buttonY="+Integer.parseInt(txtBattley_1.getText())
							+"WHERE name='battle4'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('battle4',"+Integer.parseInt(txtBattlex.getText())+","+Integer.parseInt(txtBattley_1.getText())+")");
				}
				if(ConnectionDerby.exist("gameButtons","autoPlay"))
				{
					ConnectionDerby.executeUpdate("UPDATE  gameButtons SET buttonX="+Integer.parseInt(autoX.getText())+",buttonY="+Integer.parseInt(txtAutoplayy.getText())
							+"WHERE name='autoPlay'");

				}
				else
				{
					ConnectionDerby.executeUpdate("INSERT INTO gameButtons VALUES('autoPlay',"+Integer.parseInt(autoX.getText())+","+Integer.parseInt(txtAutoplayy.getText())+")");
				}
				
				ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='playSettings1'");
				ConnectionDerby.executeUpdate("UPDATE  settings SET done=true WHERE name='autoPlay'");
				mainFrame.redirect("setupPlay2", "");
			}
		});
		next.setBounds(377, 465, 117, 29);
		add(next);
		
		cancel = new JButton("IPTAL");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("setupPanel", "");
			}
		});
		cancel.setBounds(261, 465, 117, 29);
		add(cancel);
		
		
	
		if(ConnectionDerby.playSettings())
		{
	    	HashMap<String, Integer> map=ConnectionDerby.getSetupPlay1();
	    	autoX.setText(""+map.get("autoX"));
	    	txtAutoplayy.setText(""+map.get("autoY"));
	    	BATTLE1X.setText(""+map.get("battle1X"));
	    	BATTLE1Y.setText(""+map.get("battle1Y"));
	    	bt2x.setText(""+map.get("battle2X"));
	    	bt2y.setText(""+map.get("battle2Y"));
	    	bt3x.setText(""+map.get("battle3X"));
	    	txtBattley.setText(""+map.get("battle3Y"));
	    	txtBattlex.setText(""+map.get("battle4X"));
	    	txtBattley_1.setText(""+map.get("battle4Y"));
	    	txtEnterx.setText(""+map.get("enterX"));
	    	txtEntery.setText(""+map.get("enterY"));




		}

	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
		g.drawImage(new ImageIcon("img/levels.png").getImage(),0,0 , 160, 200, this);
		g.drawImage(new ImageIcon("img/enter.png").getImage(),0,210 , 160, 140, this);
		g.drawImage(new ImageIcon("img/auto.png").getImage(),0,350 , 120, 120, this);



	}
}
