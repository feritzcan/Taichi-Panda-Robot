package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import control.Map;

public class ConnectionDerby {

    private static Connection conn = null;
    private Statement sttm = null;
    static ResultSet rs = null;
    static Statement smt1 = null;
    static Statement smt3 = null;

    public static void connectDB()
    {
    	String dbURL = "org.apache.derby.jdbc.EmbeddedDriver";
    	 
    	try {
    	Class.forName(dbURL).newInstance();
    	conn = DriverManager.getConnection("jdbc:derby:"
    	+ "derbyDB;create=true");
    	} catch (Exception except) {
    	except.printStackTrace();
    	}
    	 
    	if (conn != null) {
    	System.out.println("connected");
    	}
    	else
    	{
    		System.out.println("not");
    	}
    }	
    public static boolean exist(String table,String name)
    {
    	int count=0;
    	try {
			smt1 = conn.createStatement();
			rs = smt1.executeQuery("select count(*) from "+table+" WHERE name='"+name+"'");
			
			if (rs.next())
				count=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count>0)
    	{
    		System.out.println("count="+count);
    		return true;

    	}
    	else{
    		System.out.println("not exist");
    		return false;
    	} 
    }
    public void createTables()
    {
    	try {
    			if(isTableExist("robots")==false)
			{
				smt1 = conn.createStatement();
				 smt1.executeUpdate("CREATE TABLE robots (name VARCHAR(45))");
			}
    		
			if(isTableExist("gameButtons")==false)
			{
				smt1 = conn.createStatement();
				 smt1.executeUpdate("CREATE TABLE gameButtons (name VARCHAR(45),buttonX int,buttonY int)");
			}
			
			if(isTableExist("pets")==false)
			{
				
				smt1 = conn.createStatement();
				 smt1.executeUpdate("CREATE TABLE pets (name VARCHAR(45),petX int,petY int ,dropX int,dropY int,col1 int,col2 int,col3 int,col4 int,col5 int,col6 int,col7 int,col8 int,col9 int,col10 int)");
			}
			
			
			if(isTableExist("maps")==false)
			{
				smt1 = conn.createStatement();
				 smt1.executeUpdate("CREATE TABLE maps (name VARCHAR(45),chapter int,sira int,girisSayisi int,bitirmeSuresi int)");
			}
			
			if(isTableExist("plus")==false)
			{
				smt1 = conn.createStatement();
				 smt1.executeUpdate("CREATE TABLE plus (name VARCHAR(45),plusX int,plusY int)");
			}
			
			
			if(isTableExist("settings")==false)
			{
				smt1 = conn.createStatement();
				 smt1.executeUpdate("CREATE TABLE settings (name VARCHAR(45),done boolean)");
				
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('backpackOpen',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('petsOpen',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('backpackClose',false)");
				 smt1 = conn.createStatement();
				 
				 smt1.executeUpdate("insert into settings values('pill',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('quickUpgrade',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('battles',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('enter',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('autoPlay',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('goAgain',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('confirm',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('card',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('cardConfirm',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('ayarGosterme',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('autoPill',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('autoUpgrade',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('pillSettings',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('playSettings1',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('playSettings2',false)");
				 smt1 = conn.createStatement();
				 smt1.executeUpdate("insert into settings values('upgradeSettings',false)");
			}
			
			
		   	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void reset()
    {
    	try {
			smt1 = conn.createStatement();
			 smt1.executeUpdate("DELETE  FROM settings");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DELETE  FROM  robots");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DELETE  FROM  gameButtons");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DELETE  FROM  pets");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DELETE  FROM  plus");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DELETE  FROM  maps");

			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('backpackOpen',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('petsOpen',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('backpackClose',false)");
			 smt1 = conn.createStatement();
			 
			 smt1.executeUpdate("insert into settings values('pill',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('quickUpgrade',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('battles',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('enter',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('autoPlay',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('goAgain',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('confirm',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('card',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('cardConfirm',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('ayarGosterme',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('autoPill',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('autoUpgrade',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('pillSettings',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('playSettings1',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('playSettings2',false)");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("insert into settings values('upgradeSettings',false)");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void dropTable()
    {
    	try {
			smt1 = conn.createStatement();
			 smt1.executeUpdate("DROP TABLE settings");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DROP TABLE robots");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DROP TABLE gameButtons");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DROP TABLE pets");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DROP TABLE plus");
			 smt1 = conn.createStatement();
			 smt1.executeUpdate("DROP TABLE maps");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static boolean ayarGosterme()
    {
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='ayarGosterme'");
			
			if (rs.next())
				return rs.getBoolean("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    
    public static boolean doUpgrade()
    {
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='autoUpgrade'");
			
			if (rs.next())
				return rs.getBoolean("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    public static boolean doQuickUpgrade()
    {
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='quickUpgrade'");
			
			if (rs.next())
				return rs.getBoolean("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    public static boolean usePill()
    {
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='autoPill'");
			
			if (rs.next())
				return rs.getBoolean("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    public static boolean playSettings()
    {
		boolean done1=false,done2=false;

    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='playSettings1'");
			if (rs.next())
				 done1= rs.getBoolean("done");
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='playSettings2'");
			if (rs.next())
				 done2= rs.getBoolean("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return (done1&&done2);
    }
    public static boolean petbuton()
    {
		boolean done1=false,done2=false;

    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='petbuton'");
			if (rs.next())
				 done1= rs.getBoolean("done");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return (done1);
    }
    public static boolean upgradeSettings()
    {
		boolean done1=false,done2=false;

    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='upgradeSettings'");
			if (rs.next())
				 done1= rs.getBoolean("done");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return done1;
    }
    public static boolean pillSettings()
    {
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='pillSettings'");
			
			if (rs.next())
				return rs.getBoolean("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    public static boolean autoPill()
    {
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='autoPill'");
			
			if (rs.next())
				return rs.getBoolean("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    public static boolean autoUpgrade()
    {
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select done FROM settings WHERE name='autoUpgrade'");
			
			if (rs.next())
				return rs.getBoolean("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    public static int executeUpdate(String sql)
    {
    	ResultSet rs=null;
    	try {
			smt1 = conn.createStatement();

			return smt1.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 0;
    }
    public static ResultSet executeQuery(String sql)
    {
    	ResultSet rs=null;
    	try {
			smt1 = conn.createStatement();

			
			rs=smt1.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return rs;
    }
    public int get(String table,String data,String robot)
    {
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("select "+data+" from "+table+"WHERE name='"+robot+")");
			
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	 return 0;
    }
    
    public static HashMap<String, Integer> getSetupPlay2()
    {
    	HashMap<String, Integer> map=new HashMap<String, Integer>();
    	try {
    		smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='tekrarDene'");
			if (rs.next())
			{
				map.put("tekrarDeneX", rs.getInt("buttonX"));
				map.put("tekrarDeneY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='autoPlay'");
			if (rs.next())
			{
				map.put("autoX", rs.getInt("buttonX"));
				map.put("autoY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='card'");
			if (rs.next())
			{
				map.put("cardX", rs.getInt("buttonX"));
				map.put("cardY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='cardConfirm'");
			if (rs.next())
			{
				map.put("cardConfirmX", rs.getInt("buttonX"));
				map.put("cardConfirmY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='confirm'");
			if (rs.next())
			{
				map.put("confirmX", rs.getInt("buttonX"));
				map.put("confirmY", rs.getInt("buttonY"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	return map;
    }
    
    public static int[] upBox()
    {
    	int [] box=new int[12];
    	try {
    		smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT * FROM pets WHERE name='admin_box'");
			if (rs.next())
			{
				box[10]=rs.getInt("PETX");
				box[11]=rs.getInt("PETY");
				box[0]=rs.getInt("COL1");
				box[1]=rs.getInt("COL2");
				box[2]=rs.getInt("COL3");
				box[3]=rs.getInt("COL4");
				box[4]=rs.getInt("COL5");
				box[5]=rs.getInt("COL6");
				box[6]=rs.getInt("COL7");
				box[7]=rs.getInt("COL8");
				box[8]=rs.getInt("COL9");
				box[9]=rs.getInt("COL10");


			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	return box;
    }
    public static HashMap<String, Integer> getSetupPlay1()
    {
    	HashMap<String, Integer> map=new HashMap<String, Integer>();
    	try {
    		smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='battle1'");
			if (rs.next())
			{
				map.put("battle1X", rs.getInt("buttonX"));
				map.put("battle1Y", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='enter'");
			if (rs.next())
			{
				map.put("enterX", rs.getInt("buttonX"));
				map.put("enterY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='battle2'");
			if (rs.next())
			{
				map.put("battle2X", rs.getInt("buttonX"));
				map.put("battle2Y", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='battle3'");
			if (rs.next())
			{
				map.put("battle3X", rs.getInt("buttonX"));
				map.put("battle3Y", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='battle4'");
			if (rs.next())
			{
				map.put("battle4X", rs.getInt("buttonX"));
				map.put("battle4Y", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='autoPlay'");
			if (rs.next())
			{
				map.put("autoX", rs.getInt("buttonX"));
				map.put("autoY", rs.getInt("buttonY"));
			}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	return map;
    	
    
    	
    }
    public static HashMap<String, Integer> getpetbuton()
    {
    	HashMap<String, Integer> map=new HashMap<String, Integer>();
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='pets'");
			if (rs.next())
			{
				map.put("petsX", rs.getInt("buttonX"));
				map.put("petsY", rs.getInt("buttonY"));
				
			}} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	
	    	return map;
    }
    public static HashMap<String, Integer> getData(String robot)
    {
    	HashMap<String, Integer> map=new HashMap<String, Integer>();
    	
    	
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='pets'");
			if (rs.next())
			{
				map.put("petsX", rs.getInt("buttonX"));
				map.put("petsY", rs.getInt("buttonY"));
				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='upItem'");
			if (rs.next())
			{
				map.put("upItemX", rs.getInt("buttonX"));
				map.put("upItemY", rs.getInt("buttonY"));
				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='upgrade'");
			if (rs.next())
			{
				map.put("upX", rs.getInt("buttonX"));
				map.put("upY", rs.getInt("buttonY"));
				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='upAdd'");
			if (rs.next())
			{
				map.put("uppAddX", rs.getInt("buttonX"));
				map.put("uppAddY", rs.getInt("buttonY"));
				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='fortify'");
			if (rs.next())
			{
				map.put("fortifyX", rs.getInt("buttonX"));
				map.put("fortifyY", rs.getInt("buttonY"));
				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='qfortify'");
			if (rs.next())
			{
				map.put("qfortifyX", rs.getInt("buttonX"));
				map.put("qfortifyY", rs.getInt("buttonY"));
				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='qfConfirm'");
			if (rs.next())
			{
				map.put("qfConfirmX", rs.getInt("buttonX"));
				map.put("qfConfirmY", rs.getInt("buttonY"));
				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='upBox'");
			if (rs.next())
			{
				map.put("upBoxX", rs.getInt("buttonX"));
				map.put("upBoxY", rs.getInt("buttonY"));
				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT done FROM settings  WHERE name='autoUpgrade'");
			if (rs.next())
			{
				if(rs.getBoolean("done"))
				map.put("autoUpgrade",1);
				else
					map.put("autoUpgrade",0);

				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT done FROM settings  WHERE name='quickquickUpgradeUpgrade'");
			if (rs.next())
			{
				if(rs.getBoolean("done"))
				map.put("autoUpgrade",1);
				else
					map.put("autoUpgrade",0);

				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT done FROM settings  WHERE name='autoPill'");
			if (rs.next())
			{
				if(rs.getBoolean("done"))
				map.put("autoPill",1);
				else
					map.put("autoPill",0);

				
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='battle1'");
			if (rs.next())
			{
				map.put("battle1X", rs.getInt("buttonX"));
				map.put("battle1Y", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='enter'");
			if (rs.next())
			{
				map.put("enterX", rs.getInt("buttonX"));
				map.put("enterY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='battle2'");
			if (rs.next())
			{
				map.put("battle2X", rs.getInt("buttonX"));
				map.put("battle2Y", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='battle3'");
			if (rs.next())
			{
				map.put("battle3X", rs.getInt("buttonX"));
				map.put("battle3Y", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='battle4'");
			if (rs.next())
			{
				map.put("battle4X", rs.getInt("buttonX"));
				map.put("battle4Y", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='autoPlay'");
			if (rs.next())
			{
				map.put("autoX", rs.getInt("buttonX"));
				map.put("autoY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='card'");
			if (rs.next())
			{
				map.put("cardX", rs.getInt("buttonX"));
				map.put("cardY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='cardConfirm'");
			if (rs.next())
			{
				map.put("cardConfirmX", rs.getInt("buttonX"));
				map.put("cardConfirmY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='backpackClose'");
			if (rs.next())
			{
				map.put("backpackCloseX", rs.getInt("buttonX"));
				map.put("backpackCloseY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT * FROM pets WHERE name='"+robot+"'");
			if (rs.next())
			{				
				map.put("petX", rs.getInt("petX"));
				map.put("petY", rs.getInt("petY"));
				map.put("dropX", rs.getInt("dropX"));
				map.put("dropY", rs.getInt("dropY"));
				map.put("col1", rs.getInt("col1"));
				map.put("col2", rs.getInt("col2"));
				map.put("col3", rs.getInt("col3"));
				map.put("col4", rs.getInt("col4"));
				map.put("col5", rs.getInt("col5"));
				map.put("col6", rs.getInt("col6"));
				map.put("col7", rs.getInt("col7"));
				map.put("col8", rs.getInt("col8"));
				map.put("col9", rs.getInt("col9"));
				map.put("col10", rs.getInt("col10"));


			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='backpackOpen'");
			if (rs.next())
			{
				map.put("backpackOpenX", rs.getInt("buttonX"));
				map.put("backpackOpenY", rs.getInt("buttonY"));
			}
			
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='tekrarDene'");
			if (rs.next())
			{
				map.put("tekrarDeneX", rs.getInt("buttonX"));
				map.put("tekrarDeneY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='pillUse'");
			if (rs.next())
			{
				map.put("pillUseX", rs.getInt("buttonX"));
				map.put("pillUseY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='pill'");
			if (rs.next())
			{
				map.put("pillX", rs.getInt("buttonX"));
				map.put("pillY", rs.getInt("buttonY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT plusX,plusY FROM plus WHERE name='"+robot+"'");
			if (rs.next())
			{				System.out.println("buldu3");

				map.put("plusX", rs.getInt("plusX"));
				map.put("plusY", rs.getInt("plusY"));
			}
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT buttonX,buttonY FROM gameButtons WHERE name='confirm'");
			if (rs.next())
			{
				map.put("confirmX", rs.getInt("buttonX"));
				map.put("confirmY", rs.getInt("buttonY"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	return map;
    }
    
    public boolean isTableExist(String sTablename) throws SQLException{
        if(conn!=null)
        {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, sTablename.toUpperCase(),null);
            if(rs.next())
            {
                return true;
            }
            else
            {

                return false;

            }
        }
        else return false;
    }
    
    public static ArrayList<Map> getMaps(String robot)
    {
    	ArrayList<Map> maps=new ArrayList<Map>();
    	try {
			smt3 = conn.createStatement();
			rs = smt3.executeQuery("SELECT * FROM maps WHERE name='"+robot+"' ORDER BY sira ASC");

			while(rs.next())
			{
				maps.add(new Map(rs.getInt("chapter"), rs.getInt("sira"), rs.getInt("girissayisi"), rs.getInt("bitirmesuresi")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return maps;
    }
    
}