

import java.util.List;


public class TfIdf {
    
  
    public double tfCalculator(String[] totalterms, String termToCheck) {
    	//System.out.println(totalterms + " and  "+termToCheck);
    	
        double count = 0;  
        for (String str : totalterms) {
            if (str.equalsIgnoreCase(termToCheck)) {
                count++;
            }
        }
        return count / totalterms.length;
    }
   
    public double idfCalculator(List<String[]> allTerms, String termToCheck) {
        double count = 0;
        for (String[] str2 : allTerms) {
            for (String str : str2) {
                if (str.equalsIgnoreCase(termToCheck)) {
                    count++;
                    break;
                }
            }
        }
        return Math.log(allTerms.size() / count);
    }

}
