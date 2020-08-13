package Drug.DependancyParser;

import static Drug.DependancyParser.Featureselection.Birth_ControlF ;
import static Drug.DependancyParser.Featureselection.DepressionF;
import static Drug.DependancyParser.Featureselection.PainF;
import static Drug.DependancyParser.Featureselection.Bipolar_DisordeF ;
import static Drug.DependancyParser.Featureselection.Weight_LossF ;


public class GetDependancyFrequency {

    public static int BCFrequency(String Toekns) {
      int mastercount =0;
  try{
          StringBuilder sb=new StringBuilder();
     
    for (int startpoint =0; startpoint< Birth_ControlF.size(); startpoint++)
      {
           String[] BCparts = Birth_ControlF.get(startpoint).toString().split("#");
         String[] LemmasTokens =BCparts[1].split(",");
          if(LemmasTokens.length <=0) LemmasTokens[0]="";
          for (int first =0;first <LemmasTokens.length; first++)
          {
              String currentFeature =LemmasTokens[first];
              if(currentFeature.equalsIgnoreCase(Toekns))
                  mastercount=mastercount+1;
          }
      }
     }
     catch(Exception e)
     {
         System.out.println(e);
     }
    return mastercount;
}
    
    public static int DepFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< DepressionF.size(); startpoint++)
      {
         String[] Depparts = DepressionF.get(startpoint).toString().split("#");
         String[] LemmasTokens =Depparts[1].split(",");
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
    
    public static int BDFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< Bipolar_DisordeF.size(); startpoint++)
      {
         String[] BDparts = Bipolar_DisordeF.get(startpoint).toString().split("#");
         String[] LemmasTokens =BDparts[1].split(",");
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
    
    public static int WLFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< Weight_LossF.size(); startpoint++)
      {
         String[] WLparts = Weight_LossF.get(startpoint).toString().split("#");
         String[] LemmasTokens =WLparts[1].split(",");
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
    
     public static int painFrequency(String Toekns) {
     int mastercount =0;
     StringBuilder sb=new StringBuilder();
    for (int startpoint =0; startpoint< PainF.size(); startpoint++)
      {
         String[] painparts = PainF.get(startpoint).toString().split("#");
         String[] LemmasTokens =painparts[1].split(",");
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