// This solution only passes test set 1 and 2
// Test set 3 produces TLE result

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            long z = scanner.nextLong();
            System.out.println("Case #" + (i + 1) + ": " + solve(z));
        }
    }

    public static long solve(long z) {
        long start = (long) Math.floor(Math.sqrt(z));
        long p2 = previousPrime(start);
        long p1 = previousPrime(p2);
        long calc = p1 * p2;
        long answer = calc;

        while (calc <= z) {
            p1 = p2;
            p2 = nextPrime(p2);
            answer = calc;
            calc = p1 * p2;
        }

        return answer;
    }

    public static long findPrime(long n, boolean next) {
        int step = (next) ? 1 : -1;
        n += step;

        for (long i = 2; i < n; i++) {
            if (n % i == 0) {
                n += step;
                i = 2;
            }
        }

        return n;
    }

    public static long nextPrime(long n) {
        return findPrime(n, true);
    }

    public static long previousPrime(long n) {
        return findPrime(n, false);
    }

}
