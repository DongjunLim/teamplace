/**
 * @문제접근
 * board를 순회하며 L인 곳에서 bfs탐색에 들어가 최단 경로를 찾고,
 * 여태까지 구했던 최단경로보다 값이 크면 값을 갱신합니다.
 * 배열 전체 순회가 끝나면 가장 큰 값을 반환합니다.
 */

package ps.boj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2589_보물섬 {
    public static int R, C;
    public static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("./src/ps/boj/input.txt");
        Scanner sc = new Scanner(file);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        String[][] board = new String[R][C];
        for(int i = 0; i < R; i++)
            board[i] = sc.nextLine().split("");

        System.out.println(solve(board));
    }
    
    // 배열 전체를 순회하며 bfs 반복
    public static int solve(String[][] board){
        int shortestDistance = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].equals("L"))
                    shortestDistance = Math.max(shortestDistance, bfs(i, j, board));
            }
        }
        return shortestDistance;
    }
    
    public static int bfs(int row, int col, String[][] board){
        boolean[][] visited = new boolean[R][C];
        Queue<Node> queue = new LinkedList<>();
        int maxCnt = 0;

        queue.offer(new Node(row, col, 0));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            maxCnt = Math.max(maxCnt, now.cnt);
            visited[now.row][now.col] = true;

            for(int[] dt: direction){
                int nextRow = now.row + dt[0], nextCol = now.col + dt[1];

                if(checkIndexOutOfRange(nextRow, nextCol) && !visited[nextRow][nextCol]){
                    if(board[nextRow][nextCol].equals("L")) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new Node(nextRow, nextCol, now.cnt + 1));
                    }
                }
            }
        }

        return maxCnt;
    }

    // 인덱스가 배열 범위를 벗어나는지 확인
    public static boolean checkIndexOutOfRange(int row, int col){
        if(row < 0 || R <= row || col < 0 || C <= col)
            return false;
        return true;
    }
}

class Node{
    public int row;
    public int col;
    public int cnt;

    public Node(int row, int col, int cnt){
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}

