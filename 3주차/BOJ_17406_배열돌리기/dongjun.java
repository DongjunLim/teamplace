package ps.boj;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @문제접근
 * 모든 회전연산을 사용하는 조합을 dfs로 탐색해
 * 각각의 경우에서 모두 배열을 회전시켜보며
 * 회솟값을 찾았습니다.
 *
 *  @성능
 *  Runtime: 328 ms
 *  Memory Usage: 44388 KB
 *  시간복잡도: O((2^K)*(N^2))
 *
 */
public class BOJ_17406_배열돌리기 {
    public static int N, M, K;
    public static int[][] origin;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();

        origin = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                origin[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int[][] operation = new int[K][];

        for (int k = 0; k < K; k++) {
            operation[k] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        System.out.println(solve(operation));
    }

    private static int solve(int[][] operation) {
        visited = new boolean[K];

        dfs(0, operation, origin);

        return answer;
    }

    private static void dfs(int cnt, int[][] operation, int[][] tempBoard){
        if(cnt == K){
            answer = Math.min(answer, getMinRowSum(tempBoard));
            return;
        }

        for(int i = 0; i < operation.length; i++){
            if(!visited[i]){
                int[][] copy = arrayDeepCopy(tempBoard);

                int[] op = operation[i];
                int r = op[0], c = op[1], s = op[2];
                int sr = r - s, sc = c - s;
                int er = r + s, ec = c + s;

                rotate(sr, sc, er, ec, copy);

                visited[i] = true;
                dfs(cnt + 1, operation, copy);
                visited[i] = false;
            }
        }
    }

    private static void rotate(int sr, int sc, int er, int ec, int[][] board) {
        int depth = 0;

        while (true) {
            int nsr = sr + depth, nsc = sc + depth;
            int ner = er - depth, nec = ec - depth;
            if(nsr >= ner || nsc >= nec)
                break;

            int preVal = board[nsr - 1][nsc];

            for (int c = nsc; c <= nec; c++) {
                int temp = board[nsr][c];
                board[nsr][c] = preVal;
                preVal = temp;
            }

            for (int r = nsr + 1; r <= ner; r++) {
                int temp = board[r][nec];
                board[r][nec] = preVal;
                preVal = temp;
            }

            for (int c = nec - 1; c >= nsc; c--) {
                int temp = board[ner][c];
                board[ner][c] = preVal;
                preVal = temp;
            }

            for (int r = ner -1; r >= nsr; r--) {
                int temp = board[r][nsc];
                board[r][nsc] = preVal;
                preVal = temp;
            }
            depth++;
        }
    }

    private static int getMinRowSum(int[][] board) {
        int ret = Integer.MAX_VALUE;

        for(int i =1; i <= N; i++){
            int cnt = 0;
            for(int j = 1; j <= M; j++){
                cnt += board[i][j];
            }
            ret = Math.min(ret, cnt);
        }
        return ret;
    }

    private static int[][] arrayDeepCopy(int[][] arr){
        int[][] ret = new int[arr.length][];

        for(int i = 0; i < arr.length; i++){
            ret[i] = arr[i].clone();
        }
        return ret;
    }
}

