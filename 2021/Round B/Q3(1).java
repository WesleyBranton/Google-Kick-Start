// This solution only passes test set 1 and 2
// Test set 3 produces TLE result

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static List<Long> p = new ArrayList<>(); // Used for prime number caching

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        p.add((long) 2);
        p.add((long) 3);

        for (int i = 0; i < t; i++) {
            long z = scanner.nextLong();
            System.out.println("Case #" + (i + 1) + ": " + solve(z));
        }
    }

    public static long solve(long z) {
        long size = p.size();
        int i = 0;
        long p1 = p.get(i++);
        long p2 = p.get(i++);
        long calc = p1 * p2;
        long answer = calc;

        while (calc <= z) {
            p1 = p2;

            if (i == size) {
                p.add(nextPrime(p2));
                ++size;
            }

            p2 = p.get(i);
            ++i;

            answer = calc;
            calc = p1 * p2;
        }

        return answer;
    }

    public static long nextPrime(long n) {
        ++n;
        for (long i = 2; i < n; i++) {
            if (n % i == 0) {
                ++n;
                i = 2;
            }
        }

        return n;
    }

}
