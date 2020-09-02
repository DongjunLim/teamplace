/*
DP
Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.Scanner;

public class BJ_11057_오르막수 {

    public static int[][] arr = null;
    public static final int LIMIT = 10007;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        solution(N);
    }

    private static void solution(int n) {
        arr = new int[n][11];

        for (int i = 0; i < 11; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 11; j++) {
                arr[i][j] = (arr[i][j - 1] + arr[i - 1][j]) % LIMIT;
            }
        }
        System.out.print(arr[n - 1][10] % LIMIT);
    }
}
