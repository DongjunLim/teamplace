import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1963_소수경로 {

    public static int MAXSIZE = 10001;
    public static boolean[] prime = new boolean[MAXSIZE];
    public static int[] count = new int[MAXSIZE];
    public static int start;
    public static int end;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        eratos();

        for(int i =0;i< testCase; i++){
            start = scanner.nextInt();
            end = scanner.nextInt();

            Arrays.fill(count, Integer.MAX_VALUE);
            solution(start, end);
        }

    }

    private static void solution(int start, int end) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        count[start] = 0;

        while (!que.isEmpty()) {
            int currentInt = que.poll();
            String[] currentString = Integer.toString(currentInt).split("");

            for (int index = 0; index < 4; index++) {
                for (int j = 0; j < 10; j++) {
                    if(index == 0 && index == j) continue;
                    int nextInteger = toInteger(currentString, index, j);

                    if(prime[nextInteger] && count[nextInteger] > count[currentInt]) {
                        count[nextInteger] = count[currentInt] + 1;
                        que.offer(nextInteger);
                    }
                }
            }
        }
        printAnswer(end);
    }

    public static void eratos() {
        Arrays.fill(prime, true);

        for (int i = 2; i * i < MAXSIZE; i++) {
            for (int j = i * i; j < MAXSIZE; j += i) {
                prime[j] = false;
            }
        }
    }

    private static int toInteger(String[] currentString, int index, int j) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (i == index)
                result = result * 10 + j;
            else
                result = result * 10 + Integer.parseInt(currentString[i]);
        }
        return result;
    }

    private static void printAnswer(int end) {
        System.out.println((count[end] == Integer.MAX_VALUE)? "IMPOSSIBLE" : count[end]);
    }
}