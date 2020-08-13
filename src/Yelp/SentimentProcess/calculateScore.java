package Yelp.SentimentProcess;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.util.Scanner;
/**
 *
 * @author sunsoft
 */
public class calculateScore {
    private static Statement st;
    static int maxno;
    int posve=0;
    int negve=0,finalChecking=0;
    String neutral;
   
    public String Calcscore(String data) throws FileNotFoundException
    {
        boolean flag=false;
        Scanner scposve,scnegve,prrp;
        String finalCheck=null;
        String str = null;
    StringBuilder sb = new StringBuilder();
    StringBuilder sb1 = new StringBuilder();
    
         String [] tokens = data.split("\t");// \\p is use for space and {Alpha for (')eg it's}
        
   for(String s : tokens){
	   scposve=new Scanner(new File("F:\\+ve.txt"));
	   scnegve = new Scanner(new File("F:\\-ve.txt"));
	   
       
    while(scposve.hasNext())
    {   
        if(scposve.next().equals(s)){
         
        	posve++;
            break;
        }
        else 
        {
        	
        	
        	
        }
       
    }
    while(scnegve.hasNext())
    {   
        if(scnegve.next().equals(s)){
          
        	negve++;
        	finalChecking++;
        	
        	sb.append(s+"\t");
        	
        	
            break;
        }
        else 
        {
        	
        }
       
    }
   

    if(finalChecking==2){
    	
    	
    	negve=negve-2;
    	posve++;
    	
    	
    }
    
     
   }
    return ""+posve+"\t"+negve;
}
   public static void main(String args[]) throws FileNotFoundException
   {
       
   }

}

    
    

