

import java.io.FileNotFoundException;
import java.io.IOException;

public class DocumentSimilarity{
    
  
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        DocReader dr = new DocReader();
        
        dr.parseFiles("Path of the folder where your documents are available");
        dr.tfIdfCalculator(); //tfidf calculations
        dr.getCosine(); // cosine similarity calculations
        dr.getEuclidean(); //Euclidean similarity calculations
        dr.getSquareEuclidean(); //Squared euclidean similarity calculations
        dr.getManhattan(); //Manhattan similarity calculations
        dr.getTanimoto(); // Tanimoto similarity calculations
    }
}
