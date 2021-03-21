// This solution was not submitted during the round

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            System.out.println("Case #" + (i + 1) + ": " + solve(n, k, s));
        }
    }

    public static int solve(int n, int k, String s) {
        int score = 0;

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                ++score;
            }
        }

        return Math.abs(score - k);
    }

}
