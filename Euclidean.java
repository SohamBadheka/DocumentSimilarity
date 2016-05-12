
public class Euclidean {
	public double eucli(double[] docVector1, double[] docVector2) {
		
		double temp = 0.0;
		for (int i = 0; i < docVector1.length; i++) 
        {
			temp+= Math.pow((docVector1[i]-docVector2[i]), 2);		                  
        }
		//eucli= Math.sqrt(mag1);		
		return Math.sqrt(temp);
	}
}
