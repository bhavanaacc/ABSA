/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Semeval.SentimentProcess;

import java.math.*; 
  
class GFG { 
  
    // function that returns correlation coefficient. 
    static double correlationCoefficient(double term1, 
                                    double term2) 
    { 
       double sum_T1T2 = 0; 
        double squareSum_Term1 = 0, squareSum_term2 = 0; 
        
        // sum of X[i] * Y[i]. 
           sum_T1T2= term1*term2;
         // sum of square of array elements. 
            squareSum_Term1 = term1 * term1; 
            squareSum_term2 = term2 * term2;
         // use formula for calculating correlation  
        // coefficient. 
        double corr = (double)(6*sum_T1T2 - term1 * term2)/ 
                     (double)(Math.sqrt(( 6*squareSum_Term1 - 
                     term1 * term1) * (6*squareSum_term2 -  
                     term2 * term2))); 
        System.out.println(corr);
        return corr; 
    } 
       
    // Driver function 
    public static void main(String args[]) 
    { 
        
        // Function call to correlationCoefficient. 
        System.out.printf("%6f", 
                 correlationCoefficient(258, 77.0)); 
       
          
    } 
} 