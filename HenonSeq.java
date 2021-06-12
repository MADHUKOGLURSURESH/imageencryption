package Sequence;
import static java.lang.Math.pow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class HenonSeq  {
	 
	int limit;												//number of elements to generate in a sequence
	double alpha;												// Parameter used in Tent map
	double beta;
	public ArrayList <Double> hseqx = new ArrayList <Double> (); 	//Arraylist to store the chaotic sequence 
	public ArrayList <Double> hseqy = new ArrayList <Double> ();
	
	
    // Constructors for Henon sequence
    HenonSeq (){
    limit = 20;
    	 hseqx.add(0.21);
    	 hseqy.add(0.21);
    	 alpha = 1.4;
    	 beta = 0.3;   	}
   
     public HenonSeq (int a, double b, double c, double d, double e) {
    	 limit = a;
    	 hseqx.add(b);
    	 hseqy.add(c);
    	 alpha = d;
    	 beta = e;	}
     
     // Henon Map Sequence Generator
   		public void henonsequence() throws IOException{
   		
   			File file = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\HenonSequence.txt");   // To store the sequence in txt file
    	 
   			if (!file.exists()) {
   				file.createNewFile();
   				}
    	 
   			FileOutputStream fileOptStream = new FileOutputStream(file);
   			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOptStream));
   			
   			
   			for(int i=1; i <= limit; i++){
   				
   				double m = (double) hseqx.get(i-1);
   				double n = (double) hseqy.get(i-1);
   				Double x = n + 1 - (alpha * pow(m,2));
   				Double y = beta * m ;	
   				
   	       	 	String strBinary1 =StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(x)), 64, "0") ;
   				 String ss = String.valueOf(m);
    		 bw.write(ss);
    		 bw.newLine();
   	   	bw.write(strBinary1);	// to write the binary sequence of x values only to file if needed
     	 	bw.newLine();
   	       	 	
   	    		/*/*	To check for repeating numbers in the sequence
   	    		if(hseqx.contains(x)){	
   	    			int w = hseqx.indexOf(x);
   	    			System.out.println(" index " +w );
   	    			double p = hseqy.get(w);
	    				if(p == y){
   	    					System.out.println("duplicate found at index :"+  i );}		// To find the duplicates in the sequence
   	    			}  */
   	       	 	
   	       	 	
   	    		hseqx.add(x);
   				hseqy.add(y);		// If no duplicates just add to arraylist
        		}	
   			bw.close();
   		}

	
	public static void main (String[] args) throws IOException {
		
		  HenonSeq H = new HenonSeq(5,0.194,0.21,1.4,0.3); 
		  H.henonsequence();
		  System.out.println("\n Henon Map sequence for initial value 0.194\n" );
		  System.out.println();
		  for(int i=1; i < H.hseqx.size(); i++){
			//System.out.print( i+1 + " X: " + (H.hseqx.get(i)) + "\t" +" Y: "+ (H.hseqy.get(i)) + "\n");}	  
			  System.out.println("\t" + H.hseqx.get(i));
			  System.out.println();}
	}
}




//hseqx.set(4, 1.0784673287462971);hseqy.set(4, 0.09184199897401815);