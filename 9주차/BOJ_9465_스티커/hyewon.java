import java.io.*;
import java.util.*;

public class BJ_9465_스티커 {

    public static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {
            N = Integer.parseInt(bufferedReader.readLine());
            if (N == 0) {
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

        sticker[0][1] += sticker[1][0];
        sticker[1][1] += sticker[0][0];
        for (int col = 2; col < N; col++) {

            sticker[0][col] += findMax(sticker[1][col-1],sticker[0][col-2],sticker[1][col-2]);
            sticker[1][col] += findMax(sticker[0][col-1],sticker[0][col-2],sticker[1][col-2]);
        }
        int score = Math.max(sticker[0][N-1], sticker[1][N-1]);
        printAnswer(score);
    }

    private static int findMax(int a, int b, int c) {
        return Math.max(Math.max(a,b),c);
    }

    private static void printAnswer(int score) throws IOException {
        bufferedWriter.write(Integer.toString(score) + "\n");
    }

}