/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandeststaircase2;
import java.util.*;


public class GrandestStaircase2 {

	static HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<Integer, HashMap<Integer, Integer>>();

	public static void main(String[] args) {
//		for(int i = 1; i < 201; i++){
//			System.out.println(answer(i));
//		}
		System.out.println(answer(200));
	}

	public static int answer(int n){
		int x = (int)(Math.sqrt(n*2));
		if(x * (x+1) > n*2){
			x--;
		}
		int running = 0;
		for(int i = 2; i <= x; i++){
			running += partByK(n, i);
		}
		return running;
	}
	
	public static int partByK(int n, int k){
		if(k == 0){
			return 0;
		}
		if(n == 1 && k == 1){
			return 1;
		}
		if(n < k || k < 0){
			return 0;
		}
		int x, y;
		if(memo.containsKey(n-k)){
			if(memo.get(n-k).containsKey(k)){
				x = memo.get(n-k).get(k);
			} else {
				x = partByK(n-k, k);
				memo.get(n-k).put(k, x);
			}
			if(memo.get(n-k).containsKey(k-1)){
				y = memo.get(n-k).get(k-1);
			} else {
				y = partByK(n-k, k-1);
				memo.get(n-k).put(k-1, y);
			}
		} else {
			memo.put(n-k, new HashMap<Integer, Integer>());
			x = partByK(n-k, k);
			y = partByK(n-k, k-1);
			memo.get(n-k).put(k, x);
			memo.get(n-k).put(k-1, y);
		}
		return x+y;
	}
	
}
