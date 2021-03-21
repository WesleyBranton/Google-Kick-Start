import java.util.*;

public class Solution {
	
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	
	for (int i = 1; i <= t; ++i) {
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int x = 0; x < n; x++) {
			a[x] = in.nextInt();
		}
		System.out.println("Case #" + i + ": " + test(n, k, a));
	}
	
	in.close();
}

public static int test(int n, int k, int a[]) {
	int count = 0;
	int start = first(n, k, a, 0);
	
	while (start >= 0) {
		Boolean fail = false;
		int i = 0;
		for (i = 0; i < k && !fail; i++) {
			if (a[start + i] != k - i) {
				fail = true;
			}
		}
		
		if (!fail) {
			count++;
			start += k;
		} else {
			start++;
		}
		
		start = first(n, k, a, start);
	}
	
	return count;
}

public static int first(int n, int k, int a[], int start) {
	for (int i = start; i < n - (k - 1); i++) {
		if (a[i] == k) {
			return i;
		}
	}
	return -1;
}

}
