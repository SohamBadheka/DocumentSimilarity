

public class SquaredEuclidean {
public double squareEucli(double[] docVector1, double[] docVector2) {
		
		double temp = 0.0;
		for (int i = 0; i < docVector1.length; i++) 
        {
			temp+= Math.pow((docVector1[i]-docVector2[i]), 2);		                  
        }
		return temp;
	}
}
