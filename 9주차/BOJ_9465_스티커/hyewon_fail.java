import java.io.*;
import java.util.*;

public class BJ_9465_스티커 {

    public static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static int N;

 /*   private static final Comparator<Node> COMPARATOR =
            Comparator.comparingInt((Node node) -> -node.value)
                    .thenComparing(node -> node.x)
                    .thenComparing(node -> node.y);*/

    public static class Node{

        public int value;
        public int x;
        public int y;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

/*        @Override
        public int compareTo(Node o) {
            return COMPARATOR.compare(this, o);
        }*/
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {
            N = Integer.parseInt(bufferedReader.readLine());
            if(N == 0) {
                printAnswer(0);
                continue;
            }
            int[][] sticker = new int[2][N];

            for (int t = 0; t < 2; t++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int i = 0; i < N; i++) {
                    sticker[t][i] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            solution(sticker);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void solution(int[][] sticker) throws IOException {

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                list.add(new Node(sticker[i][j], i, j));
            }
        }

        int score = 0;
        Collections.sort(list, Comparator.comparingInt(
                (Node node) -> -node.value)
                .thenComparing(node -> node.x)
                .thenComparing(node -> node.y)
        );
        for (Node element : list){
            if (sticker[element.x][element.y] == -1) {
                continue;
            }
            score += sticker[element.x][element.y];
            sticker[element.x][element.y] = -1;

            for (int i = 0; i < 4; i++) {
                int nx = element.x + direction[i][0];
                int ny = element.y + direction[i][1];
                if (!isboundary(nx, ny)) continue;
                sticker[nx][ny] = -1;
            }
        }
        printAnswer(score);
        bufferedWriter.flush();
    }

    private static void printAnswer(int score) throws IOException {
        bufferedWriter.write(Integer.toString(score));
    }

    private static boolean isboundary(int nx, int ny) {
        return nx >= 0 && nx < 2 && ny >= 0 && ny < N;
    }

}
/*
1

3

50 100 200

30 10 10
 */