/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yelp.SentimentProcess;

import master.DbconnYelp;
import com.mysql.jdbc.Statement;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreePrint;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class DependancyFeaturesExtraction {
 
    public static void main(String[] args)
    {
    try{
        DbconnYelp db= new DbconnYelp();
        Connection conn =db.conn();
        Statement st=(Statement) conn.createStatement();
        ResultSet rs=st.executeQuery("select * from reviewtrain order by id asc");
        while(rs.next())
        { 
            int id=rs.getInt("id");
            System.out.println("id is :"+rs.getInt("id"));
            String Pdata =rs.getString(2);
            String data=Pdata.replaceAll("[\\(\\)\\[\\]\\{\\}\\$\\:\\;\\-\\_]","");
           String Result= ExtractFeatures(data);
            
             Statement stmt=(Statement) conn.createStatement();
             stmt.executeUpdate("update reviewtrain set dependancy = '"+Result+"' where id='"+id+"'");
       
        }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public static String ExtractFeatures(String text) throws Exception {
        // String text = "the food quality was very good but peoples has not afford with charges";
         TreebankLanguagePack tlp = new PennTreebankLanguagePack();
        GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
        LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
        lp.setOptionFlags(new String[]{"-maxLength", "500", "-retainTmpSubcategories"});
        TokenizerFactory<CoreLabel> tokenizerFactory =
                PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
        
        List<CoreLabel> wordList = tokenizerFactory.getTokenizer(new StringReader(text)).tokenize();
         System.out.println("input");
        System.out.println(wordList);
        Tree tree = lp.apply(wordList); 
//         System.out.println("tree");
//        System.out.println(tree);
        GrammaticalStructure gs = gsf.newGrammaticalStructure(tree);
        Collection<TypedDependency> tdl = gs.typedDependenciesCCprocessed(true);
         System.out.println("tdl");
        System.out.println(tdl);
        System.out.println("splitting");
    //	  Tree tree=parser.getBestParse();
    	  List<TaggedWord> taggedSent=tree.taggedYield();
    	  StringBuilder sb=new StringBuilder();
    	 for (TypedDependency dependency : tdl) {
    		    int nodeIndex=dependency.dep().index();
    		    int parentIndex=dependency.gov().index();
    		    String relation=dependency.reln().toString();
    		    String token=taggedSent.get(nodeIndex - 1).word();
    		    String pos=taggedSent.get(nodeIndex - 1).tag();
                    String[] inputdata=text.split("\\s");
    	       if(relation.contains("acomp") || relation.contains("compound") || relation.contains("advcl") ||relation.contains("advmod") ||relation.contains("amod") ||relation.contains("conj") ||relation.contains("dobj") ||relation.contains("neg") ||relation.contains("nn") ||relation.contains("npadvmod") ||relation.contains("nsubj") ||relation.contains("prepc") ||relation.contains("rcmod")||relation.contains("nmod"))
               {
//                 System.out.println(" token : "+ token + " , relation : "+ relation+ ", pos : "+ pos+ " , parentIndex : "+ parentIndex);
//    		 System.out.println("DP Relation :"+ token + "_"+ inputdata[parentIndex-1]);
                 sb.append(token + "_"+ inputdata[parentIndex-1]+",");
                }
		
  }
         return sb.toString();
}
}