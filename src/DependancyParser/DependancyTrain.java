package DependancyParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import master.DbconnSemeval;

class DependancyTrain {
    public static void main(String[] args) throws Exception {
        ExtractTrainFeatures();
    }
 
     public static void ExtractTrainFeatures() throws Exception {
          // String text = "the food quality was very good but peoples has not afford with charges";
         TreebankLanguagePack tlp = new PennTreebankLanguagePack();
        GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
        LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
        lp.setOptionFlags(new String[]{"-maxLength", "500", "-retainTmpSubcategories"});
        TokenizerFactory<CoreLabel> tokenizerFactory =
                PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
     
        // Db load from here  
        DbconnSemeval db= new DbconnSemeval();
        Connection conn =db.conn();
        Statement st=(Statement) conn.createStatement();
        ResultSet rs=st.executeQuery("select * from reviewtrain order by id asc");
        while(rs.next())
        { 
            int id=rs.getInt("id");
            System.out.println("id is :"+rs.getInt("id"));
            String Pdata =rs.getString(2);
            String data1=Pdata.replaceAll("[\\(\\)\\[\\]\\{\\}\\$\\:\\;\\-\\_\\!\\*\\'\\@\\#\\~\\%\\^\\&\\?\\.\\,\\+"+"\\+]","");
         String data2= data1.replaceAll("[0-9]", "");
          String data= data2.replaceAll("cannot", "cant");
            List<CoreLabel> wordList = tokenizerFactory.getTokenizer(new StringReader(data)).tokenize();
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
                    String[] inputdata=data.split("\\s");
             
                    // relationship policies filter
    	      if(relation.contains("acomp") || relation.contains("compound") || relation.contains("advcl") ||relation.contains("advmod") ||relation.contains("amod") ||relation.contains("conj") ||relation.contains("dobj") ||relation.contains("neg") ||relation.contains("nn") ||relation.contains("nsubj") ||relation.contains("rcmod")||relation.contains("nmod")||relation.contains("agent")||relation.contains("cop")||relation.contains("nsubjpass")||relation.contains("xcomp"))
              // if(!relation.contains("det")||(!relation.contains("root")))   
              {
//                 System.out.println(" token : "+ token + " , relation : "+ relation+ ", pos : "+ pos+ " , parentIndex : "+ parentIndex);
  		 System.out.println("DP Relation :"+ token + "_"+ inputdata[parentIndex-1]);
                 sb.append(token + "_"+ inputdata[parentIndex-1]+",");
                }
		
  }
  // update dependancy rules into table
         String rset= sb.toString();
          Statement stmt=(Statement) conn.createStatement();
             stmt.executeUpdate("update reviewtrain set dependancy = '"+rset+"' where id='"+id+"'");

}}}