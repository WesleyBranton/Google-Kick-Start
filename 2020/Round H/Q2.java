// This solution only passes test set 1
// Test set 2 produces TLE result

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            long l = in.nextLong();
            long r = in.nextLong();

            System.out.println("Case #" + i + ": " + test(l, r));
        }

        in.close();
    }

    public static long test(long l, long r) {
        int c = 0;

        for (;l <= r; l++) {
            long n = l;
            long len = count(n);
            while (len > 0) {
                long d = n % 10;
                n /= 10;
                if (len % 2 != d % 2) len = 0;
                --len;
            }
            if (len == 0) ++c;
        }

        return c;
    }

    public static long count(long n) {
        long c = 0;
        while (n != 0) {
            n /= 10;
            ++c;
        }
        return c;
    }

}
