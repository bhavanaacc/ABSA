
package Classifiers;

import static edu.stanford.nlp.util.SystemUtils.run;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.rules.JRip;
import weka.classifiers.rules.PART;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.WekaPackageManager;
 
public class Classifiers {
    
public static double percentDOS;
 public static double percentU2R;
 public static double percentR2L;
 public static double percentProbe;
    public int Execute(String train, String test, String classifierlist, int method) throws FileNotFoundException, IOException, Exception {
        // TODO code application logic hereInstances trainset=new Instances(new BufferedReader(new FileReader("C:/project/traindataset.arff")));
        int rval=0; 
        int _mtype=method; 
        boolean T=false;
        try
        { rval=1;
            String parts []=classifierlist.split("#");
            if(true)
            {
                System.out.println("First Classifier \t"+parts[0]);
           // System.out.println("Second Classifier \t"+parts[1]);
//                System.out.println("Third Classifier \t"+parts[2]);
//                System.out.println("Fourth Classifier \t"+parts[3]);
//                System.out.println("Fifth Classifier \t"+parts[4]);
            int correctlyPredicted[] = new int[5];
            ArffLoader al = new ArffLoader();
            al.setFile(new File(train));
            Instances inst = al.getDataSet();
            inst.setClassIndex(inst.numAttributes()-1);
            
            ArffLoader alTest = new ArffLoader();
            alTest.setFile(new File(test));
            Instances instTest = alTest.getDataSet();
            instTest.setClassIndex(instTest.numAttributes()-1);
            //instTest.setClassMissing();
            
NaiveBayes nb = null;
JRip nb1 = null;
MultilayerPerceptron nb2 = null;
J48 nb3 = null;
PART nb4 = null;
BayesNet nb5 = null;
IBk nb6 = null;
SMO nb7 = null;
LibSVM svm=null;
NaiveBayesMultinomial nbobj =null;
//Load SVM path
WekaPackageManager.loadPackages( false, true, false );
AbstractClassifier classifier = ( AbstractClassifier ) Class.forName(
            "weka.classifiers.functions.LibSVM" ).newInstance();


       if(classifierlist.contains("svm"))
{   T=true;
            svm=new LibSVM();
            svm.buildClassifier(instTest);
    
    Evaluation evaluation = new Evaluation(instTest);
    evaluation.crossValidateModel(classifier, instTest, 3, new Random(1));
    ///System.out.println(evaluation.toSummaryString());
    printMeasures(evaluation, _mtype,T);
}
   
   if(classifierlist.contains("NaiveBayes")){
             nb = new NaiveBayes();
             nb.buildClassifier(instTest);
        T=false;
             Evaluation evaluation = new Evaluation(instTest);
    evaluation.crossValidateModel(classifier, instTest, 3, new Random(1));
    System.out.println(evaluation.toSummaryString());
    printMeasures(evaluation,_mtype,T);
}
       
            double correctClass = 0;
            double records = 0;
            int i = 0;
            //attributes.remove();
            for (i = 0; i < instTest.numInstances(); i++) 
            {
                records++;
                double pred = 0, pred1 = 0, pred2 = 0,pred3=0,pred4=0,pred5=0,pred6=0,pred7=0;
                int classArray[] = new int[5];
                 
                if(classifierlist.contains("svm")){
                pred = svm.classifyInstance(instTest.instance(i));
                classArray[(int)pred]++;}
               
                if(classifierlist.contains("NaiveBayes")){
                pred = nb.classifyInstance(instTest.instance(i));
                classArray[(int)pred]++;}
                
                int maxClass = 0;
                for(int k = 1;  k < classArray.length; k++)
                {
                	if(classArray[k] > classArray[maxClass])
        			{
                		 maxClass = k;
        			}
                }
                
                String actualClass = instTest.classAttribute().value((int) instTest.instance(i).classValue());
                String predictedClass = instTest.classAttribute().value((int)maxClass);
                if(actualClass.equalsIgnoreCase(predictedClass))
                {
                	correctlyPredicted[maxClass]++;
                    correctClass++;
                }
            }
            System.out.println("Correctly classified : " + correctClass);
            System.out.println("No of records : " + records);            
            System.out.println("Accuracy : " + (correctClass/(records)*100));
            
            for(int k = 0; k < correctlyPredicted.length; k++){
            	String predictedClass = instTest.classAttribute().value(k);
            	System.out.println(predictedClass + " Correctly Classified Instances : " + correctlyPredicted[k]);
            }
                 
           }
            else
            {
              rval=0; 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

       return rval;
    }
    
        public static void printMeasures(final Evaluation eval, int type, boolean R) {

    final List<String> cat = EntityClassMap.entityClasses;
    for ( String cl : EntityClassMap.entityClasses) {
        System.out.println("Class is :"+cl);
        Eva evalo=new Eva();
        int pval=cat.indexOf(cl);
      final double p = evalo.precision(cat.indexOf(cl),type,R);
      final double r = evalo.recall(cat.indexOf(cl),type,R);
      final double f1 = evalo.fMeasure(p,r);

      System.out.println("=== classes ===");
      System.out.println("class: " + cl);
      System.out.println("fMeasure: " + f1);
      System.out.println("precision: " + p);
      System.out.println("recall: " + r);
    }
  }
}
