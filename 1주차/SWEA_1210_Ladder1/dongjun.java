/**
 *  @��������
 *  Ž���� ������ �ɾ� �ذ��߽��ϴ�.
 *  1. �翷�� ��ٸ��� ������ ������ �̵��մϴ�.
 *  2. ���� ��ٸ��� ���ٸ� �Ʒ��� �������ϴ�.
 *  3. �迭�� ������ �������� �ش� �ε����� ����ִ� ���� ��ȯ�մϴ�.
 *  4. ��ȯ�� ���� 2�� ���� �������� ��ȯ�մϴ�.
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

    // ��������� ��ٸ��� ������
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

    // �ε��� ���� �迭 ������ ������� ����
    private static boolean checkIndexOutOfRange(int row, int col){
        if(row < 0 || MAX <= row || col < 0 || MAX <= col)
            return false;
        return true;
    }
}

