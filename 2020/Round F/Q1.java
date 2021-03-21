// This solution only passes test set 1
// Test set 2 produces TLE result

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	
	for (int i = 1; i <= t; i++) {
		int n = in.nextInt();
		int x = in.nextInt();
		Queue<Integer[]> a = new LinkedList<Integer[]>();
		Queue<Integer[]> out = new LinkedList<Integer[]>();
		
		for (int j = 0; j < n; j++) {
			Integer[] temp = new Integer[2];
			temp[0] = j + 1;
			temp[1] = in.nextInt();
			a.add(temp);
		}
	
		
		while(a.size() > 0) {
			Integer[] temp = a.remove();
			temp[1] -= x;
			
			if (temp[1] > 0) {
				a.add(temp);
			} else {
				out.add(temp);
			}
		}
		
		String output = " ";
		
		while(!out.isEmpty()) {
			Integer[] temp = out.remove();
			output += temp[0] + " ";
		}
		
		System.out.println("Case #" + i + ":" + output);
		
	}
	
	in.close();
}

}