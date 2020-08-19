/*
DFS

Time Complexity: O(2^N)
Space Complexity: O(1)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_1182_부분수열의_합 {
    public static int answer = 0;
    public static int[] array;

    public static void solution(int target) {
        Arrays.sort(array);

        int sum = 0;
        dfs(target, -1, 0);

        if (target == 0) answer--;
        printAnswer();
    }

    private static void dfs(int target, int index, int sum) {
        if (target == sum && index == array.length - 1) {
            answer++;
            return;
        }
        if (array.length - 1 == index) {
            return;
        }

        dfs(target, index + 1, sum);
        dfs(target, index + 1, sum + array[index + 1]);
    }

    private static void printAnswer() {
        System.out.print(answer);
    }

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        array = new int[N];


        int target = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        solution(target);
    }
}

/*
2 4
1 2

5 0
-7 -3 -2 5 8

5 7
1 2 3 4 5

3 -1
-1 -1 -1

6 8
1 1 2 5 6 7

2 0
-1 3

3 0
-1 0 1

3 1
1 1 0
 */
