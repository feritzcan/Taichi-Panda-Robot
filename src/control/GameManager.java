package control;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JPanel;

public class GameManager extends JPanel {

	/**
	 * Create the panel.
	 */
	static String[] robots;
	static GamePlay game;
	static int current=-1;
	public static GamePlay currentRobot;
	public static int cons=100,world=1;

	public GameManager(String[] robots,int cons,int world) {
		this.robots=robots;
		this.cons=cons;
		this.world=world;
		startNext();

		
	}
	
	public static void stop()
	{
		currentRobot.gameThread.stop();
	}
	
	public static void startNext()
	{
		current++;
		if(current<robots.length)
		{
			game=new GamePlay(robots[current]);
			currentRobot=game;
		}
	}


}
