import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
input : 각 element간의 관계
element간의 촌수를 구하는 문제

BFS 풀이

element간의 관계를 이차원 배열에 저장

알고싶은 두 노드 중 출발 노드를 시작으로 BFS 탐색

Time Complexity: O(V + E)
Space Complexity: O(V + E)

*/
public class BJ_2644_촌수계산 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;


        int n = Integer.parseInt(bufferedReader.readLine());
        boolean[][] family = new boolean[n + 1][n + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int src = Integer.parseInt(stringTokenizer.nextToken());
        int dst = Integer.parseInt(stringTokenizer.nextToken());

        int relationship = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < relationship; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            family[y][x] = true;
            family[x][y] = true;
        }
        int answer = solution(family, src, dst);
        System.out.print(answer);
    }

    private static int solution(boolean[][] family, int src, int dst) {
        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;
        que.offer(src);
        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                int current = que.poll();
                if (current == dst) return cnt;
                for (int i = 0; i < family.length; i++) {
                    if (family[current][i]){
                        que.offer(i);
                        family[current][i] = false;
                        family[i][current] = false;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
/*
9
3 9
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */
