/**
 *  @문제접근
 *  각각의 홈에서 이동 가능한 홈들을 인접리스트로 세팅한 후
 *  BFS로 풀었습니다.
 *
 *  @성능
 *  Runtime: 1752 ms
 *  Memory Usage: 55116 KB
 *  시간복잡도: O(N^2) -> 완전 연결 그래프가 나올 경우
 */

public class BOJ_2412_암벽등반 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), T = Integer.parseInt(input[1]);

        ArrayList<int[]> nodes = new ArrayList<>(n+1);
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(n+1);

        setInput(n, nodes, edges);

        System.out.println(solve(n, T, nodes, edges));
    }

    private static int solve(int n, int t, ArrayList<int[]> nodes, ArrayList<ArrayList<Integer>> edges) {
        nodes.sort((e1, e2) -> { return Integer.compare(e1[0], e2[0]);});

        setEdge(nodes, edges);

        return bfs(t, nodes, edges);
    }

    public static void setEdge(ArrayList<int[]> nodes, ArrayList<ArrayList<Integer>> edges){
        for(int i = 0; i < nodes.size(); i++){
            int[] now = nodes.get(i);
            int nx = now[0], ny = now[1];
            for(int j = i+1; j < nodes.size(); j++){
                int[] c = nodes.get(j);
                int na = c[0], nb = c[1];
                if(na-nx > 2)
                    break;

                if(isClime(nx, ny, na, nb)){
                    edges.get(i).add(j);
                    edges.get(j).add(i);
                }
            }
        }
    }


    public static boolean isClime(int x, int y, int a, int b){
        if(Math.abs(a-x) <= 2 && Math.abs(b-y) <= 2)
            return true;

        return false;
    }

    private static int bfs(int T, ArrayList<int[]> nodes, ArrayList<ArrayList<Integer>> edges) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {0, 0});

        int[] dists = new int[nodes.size()];
        Arrays.fill(dists, Integer.MAX_VALUE);

        dists[0] = 0;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int nodeNum = node[0], nowDist = node[1];

            ArrayList<Integer> edge = edges.get(nodeNum);

            if(nodes.get(nodeNum)[1] == T){
                return nowDist;
            }

            for(int i = 0; i < edge.size(); i++){
                int nextNode = edge.get(i);

                if(nowDist + 1 < dists[nextNode]){
                    dists[nextNode] = nowDist + 1;
                    queue.offer(new int[] {nextNode, nowDist + 1});
                }
            }
        }
        return -1;
    }

    private static void setInput(int n, ArrayList<int[]> nodes, ArrayList<ArrayList<Integer>> edges) throws IOException {
        int x, y;
        String[] input;

        nodes.add(new int[] {0, 0});
        edges.add(new ArrayList<Integer>());

        for(int i = 1; i <= n; i++){
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            nodes.add(new int []{x, y});
            edges.add(new ArrayList<Integer>());
        }
    }
}

