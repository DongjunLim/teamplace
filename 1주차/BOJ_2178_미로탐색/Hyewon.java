import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {

    private static int[] direction_x = {1, -1, 0, 0};
    private static int[] direction_y = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int[][] map;
    private static int N;
    private static int M;


    private static boolean isBoundary(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static void breadthFistSearch(int x, int y) {

        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{x, y});

        while (!que.isEmpty()) {

            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + direction_x[i];
                int ny = cur[1] + direction_y[i];

                if (!isBoundary(nx, ny)) continue;
                if(map[nx][ny]== 0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                que.offer(new int[]{nx,ny});
                map[nx][ny] = map[cur[0]][cur[1]] + 1;
            }
        }
    }

    private static void printAnswer() {
        System.out.print(map[N-1][M-1]);
    }

    private static void solution(int[][] map) {
        visited[0][0] = true;
        breadthFistSearch(0, 0);
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) -'0';
            }
        }
        solution(map);
    }
}
