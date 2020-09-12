import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
출발지점에서 목적지까지 최단 경로 문제
전형적인 BFS 문제이지만, 고려해야할 조건들이 많다.

Time Complexity: O(N*M)
Space Complexity: O(N*M)

 */
public class BJ_3055_탈출 {

    private static int[] direction_x = {1, -1, 0, 0};
    private static int[] direction_y = {0, 0, -1, 1};
    private static String[][] map;
    private static int N;
    private static int M;
    public static Queue<Point> waterQue = new LinkedList<>();
    public static Queue<Point> hedgeQue = new LinkedList<>();
    public static Point destination;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(str.charAt(j));

                if (map[i][j].equals("D")) {
                    destination = new Point(i, j, -2);
                } else if (map[i][j].equals("*")) {
                    waterQue.offer(new Point(i, j, -1));
                } else if (map[i][j].equals("S")) {
                    hedgeQue.offer(new Point(i, j, 0));
                }
            }
        }
        solution();
    }

    public static void solution() {

        String answer = "";
        while (!hedgeQue.isEmpty()) {
            extendWater();
            extendHedge();
            if (!map[destination.x][destination.y].equals("D")) {
                break;
            }
        }
        answer = map[destination.x][destination.y].equals("D") ? "KAKTUS" : map[destination.x][destination.y];
        System.out.print(answer);
    }

    private static void extendHedge() {
        int size = hedgeQue.size();
        while (size-- > 0) {
            Point temp = hedgeQue.poll();

            if (isDestination(temp.x, temp.y)) {
                map[temp.x][temp.y] = String.valueOf(temp.visit);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + direction_x[i];
                int ny = temp.y + direction_y[i];

                if (!isboundary(nx, ny)) continue;
                if (isRock(nx, ny)) continue;
                if (isWater(nx, ny)) continue;
                if (alreadyVisit(nx, ny) && !isDestination(nx,ny)) continue; //중복 방문 이므로

                map[nx][ny] = Integer.toString(temp.visit + 1);
                hedgeQue.offer(new Point(nx, ny, temp.visit + 1));
            }
        }
    }

    private static void extendWater() {
        int size = waterQue.size();
        while (size-- > 0) {
            Point temp = waterQue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + direction_x[i];
                int ny = temp.y + direction_y[i];

                if (!isboundary(nx, ny)) continue;
                if (isRock(nx, ny)) continue;
                if (isDestination(nx, ny)) continue;
                if(isWater(nx,ny)) continue;

                map[nx][ny] = "*";
                waterQue.offer(new Point(nx, ny, -1));
            }
        }
    }

    private static boolean isDestination(int nx, int ny) {
        return map[nx][ny].equals("D");
    }

    private static boolean isWater(int nx, int ny) {
        return map[nx][ny].equals("*");
    }

    private static boolean isRock(int x, int y) {
        return map[x][y].equals("X");
    }

    private static boolean isboundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static boolean alreadyVisit(int nx, int ny) {
        return !map[nx][ny].equals(".");
    }

    public static class Point {
        int x;
        int y;
        int visit;

        Point(int x, int y, int visit) {
            this.x = x;
            this.y = y;
            this.visit = visit;
        }
    }
}
/*
물이 상하좌우 4방향으로 퍼져가고,
고슴도치 또한 상하좌우 4방향으로 이동할 수 있다.
장애물을 피해서 도착지에 도달하는 최단 거리를 구하는 문제이다.

visit을 확인하기 위한 별도의 변수를 두지 않고, map에 바로 저장한다.

[고슴도치의 이동]
- 현재 위치를 큐에 담는다.
- 이동 할수 있는 4방향으로 새로운 좌표를 구한다.
- 새로운 좌표가
    - 주어진 맵의 범위 내에 있는지
    - 돌의 위치 인지
    - 물의 위치인지
    - 혹은 이미 지나온 곳인지 (체크하지 않으면 메모리 초과 발생)
확인하고, 모든 조건을 충족시킬 때에만 다시 큐에 넣어진다.

[물의 이동]
- 현재 물의 위치를 큐에 넣는다.
- 이동 할수 있는 4방향으로 새로운 좌표를 구한다.
- 새로운 좌표가
    - 주어진 맵의 범위 내에 있는지
    - 돌의 위치 인지
    - 목적지 인지
    - 혹은 이미 물인지 (체크하지 않으면 메모리 초과 발생)
확인하고, 모든 조건을 충족시킬 때에만 다시 큐에 넣어진다.

이렇게 고슴도치의 이동과 물의 이동이 한 싸이클로 돌아간다.
한 싸이클이 끝났을 경우 혹시 도착지에 도달하지는 않았는지 체크하고
도달하지 못한 경우 다시 이와 같은 과정을 반복한다.
 */