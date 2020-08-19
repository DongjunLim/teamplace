/*
BFS

Time Complexity: O(N^2);
Space Complexity: O(N^2)
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Car {
    int x, y;
    int cost;
    Direct direction;

    public Car(int x, int y, int cost, Direct direction) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = direction;
    }
}

enum Direct {
    EAST, SOUTH, WEST, NORTH;
}

class Solution {
    public static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int[][] cost = null;

    public static int solution(int[][] board) {

        cost = new int[board.length][board.length];

        for (int[] ints : cost) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        Queue<Car> que = new LinkedList<Car>();

        cost[0][0] = 0;
        que.offer(new Car(0, 0, cost[0][0], Direct.SOUTH));
        que.offer(new Car(0, 0, cost[0][0], Direct.EAST));

        while (!que.isEmpty()) {
            Car pre = que.poll();

            for (int[] ints : direction) {
                int nextX = pre.x + ints[0];
                int nextY = pre.y + ints[1];

                if (!isBoundary(nextX, nextY)) continue;
                if (board[nextX][nextY] == 1) continue;
                if (cost[nextX][nextY] < pre.cost) continue;

                int price = pre.cost + 100;
                Direct nextDirect = findDirection(pre.x, pre.y, nextX, nextY);
                if (pre.direction != nextDirect) {
                    price += 500;
                }
                if (cost[nextX][nextY] >= price) {
                    que.offer(new Car(nextX, nextY, price, nextDirect));
                    cost[nextX][nextY] = price;
                }
            }
        }
        return cost[board.length - 1][board.length - 1];
    }

    private static boolean isBoundary(int nextX, int nextY) {
        return nextX >= 0 && nextX < cost.length && nextY >= 0 && nextY < cost.length;
    }

    private static Direct findDirection(int currentX, int currentY, int nextX, int nextY) {
        int x = nextX - currentX;
        int y = nextY - currentY;
        if (x == 0 && y == 1) return Direct.EAST;
        if (x == 0 && y == -1) return Direct.WEST;
        if (x == -1 && y == 0) return Direct.NORTH;
        return Direct.SOUTH;
    }

    public static void main(String[] args) {
//        int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
//        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};
        int answer = solution(board);
        System.out.print(answer);
    }
}
