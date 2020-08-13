package Yelp.SentimentProcess;
 
import static Yelp.SentimentProcess.ProcessComments.ambianceF;
import static Yelp.SentimentProcess.ProcessComments.foodF;
import static Yelp.SentimentProcess.ProcessComments.WorthinessF;
import static Yelp.SentimentProcess.ProcessComments.RestaurantF;
import static Yelp.SentimentProcess.ProcessComments.priceF;
import static Yelp.SentimentProcess.ProcessComments.serviceF;

public class GetFrequency {

    public static int FoodFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
     
    for (int startpoint =0; startpoint< foodF.size(); startpoint++)
      {
         String[] foodparts = foodF.get(startpoint).toString().split("#");
         String[] LemmasTokens =foodparts[1].split("\\s+");
          for (int first =0;first <LemmasTokens.length; first++)
          {
              String currentFeature =LemmasTokens[first];
              sb.append(sb);
               if(currentFeature.equalsIgnoreCase(Toekns))
                  mastercount=mastercount+1;
          }
      }
    return mastercount;
}
    
    public static int RestaurantFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< RestaurantF.size(); startpoint++)
      {
         String[] priceparts = RestaurantF.get(startpoint).toString().split("#");
         String[] LemmasTokens =priceparts[1].split("\\s+");
          for (int first =0;first <LemmasTokens.length; first++)
          {
               String currentFeature =LemmasTokens[first];
               sb.append(currentFeature);
              if(currentFeature.equalsIgnoreCase(Toekns))
                  mastercount=mastercount+1;
          }
            
      }
    return mastercount;
}
    
    public static int AmbianceFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< ambianceF.size(); startpoint++)
      {
         String[] ambiparts = ambianceF.get(startpoint).toString().split("#");
         String[] LemmasTokens =ambiparts[1].split("\\s+");
          for (int first =0;first <LemmasTokens.length; first++)
          {
               String currentFeature =LemmasTokens[first];
               sb.append(currentFeature);
              if(currentFeature.equalsIgnoreCase(Toekns))
                  mastercount=mastercount+1;
          }
            
      }
    return mastercount;
}
    
    public static int ServiceFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< serviceF.size(); startpoint++)
      {
         String[] serviceparts = serviceF.get(startpoint).toString().split("#");
         String[] LemmasTokens =serviceparts[1].split("\\s+");
          for (int first =0;first <LemmasTokens.length; first++)
          {
               String currentFeature =LemmasTokens[first];
               sb.append(currentFeature);
              if(currentFeature.equalsIgnoreCase(Toekns))
                  mastercount=mastercount+1;
          }
            
      }
    return mastercount;
}
     public static int priceFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< priceF.size(); startpoint++)
      {
         String[] miscparts = priceF.get(startpoint).toString().split("#");
         String[] LemmasTokens =miscparts[1].split("\\s+");
          for (int first =0;first <LemmasTokens.length; first++)
          {
               String currentFeature =LemmasTokens[first];
               
              if(currentFeature.equalsIgnoreCase(Toekns))
                  mastercount=mastercount+1;
          }
            
      }
    return mastercount;
}
    
     public static int worthnessFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< WorthinessF.size(); startpoint++)
      {
         String[] miscparts = WorthinessF.get(startpoint).toString().split("#");
         String[] LemmasTokens =miscparts[1].split("\\s+");
          for (int first =0;first <LemmasTokens.length; first++)
          {
               String currentFeature =LemmasTokens[first];
               
              if(currentFeature.equalsIgnoreCase(Toekns))
                  mastercount=mastercount+1;
          }
            
      }
    return mastercount;
}
}