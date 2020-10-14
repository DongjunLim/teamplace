import java.util.*;

public class BJ_1699_제곱수의_합 {

    public static int[] dp = null;
    public static Set<Integer> powCandidate = new HashSet<>(Arrays.asList(0, 1, 4, 5, 6, 9));

    public static int solution(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp,0);

        for(int i =1;i<=n;i++){
            dp[i] = i;
            for(int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i],dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = solution(n);
        System.out.println(answer);
    }
}
