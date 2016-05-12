

import java.io.BufferedReader;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class DocReader {


    private List<String[]> docsArray = new ArrayList<String[]>(); //Each document will be stored in this
    private List<String> termsDictionary = new ArrayList<String>(); //Each individual term will be stored in this
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>(); //for VSM(Vector space model) 

    public void parseFiles(String filePath) throws FileNotFoundException, IOException {
        File[] allfiles = new File(filePath).listFiles();
       
        int noOfFiles = 0;
        System.out.println("Files in the folder are ");
        for (File f : allfiles) {
        	if( f.getName().endsWith(".txt")){
        		
	        	System.out.print(f.getName()+", ");
	        	noOfFiles++;
	        	
        	}
       }
        System.out.println("\n No of files "+noOfFiles);
        BufferedReader in = null;
        for (File f : allfiles) {
            if (f.getName().endsWith(".txt")) {
                in = new BufferedReader(new FileReader(f));
                StringBuilder sb = new StringBuilder();
                String s = null;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                }
                String[] tokenizer = sb.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms, "just like whitespace analyzer"
                System.out.println("docsArray =>");
                for(int i=0; i<tokenizer.length;i++)
                System.out.print(" "+tokenizer[i]);// Prints every document in a string array 
                for (String term : tokenizer) {
                    if (!termsDictionary.contains(term)) {  // Same terms should be ignored, basic filtering
                        termsDictionary.add(term);
                    }
                }
                docsArray.add(tokenizer);// Those individual docs are stored in a form of a string in the array !
                
            }
            System.out.println("Terms dictionary "+termsDictionary);
            
           
        }
    	
        
        System.out.println(" No of unique words are "+termsDictionary.size());
        
    }

    
    public void tfIdfCalculator() {
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term requency inverse document frequency        
        for (String[] docTermsArray : docsArray) {
            double[] tfidfvectors = new double[termsDictionary.size()]; // So there will be as many tfidf as the individual terms because it is "tdiff(d1, tn), tfidf(d2, tn)...etc" 
            int count = 0;
            for (String terms : termsDictionary) {
                tf = new TfIdf().tfCalculator(docTermsArray, terms);
                idf = new TfIdf().idfCalculator(docsArray, terms);
                tfidf = tf * idf;
                tfidfvectors[count] = tfidf;
                count++;
            }
            tfidfDocsVector.add(tfidfvectors);  //storing document vectors;
            System.out.println("------------Vectors-----------");
            for(int i = 0; i<tfidfvectors.length;i++)
            	System.out.println(tfidfvectors[i]);
        }
    }

    /**
     * Method to calculate cosine similarity between all the documents.
     */
    public void getCosineSimilarity() {
        for (int i = 0; i < tfidfDocsVector.size(); i++) {
            for (int j = 0; j < tfidfDocsVector.size(); j++) {
                System.out.println("Distance between doc " + i + " and doc " + j + "  =  "
                                   + new CosineSimilarity().cosineSimilarity
                                       (
                                         tfidfDocsVector.get(i), 
                                         tfidfDocsVector.get(j)
                                       )
                                  );
            }
        }
    }

/**
     * Method to calculate euclidean similarity between all the documents.
     */
    public void getEuclidean(){
    	System.out.println("Distance measure by Euclidean Distance ");
    	
    	for (int i = 0; i < tfidfDocsVector.size(); i++) {
            for (int j = 0; j < tfidfDocsVector.size(); j++) {
                System.out.println("between " + i + " and " + j + "  =  "
                                   + new Euclidean().eucli
                                       (
                                         tfidfDocsVector.get(i), 
                                         tfidfDocsVector.get(j)
                                       )
                                  );
            }
        }
    	System.out.println("---------------------");
    }
    /**
     * Method to calculate squaredEuclidean similarity between all the documents.
     */
    
    public void getSquareEuclidean(){
    	System.out.println("Distance measure by SquaredEuclidean Distance ");
    	
    	for (int i = 0; i < tfidfDocsVector.size(); i++) {
            for (int j = 0; j < tfidfDocsVector.size(); j++) {
                System.out.println("between " + i + " and " + j + "  =  "
                                   + new SquaredEuclidean().squareEucli
                                       (
                                         tfidfDocsVector.get(i), 
                                         tfidfDocsVector.get(j)
                                       )
                                  );
            }
        }
    	System.out.println("---------------------");
    }
    /**
     * Method to calculate Manhattan similarity between all the documents.
     */
    public void getManhattan(){
    	System.out.println("Distance measure by Manhattan Distance ");
    	
    	for (int i = 0; i < tfidfDocsVector.size(); i++) {
            for (int j = 0; j < tfidfDocsVector.size(); j++) {
                System.out.println("between " + i + " and " + j + "  =  "
                                   + new Manhattan().manhattan
                                       (
                                         tfidfDocsVector.get(i), 
                                         tfidfDocsVector.get(j)
                                       )
                                  );
            }
        }
    	System.out.println("---------------------");
    }
    /**
     * Method to calculate Tanimoto similarity between all the documents.
     */
    public void getTanimoto(){
    	System.out.println("Distance measure by Tanimoto Distance ");
    	
    	for (int i = 0; i < tfidfDocsVector.size(); i++) {
            for (int j = 0; j < tfidfDocsVector.size(); j++) {
                System.out.println("between " + i + " and " + j + "  =  "
                                   + new Tanimoto().tanimoto
                                       (
                                         tfidfDocsVector.get(i), 
                                         tfidfDocsVector.get(j)
                                       )
                                  );
            }
        }
    	System.out.println("---------------------");
    }
}

   
