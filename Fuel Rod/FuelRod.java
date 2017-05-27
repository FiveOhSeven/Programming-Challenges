/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelrod;

/**
 *
 * @author Andrew Whang
 */
public class FuelRod {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println(answer("4"));
	}
	
	public static int answer(String n) { 
		int num = Integer.parseInt(n);
		int x = (int)(Math.log(num) / (Math.log(2)));
		System.out.println(x);
		int pow1 = (int)Math.pow(2, x);
		int pow2 = (int)Math.pow(2, x+1);
		if(num-pow1 < pow2-num){
			return x+num-pow1;
		} else {
			return x+1+pow2-num;
		}
        
	} 
	
}
