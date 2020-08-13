package Drug.SentimentProcess;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Semeval.SentimentProcess.*;
import com.mysql.jdbc.Statement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemoveStopwords {
    private static Statement st;
    static int maxno;
    public String RemoveWords(String data) throws FileNotFoundException
    {
        boolean flag=false;
        Scanner sc;
        String str = null;
        StringBuilder sb = new StringBuilder();
    
         String [] tokens = data.split("\\P{Alpha}+");// \\p is use for space and {Alpha for (')eg it's}
        
   for(String s : tokens){
    sc=new Scanner(new File("F:\\stopwords.txt"));
       
    while(sc.hasNext())
    {   
        if(sc.next().equalsIgnoreCase(s)){
            flag = true;
            break;
        }
        else
        {
            flag=false;
        }
       
    }  
      if(flag==false)
        {
        
        sb.append(s+"\t");
        }
   }
    return sb.toString();
}
    

}

    
    

