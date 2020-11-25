import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
주어진 관계들 중에서 A-B-C-D-E 과 같은 친구관게계가 있는지 찾는 문제('-' 친구관계를 나타냄)

다섯명의 연속 친구관계를 찾고있으므로 DFS의 깊이가 5를 만족하면 true를 return하면 된다.
출발노드에 따라 깊이가 달라지므로 각각의 노드를 출발노드로 하여 모든 N에 대하여 탐색해야한다.

DFS에서는 현재의 index 넘버와, 카운트 변수를 가진다.
index 번호는 현재 노드의 번호를 가리키며, 카운트는 깊이를 의미한다.

DFS 과정
출발노드에서 갈 수 있는 노드를 찾아본다.
다음노드가 이미 방문한 노드가 아니라면
카운트 변수에 1을 추가하여 다음 노드에 대하여 DFS 탐색을 진행한다.

Time Complexity: O(N*M) // M개의 관계(간선)에 대하여 친구관계를 만족하는지 확인해아하며, N번의 DFS를 돌아야하므로
Space Complexity: O(1) // DFS의 깊이가 5이상으로 가지 않으므로(?)
 */

public class BJ_13023_ABCDE {

    public static boolean[] visit = null;
    public static boolean ans = false;
    public static ArrayList<Integer>[] relations;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        visit = new boolean[n];
        relations = new ArrayList[n];

        for(int i =0;i<n; i++){
            relations[i] = new ArrayList<>();
        }
        Arrays.fill(visit, false);

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            relations[x].add(y);
            relations[y].add(x);
        }
        solution();
    }

    private static void solution() {
        for (int i = 0; i < visit.length; i++) {
            isFriends(i, 1);
            if (ans) break;
        }
        System.out.print(ans ? "1" : "0");
    }

    private static void isFriends(int current, int cnt) {

        if (cnt == 5) {
            ans = true;
            return;
        }
        visit[current] = true;
        for (int index : relations[current]) {
            if (visit[index]) continue;
            isFriends(index, cnt + 1);
            if (ans) return;
        }
        visit[current] = false;
    }
}
