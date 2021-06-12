package Sequence;

import static java.lang.Math.pow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


public class CubicSeq  {
	
	 int limit;												//number of elements to generate in a sequence
	 double lamda;											// Parameter used in Cubic map
	 public ArrayList <Double> cseq = new ArrayList <Double>(); 	//Arraylist to store the chaotic sequence
	
	 
	      
    // Constructors for Cubic sequence
    CubicSeq (){
   	limit = 20;
   	cseq.add(0.4999);	
   	lamda = 2.5;  }
   
    public CubicSeq(int a, double b, double c) {
   	limit = a;
   	cseq.add(b);
   	lamda = c;		}
    
    // Cubic Map Sequence Generator
    public void cubicsequence() throws IOException{
   	 
   	 File file = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\CubicSequence.txt");   // To store the sequence in txt file
   	 if (!file.exists()) {
			file.createNewFile();
			}
   	 
   	 FileOutputStream fileOptStream = new FileOutputStream(file);
   	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOptStream));
   	
   	
   	 for(int i=1; i <= limit; i++){
   
       	double k = (double) cseq.get(i-1);
       	Double m = ( lamda * k ) * (1 - pow(k,2));
   		
      	 	String strBinary1 =StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(m)), 64, "0") ;		//to convert the sequence to binary
      	 
      	 	 String ss = String.valueOf(m);
    		bw.write(ss);
    		 bw.newLine();
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
		
		CubicSeq C = new CubicSeq(5,0.4999,2.59); 
		C.cubicsequence();
		System.out.println();
             //   System.out.println("cubic map sequence for initial value 0.4999");
		for (int i = 1; i < C.cseq.size(); i++)
			{
			System.out.println("\t" + C.cseq.get( i ));
			System.out.println();
			}
		}

}
