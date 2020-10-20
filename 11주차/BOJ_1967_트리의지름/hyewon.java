import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_1967_트리의_지름 {

    static class Pair {
        int point, weight;

        public Pair(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }
    }

    public static ArrayList<Pair>[] tree;
    public static boolean visit[];
    public static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        visit = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        Arrays.fill(visit, false);

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n -1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int value = Integer.parseInt(stringTokenizer.nextToken());

            tree[x].add(new Pair(y, value));
            tree[y].add(new Pair(x, value));
        }
        solution();
    }

    private static void solution() {
        for (int start = 0; start < visit.length; start++) {
            dfs(start, 0);
        }
        System.out.print(maxValue);
    }

    private static void dfs(int start, int currentWeight) {

        maxValue = Math.max(currentWeight,maxValue);

        visit[start] = true;
        for(Pair nextPoint : tree[start]){
            if(visit[nextPoint.point]) continue;
            dfs(nextPoint.point, currentWeight + nextPoint.weight);
        }
        visit[start] = false;
    }
}
