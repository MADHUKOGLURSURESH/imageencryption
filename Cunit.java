package Sequence;

import java.util.ArrayList;
import java.util.Collections;

class Crossover_row {
	
	ArrayList<Integer> K1 = new ArrayList <Integer>();
	ArrayList<Integer> cross_point = new ArrayList <Integer>();
	int no_cp,L,K;
	int [][] image_array;
	
	Crossover_row(ArrayList<Integer> keystream, int cp, int no_row,int ii, int[][] result){
		K1 = keystream;
		no_cp = cp;
		L = no_row;
		K = ii;
		image_array = result;
	}
	
	int[][] calc_crosspoints(){
		
		cross_point.add(0);
			for(int i=1; i<= no_cp; i++){
			int x = (cross_point.get(i-1) + Math.abs(K1.get(K) - K1.get(K+1))) % L;
			cross_point.add(x);
			}
		
		cross_point.remove(0);
		
		Collections.sort(cross_point);
	//	System.out.println("\nCross points of :" +K1.get(K) +" and " + K1.get(K+1));
	//	for(int i = 0; i < cross_point.size(); i++)
	//		System.out.print(cross_point.get(i)  + "\t");
		
		for(int i=0;i<cross_point.size();i=i+2){
			
			if(cross_point.size()%2 ==0){
				for(int x=cross_point.get(i);x<cross_point.get(i+1);x++){
					int temp = image_array[(K1.get(K))-1][x];
					image_array[(K1.get(K))-1][x] = image_array[(K1.get(K+1))-1][x];
					image_array[(K1.get(K+1))-1][x] = temp;
				}
			}
			
			else{
				
				if(i == cross_point.size()-1){
					for(int x=cross_point.get(i);x<image_array[0].length;x++){
						int temp = image_array[(K1.get(K))-1][x];
						image_array[(K1.get(K))-1][x] = image_array[(K1.get(K+1))-1][x];
						image_array[(K1.get(K+1))-1][x] = temp;
					}
				}
				
				else{
					for(int x=cross_point.get(i);x<cross_point.get(i+1);x++){
						int temp = image_array[(K1.get(K))-1][x];
						image_array[(K1.get(K))-1][x] = image_array[(K1.get(K+1))-1][x];
						image_array[(K1.get(K+1))-1][x] = temp;
					}
				}
			}
		}
		return image_array;
	}	
}




class Crossover_col {
	
	ArrayList<Integer> K2 = new ArrayList <Integer>();
	ArrayList<Integer> cross_point = new ArrayList <Integer>();
	int no_cp,M,K;
	int [][] image_array;
	
	Crossover_col(ArrayList<Integer> keystream, int cp, int no_col,int ii, int[][] result){
		K2 = keystream;
		no_cp = cp;
		M = no_col;
		K = ii;
		image_array = result;
	}
	
	int[][] calc_crosspoints(){
		
		cross_point.add(0);
			for(int i=1; i<= no_cp; i++){
			int x = (cross_point.get(i-1) + Math.abs(K2.get(K) - K2.get(K+1))) % M;
			cross_point.add(x);
			}
		
		cross_point.remove(0);
		
		Collections.sort(cross_point);
	//	System.out.println("\nCross points of :" +K2.get(K) +" and " + K2.get(K+1));
	//	for(int i = 0; i < cross_point.size(); i++)
	//		System.out.print(cross_point.get(i)  + "\t");
		
		for(int i=0;i<cross_point.size();i=i+2){
			
			if(cross_point.size()%2 ==0){
				for(int x=cross_point.get(i);x<cross_point.get(i+1);x++){
					int temp = image_array[x][(K2.get(K))-1];
					image_array[x][(K2.get(K))-1] = image_array[x][(K2.get(K+1))-1];
					image_array[x][(K2.get(K+1))-1] = temp;
				}
			}
			
			else{
				
				if(i == cross_point.size()-1){
					for(int x=cross_point.get(i);x<image_array.length;x++){
						int temp = image_array[x][(K2.get(K))-1];
						image_array[x][(K2.get(K))-1] = image_array[x][(K2.get(K+1))-1];
						image_array[x][(K2.get(K+1))-1] = temp;
					}
				}
				
				else{
					for(int x=cross_point.get(i);x<cross_point.get(i+1);x++){
						int temp = image_array[x][(K2.get(K))-1];
						image_array[x][(K2.get(K))-1] = image_array[x][(K2.get(K+1))-1];
						image_array[x][(K2.get(K+1))-1] = temp;
					}
				}
			}
		}
		return image_array;
	}	
}

public class Cunit {
	public static void main(String args[]){
		
	}
}
