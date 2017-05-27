/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandeststaircase;
import java.util.*;

/**
 *
 */
public class GrandestStaircase {


	public static void main(String[] args) {
		for(int i = 3; i < 20; i++){
			System.out.println(answer(i) + " " + i);
		}
	}
	
	public static int answer(int n) {
		ArrayList<Integer> x = stairCase(n);
		System.out.println(x);
		return x.size();
	}
	
	public static ArrayList stairCase(int n){
		if(n == 3){
			ArrayList<ArrayList<Integer>> x = new ArrayList<>();
			x.add(new ArrayList<>());
			x.get(0).add(1);
			x.get(0).add(2);
			return x;
		}
		ArrayList<ArrayList<Integer>> recurse = stairCase(n-1);
		ArrayList<ArrayList<Integer>> current = new ArrayList<>();
		for(int i = 0; i < recurse.size(); i++){
			for(int k = 0; k < recurse.get(i).size(); k++){
				if(k == recurse.get(i).size() - 1){
					recurse.get(i).set(k, recurse.get(i).get(k) + 1);
					current.add(recurse.get(i));
				} else {
					if(recurse.get(i).get(k)+1 < recurse.get(i).get(k+1)){
						recurse.get(i).set(k, recurse.get(i).get(k)+1);
						ArrayList x = isDup(current, recurse.get(i));
						if(x != null){
							current.add(x);
						}
						recurse.get(i).set(k, recurse.get(i).get(k)-1);
					}
				}
				
				if(k == 0 && recurse.get(i).get(0) > 1){
					recurse.get(i).add(0, 1);
					ArrayList x = isDup(current, recurse.get(i));
					if(x != null){
						current.add(x);
					}
					recurse.get(i).remove(0);
				}
			}
		}
		return current;
	}
	
	public static ArrayList isDup(ArrayList<ArrayList<Integer>> x, ArrayList<Integer> y){
		for(int i = 0; i < x.size(); i++){
			if(x.get(i).size() != y.size()){
				continue;
			}
			boolean truthy = true;
			for(int k = 0; k < y.size(); k++){
				if(!(x.get(i).get(k).equals(y.get(k)))){
					truthy = false;
					break;
				}
			}
			if(truthy){
				return null;
			}
		}
		return (ArrayList<Integer>)y.clone();
	}
	
}
