/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sequence;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Sequence.Xorseq;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class Multimaps_encrypt {
    public static void main (String[] args) throws IOException {
        
        
		File ipath1 = null;
       ipath1 = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_crossover.bmp");
  	BufferedImage img1 = ImageIO.read(ipath1);    	
    	BufferedImage img_new = new BufferedImage(img1.getWidth(),img1.getHeight(),BufferedImage.TYPE_INT_RGB);
    	
    	// Encrypted image path
       
            File dPath2 =new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_encrypt.bmp");
    	
                 int no_seq = img1.getWidth() * img1.getHeight();
                
                  	Xorseq L2 = new Xorseq(no_seq);
                        L2.sequencexor();
                
                
              int  i = 0 ;
                 for (int x = 0; x < img_new.getWidth(); x++) {
		    	for (int y = 0; y < img_new.getHeight(); y++) {
	    		
	    		//Read each pixel
	        	int pixelA = img_new.getRGB(x, y);
	        	
	        	//Converting pixel value to biginteger
	        	String strb = Integer.toBinaryString(pixelA);
	        	BigInteger bi1 = new BigInteger(strb,2);
	       
                         BigInteger bi7 = new BigInteger(StringUtils.leftPad(Long.toBinaryString(Double.doubleToLongBits(L2.xord.get(i))),64,"0"),2);
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
	        	i++;
	        		
	    	}
	    }
   ImageIO.write(img_new, "bmp", dPath2);
	    System.out.println("Wrote to "+dPath2);
		}
}