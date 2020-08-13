package Drug.SentimentProcess;
 
import Drug.SentimentProcess.*;
import static Drug.SentimentProcess.ProcessComments.Bipolar_DisordeF;
import static Drug.SentimentProcess.ProcessComments.Birth_ControlF;
import static Drug.SentimentProcess.ProcessComments.DepressionF;
import static Drug.SentimentProcess.ProcessComments.PainF;
import static Drug.SentimentProcess.ProcessComments.Weight_LossF;
 

public class GetFrequency {

    public static int Birth_ControlFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
     
    for (int startpoint =0; startpoint< Birth_ControlF.size(); startpoint++)
      {
         String[] foodparts = Birth_ControlF.get(startpoint).toString().split("#");
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
    
    public static int DepressionFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< DepressionF.size(); startpoint++)
      {
         String[] priceparts = DepressionF.get(startpoint).toString().split("#");
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
    
    public static int Bipolar_DisordeFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< Bipolar_DisordeF.size(); startpoint++)
      {
         String[] ambiparts = Bipolar_DisordeF.get(startpoint).toString().split("#");
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
    
    public static int PainFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< PainF.size(); startpoint++)
      {
         String[] serviceparts = PainF.get(startpoint).toString().split("#");
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
    
     public static int Weight_LossFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< Weight_LossF.size(); startpoint++)
      {
         String[] miscparts = Weight_LossF.get(startpoint).toString().split("#");
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