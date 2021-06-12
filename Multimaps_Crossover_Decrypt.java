package Sequence;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Sequence.Xorseq;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class Multimaps_Crossover_Decrypt {

	public static void main (String[] args) throws IOException {
            
            
              
		File ipath3 = null;
        ipath3 = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_encrypt.bmp");

    	BufferedImage img2 = ImageIO.read(ipath3);    	
    	BufferedImage img_new1 = new BufferedImage(img2.getWidth(),img2.getHeight(),BufferedImage.TYPE_INT_RGB);
    	
    	// Encrypted image path
       
            File dPath3 =new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_decrossover.bmp");
    	
    	
                 int no_seq = img2.getWidth() * img2.getHeight();
               
                  	Xorseq L3 = new Xorseq(no_seq);
                        L3.sequencexor();
                
                
              int  k = 0 ;
                 for (int x = 0; x < img2.getWidth(); x++) {
		    	for (int y = 0; y < img2.getHeight(); y++) {
	    		
	    		//Read each pixel
	        	int pixelA = img2.getRGB(x, y);
	        	
	        	//Converting pixel value to biginteger
	        	String strb = Integer.toBinaryString(pixelA);
	        	BigInteger bi1 = new BigInteger(strb,2);
	       
                    BigInteger bi7 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(L3.xord.get(k))),64,"0"),2);
	        
                        BigInteger bi3 = bi1.xor(bi7);
              
                        
                        	//Converting the xor biginteger result to binary string
	        	String results = StringUtils.leftPad(bi3.toString(2), 64, "0");
	        	
	        	
	        	// Getting lower 32 bits in the xored binary string
	        	String a = results.substring(32, results.length()); 
	        	
	        	// Converting lower 32 bits into biginteger and then to integer
	        	BigInteger bi4 = new BigInteger(a,2);	        	
	        	int value = bi4.intValue();
                        
	        	img_new1.setRGB(x, y, value);
	        	
	        	k++;
	        		
	    	}
	    }
       
  ImageIO.write(img_new1, "bmp", dPath3);
	    System.out.println("Wrote to "+dPath3);
            
            
            //second step to decrypt
            
            
		File ipath = null;
            // Input image to be used in crossover
             ipath = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_decrossover.bmp");
            
    	BufferedImage imageA = ImageIO.read(ipath);   	
    	BufferedImage img = new BufferedImage(imageA.getWidth(),imageA.getHeight(),BufferedImage.TYPE_INT_RGB);
    	
    	//Decrypted image path
		String dPath1 = "C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\original.bmp";
    	
    	int[][] result = convertTo2DUsingGetRGB(imageA);
    	
    	// Generating 2 sequences for crossover
		
    		
    	
    	Xorseq L1 = new Xorseq(imageA.getWidth());
   	 	L1.sequencexor();
   	 	
    	Xorseq L2 = new Xorseq(imageA.getHeight());
   	 	L2.sequencexor();
    			
    		 		  			
    	// Quantification unit
    			
        Quantification K1 = new Quantification(L1.xord);
    	K1.ordered();
   
    			
    	Quantification K2 = new Quantification(L2.xord);
    	K2.ordered();

    			
   
    	// Crossover Unit
    			
    	int no_row_cp = (int) Math.floor(imageA.getWidth()/2);
    	System.out.println("\n \nNo of row cut points : " +no_row_cp);
    		
    	int no_col_cp = (int) Math.floor(imageA.getHeight()/2);
    	System.out.println("No of col cut points : " +no_col_cp);
    	
    	// Column crossver
    	
    	for(int i =0; i< K2.ordered.size() & i!=K2.ordered.size()-1;i=i+2){
    		Crossover_col C2 = new Crossover_col(K2.ordered, no_col_cp, imageA.getWidth(),i,result);
    		result = C2.calc_crosspoints();
    	}
    	
    	// Row crossver
    	
    	for(int i =0; i< K1.ordered.size() & i!=K1.ordered.size()-1;i=i+2){
    		Crossover_row C1 = new Crossover_row(K1.ordered, no_row_cp, imageA.getHeight(),i,result);
    		result = C1.calc_crosspoints();
    	}
    			
    	// Writing Image after crossover
    	for (int x = 0; x < result.length; x++) {
    	    for (int y = 0; y < result[0].length; y++) {        	   	
    	    	img.setRGB(x, y, result[x][y]);
    	    }
   		}	   

   		System.out.println("Descrambling Process Completed");
   		ImageIO.write(img, "bmp", new File(dPath1));
   		System.out.println("Wrote to "+dPath1);   	    	
    	
	}
	
	private static int[][] convertTo2DUsingGetRGB(BufferedImage image) {

		  int width = image.getWidth();
	      int height = image.getHeight();
	      int[][] result = new int[width][height];

	      for (int row = 0; row < width; row++) {
	         for (int col = 0; col < height; col++) {
	            result[row][col] = image.getRGB(row, col);
	         }
	      }
	      return result;
	}
}
