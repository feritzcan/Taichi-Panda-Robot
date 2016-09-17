package control;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import db.ConnectionDerby;

public class GamePlay implements Runnable {

	
	
	Robot robot;
	public Thread gameThread;
	
	
	
	//GAME DATAS
	Player player;
	HashMap<String, Integer> controlMap;
	ArrayList<Map> maps;
	Point battle1,battle2,battle3,battle4;
	
	boolean usePill=false,autoUpgrade=false,quickUpgrade=false;
	
	
	//upgrade
	int[] colBox=null;
	int boxX=0,boxY=0;


	//CONTROLLERS
	boolean mapChange=false;
	String robotName;
	public GamePlay(String robotName)
	{
		player=new Player(GameManager.world, GameManager.cons);
		this.robotName=robotName;
		gameThread=new Thread(this);
		try {
			robot=new Robot();
		} catch (AWTException e) {
		}
		controlMap=ConnectionDerby.getData(robotName);
		usePill=ConnectionDerby.usePill();
		autoUpgrade=ConnectionDerby.autoUpgrade();
		if(autoUpgrade)
		{
			colBox=ConnectionDerby.upBox();
		}
		quickUpgrade=ConnectionDerby.doQuickUpgrade();
		maps=ConnectionDerby.getMaps(robotName);
		battle1=new Point(controlMap.get("battle1X"),controlMap.get("battle1Y"));
		gameThread.start();
	}
	public void run() {
		Random r=new Random();
		
		
		robot.delay(1500);
		
		Map currentMap=maps.get(0);
		maps.remove(0);
		boolean start=true;
		boolean just=true;

		int battle=0;
		while(maps.size()!=0||just)
		{
			
			

			just=false;
			
			while(currentMap.girisSayisi==0)
			{
				currentMap=maps.get(0);
				maps.remove(0);

				start=true;
			}
			
			if(start)
				{
					start=false;
				}
				
				if(player.chapter!=currentMap.chapter)
				{
					System.out.println(player.chapter+" "+currentMap.chapter);
					openPets();
					clickOnPet();
					clickOnPlus();
					clickOnBattle(currentMap.sira);
					
					robot.delay(15000);
						

				mapChange=true;
			}
			
			while(currentMap.girisSayisi!=0)
			{
				if(player.constition<150&&usePill)
					reconst();
				if(battle%5==0&&autoUpgrade)
				{
					System.out.println("upgrade battle: "+battle);
					upgrade();
					robot.delay(1500);

				}
				openPets();	
				clickOnPet();
				clickOnPlus();
				clickOnBattle(currentMap.sira);
				clickOnEnter();
				robot.delay(10000);
				if(mapChange)
				{
					robot.delay(15000);
				}
				
				//clickOnAutoPlay();
				clickOnAutoPlay();
				
				bitmesiniBekle(currentMap);

				if(checkDrop())
				{
					battle++;
					player.constition=player.constition-8;
					clickOnConfirm();
					robot.delay(1000);
					clickOnCard();
					robot.delay(1000);
					clickOnConfirmCard();
					robot.delay(10000);
					currentMap.girisSayisi--;
					System.out.println("1");

					continue;
				}
				else
				{
					solaCek();
					robot.delay(1000);
					System.out.println("");

					if(checkDrop())
					{					battle++;

						player.constition=player.constition-8;

						clickOnConfirm();
						robot.delay(1000);
						clickOnCard();
						robot.delay(1000);
						clickOnConfirmCard();
						robot.delay(5000);
						currentMap.girisSayisi--;
						System.out.println("3");
						continue;
					}
				}
				
				while(checkDrop()==false)
				{

					clickOnTekrar();
					robot.delay(8000);
					
					clickOnAutoPlay();
					robot.delay(1000);
					//clickOnAutoPlay();
					
					bitmesiniBekle(currentMap);
					robot.delay(10000);
					if(checkDrop())
					{
						System.out.println(2);
						player.constition=player.constition-8;
						battle++;

						clickOnConfirm();
						robot.delay(1000);
						clickOnCard();
						robot.delay(1000);
						clickOnConfirmCard();
						robot.delay(10000);
						currentMap.girisSayisi--;
						break;
					}
					else
					{
						solaCek();
						if(checkDrop())
						{
							battle++;
							System.out.println(3);

							clickOnConfirm();
							robot.delay(1000);
							clickOnCard();
							robot.delay(1000);
							clickOnConfirmCard();
							robot.delay(10000);
							currentMap.girisSayisi--;
							break;
						}
					}
				}
				
				
			}
				
			
		}
		GameManager.startNext();
		
	}
	
	
	public boolean checkDrop()
	{
		
		int dropY=controlMap.get("dropY");
		int count=0;
		for(int a=controlMap.get("dropX")-200;a<controlMap.get("dropX")+200;a++)
		{
			
			
			if(Math.abs(robot.getPixelColor(a, dropY).getRGB()-controlMap.get("col1"))<50)
			{
			
				for(int b=0;b<10;b++)
				{

					if(Math.abs(robot.getPixelColor(a+b, dropY).getRGB()-controlMap.get("col"+(b+1)))<50)
					{
						
						count++;
						System.out.println("found");
					}
					
				}
				break;
			}
		}
		
		if(count>3)
		{
			System.out.println("found");

			return true;
			
		}
		else{
			System.out.println("not found");

			return false;

		}
	}
	
	public boolean checkBox()
	{
		
		int dropY=boxY;
		int count=0;
		int num=0;
		
		for(int a=boxX;a<boxX+10;a++)
		{
			
			
			
			

					if(robot.getPixelColor(a, boxY).getRGB()==colBox[num])
					{
						
						count++;
					}
					num++;
				
			
		}
		
		if(count>7)
		{

			return true;
			
		}
		else{

			return false;

		}
	}
	
	public void bitmesiniBekle(Map currentMap)
	{
		int kere=currentMap.bitirmeSuresi/60;
		int artan=currentMap.bitirmeSuresi%60;
		System.out.println(kere+"x60000 ve "+artan+" kadar beklendi.");

		for(int a=0;a<kere;a++)
			robot.delay(60000);
		robot.delay(artan);

	}
	public void leftClick()
	{
		robot.delay(500);
		   robot.mousePress(InputEvent.BUTTON1_MASK);
		    robot.delay(200);
		    robot.mouseRelease(InputEvent.BUTTON1_MASK);
		    robot.delay(1800);
	}
	public void nonleftClick()
	{
		robot.delay(500);
		   robot.mousePress(InputEvent.BUTTON1_MASK);
		    robot.delay(200);
		    robot.mouseRelease(InputEvent.BUTTON1_MASK);
		    robot.delay(500);
	}
	 	
	public void solaCek()
	{
		robot.mouseMove(controlMap.get("dropX"), controlMap.get("dropY"));
		
		robot.delay(400);
		   robot.mousePress(InputEvent.BUTTON1_MASK);
		   
		   
		   int x=controlMap.get("petX");
		   for(int a=0;a<50;a++)
		   {
			   System.out.println("sola cek x: ");
			   System.out.print(" "+x);
			    robot.mouseMove(--x, controlMap.get("petY"));

				robot.delay(3);

		   }
		    robot.delay(1000);
		   

		    robot.mouseRelease(InputEvent.BUTTON1_MASK);
		    robot.delay(2500);
	}
	
	
	
	public void yukari(int repeat)
	{
		robot.mouseMove(controlMap.get("battle2X")-155, controlMap.get("battle2Y"));
		robot.delay(300);
		   robot.mousePress(InputEvent.BUTTON1_MASK);
		
		   for(int a=0;a<repeat;a++)
		   {
			   while(MouseInfo.getPointerInfo().getLocation().y>controlMap.get("battle1Y"))
				{
					robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y-1);
					robot.delay(3);
				}
		   }
		
		
	    robot.mouseRelease(InputEvent.BUTTON1_MASK);

		   robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y-1);
		    robot.mouseRelease(InputEvent.BUTTON1_MASK);
		    robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y+1);
		    robot.mouseRelease(InputEvent.BUTTON1_MASK);

	}
	
	public void yukariCek()
	{
		robot.delay(400);

	    robot.mouseMove(650,500);
		robot.delay(400);

		   robot.mousePress(InputEvent.BUTTON1_MASK);
		   
		    robot.delay(500);
		    robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x, 493);
		    robot.delay(1);
		    robot.mouseRelease(InputEvent.BUTTON1_MASK);		    		    
		    robot.delay(10000);	
	}
	public void startBattle(int battle)
	{
		robot.mouseMove(controlMap.get("plusX"), controlMap.get("plusY"));
		leftClick();
	}
	public void clickOnPet()
	{
		robot.mouseMove(controlMap.get("petX"), controlMap.get("petY"));
		leftClick();
	}
	public void clickOnConfirm()
	{
		robot.mouseMove(controlMap.get("confirmX"), controlMap.get("confirmY"));
		leftClick();
	}
	
	public void clickOnConfirmCard()
	{
		robot.mouseMove(controlMap.get("cardConfirmX"), controlMap.get("cardConfirmY"));
		leftClick();
	}
	public void tryAgain()
	{
		robot.mouseMove(controlMap.get("cardConfirmX"), controlMap.get("cardConfirmY"));
		leftClick();
	}
	public void clickOnEnter()
	{
		robot.mouseMove(controlMap.get("enterX"), controlMap.get("enterY"));
		leftClick();
	}
	public void clickOnBattle(int battle)
	{
		if(battle==1)
		robot.mouseMove(controlMap.get("battle1X"), controlMap.get("battle1Y"));
		if(battle==2)
			robot.mouseMove(controlMap.get("battle2X"), controlMap.get("battle2Y"));
		if(battle==3)
			robot.mouseMove(controlMap.get("battle3X"), controlMap.get("battle3Y"));
		if(battle==4)
			robot.mouseMove(controlMap.get("battle4X"), controlMap.get("battle4Y"));
		
		if(battle>4)
		{
			yukari(battle-4);
			robot.mouseMove(controlMap.get("battle4X"), controlMap.get("battle4Y"));
		}
		leftClick();
		robot.delay(2000
				);
	}
	
	public void clickOnPlus()
	{
		robot.mouseMove(controlMap.get("plusX"), controlMap.get("plusY"));
		leftClick();
	}
	public void clickOnPill()
	{
		robot.mouseMove(controlMap.get("pillX"), controlMap.get("pillY"));
		leftClick();
	}
	public void usePill()
	{
		robot.mouseMove(controlMap.get("pillUseX"), controlMap.get("pillUseY"));
		leftClick();
	}
	
	
	public void reconst()
	{
		openBackPack();
		clickOnPill();
		usePill();
		closeBackPack();
		player.constition+=2*25;
		
	}
	public void cardConfirm()
	{
		System.out.println("clickonconfirm");

		robot.mouseMove(controlMap.get("cardConfirmX"), controlMap.get("cardConfirmY"));
		leftClick();
	}
	public void clickOnCard()
	{
		System.out.println("clickoncart");

		robot.mouseMove(controlMap.get("cardX"), controlMap.get("cardY"));
		leftClick();
	}
	
	public void upgrade()
	{
		openBackPack();
		robot.delay(1000);

		robot.mouseMove(controlMap.get("upItemX"), controlMap.get("upItemY"));
		leftClick();
		robot.delay(1000);

		robot.mouseMove(controlMap.get("upX"), controlMap.get("upY"));
		robot.delay(500);
		leftClick();
		
		
		if(quickUpgrade)
		{
			robot.mouseMove(controlMap.get("qfortifyX"), controlMap.get("qfortifyY"));
			robot.delay(500);
			leftClick();
			robot.delay(1500);
			robot.mouseMove(controlMap.get("qfConfirmX"), controlMap.get("qfConfirmY"));
			robot.delay(1000);
			leftClick();
			robot.mouseMove(controlMap.get("qfConfirmX"), controlMap.get("qfConfirmY"));
			robot.delay(1000);
			leftClick();
			robot.delay(1000);

			closeBackPack();
			robot.delay(1000);
			closeBackPack();
		}
		else
		{
			
			
			for(int a=0;a<6;a++	)
			{
				robot.mouseMove(controlMap.get("uppAddX"), controlMap.get("uppAddY"));
				robot.delay(500);
				leftClick();
				robot.delay(500);
				robot.mouseMove(controlMap.get("fortifyX"), controlMap.get("fortifyY"));
				robot.delay(100);
				leftClick();
				
				
				
			}
			closeBackPack();
			robot.delay(1000);
			closeBackPack();
			
			
		
		}
		
		
		
	}

	public void clickOnTekrar()
	{
		System.out.println("clickonTEKRARÅ�L");

		robot.mouseMove(controlMap.get("tekrarDeneX"), controlMap.get("tekrarDeneY"));
		leftClick();
	}
	public void clickOnAutoPlay()
	{
		System.out.println("clickonauto");
		robot.mouseMove(controlMap.get("autoX"), controlMap.get("autoY"));
		nonleftClick();
	}
	public void clickOnItem()
	{
		System.out.println("clickonitem");

		robot.mouseMove(controlMap.get("petX"), controlMap.get("petY"));
		leftClick();
	}
	public void openPets()
	{
		System.out.println("open pets");

		robot.mouseMove(controlMap.get("petsX"), controlMap.get("petsY"));
		leftClick();
		robot.delay(1000);
	}
	public void openBackPack()
	{
		System.out.println("copenbp");

		robot.mouseMove(controlMap.get("backpackOpenX"), controlMap.get("backpackOpenY"));
		leftClick();
	}
	public void closeBackPack()
	{
		robot.mouseMove(controlMap.get("backpackCloseX"), controlMap.get("backpackCloseY"));
		leftClick();
	}

}
