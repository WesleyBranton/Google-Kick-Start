import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            long n = in.nextLong(); // Levels in the game
            long k = in.nextLong(); // Current level
            long s = in.nextLong(); // Sword level

            System.out.println("Case #" + i + ": " + test(n, k, s));
        }

        in.close();
    }

    public static long test(long n, long k, long s) {
        long r = k - 1 + 1 + n; // Restart
        long b = k - 1 + k - s + n - s + 1; // Backtrack

        if (b <= r) return b;
        else return r;
    }

}