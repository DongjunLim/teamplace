/**
 * @��������
 * BFS�� Ǯ�����ϴ�.
 * �ѹ� Ž���� ���� ����� ��� ���� �湮ó���ؼ� ������ �����߽��ϴ�.
 * �ּڰ����� ����ؾ� �ϱ� ������ ������ �ּ����� ��Ƽ�
 * ���������� ���ʷ� ����ϰ� �����߽��ϴ�.
 *
 * @����
 *  Runtime: 84 ms
 *  Memory Usage: 13216 KB
 *  �ð����⵵: O(N^2)
 */

public class BOJ_2667_������ȣ���̱� {
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

