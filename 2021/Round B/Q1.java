import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println("Case #" + (i + 1) + ": " + solve(n, s));
        }
    }
    
    public static String solve(int n, String s) {
        StringBuilder answer = new StringBuilder();
        answer.append("1 ");

        int[] count = new int[n];
        count[0] = 1;
        int acc = 1;
        int previous = s.charAt(0);

        for (int i = 1; i < n; i++) {
            int current = s.charAt(i);
            if (current > previous) {
                ++acc;
            } else {
                acc = 1;
            }

            answer.append(acc + " ");
            previous = current;
        }

        return answer.toString().trim();
    }

}
