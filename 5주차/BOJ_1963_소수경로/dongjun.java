/**
 * @문제접근
 * bfs로 풀었습니다. 가능한 모든 소수를 미리 구해 놓고
 * 자릿수를 하나씩 바꿔가며 최소 변경횟수를 찾았습니다.
 *
 * @성능
 *  Runtime: 124 ms
 *  Memory Usage: 14204 KB
 *  시간복잡도: O(VE) V = 노드의 갯수 = 1000~9999,  E = 간선의 갯수 = 36
 */
public class BOJ_1963_소수경로 {
    static boolean[] compositeNumber;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        visited = new boolean[10000];
        setPrime();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            String[] input = br.readLine().split(" ");

            int ret = solve(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

            if(ret == -1)
                bw.write("Impossible" + "\n");
            else
                bw.write(ret + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int solve(int start, int target) {
        Arrays.fill(visited, false);
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {start, 0});
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            int num = now[0], cnt = now[1];

            if(num == target)
                return cnt;

            for(int i = 1; i <= 4; i++){
                int j = i == 4 ? 1 : 0;

                for(; j <= 9; j++){
                    int next = setNextNumber(num, i, j);

                    if(!compositeNumber[next] && !visited[next]){
                        visited[next] = true;
                        queue.offer(new int[] {next, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }

    public static int setNextNumber(int num, int digit, int singleNum){
        int temp = (int) Math.pow(10, digit);
        int subDigitNum = num % temp;
        int addDigitNum = (temp / 10) * singleNum;
        int mod = num % (temp / 10);
        return num - subDigitNum + addDigitNum + mod;
    }

    public static void setPrime(){
        compositeNumber = new boolean[10000];

        for(int i = 2; i < 10000; i++){
            if(!compositeNumber[i]){
                for(int j = i + i; j < 10000; j += i){
                    compositeNumber[j] = true;
                }
            }
        }
    }
}
