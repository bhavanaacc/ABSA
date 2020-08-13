/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Drug.SentimentProcess;

import Semeval.SentimentProcess.*;

/**
 *
 * @author Sunsoft
 */
public class calculateDistance {
    
public static int GetSimilarityForSymptoms(String features1, String features2) 
{   // Trim and remove duplicate spaces
    int percentage = 0;
    features1 = features1.trim().replaceAll("\\s+", " ");
    features2 = features2.trim().replaceAll("\\s+", " ");
    percentage=(int) (100 - (float) LevenshteinDistance(features1, features2) * 100 / (float) (features1.length() + features2.length()));
    return percentage;
}


public static int LevenshteinDistance(String Featureset1 , String Featureset2) {

    int len0 = Featureset1.length() + 1;
    int len1 = Featureset2.length() + 1;  
    // the array of distances
    int[] cost = new int[len0];
    int[] newcost = new int[len0];

    // initial cost of skipping prefix in String s0
    for (int i = 0; i < len0; i++)
        cost[i] = i;

    // dynamically computing the array of distances

    // transformation cost for each letter in s1
    for (int j = 1; j < len1; j++) {

        // initial cost of skipping prefix in String s1
        newcost[0] = j - 1;

        // transformation cost for each letter in s0
        for (int i = 1; i < len0; i++) {

            // matching current letters in both strings
            int match = (Featureset1.charAt(i - 1) == Featureset2.charAt(j - 1)) ? 0 : 1;

            // computing cost for each transformation
            int cost_replace = cost[i - 1] + match;
            int cost_insert = cost[i] + 1;
            int cost_delete = newcost[i - 1] + 1;

            // keep minimum cost
            newcost[i] = Math.min(Math.min(cost_insert, cost_delete),
                    cost_replace);
        }

        // swap cost/newcost arrays
        int[] swap = cost;
        cost = newcost;
        newcost = swap;
    }

    // the distance is the cost for transforming all letters in both strings
    return cost[len0 - 1];
}

 public static void main(String args [])
    {
        calculateDistance nn=new calculateDistance();
        int dis=nn.GetSimilarityForSymptoms("","");
        System.out.println(dis);
}
}
