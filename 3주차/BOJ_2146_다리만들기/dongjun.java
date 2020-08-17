/**@��������
 * BFS�� Ǯ�����ϴ�.
 * ���� BFS�� ���� ��ȣ�� �ο��ϰ�,
 * ���� ������ �ٴٱ����� ������������ ǥ���� edgepoint �迭�� �����մϴ�.
 * �󺧸��� ������ �� ������������ bfs�� �ϸ� �ּ� �Ǽ������ ã���ϴ�.
 *
 * @����
 *  Runtime: 316 ms
 *  Memory Usage: 30240 KB
 *  �ð����⵵: O(N^4)?
 */

public class BOJ_2146_�ٸ������ {
    public static int[][] visited;
    public static int[][] edgepoint;
    public static boolean[][] isBuilt;
    public static int answer = Integer.MAX_VALUE;

    public static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
            sc.nextLine();
        }

        System.out.println(solve(n, board));
    }

    private static int solve(int n, int[][] board) {
        visited = new int[n][n];
        edgepoint = new int[n][n];
        isBuilt = new boolean[n][n];

        int islandNum = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1 && visited[i][j] == 0){
                    label(i, j, n, islandNum, board);
                    islandNum++;
                }
            }
        }

        if(answer == 1)
            return answer;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(edgepoint[i][j] > 0){
                    islandNum = edgepoint[i][j];
                    answer = Math.min(answer, buildBridge(i, j, n, islandNum));
                }
            }
        }
        return answer;
    }
    
    private static void label(int sr, int sc, int n, int islandNum, int[][] board) {

        Queue<int[]> queue = new LinkedList<>();
        visited[sr][sc] = islandNum;
        edgepoint[sr][sc] = -1;
        queue.offer(new int[] {sr, sc});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowR = now[0], nowC = now[1];

            for(int[] dt: DIRECTION){
                int nr = nowR + dt[0], nc = nowC + dt[1];

                if(checkIdxOutOfRange(nr, nc, n) && visited[nr][nc] == 0) {
                    if(board[nr][nc] == 0){
                        if(edgepoint[nr][nc] != islandNum && edgepoint[nr][nc] > 0){
                            answer = 1;
                            return;
                        }
                        edgepoint[nr][nc] = islandNum;
                    }
                    else if(board[nr][nc] == 1) {
                        visited[nr][nc] = islandNum;
                        edgepoint[nr][nc] = -1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    private static int buildBridge(int sr, int sc, int n, int islandNum){
        for(boolean[] b: isBuilt)
            Arrays.fill(b, false);

        Queue<int[]> queue = new LinkedList<>();
        isBuilt[sr][sc] = true;
        queue.offer(new int[] {sr, sc, 1});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowR = now[0], nowC = now[1];
            int cost = now[2];

            if (edgepoint[nowR][nowC] != islandNum && edgepoint[nowR][nowC] > 0)
                return cost;

            for (int[] dt : DIRECTION) {
                int nr = nowR + dt[0], nc = nowC + dt[1];

                if (checkIdxOutOfRange(nr, nc, n) && edgepoint[nr][nc] > -1 && !isBuilt[nr][nc]) {
                    isBuilt[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, cost + 1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static boolean checkIdxOutOfRange(int row, int col, int n){
        if(row < 0 || n <= row || col < 0 || n <= col)
            return false;
        return true;
    }
}

