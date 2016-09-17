package panels;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import db.ConnectionDerby;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class newMap extends JPanel {
	private JTextField chapter;
	private JTextField sira;
	private JTextField girisSayisi;
	private JTextField sure;

	/**
	 * Create the panel.
	 */
	public newMap(final JFrame parent,final String robot) {

		setBounds(0, 0, 300, 300);
		setLayout(null);
		
		JLabel lblChapter = new JLabel("Chapter:");
		lblChapter.setForeground(Color.RED);
		lblChapter.setBounds(21, 44, 61, 16);
		add(lblChapter);
		
		JLabel label = new JLabel("Row:");
		label.setForeground(Color.RED);
		label.setBounds(21, 87, 61, 16);
		add(label);
		
		JLabel label_1 = new JLabel("Enter chance");
		label_1.setForeground(Color.RED);
		label_1.setBounds(21, 131, 79, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Finish time:");
		label_2.setForeground(Color.RED);
		label_2.setBounds(21, 173, 90, 16);
		add(label_2);
		
		JButton btnEkle = new JButton("ADD");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				parent.setVisible(false);
					ConnectionDerby.executeUpdate("INSERT INTO maps VALUES('"+robot+"',"+Integer.parseInt(chapter.getText())+","+sira.getText()+","+girisSayisi.getText()+","+sure.getText()+")");
				
			}
		});
		btnEkle.setBounds(177, 250, 117, 29);
		add(btnEkle);
		
		JButton btnIptal = new JButton("IPTAL");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				setVisible(false);
			}
		});
		btnIptal.setBounds(6, 250, 117, 29);
		add(btnIptal);
		
		chapter = new JTextField();
		chapter.setBounds(94, 38, 69, 28);
		add(chapter);
		chapter.setColumns(10);
		
		sira = new JTextField();
		sira.setColumns(10);
		sira.setBounds(94, 81, 69, 28);
		add(sira);
		
		girisSayisi = new JTextField();
		girisSayisi.setColumns(10);
		girisSayisi.setBounds(112, 125, 69, 28);
		add(girisSayisi);
		
		sure = new JTextField();
		sure.setColumns(10);
		sure.setBounds(122, 167, 69, 28);
		add(sure);
	}

}
