package Semeval.SentimentProcess;
 
import static Semeval.SentimentProcess.ProcessComments.ambianceF;
import static Semeval.SentimentProcess.ProcessComments.foodF;
import static Semeval.SentimentProcess.ProcessComments.miscellaneousF;
import static Semeval.SentimentProcess.ProcessComments.priceF;
import static Semeval.SentimentProcess.ProcessComments.serviceF;

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
    
    public static int PriceFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< priceF.size(); startpoint++)
      {
         String[] priceparts = priceF.get(startpoint).toString().split("#");
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
    
     public static int miscellaneousFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< miscellaneousF.size(); startpoint++)
      {
         String[] miscparts = miscellaneousF.get(startpoint).toString().split("#");
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