import java.util.*;

public class BJ_2667_단지번호붙이기 {

    public static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int[][] map = null;
    public static ArrayList<Integer> answer = new ArrayList<>();

    private static void solution() {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) continue;
                bfs(i, j);
            }
        }
        printAnswer();
    }

    private static void bfs(int i, int j) {

        int cnt = 1;
        Queue<int[]> que = new LinkedList<>();

        map[i][j] = 0; //첫 방문에 대한 visit처리를 해주지 않아서 오답이었음.
        que.offer(new int[]{i, j});

        while (!que.isEmpty()) {

            int[] prev = que.poll();

            for (int[] direction : directions) {
                int nx = prev[0] + direction[0];
                int ny = prev[1] + direction[1];

                if (!isBoundary(nx, ny)) continue;
                if (map[nx][ny] == 0) continue;
                map[nx][ny] = 0;
                que.offer(new int[]{nx, ny});
                cnt++;
            }
        }
        answer.add(cnt);
    }

    private static void printAnswer() {
        Collections.sort(answer);

        System.out.print(answer.size());
        for(int number: answer){
            System.out.print("\n");
            System.out.print(number);
        }
    }

    private static boolean isBoundary(int nx, int ny) {
        return nx >= 0 && nx < map.length && ny >= 0 & ny < map.length;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        solution();
    }
}
/*
7
0110100
0110101
1110101
0000101
0100000
0111110
0111000

4
1111
1001
1001
1111
 */
