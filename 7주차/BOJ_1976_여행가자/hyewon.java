import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Time Complexity: O(N^3)
Space Complexity:O(1)

@문제이해
주여진 여행경로를 이행할 수 있는지에 대한 여부를 판단한다.

@input
N*N의 행렬로 도시간의 연결 관계와 여행경로가 주어진다.

@알고리즘과 복잡도
A,B,C 3개의 도시가 있다고 가정해보자.

A에서 B를 갈 수 있다면
B에서 갈수 있는 도시들들에 대한 정보를 A가 갈 수 있는 경로로 update한다.(or연산)
A에서 C를 갈 수 있다면
C에서 갈수 있는 도시들들에 대한 정보를 A가 갈 수 있는 경로로 update한다.(or연산)
이때 O(N^2)의 시간이 소요된다.

이와 같은 과정을 주어진 모든 도시에 대하여 반복해야 하므로 O(N^3)의 시간복잡도를 갖는다.

하지만.. Wrong Answer
어디가 문제인지 모르겠다.

*/

public class BJ_1976_여행_가자 {
    public static boolean[][] map;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String answer = "YES";
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        makeRoot();

        st = new StringTokenizer(br.readLine());
        int next = Integer.parseInt(st.nextToken());

        for (int i = 1; i < m; i++) {
            int current = next;
            next = Integer.parseInt(st.nextToken());
            if (!map[current - 1][next - 1]) {
                answer = "NO";
                break;
            }
        }
        System.out.print(answer);
        br.close();
    }

    private static void makeRoot() {
        int size = map.length;
        for (int index = 0; index < size; index++) {
            for (int col = 0; col < size; col++) {
                if(!map[index][col]) continue;
                for (int row = 0; row < size; row++) {
                    map[index][row] |= map[col][row];
                }
            }
        }
    }

}
/*
5
5
0 1 1 0 0
1 0 0 0 0
1 0 0 0 0
0 0 0 0 1
0 0 0 1 0
1 2 3 4 5

5
2
0 0 0 0 1
0 0 0 0 1
0 0 0 0 1
0 0 0 0 0
1 1 1 0 0
1 3

3
5
1 0 0
0 1 1
0 1 1
2 3 2 3 2

3
3
0 1 0
1 0 1
0 1 0
1 2 3
 */