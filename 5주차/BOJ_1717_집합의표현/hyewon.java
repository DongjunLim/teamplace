/*
Union Find

Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.Scanner;

public class BJ_1717_집합의_표현 {

    public static int[] parents = null;

    private static int find(int x) {
        if (x == parents[x])
            return x;
        int y = find(parents[x]);
        parents[x] = y;
        return y;
    }

    private static void merge(int a, int b) {
        a = find(a);
        b = find(b);
        parents[b] = a;
    }

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            String answer = "";
            int operation = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (operation == 1) {
                if (find(a) != find(b)) {
                    answer = "NO";
                } else {
                    answer = "YES";
                }
                System.out.println(answer);
            } else {
                merge(a, b);
            }
        }
    }
}
