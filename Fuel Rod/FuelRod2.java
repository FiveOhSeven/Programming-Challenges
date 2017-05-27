/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelrod2;
import java.util.*;

/**
 *
 * @author Andrew Whang
 */
public class FuelRod2 {

	/**
	 * @param args the command line arguments
	 */
	
	public static void main(String[] args) {
		System.out.println(answer("56"));
	}
	
	public static int answer(String n) {
		ArrayList<Integer> numArr = new ArrayList<Integer>();
		for(int i = 0; i < n.length(); i++){
			numArr.add(Integer.parseInt(n.substring(i, i+1)));
		}
		return recurse(numArr);
	}
	
	public static int recurse(ArrayList<Integer> numArr){
		if(numArr.size() == 1 && numArr.get(0) == 1){
			return 0;
		}
		if(numArr.size() == 1 && numArr.get(0) == 3){
			return 2;
		}
		if(numArr.get(numArr.size()-1)%2 == 1){
			numArr.set(numArr.size()-1, numArr.get(numArr.size()-1)+moreTwo(numArr));
			return recurse(numArr) + 1;
		} else {
			return recurse(half(numArr)) + 1;
		}
	}
	
	public static ArrayList<Integer> half(ArrayList<Integer> numArr){
		ArrayList<Integer> halved = new ArrayList<Integer>();
		boolean carry = true;
		if(numArr.get(0) > 1){
			if(numArr.get(0)%2==0){
				carry = false;
			}
			halved.add(numArr.get(0)/2);
		}
		for(int i = 1; i < numArr.size(); i++){
			int x = numArr.get(i)/2;
			if(carry){
				x += 5;
				carry = false;
			}
			if(numArr.get(i)%2==1){
				carry = true;
			}
			halved.add(x);
		}
		return halved;
	}
	
	public static int moreTwo(ArrayList<Integer> numArr){
		if(numArr.size() > 1 && numArr.get(numArr.size()-2) == 0 && numArr.get(numArr.size()-1) == 0){
			return 1;
		}
		ArrayList<Integer> upper, lower;
		numArr.set(numArr.size()-1, numArr.get(numArr.size()-1)-1);
		lower = half(numArr);
	//	numArr.set(numArr.size()-1, numArr.get(numArr.size()-1)+2);
	//	upper = half(numArr);
		numArr.set(numArr.size()-1, numArr.get(numArr.size()-1)+1);
		if(lower.get(lower.size()-1)%2 == 0){
			return -1;
		}
		return 1;
	}
	
	public static int amtTwo(ArrayList<Integer> numArr){
		if(numArr.get(numArr.size()-1)%2 == 1){
			return 0;
		}
		ArrayList<Integer> half = half(numArr);
		return 1 + amtTwo(half);
	}
	
	public static boolean belowSquare(ArrayList<Integer> numArr){
		if(numArr.get(numArr.size()-1) == 9){
			return false;
		}
		numArr.set(numArr.size()-1, numArr.get(numArr.size()-1)+1);
		ArrayList<Integer> half = half(numArr);
		numArr.set(numArr.size()-1, numArr.get(numArr.size()-1)-1);
		while(true){
			if(half.size() == 1 && half.get(0) == 1){
				return true;
			}
			if(half.get(half.size()-1)%2 == 1){
				return false;
			}
			half = half(half);
		}
	}
}
