/**
 * @문제접근
 * BFS로 풀었습니다.
 * 한번 탐색에 들어가면 연결된 모든 곳을 방문처리해서 구역을 구분했습니다.
 * 최솟값부터 출력해야 하기 때문에 정답을 최소힙에 담아서
 * 작은값부터 차례로 출력하게 구현했습니다.
 *
 * @성능
 *  Runtime: 84 ms
 *  Memory Usage: 13216 KB
 *  시간복잡도: O(N^2)
 */

public class BOJ_2667_단지번호붙이기 {
    public static boolean visited[][];
    public static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {



        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++)
            board[i] = br.readLine().toCharArray();


        solve(board);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(char[][] board) throws IOException {
        PriorityQueue<Integer> answer = new PriorityQueue<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '1' && !visited[i][j]){
                    answer.offer(visitProcess(i, j, board));
                }
            }
        }

        bw.write(Integer.toString(answer.size()) + '\n');
        while(!answer.isEmpty()){
            bw.write(Integer.toString(answer.poll()) + '\n');
        }
    }

    public static int visitProcess(int sr, int sc, char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        int cnt = 1;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            visited[now[0]][now[1]] = true;

            for(int[] dt: DIRECTION){
                int nr = now[0] + dt[0], nc = now[1] + dt[1];

                if(checkIdxOutOfRange(nr, nc, board.length) && board[nr][nc] == '1' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    cnt++;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        return cnt;
    }

    public static boolean checkIdxOutOfRange(int row, int col, int n){
        if(row < 0 || n <= row || col < 0 || n <= col)
            return false;
        return true;
    }
}

