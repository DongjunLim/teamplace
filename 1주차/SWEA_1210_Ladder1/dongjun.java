/**
 *  @문제접근
 *  탐색에 조건을 걸어 해결했습니다.
 *  1. 양옆에 사다리가 있으면 옆으로 이동합니다.
 *  2. 옆에 사다리가 없다면 아래로 내려갑니다.
 *  3. 배열의 끝까지 내려가면 해당 인덱스에 담겨있는 값을 반환합니다.
 *  4. 반환한 값이 2면 시작 열정보를 반환합니다.
 */

package ps.swea;

import java.util.Scanner;

public class SWEA_1210_Ladder1 {
    public static int MAX = 100, START = 0;
    public static boolean[][] visited = new boolean[MAX][MAX];
    public static int[][] DIRECTION = {{0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[MAX][MAX];
        for(int t = 1; t <= 10; t++){
            String tc = sc.nextLine();
            for(int i = 0; i<MAX; i++){
                String[] input = sc.nextLine().split(" ");

                for(int j = 0; j < input.length; j++)
                    board[i][j] = Integer.parseInt(input[j]);
            }
            System.out.println("#" + tc + " " + solve(board));
        }
    }

    private static int solve(int[][] board) {
        for(int col = 0; col < MAX; col++){
            if(board[START][col] == 1) {
                visited = new boolean[MAX][MAX];
                int playResult = playLadder(START, col, board);
                if(playResult == 2)
                    return col;
            }
        }
        return 0;
    }

    // 재귀적으로 사다리를 내려감
    private static int playLadder(int row, int col, int[][] board) {
        if(row == board.length-1)
            return board[row][col];

        for(int[] next: DIRECTION){
            int nextRow = row+next[0], nextCol = col+next[1];

            if(checkIndexOutOfRange(nextRow, nextCol) && board[nextRow][nextCol] != 0 && !visited[nextRow][nextCol]){
                visited[nextRow][nextCol] = true;
                return playLadder(nextRow, nextCol, board);
            }
        }
        return 0;
    }

    // 인덱스 값이 배열 범위를 벗어나는지 조사
    private static boolean checkIndexOutOfRange(int row, int col){
        if(row < 0 || MAX <= row || col < 0 || MAX <= col)
            return false;
        return true;
    }
}

