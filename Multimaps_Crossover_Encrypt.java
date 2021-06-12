package Sequence;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Sequence.Xorseq;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class Multimaps_Crossover_Encrypt  {

	public static void main (String[] args) throws IOException {
	
            
            
            
            File ipath = null;
      
         
          
    
       
     
          
            
          
       
             ipath = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\image.bmp");
    	BufferedImage imageA = ImageIO.read(ipath);   	
    	BufferedImage img = new BufferedImage(imageA.getWidth(),imageA.getHeight(),BufferedImage.TYPE_INT_RGB);
		// Input image to be used in crossover
	//	String ipath = args;
    //	BufferedImage imageA = ImageIO.read(new File(ipath));    	
   // 	BufferedImage img = new BufferedImage(imageA.getWidth(),imageA.getHeight(),BufferedImage.TYPE_INT_RGB);
    	
    	// Encrypted image path
		String dPath1 = "C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_crossover.bmp";
    	
    	int[][] result = convertTo2DUsingGetRGB(imageA);
    	
    	// Generating 2 sequences for crossover
		
    		
    	
    	Xorseq L1 = new Xorseq(imageA.getWidth());
   	 	L1.sequencexor();
   	 	
    	Xorseq L2 = new Xorseq(imageA.getHeight());
   	 	L2.sequencexor();
    	       int  no_sq = imageA.getWidth() * imageA.getHeight() ; 
       System.out.println(no_sq);		
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
    	
    	// Row crossver
    	
    	for(int i =0; i< K1.ordered.size() & i!=K1.ordered.size()-1;i=i+2){
    		Crossover_row C1 = new Crossover_row(K1.ordered, no_row_cp, imageA.getHeight(),i,result);
    		result = C1.calc_crosspoints();
    	}
    	
    	// Column crossver
    	
    	for(int i =0; i< K2.ordered.size() & i!=K2.ordered.size()-1;i=i+2){
    		Crossover_col C2 = new Crossover_col(K2.ordered, no_col_cp, imageA.getWidth(),i,result);
    		result = C2.calc_crosspoints();
    	}
    			
    	// Writing Image after crossover
    	for (int x = 0; x < result.length; x++) {
    	    for (int y = 0; y < result[0].length; y++) {        	   	
    	    	img.setRGB(x, y, result[x][y]);
    	    }
   		}	   

   		System.out.println("Scrambling Process Completed");
                System.out.println(ipath);
   		ImageIO.write(img, "bmp", new File(dPath1));
   		System.out.println("Wrote to "+dPath1);   	    	
    	
	
       //encrypt image here 
                
		File ipath1 = null;
       ipath1 = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_crossover.bmp");
  	BufferedImage img1 = ImageIO.read(ipath1);    	
    	BufferedImage img_new = new BufferedImage(img1.getWidth(),img1.getHeight(),BufferedImage.TYPE_INT_RGB);
    	
    	// Encrypted image path
       
            File dPath2 =new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_encrypt.bmp");
    	
                 int no_seq = img1.getWidth() * img1.getHeight();
                
                  	Xorseq L3 = new Xorseq(no_seq);
                        L3.sequencexor();
                
                
              int  k = 0 ;
                 for (int x = 0; x < img_new.getWidth(); x++) {
		    	for (int y = 0; y < img_new.getHeight(); y++) {
	    		
	    		//Read each pixel
	        	int pixelA = img1.getRGB(x, y);
	        	//System.out.println(pixelA);
	        	//Converting pixel value to biginteger
	        	String strb = Integer.toBinaryString(pixelA);
	        	BigInteger bi1 = new BigInteger(strb,2);
	       
                         BigInteger bi7 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(L3.xord.get(k))),64,"0"),2);
	        	//System.out.println(bi7);
	        	 BigInteger bi3 = bi1.xor(bi7);
                         //Converting the xor biginteger result to binary string
	        	String results = StringUtils.leftPad(bi3.toString(2), 64, "0");
	        	// Getting lower 32 bits in the xored binary string
	        	String a = results.substring(32, results.length()); 
	        	// Converting lower 32 bits into biginteger and then to integer
	        	BigInteger bi4 = new BigInteger(a,2);	        	
	        	int value = bi4.intValue();
                        img_new.setRGB(x, y, value);
	        	k++;
	                //System.out.println(value);
	    	}
	    }
   ImageIO.write(img_new, "bmp", dPath2);
	    System.out.println("Wrote to "+dPath2);
       
                
                
                
                
                
                
                
                
                
                
                
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
