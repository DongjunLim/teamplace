/**
 * 
 * @��������
 * ������ȹ���� ����� Ǯ�����ϴ�.
 *
 * @����
 *  Runtime: 108 ms
 *  Memory Usage: 14356 KB
 *  �ð����⵵: O(N)
 *  
 */
public class BOJ_11057_�������� {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(solve(n));
    }

    public static int solve(int n){
        int[][] dp = new int[n+1][11];

        Arrays.fill(dp[1], 1);

        for(int i = 2; i <= n; i++){
            for(int j = 9; j >= 0; j--){
                dp[i][j] = (dp[i-1][j] + dp[i][j+1]) % 10007;
            }
        }
        int ret = 0;

        for(int i = 0; i < 10; i++)
            ret += dp[n][i];

        return ret % 10007;
    }
}
