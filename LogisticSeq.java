/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

/**
 *
 * @author india
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


public class LogisticSeq  {
	
	 int limit;													//number of elements to generate in a sequence
	 double lamda;												// Parameter used in Logistic map
	 public ArrayList <Double> lseq = new ArrayList <>(); 	//Arraylist to store the chaotic sequence
  

	 
	      
     // Constructors for Logistic sequence
    public LogisticSeq (){
    	limit = 20;
    	lseq.add( 0.4999);	
    	lamda =  3.9999;  }
    
     public LogisticSeq(int a, double b, double c) {
    	limit = a;
    	lseq.add(b);
    	lamda = c;		}
     
     // Logistic Map Sequence Generator
     public void logisticsequence() throws IOException{
    		
    	 File file = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\LogisticSequence.txt");   // To store the sequence in txt file
    	 if (!file.exists()) {
 			file.createNewFile();
 			}
    	 
    	 	FileOutputStream fileOptStream = new FileOutputStream(file);
    	 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOptStream));
    
    	 
  
    	 for(int i=1; i <= limit; i++){
    
    		 double k =  lseq.get(i-1);
    		 Double m = (( lamda * k ) * (1 - k));
    		
    		 String strBinary1 =StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(m)),64,"0");		//to convert the sequence to binary
  
    		 String a = strBinary1.substring(32, strBinary1.length());
    	
    		 String ss = String.valueOf(m);
    	//	 bw.write(ss);
    	//	 bw.newLine();
    //		 bw.write(a);
    	//	 bw.write(strBinary1);	 // to write the binary sequence to file if needed
    	//	 bw.newLine();
    		 
       	 	     
       	 	/* To find the duplicates in the sequence (if needed/takes time) 
        		if(lseq.contains(m)){	
        			System.out.println("duplicate found at index" +i );		// 
        			lseq.add(m);
        			}
        		else   
       	 	*/
        		
    		 lseq.add(m);		// To add the generated number to arraylist
    	 	}
       bw.close();
        
        
     }   

		public static void main (String[] args) throws IOException {
		
		LogisticSeq L = new LogisticSeq(5,0.4899,3.9999); 
		L.logisticsequence();
                
              
		System.out.println();
		//System.out.println("\n Logistic Map Chaotic Sequence: for initial value 0.4899 \n" );
		for (int i = 1; i < L.lseq.size(); i++)
		{
        	System.out.print( "\t" + L.lseq.get( i ) + "\n" );
        	System.out.println();
        	
        	/*if(i%5 ==0)
        	{
        		System.out.println();
        	}*/
		}
        	// i + ": " +
		}
}
	

