import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private final byte EAST = 0, SOUTH = 1, WEST = 2, NORTH = 3, ANY = 4;
    private final byte[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(int[][] board) {
        int[][][] dist = new int[board.length][board.length][5];
        for(int[][] d: dist)
            for(int [] f: d)
                Arrays.fill(f, Integer.MAX_VALUE);

        dist[0][0][0] = 0;
        dist[0][0][1] = 0;
        dist[0][0][2] = 0;
        dist[0][0][3] = 0;
        dist[0][0][4] = 0;


        int answer = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0, ANY});

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            int nowRow = now[0], nowCol = now[1], nowCost = now[2], nowdt = now[3];
            if(nowRow == board.length-1 && nowCol == board.length-1)
                answer = Math.min(answer, nowCost);

            for(int nextDt = 0; nextDt < DIRECTION.length; nextDt++){
                int nextRow = nowRow + DIRECTION[nextDt][0], nextCol = nowCol + DIRECTION[nextDt][1];

                int nextCost = nowdt == nextDt || nowdt == ANY ? 100 : 600;

                if(isBuilt(nextRow, nextCol, board)){
                    if(dist[nextRow][nextCol][nextDt] < dist[nowRow][nowCol][nowdt] + nextCost)
                        continue;
                    dist[nextRow][nextCol][nextDt] = dist[nowRow][nowCol][nowdt] + nextCost;
                    queue.offer(new int[] {nextRow, nextCol, dist[nextRow][nextCol][nextDt], nextDt});
                }
            }
        }
        return answer;
    }

    public boolean isBuilt(int row, int col, int[][] board){
        if(row < 0 || board.length <= row || col < 0 || board.length <= col)
            return false;

        if(board[row][col] == 1)
            return false;

        return true;
    }
}
