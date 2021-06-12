package Sequence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class ChebSeq  {
	
	 int limit;												//number of elements to generate in a sequence
	 double lamda;											// Parameter used in Chebysev map
	 public ArrayList <Double> cseq = new ArrayList <Double>(); 	//Arraylist to store the chaotic sequence
	
	 
	      
     // Constructors for sequence
     ChebSeq (){
    	limit = 20;
    	cseq.add(0.4999);	
    	lamda = 4;  }
    
     public ChebSeq(int a, double b, double c) {
    	limit = a;
    	cseq.add(b);
    	lamda = c;		}
     
     // Sequence Generator
     public void chebsequence() throws IOException{
    	 
    	 File file = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\ChebSequence.txt");   // To store the sequence in txt file
    	 if (!file.exists()) {
 			file.createNewFile();
 			}
    	 
    	 
    	 FileOutputStream fileOptStream = new FileOutputStream(file);
    	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOptStream));
    	
    	
    	 for(int i=1; i <= limit; i++){
    
        	double k = (double) cseq.get(i-1);	
        	Double m = Math.cos(lamda * (Math.acos(k)));
        	
        	//Double m = Math.cos(Math.acos(k)/ lamda);
    		
       	 	String strBinary1 = StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(m)), 64, "0") ;		//to convert the sequence to binary
       	 	 String a = strBinary1.substring(32, strBinary1.length());
                String ss = String.valueOf(m);
    		 bw.write(ss);
    		 bw.newLine();
                 
              //   bw.write(a);
       	bw.write(strBinary1);	// to write the binary sequence to file if needed
       	 bw.newLine();      	 	
       	 
       	 	
        	/*	To check for repeating numbers in the sequence
        		if(cseq.contains(m)){	
        			System.out.println("duplicate found at index" +i );		// To find the duplicates in the sequence
        			cseq.add(m);
        			}
        		else  */ 
       	 	
        	cseq.add(m);		// To add the generated number to arraylist
    	  }
       bw.close();
     }   

		
		public static void main (String[] args) throws IOException {
		
		ChebSeq Q = new ChebSeq(5,0.4999,4); 
		Q.chebsequence();
		System.out.println();
             //   System.out.println("Chebysev map sequence for initial value 0.4999");
		for (int i = 1; i < Q.cseq.size(); i++)
		{
        	System.out.println("\t" + Q.cseq.get( i ));
        	System.out.println();
		}
		}
		

}
	

