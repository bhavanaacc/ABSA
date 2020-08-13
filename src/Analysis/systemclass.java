/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import java.util.ArrayList;
public class systemclass {

      
    
    public static void Refresh(int no) {
        
      
        ArrayList obj =new ArrayList();
        
        String[] set1= obj.get(0).toString().split("#");
        String[] set2= obj.get(1).toString().split("#");
        String[] set3= obj.get(2).toString().split("#");
        String[] set4= obj.get(3).toString().split("#");
        String[] set5= obj.get(4).toString().split("#");
        
        chk1.FoodTP = Double.parseDouble(set1[0]);
        chk1.FoodFP = Double.parseDouble(set1[1]);
        chk1.FoodFN = Double.parseDouble(set1[2]);
        
         chk1.ServiceTP = Double.parseDouble(set2[0]);
        chk1.ServiceFP = Double.parseDouble(set2[1]);
        chk1.ServiceFN = Double.parseDouble(set2[2]);
        
         chk1.AmbTP = Double.parseDouble(set3[0]);
        chk1.AmbFP = Double.parseDouble(set3[1]);
        chk1.AmbFN = Double.parseDouble(set3[2]);
        
         chk1.PriceTP = Double.parseDouble(set4[0]);
        chk1.PriceFP = Double.parseDouble(set4[1]);
        chk1.PriceFN = Double.parseDouble(set4[2]);
        
         chk1.MiscTP = Double.parseDouble(set5[0]);
        chk1.MiscFP = Double.parseDouble(set5[1]);
        chk1.MiscFN = Double.parseDouble(set5[2]);
        
    }
    
   
}  
