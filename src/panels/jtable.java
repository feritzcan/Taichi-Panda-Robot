package panels;
  

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

import db.ConnectionDerby;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;


//BU CLASS KİTAPLARI TABLO HALİNDE OLUŞTURMAK İÇİN OLDU
//BU METHODLARI BİZ KULLANMAYACAĞIZ, TABLO OLUŞTURULDUĞU ANDA CLASS BU METHODLARDAN TABLO GÖSTERİMİNİ DÜZENLEYECEK
public class jtable extends AbstractTableModel{
  
	//TABLONUN KOLONLARI
  private String[] kolonlar=
    {"robots"};

  

  
	  

  public int getColumnCount(){
    return 1;
  }        
  //DBDEN TOPLAM ROW SAYISINI ÇEKECEZ
  public int getRowCount(){
	  
	  

		   int numberRow = 0;
		   
		try{
			
			//KİTAPLARDAKİ SATIR SAYISINI SEÇ
		    String sql = "select count(*) from robots";
		    ResultSet rs = ConnectionDerby.executeQuery(sql);
		    //
		    while(rs.next()){
		        numberRow = rs.getInt(1);
		    }

		}catch (Exception ex){
		    System.out.println(ex.getMessage());
		}
		
		return numberRow;
		}      
     
  // 1.KOLON İSMİ 2. KOLON İSMİ VS VS
  public String getColumnName(int column){
    return kolonlar[column];
  }
  // TABLO BİR MATRİS, TABLE CLASS'I BU METHOD İLE HER BİR POZİSYONDAKİ DATAYI ÇEKECEK
  public String getValueAt(int satir, int sutun){
   
	String robots="";
	
	try {
		
		
		
		String query = "SELECT * FROM robots";
		ResultSet rs = ConnectionDerby.executeQuery(query);
		if(rs.next())
		{
			for(int a=0;a<satir;a++)
			{
				rs.next();
			}
			robots=rs.getString(1);
			
		}



	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
		
	
	
    
    
    return robots;
    
  }}  