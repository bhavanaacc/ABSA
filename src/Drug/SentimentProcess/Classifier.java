package Drug.SentimentProcess;
import Semeval.SentimentProcess.*;
import java.util.HashMap;
import java.util.Map;

public class Classifier {
    Map<String, Integer> wordMap = new HashMap<String, Integer>();

    public void incCount(String word)  {
        Integer oldCount = wordMap.get(word);
        wordMap.put(word, oldCount == null ? 1 : oldCount + 1);
    }

    double getSimilarityWith(Classifier otherVector) {
        double innerProduct = 0;
        for(String w: this.wordMap.keySet()) {
            innerProduct += this.getCount(w) * otherVector.getCount(w);
        }
        return innerProduct / (this.getNorm() * otherVector.getNorm());
    }

    double getNorm() {
        double sum = 0;
        for (Integer count : wordMap.values()) {
            sum += count * count;
        }
        return Math.sqrt(sum);
    }
    int getCount(String word) {
        return wordMap.containsKey(word) ? wordMap.get(word) : 0;
    }
    public double GetNBScore(String vector1, String vector2) {
        String doc1 = vector1;
        String doc2 = vector2;
        System.out.println("Classification 1 = " + doc1);
        System.out.println("Classification 2 = " + doc2);
        Classifier v1 = new Classifier();
        for(String w:doc1.split("[^a-zA-Z]+")) {
            v1.incCount(w);
        }

        Classifier v2 = new Classifier();
        for(String w:doc2.split("[^a-zA-Z]+")) {
            v2.incCount(w);
        }
       // System.out.println("Classification Similarity = " + v1.getSimilarityWith(v2));
        
        return v1.getSimilarityWith(v2);
    }
public static void main(String args[])
{
           Classifier cs=new Classifier();
           //Note param 1 is users input and Param 2 from training DB 
           cs.GetNBScore("model,data,mine", "model,data,paper,mine,set,propose,collection,data,user,privacy,data,information,propose,network,analysis,network,network,data,privacy,large,set,data,model,network,propose,data,privacy,information,propose,user,data,propose,user,network,network,propose,data,network,process,data,process,secur,user,network,information,information,privacy,paper,propose,mine,user,data,privacy,data,network,propose,multiple,character,network,propose,paper,data,propose,secur,storage,big,model,driven,source,science,revolution,mine,data,concern,large,volume,complex,grow,set,multiple,autonomou,fast,develop,network,storage,data,user,propose,storage,network,user,propose,model,interest,data,propose,secur,user,information,secur,user,data,aggregation,large,propose,propose,information,data,network,propose,user,mine,set,domain,information,user,model,data,paper,data,storage,user,secur,paper,propose,privacy,information,data,develop,user,privacy,information,user,privacy,information,user,privacy,information,storage,secur,issue,propose,information,present,interest,large,involve,network,user,user,present,information,data,develop,user,information,privacy,model,propose,information,data,model,storage,set,data,source,data,propose,user,paper,propose,interest,user,privacy,secur,driven,privacy,paper,present,data,network,propose,secur,data,user,set,storage,capac,capac,network,model,user,propose,secur,network,issue,data,issue,user,model,network,capac,paper,network,model,data,multiple,privacy,data,set,data,large,user,data,privacy,user,data,privacy,paper,present,data,model,propose,data,set,privacy,fast,data,present,secur,user,paper,interest,privacy,propose,set,data,data,propose,data,privacy,big,set,model,information,user,propose,information,interest,network,secur,engine,set,secur,data,propose,mine,propose,user,present,secur,paper,secur,propose,network,user,engine,user,privacy,network,analyze,propose,data,privacy,user,source,information,user,paper,information,user,paper,issue,network,propose,data,propose,network,model,data,process,concern,user,data,big,user,");
}
}