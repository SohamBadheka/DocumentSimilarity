package com.clustering.kmeans;
public class Tanimoto {
	public double tanimoto(double[] docVector1, double[] docVector2) {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double tanimoto = 0.0;

        for (int i = 0; i < docVector1.length; i++) 
        {
            dotProduct += docVector1[i] * docVector2[i];  //a.b
            magnitude1 += Math.pow(docVector1[i], 2);  //(a^2)
            magnitude2 += Math.pow(docVector2[i], 2); //(b^2)
        }

        magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
        magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)

        if (magnitude1 != 0.0 | magnitude2 != 0.0) {
            tanimoto = dotProduct / (magnitude1 + magnitude2-dotProduct);
        } else {
            return 0.0;
        }
        return tanimoto;
    }
}
