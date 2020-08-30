/**
 * 
 *  @문제접근
 *  UNION-FIND로 풀었습니다.
 *
 *  @성능
 *  Runtime: 552 ms
 *  Memory Usage: 65012 KB
 *  시간복잡도: O(M)
 *  
 */
public class BOJ_1717_집합의표현 {
    static final int UNION = 0, FIND = 1;
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        solve(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
    }

    private static void solve(int n, int m) throws IOException {
        int[] set = new int[n+1];
        Arrays.fill(set, -1);
        int order, a, b;

        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");
    
			order = Integer.parseInt(input[0]);
            a = Integer.parseInt(input[1]);
            b = Integer.parseInt(input[2]);

            if(order == UNION)
                union(a, b, set);
            else {
                if(isSameSet(a, b, set)){
                    bw.write("YES\n");
                }
                else
                    bw.write("NO\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int a, int b, int[] set) {
        int parentA = find(a, set);
        int parentB = find(b, set);
        if(parentA == parentB)
            return;
        set[parentB] = parentA;
    }

    private static int find(int a, int[] set) {
        if(set[a] < 0)
            return a;
        return set[a] = find(set[a], set);
    }

    private static boolean isSameSet(int a, int b, int[] set) {
        return find(a, set) == find(b, set);
    }
}

