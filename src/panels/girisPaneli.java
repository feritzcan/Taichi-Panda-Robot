package panels;
import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Robot;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.ProcessBuilder.Redirect;

import javax.swing.JList;
import javax.swing.JLabel;

import control.GameManager;
import control.GamePlay;
import db.ConnectionDerby;

import javax.swing.JTextField;


public class girisPaneli extends JPanel {

	/**
	 * Create the panel.
	 */
	JTable list;
	GamePlay gp;
	GameManager manager;
	private JTextField cons;
	private JTextField world;
	private JTextField x;
	private JTextField y;
	public girisPaneli() {
		setBounds(0, 00, 500, 500);

		JButton btnAyarlar = new JButton("Settings");
		btnAyarlar.setBounds(377, 429, 117, 29);
		btnAyarlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ConnectionDerby.ayarGosterme())
				{
					mainFrame.redirect("setupPanel", "");
				}
				else
				mainFrame.redirect("setupBegin","");
				
			}
		});
		setLayout(null);
		add(btnAyarlar);
		
		list = new JTable(new jtable());
		list.setBounds(32, 43, 145, 169);
		list.setRowSelectionAllowed(true);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(list);

		JLabel lblRobotlarin = new JLabel("YOUR ROBOTS");
		lblRobotlarin.setBounds(60, 6, 117, 16);
		add(lblRobotlarin);
		
		JButton yeniRobot = new JButton("New Robot");
		yeniRobot.setBounds(219, 38, 117, 29);
		yeniRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.redirect("selectSoul","");
				
			}
		});
		add(yeniRobot);
		final JButton btnStop = new JButton("STOP");
		btnStop.setBounds(175, 284, 117, 29);
		final JButton btnBasla = new JButton("Start");
		btnBasla.setBounds(32, 284, 117, 29);

		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBasla.setEnabled(true);
				btnStop.setEnabled(false);
				manager.stop();
			}
		});

		btnBasla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] row=list.getSelectedRows();
				String[] robots=new String[row.length];
				int count=0;
				
				for(int a:row)
				{
					String robot=(String) list.getModel().getValueAt(a, 0);
					robots[count++]=robot;

				}
				manager=new GameManager(robots,Integer.parseInt(cons.getText()),Integer.parseInt(world.getText()));
				btnStop.setEnabled(true);
				btnBasla.setEnabled(false);
				
			}
		});
		add(btnBasla);
		
		btnStop.setEnabled(false);
		add(btnStop);
		
		JButton btnNewButton = new JButton("FACTORY SETTINGS!!");
		btnNewButton.setBounds(6, 429, 185, 51);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionDerby.reset();
				mainFrame.redirect("girisPaneli", "");
			}
		});
		add(btnNewButton);
		
		JLabel lblCharacter = new JLabel("Character constition:");
		lblCharacter.setBounds(6, 216, 159, 16);
		add(lblCharacter);
		
		JLabel label = new JLabel("Character world:");
		label.setBounds(6, 244, 159, 16);
		add(label);
		
		cons = new JTextField("100");
		cons.setBounds(150, 216, 54, 16);
		add(cons);
		cons.setColumns(10);
		
		world = new JTextField("1");
		world.setBounds(137, 244, 54, 16);
		world.setColumns(10);
		add(world);
		
		x = new JTextField("X");
		x.setBounds(390, 121, 43, 29);
		add(x);
		x.setColumns(10);
		
		y = new JTextField("Y");
		y.setColumns(10);
		y.setBounds(445, 121, 43, 29);
		add(y);
		
		JButton btnEditSoul = new JButton("EDIT SOUL");
		btnEditSoul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Robot r=null;
				try {
					r = new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int[] row=list.getSelectedRows();
				String[] robots=new String[row.length];
				int count=0;
				
				for(int a:row)
				{
					String robot=(String) list.getModel().getValueAt(a, 0);
					robots[count++]=robot;

				}
				
				for(String robot:robots)
				{
					if(ConnectionDerby.exist("pets",robot))
					{
						int[] cols=new int[10];
						for(int a=0;a<10;a++)
							cols[a]=(r.getPixelColor(Integer.parseInt(x.getText())+a, Integer.parseInt(y.getText())).getRGB());
						ConnectionDerby.executeUpdate("UPDATE  pets SET DROPX="+Integer.parseInt(x.getText())+",DROPY="+Integer.parseInt(y.getText())
								+",COL1="+cols[0]+",COL2="+cols[1]+",COL3="+cols[2]+",COL4="+cols[3]+",COL5="+cols[4]+
								",COL6="+cols[5]+",COL7="+cols[6]+",COL8="+cols[7]+",COL9="+cols[8]+",COL10="+cols[9]+"WHERE name='"+robot+"'");
						
					}
				}
			}
		});
		btnEditSoul.setBounds(377, 150, 117, 29);
		add(btnEditSoul);
		
		JButton delete = new JButton("delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row=list.getSelectedRows();
				String[] robots=new String[row.length];
				int count=0;
				
				for(int a:row)
				{
					String robot=(String) list.getModel().getValueAt(a, 0);
					robots[count++]=robot;

				}
				
				for(String robot:robots)
				{
					ConnectionDerby.executeUpdate("DELETE FROM PETS WHERE name='"+robot+"'");
					ConnectionDerby.executeUpdate("DELETE FROM ROBOTS WHERE name='"+robot+"'");
					ConnectionDerby.executeUpdate("DELETE FROM MAPS WHERE name='"+robot+"'");

				}
				
				mainFrame.redirect("girisPaneli", "");
			}
		});
		delete.setBounds(219, 74, 117, 29);
		add(delete);

	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
	}
}
