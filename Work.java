package Sequence;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Sequence.Xorseq;
// import static Sequence.work1.Path;
// import static Sequence.work1.path1;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;




public class Work extends JFrame{
    public static String path1 = "";
    JButton button ;
    JButton button1 ;
    JButton button2 ;
        
//    public String Pathpass;
    JLabel label;
    JLabel label1;

    JLabel label2;
    JButton button3 ;
    JButton button4 ;
    JButton button5 ;
    JLabel label3;
    JLabel label4;
    JLabel label5;



    public static String Path = "";
    
    
    
    public Work(){
        
    super("IMAGE ENCRYPTION AND DECRYPTION");
   
    button = new JButton("Browse");
    button.setBounds(220,300,100,40);
    button1 = new JButton("Load Crossover Image");
    button1.setBounds(620,300,200,40);
    button2 = new JButton("Load Encrypted Image");
    button2.setBounds(1000,300,200,40);
    
    
    label = new JLabel();
    label.setBounds(110,10,264,264);
    label1 = new JLabel();
    label1.setBounds(600,10,264,264);
    label2 = new JLabel();
    label2.setBounds(950,10,264,264);
    
    
    button3 = new JButton("Browse");
    button3.setBounds(220,650,100,40);
    button4 = new JButton("Load decrypted Crossover Image");
    button4.setBounds(620,650,200,40);
    button5 = new JButton("Load Original Image");
    button5.setBounds(1000,650,200,40);
   
    
    label3 = new JLabel();
    label3.setBounds(110,350,264,264);  
    label5 = new JLabel();
    label5.setBounds(950,350,264,264);

    label4 = new JLabel();
    label4.setBounds(600,350,264,264);
    
    
    
    add(button);
    add(label);
    add(button1);
    add(label1);
    add(button2);
    add(label2);
    
    add(button3);
    add(label3);
    add(button4);
    add(label4);
    add(button5);
    add(label5);
    
    try {
        
    
    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
        
          JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png","bmp");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
             
              try {
                  //   Pathpass = path;
                  //System.out.println(path);
//   sent(Pathpass);
String Path = call(path);
              } catch (IOException ex) {
                  Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
              }
//              System.out.println(Path);

              label.setIcon(ResizeImage(path));
              
          }
           //if the user click on save in Jfilechooser


          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
        }
    });
    }
    
    catch (Exception e)  {
        System.out.println("No File chosesn yet");
    }
    
 
    try {
        
    
    button3.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
        
          JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","png","bmp");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
             
              try {
                  //   Pathpass = path;
                  //System.out.println(path);
//   sent(Pathpass);
String Path = calldecrypt(path);
              } catch (IOException ex) {
                  Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
              }
//              System.out.println(Path);
        path1=Path;
              label3.setIcon(ResizeImage(path));
              
          }
           //if the user click on save in Jfilechooser


          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
        }
    });
    }
    
    catch (Exception e)  {
        System.out.println("No File chosesn yet");
    }
    
     
    
    
      
    
    
    
    
    
    
    
     
     
     button1.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
 BufferedImage img = null;
try {
    img = ImageIO.read(new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_crossover.bmp"));
} catch (IOException ei) {
    ei.printStackTrace();
}


Image dimg = img.getScaledInstance(label1.getWidth(), label1.getHeight(),
        Image.SCALE_SMOOTH);
 label1.setIcon(new ImageIcon(dimg));


         
        }
    });

  
   
   
   
     
     
     button2.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
 BufferedImage img5 = null;
try {
    img5 = ImageIO.read(new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_encrypt.bmp"));
} catch (IOException ei) {
    ei.printStackTrace();
}


Image dimg5 = img5.getScaledInstance(label2.getWidth(), label2.getHeight(),
        Image.SCALE_SMOOTH);
 label2.setIcon(new ImageIcon(dimg5));


         
        }
    });
     

       button4.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
 BufferedImage img = null;
try {
    img = ImageIO.read(new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\multimaps_decrossover.bmp"));
} catch (IOException ei) {
    ei.printStackTrace();
}


Image dimg = img.getScaledInstance(label4.getWidth(), label4.getHeight(),
        Image.SCALE_SMOOTH);
 label4.setIcon(new ImageIcon(dimg));


         
        }
    });   
     
   
   
    button5.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
 BufferedImage img = null;
try {
    img = ImageIO.read(new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\original.bmp"));
} catch (IOException ei) {
    ei.printStackTrace();
}


Image dimg = img.getScaledInstance(label5.getWidth(), label5.getHeight(),
        Image.SCALE_SMOOTH);
 label5.setIcon(new ImageIcon(dimg));


         
        }
    });
     
     
     
     
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(1365,750);
    setVisible(true);
    }
     
      
    
    
    
    
public String call(String callpath) throws IOException{
        
        File ipath = null;
//      System.out.println(callpath);

    
    try{ ipath = new File(callpath); }
    catch (Exception E){
        System.out.println(E);
    }
         

    
//       System.out
    System.out.println(ipath);
          
            
          
       
//        ipath = new File("C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\image1.bmp");
//                "C:\\Users\\india\\Documents\\NetBeansProjects\\Sequence\\src\\sequence\\image1.bmp");
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
       
                
                
                
                
                
                
                
                
             return callpath;   
                
                
        }



public String calldecrypt(String callpath1) throws IOException{	
    
          File ipath3 = null;
//      System.out.println(callpath);

    
    try{ ipath3 = new File(callpath1); }
    catch (Exception E1){
        System.out.println(E1);
    }
         

    
//       System.out
    System.out.println(ipath3);
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
    	
	   return callpath1;

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

  
    
    
    
    
    
     // Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath)
    {
                BufferedImage imgg = null;
try {
    imgg = ImageIO.read(new File(ImagePath));
} catch (IOException eii) {
    eii.printStackTrace();
}


Image dimgg = imgg.getScaledInstance(label.getWidth(), label.getHeight(),
        Image.SCALE_SMOOTH);


        ImageIcon MyImage = new ImageIcon(dimgg);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
  
        
       //  System.out.println(ImagePath);
      
                ImageIcon image = new ImageIcon(newImg);
        return image;
        
            
   
        
    }
    
  
    
    
    public static void main(String[] args) throws IOException{
 
        
        new Work();
  
     
        
        
        
        
    }
}
   
