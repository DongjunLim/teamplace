import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
출발지에서 목저지 까지 가는데 최단 경로를 구하는 문제

BFS를 이용한 풀이

출발위치를 큐에 담고 시작한다.
현재 위치로부터 -1, +1, *2 의 위치로 이동할 수 있다.
3가지 방식으로 이동할 수 있는 지를 검사하고
이동할 수 있다면 새로운 좌표를 다시 큐에 넣는다.
계속해서 이와 같은 과정을 반복한다.
다만, 똑같은 위치를 반복하여 방문하는 것을 방지 하기위해 visit체크를 위한 변수를 둔다.

BFS
Time Complexity: O( V + E )
Space Complexity: O( V + E )

BFS에서는 항상 visit을 체크하는 위치에서 에러를 발생시킨다.
큐에 넣기전 visit을 체크해야 에러가 발생하지 않는다.

 */

public class BJ_1697_숨바꼭질 {

    public static class Point {
        int place;
        int cnt;

        Point(int place, int cnt) {
            this.place = place;
            this.cnt = cnt;
        }
    }

    public static final int MAXLEN = 100001;
    public static boolean[] visit = new boolean[MAXLEN];

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();
        int dest = scanner.nextInt();
        solution(source, dest);
    }

    private static void solution(int source, int dest) {
        Queue<Point> que = new LinkedList<>();

        visit[source] = true;
        que.offer(new Point(source, 0));

        while (!que.isEmpty()) {
            Point current = que.poll();

            if (current.place == dest) {
                printAnswer(current.cnt);
                return;
            }
            //index값이 범위 안에 있는 지 check
            //방문한 적이 있었는지 check
            if (isBoundary(current.place - 1) && !visit[current.place - 1]) {
                visit[current.place - 1] = true;
                que.offer(new Point(current.place - 1, current.cnt + 1));
            }
            if (isBoundary(current.place + 1) && !visit[current.place + 1]) {
                visit[current.place + 1] = true;
                que.offer(new Point(current.place + 1, current.cnt + 1));
            }
            if (isBoundary(current.place * 2) && !visit[current.place * 2]) {
                visit[current.place * 2] = true;
                que.offer(new Point(current.place * 2, current.cnt + 1));
            }
        }
    }

    private static boolean isBoundary(int place) {
        return place >= 0 && place < MAXLEN;
    }

    private static void printAnswer(int cnt) {
        System.out.print(cnt);
    }
}
