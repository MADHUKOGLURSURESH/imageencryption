package Sequence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class Xorseq {
	int no;
	public ArrayList <Double> xord = new ArrayList <Double>();   //To store the final double xored value
	
	public Xorseq(int n)
	{
		no = n;
	}
	
	public void sequencexor() throws IOException
	{
	
		File file = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\XorSequence.txt");   // To store the sequence in txt file
	 	if (!file.exists()) {
	 		file.createNewFile();
			}
	 
	 	FileOutputStream fileOptStream = new FileOutputStream(file);
	 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOptStream));
	 	
	 	//Creating logistic sequence
		
		sequence.LogisticSeq L = new sequence.LogisticSeq(no,0.4899,3.9999); 
                L.logisticsequence();
		
		//Creating tent sequence
		
		TentSeq T = new TentSeq(no,0.21,0.4); 
		T.tentsequence();	
		
		//Creating Henon sequence
		
		HenonSeq H = new HenonSeq(no,0.21,0.21,1.4,0.3); 
		H.henonsequence();	
		
		//Creating Cubic sequence
		
		CubicSeq C = new CubicSeq(no,0.4999,2.59); 
		C.cubicsequence();	
		
		//Creating Sine sequence
		
		sequence.SineSeq S = new sequence.SineSeq(no,0.4999,0.99); 
		S.sinesequence();	
		
		//Creating Chebysev map sequence
		
		ChebSeq Q = new ChebSeq(no,0.4999,4); 
		Q.chebsequence();
		
		// Xoring the sequence and storing in xord arraylist 
		
		 BigInteger bi1, bi2, bi3 , bi4 , bi5 , bi6 , bi7;
				
		for(int i = 1; i < L.lseq.size(); i++){
			
			 bi1 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(L.lseq.get(i))),64,"0"),2);
			 bi2 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(T.tseq.get(i))),64,"0"),2);
			 bi3 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(H.hseqx.get(i))),64,"0"),2);
			 bi4 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(C.cseq.get(i))),64,"0"),2);
			 bi5 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(S.sseq.get(i))),64,"0"),2);
			 bi6 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(Q.cseq.get(i))),64,"0"),2);
			 
			 bi7 = ((((bi1.xor(bi2)).xor(bi3)).xor(bi4)).xor(bi5)).xor(bi6);
	
          
			 String s1 = StringUtils.leftPad(bi7.toString(2), 64, "0");
			 xord.add(Double.longBitsToDouble(new BigInteger(s1, 2).longValue()));
			
			
			 bw.write(s1);
			 bw.newLine();
		}
		bw.close();
			
		
		
	}	

	
	public static void main(String args[]) throws IOException
	{
	 Xorseq X = new Xorseq(6);
	 X.sequencexor();

	 //System.out.println("\n Unpredictable Sequence \n");
	 System.out.println();
		for(int m=0;m < X.xord.size(); m++){
			
			System.out.println("\t" + X.xord.get(m));
			System.out.println();
		}
               
           
	}
		
}








	/*
	 * 
	 *  bw.write(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(L.lseq.get(i))),64,"0"));
			 bw.newLine();
			 bw.write(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(T.tseq.get(i))),64,"0"));
			 bw.newLine();
			 bw.write(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(H.hseqx.get(i))),64,"0"));
			 bw.newLine();
			 bw.write(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(C.cseq.get(i))),64,"0"));
			 bw.newLine();
			 bw.write(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(S.sseq.get(i))),64,"0"));
			 bw.newLine();
			 bw.write(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(Q.cseq.get(i))),64,"0"));
			 bw.newLine();
			*/ 
