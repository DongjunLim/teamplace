package ps.boj;

import java.util.Scanner;

/**
 *  @문제접근
 *  완전탐색으로 풀었습니다.
 *
 *  @성능
 *  Runtime: 120 ms
 *  Memory Usage: 14296 KB
 *  시간복잡도: O(2^N)
 */

public class BOJ_1182_부분수열의합 {
    public static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), s = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(solve(arr, s));
    }

    public static int solve(int[] arr, int target){
        
        dfs(0, 0, target, arr, false);

        return answer;
    }

    private static void dfs(int idx, int now, int target, int[] arr, boolean isAdd) {
        if(isAdd && now == target)
            answer++;

        if(idx == arr.length)
            return;

        dfs(idx + 1, now + arr[idx], target, arr, true);
        dfs(idx + 1, now, target, arr, false);
    }
}

