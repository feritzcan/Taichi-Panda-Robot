package panels;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
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

public class setupLevels extends JPanel {

	/**
	 * Create the panel.
	 */
	public setupLevels(final String robot) {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(241, 0, 1, 294);
		add(verticalStrut);
		
		JLabel lblMapEklemek = new JLabel("Map Settings");
		lblMapEklemek.setForeground(Color.RED);
		lblMapEklemek.setBounds(71, 6, 91, 16);
		add(lblMapEklemek);
		
		JLabel lblBuAdimdaitemlerin = new JLabel("     In that step; we will  ");
		lblBuAdimdaitemlerin.setBounds(6, 21, 236, 53);
		add(lblBuAdimdaitemlerin);
		
		JLabel lblHaritalariRobotaEkleyecegiz = new JLabel("select maps robot runs.");
		lblHaritalariRobotaEkleyecegiz.setBounds(6, 56, 245, 33);
		add(lblHaritalariRobotaEkleyecegiz);
		
		JLabel lblMap = new JLabel("Chapter:");
		lblMap.setForeground(Color.RED);
		lblMap.setBounds(84, 86, 61, 16);
		add(lblMap);
		
		JLabel lblOyundaGibi = new JLabel("Worlds in the game");
		lblOyundaGibi.setBounds(16, 101, 245, 40);
		add(lblOyundaGibi);
		
		JLabel label = new JLabel("that we transfer ");
		label.setBounds(6, 133, 245, 40);
		add(label);
		
		JLabel label_1 = new JLabel("only by portals. ");
		label_1.setBounds(6, 169, 245, 40);
		add(label_1);
		
		JLabel label_2 = new JLabel("we have 3 chapters.");
		label_2.setBounds(6, 201, 245, 40);
		add(label_2);
		
		JLabel label_3 = new JLabel("row:1,2,3,4..");
		label_3.setForeground(Color.RED);
		label_3.setBounds(71, 239, 78, 16);
		add(label_3);
		
		JLabel lblMapinHaritalarArasindaki = new JLabel("Which row is map?.");
		lblMapinHaritalarArasindaki.setBounds(16, 253, 226, 41);
		add(lblMapinHaritalarArasindaki);
		
		JLabel label_4 = new JLabel("Enter change");
		label_4.setForeground(Color.RED);
		label_4.setBounds(54, 288, 108, 16);
		add(label_4);
		
		JLabel label_5 = new JLabel("How many times u can do daily?");
		label_5.setBounds(16, 315, 226, 41);
		add(label_5);
		
		JLabel label_6 = new JLabel("Finish time");
		label_6.setForeground(Color.RED);
		label_6.setBounds(69, 356, 108, 16);
		add(label_6);
		
		JLabel label_7 = new JLabel("Maximum time that map takes(seconds)");
		label_7.setBounds(17, 394, 305, 40);
		add(label_7);
		
		JLabel label_8 = new JLabel("Open that from");
		label_8.setBounds(305, 327, 226, 41);
		add(label_8);
		
		JLabel label_9 = new JLabel("+ symbol in pets.");
		label_9.setBounds(268, 356, 226, 41);
		add(label_9);
		
		JButton btnBolumEkle = new JButton("ADD MAP");
		btnBolumEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame ("New map");
				
	            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new newMap(frame,robot));
	            frame.pack();
	            frame.setSize(300,300);
	            frame.setVisible (true);
			}
		});
		btnBolumEkle.setBounds(193, 427, 154, 40);
		add(btnBolumEkle);
		
		JLabel lblBirdenFazlaMap = new JLabel("(You can add multiple maps.)");
		lblBirdenFazlaMap.setForeground(Color.WHITE);
		lblBirdenFazlaMap.setBounds(157, 466, 241, 16);
		add(lblBirdenFazlaMap);
		
		JButton button = new JButton("NEXT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("newRobot",robot);

			}
		});
		button.setBounds(346, 427, 154, 40);
		add(button);
		
		JButton btnIptal = new JButton("CANCEL");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("girisPaneli", "");

			}
		});
		btnIptal.setBounds(6, 433, 117, 29);
		add(btnIptal);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("girisPaneli","");
			}
		});

	}
	public void paintComponent(Graphics g)
	{
		
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
		g.drawImage(new ImageIcon("img/levels.png").getImage(),300,0 , 180, 300, this);
	}
}
