// This solution was not submitted during the round

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] g = new int[r][c];

            for (int x = 0; x < r; x++) {
                for (int y = 0; y < c; y++) {
                    g[x][y] = scanner.nextInt();
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(r, c, g));
        }
    }

    public static int solve(int r, int c, int[][] g) {
        int count = 0;

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (g[x][y] == 1) {
                    count += checkTouching(r, c, g, x, y);
                }
            }
        }

        return count;
    }

    public static int checkTouching(int r, int c, int[][] g, int x, int y) {
        int n = 0;
        int s = 0;
        int e = 0;
        int w = 0;
        int count = 0;

        int i = x;
        while (i > -1) {
            if (g[i][y] == 0) {
                break;
            }
            ++n;
            --i;
        }

        i = x;
        while (i < r) {
            if (g[i][y] == 0) {
                break;
            }
            ++s;
            ++i;
        }

        if (n < 2 && s < 2) return 0;

        i = y;
        while (i > -1) {
            if (g[x][i] == 0) {
                break;
            }
            ++e;
            --i;
        }

        i = y;
        while (i < c) {
            if (g[x][i] == 0) {
                break;
            }
            ++w;
            ++i;
        }

        if (w < 2 && e < 2) return 0;

        count += countL(w, n);
        count += countL(e, n);
        count += countL(w, s);
        count += countL(e, s);
        count += countL(n, w);
        count += countL(n, e);
        count += countL(s, w);
        count += countL(s, e);

        return count;
    }

    public static int countL(int min, int max) {
        if (min < 2 || max < 4) return 0;

        while (max < min * 2) {
            --min;
        }

        if (min < 2) return 0;

        return min - 1;
    }

}
