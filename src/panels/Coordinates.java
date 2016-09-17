package panels;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;

public class Coordinates extends JPanel implements Runnable{

	/**
	 * Create the panel.
	 */
	JLabel x,y;
	Thread update;
	public Coordinates() {

		setBounds(0, 500, 500, 50);
		setLayout(null);
		
		JLabel lblMouseX = new JLabel("Mouse X:");
		lblMouseX.setForeground(Color.RED);
		lblMouseX.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMouseX.setBounds(17, 6, 61, 16);
		add(lblMouseX);
		
		JLabel label = new JLabel("Mouse Y:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		label.setBounds(262, 6, 61, 16);
		add(label);
		
		 x = new JLabel("");
		x.setBounds(104, 6, 61, 16);
		add(x);
		
		 y = new JLabel("");
		y.setBounds(351, 6, 61, 16);
		add(y);
		
		update=new Thread(this);
		update.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			x.setText(""+MouseInfo.getPointerInfo().getLocation().x);
			y.setText(""+MouseInfo.getPointerInfo().getLocation().y);
			
			repaint();
			mainFrame.contentPane.repaint();
			try {
				update.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
		
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("bg.jpg").getImage(), 0, 0,getWidth(),getHeight(),null);
	}

}
