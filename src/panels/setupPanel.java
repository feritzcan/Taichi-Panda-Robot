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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import db.ConnectionDerby;

public class setupPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public setupPanel() {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		JLabel lblBuAyarlariItem = new JLabel("You dont need to change settings unless coordinates change.");
		lblBuAyarlariItem.setBounds(6, 151, 488, 64);
		add(lblBuAyarlariItem);
		
		JButton btnPillAyarlari = new JButton("Pill settings");
		btnPillAyarlari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("setupPill", "");
			}
		});
		btnPillAyarlari.setBounds(52, 218, 117, 29);
		add(btnPillAyarlari);
		
		JButton btnUpgradeAyarlari = new JButton("Upgrade settings");
		btnUpgradeAyarlari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("setupUpgrade", "");
			}
		});
		btnUpgradeAyarlari.setBounds(281, 218, 171, 29);
		add(btnUpgradeAyarlari);
		
		final JCheckBox chckbxPillKullan = new JCheckBox("Use pill");
		chckbxPillKullan.setBounds(52, 401, 128, 23);
		chckbxPillKullan.setSelected(ConnectionDerby.autoPill());
		add(chckbxPillKullan);
		
		final JCheckBox chckbxOtomatikUpgrade = new JCheckBox("Do upgrade");
		chckbxOtomatikUpgrade.setSelected(ConnectionDerby.autoUpgrade());
		chckbxOtomatikUpgrade.setBounds(52, 347, 154, 23);
		add(chckbxOtomatikUpgrade);
		
		JButton btnMapAyarlari = new JButton("Play settings");
		btnMapAyarlari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.redirect("setupPlay", "");
				
				
			}
		});
		btnMapAyarlari.setBounds(52, 280, 117, 29);
		add(btnMapAyarlari);
		final JCheckBox chckbxQuickFortificationrequiresVip = new JCheckBox("Quick fortification(requires vip level)");

		JButton btnTamam = new JButton("DONE");
		btnTamam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionDerby.executeUpdate("UPDATE  settings SET done="+chckbxQuickFortificationrequiresVip.isSelected() + " WHERE name='quickUpgrade'");

				ConnectionDerby.executeUpdate("UPDATE  settings SET done="+chckbxOtomatikUpgrade.isSelected() +" WHERE name='autoUpgrade'");
				ConnectionDerby.executeUpdate("UPDATE  settings SET done="+chckbxPillKullan.isSelected() + " WHERE name='autoPill'");
				mainFrame.redirect("girisPaneli", "");
			}
		});
		btnTamam.setBounds(377, 450, 117, 29);
		add(btnTamam);
		
		chckbxQuickFortificationrequiresVip.setBounds(52, 377, 288, 23);
		add(chckbxQuickFortificationrequiresVip);

	}
	public void paintComponent(Graphics g)
	{
		
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
		
		
		if(ConnectionDerby.pillSettings())
		g.drawImage(new ImageIcon("img/Tick.png").getImage(), 163, 212,25,25,null);
		else
			g.drawImage(new ImageIcon("img/notTick.png").getImage(), 163, 212,25,25,null);

		//upgr
		if(ConnectionDerby.upgradeSettings())
			g.drawImage(new ImageIcon("img/Tick.png").getImage(), 404, 218,25,25,null);
		else
		g.drawImage(new ImageIcon("img/notTick.png").getImage(), 404, 218,25,25,null);

		if(ConnectionDerby.playSettings())
			g.drawImage(new ImageIcon("img/Tick.png").getImage(), 160, 280,25,25,null);
		else
			g.drawImage(new ImageIcon("img/notTick.png").getImage(), 160, 280,25,25,null);


	}
}
