import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2589_보물섬 {
    private static int[] direction_x = {1, -1, 0, 0};
    private static int[] direction_y = {0, 0, -1, 1};
    private static int[][] map;
    private static int N;
    private static int M;

    private static boolean isBoundary(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static int[][] deepCopy(int[][] original){
        if(original == null) return null;

        int[][] result = new int[original.length][original[0].length];

        for(int i =0;i< original.length; i++){
            System.arraycopy(original[i],0,result[i],0,original[0].length);
        }
        return result;
    }
    private static int breadthFistSearch(int x, int y) {

        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[][] count = deepCopy(map);

        int localMax = Integer.MIN_VALUE;

        visited[x][y] = true;
        que.offer(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] current = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + direction_x[i];
                int ny = current[1] + direction_y[i];

                if (!isBoundary(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                que.offer(new int[]{nx, ny});
                count[nx][ny] = count[current[0]][current[1]] + 1;
                localMax = Math.max(count[nx][ny] -1, localMax);
            }
        }
        return localMax;
    }

    private static void printAnswer(int maxCount) {
        System.out.print(maxCount);
    }

    private static void solution(int[][] map) {

        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                count = breadthFistSearch(i, j);
                maxCount = Math.max(count, maxCount);
            }
        }
        printAnswer(maxCount);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = (str.charAt(j) == 'W') ? 0 : 1;
            }
        }
        solution(map);
    }
}
