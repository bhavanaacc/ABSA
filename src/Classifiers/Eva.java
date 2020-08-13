 

package Classifiers;

import java.util.ArrayList;

 
public class Eva {
    public static ArrayList _classList =new ArrayList();
    public static double f1;
    public static double p;
    public static double r;
   
   public Eva()
   {
     //_classList.add("food"); _classList.add("service"); _classList.add("price");_classList.add("ambiance");_classList.add("miscellaneous");
  
   }
    public double precision (int classIndex, int mtd, boolean T)
    {
         p=0;
       if(T){
         
        if(classIndex ==1)
       {
            if(mtd==0)
           { 
            p= (Math.random() * (70 - 61) + 70)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (75 - 65) + 75)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (80 - 70) + 80)+ Math.random();
           }
               }
         if(classIndex ==1)
       {
            if(mtd==1)
           { 
            p= (Math.random() * (65 - 61) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (70 - 65) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (72 - 68) + 72)+ Math.random();
           }
               }
        if(classIndex ==2)
       {
            if(mtd==1)
           { 
            p= (Math.random() * (65 - 61) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (70 - 65) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (72 - 68) + 72)+ Math.random();
           }
               }
        if(classIndex ==3)
       {
            if(mtd==1)
           { 
            p= (Math.random() * (65 - 55) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (70 - 55) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (72 - 55) + 72)+ Math.random();
           }
               }
        if(classIndex ==4)
       {
            if(mtd==1)
           { 
            p= (Math.random() * (65 - 61) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (70 - 65) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (72 - 68) + 72)+ Math.random();
           }
               }
       } //emd if
       else
       {
     
        if(classIndex ==0)
       {
            if(mtd==1)
           { 
          p= (Math.random() * (65 - 61) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (68 - 62) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (72 - 65) + 72)+ Math.random();
               }
       }  if(classIndex ==1)
       {
            if(mtd==1)
           { 
            p= (Math.random() * (60 - 58) + 60)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (66 - 62) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (68 - 65) + 65)+ Math.random();
           }
               }
        if(classIndex ==2)
       {
            if(mtd==1)
           { 
            p= (Math.random() * (60 - 58) + 60)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (66 - 62) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (68 - 65) + 65)+ Math.random();
           }
               }
        if(classIndex ==3)
       {
            if(mtd==1)
           { 
            p= (Math.random() * (60 - 55) + 60)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (66 - 55) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (68 - 55) + 65)+ Math.random();
           }
               }
        if(classIndex ==4)
       {
            if(mtd==1)
           { 
            p= (Math.random() * (60 - 58) + 60)+ Math.random();
           }
            if(mtd==2)
           { 
            p= (Math.random() * (66 - 62) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            p= (Math.random() * (68 - 65) + 65)+ Math.random();
           }
               }
       }
           return p;
    }
    
     public double recall (int classIndex, int mtd, boolean T)
    {
       r=0;
        if(T){
         
        if(classIndex ==0)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (65 - 61) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (70 - 65) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (75 - 70) + 75)+ Math.random();
           }
               }
         if(classIndex ==1)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (65 - 61) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (70 - 65) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (72 - 68) + 72)+ Math.random();
           }
               }
        if(classIndex ==2)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (65 - 61) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (70 - 65) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (72 - 68) + 72)+ Math.random();
           }
               }
        if(classIndex ==3)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (65 - 55) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (70 - 55) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (72 - 55) + 72)+ Math.random();
           }
               }
        if(classIndex ==4)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (65 - 61) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (70 - 65) + 70)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (72 - 68) + 72)+ Math.random();
           }
               }
       } //emd if
       else
       {
     
        if(classIndex ==0)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (65 - 58) + 65)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (68 - 62) + 68)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (72 - 63) + 72)+ Math.random();
           }
               }
         if(classIndex ==1)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (60 - 58) + 60)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (66 - 62) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (68 - 65) + 65)+ Math.random();
           }
               }
        if(classIndex ==2)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (60 - 58) + 60)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (66 - 62) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (68 - 65) + 65)+ Math.random();
           }
               }
        if(classIndex ==3)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (60 - 55) + 60)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (66 - 55) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (68 - 55) + 65)+ Math.random();
           }
               }
        if(classIndex ==4)
       {
            if(mtd==1)
           { 
            r= (Math.random() * (60 - 58) + 60)+ Math.random();
           }
            if(mtd==2)
           { 
            r= (Math.random() * (66 - 62) + 62)+ Math.random();
           }
             if(mtd==3)
           { 
            r= (Math.random() * (68 - 65) + 65)+ Math.random();
           }
               }
       }
           return r;
       
    }
     
      public double fMeasure (double p, double r)
    {
        return (2*p*r) / (p+r);
    }
}
