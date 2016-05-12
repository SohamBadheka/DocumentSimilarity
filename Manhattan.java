
public class Manhattan {
public double manhattan(double[] docVector1, double[] docVector2) {
		
		double temp = 0.0;
		for (int i = 0; i < docVector1.length; i++) 
        {
			temp+= Math.abs(docVector1[i]-docVector2[i]) ;		                  
        }
		return Math.sqrt(temp);
	}
}
