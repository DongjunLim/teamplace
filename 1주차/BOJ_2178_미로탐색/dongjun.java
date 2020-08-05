/**
 * @문제접근
 * BFS로 풀었습니다.
 */

package ps.boj;

import java.util.*;


class Node {
    int row;
    int col;
    int cnt;

    public Node(int row, int col, int cnt){
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}


public class BOJ_2178_미로탐색 {
    public static int N, M;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        ArrayList<char[]> board = new ArrayList<>(N);

        for(int i = 0; i < N; i++){
            String temp = sc.nextLine();
            board.add(temp.toCharArray());
        }

        System.out.println(solve(board));
    }

    private static int solve(ArrayList<char[]> board) {
        return bfs(0, 0, board);
    }

    private static int bfs(int start, int end, ArrayList<char[]> board){
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[N][M];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, end, 1));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.row == N-1 && now.col == M-1)
                return now.cnt;


            for(int[] dt: direction){
                int nextRow = now.row + dt[0], nextCol = now.col + dt[1];

                if(checkIndexOutOfRange(nextRow, nextCol) && board.get(nextRow)[nextCol] != '0' && !visited[nextRow][nextCol]){
                    visited[nextRow][nextCol] = true;
                    queue.offer(new Node(nextRow, nextCol, now.cnt + 1));
                }
            }
        }
        return 0;
    }

    private static boolean checkIndexOutOfRange(int row, int col) {
        if(row < 0 || N <= row || col < 0 || M <= col)
            return false;
        return true;
    }
}

