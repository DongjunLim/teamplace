
import java.util.Scanner;

public class BJ_11055_가장_큰_증가_부분_수열 {

    private static void printAnswer(int maxValue) {
        System.out.print(maxValue);
    }

    private static void solution(int[] array) {

        int[] dp = new int[array.length];
        int maxValue = Integer.MIN_VALUE;
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + array[i]);
                }
            }
            maxValue = Math.max(dp[i], maxValue);
        }
        printAnswer(maxValue);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        solution(array);
    }
}
//5 99 100 98 99 100