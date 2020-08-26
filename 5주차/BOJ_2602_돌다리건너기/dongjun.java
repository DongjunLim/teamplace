public class BOJ_2602_���ٸ��ǳʱ� {
    public static int answer = 0;
    public static final int ANGEL = 0, DEVIL = 1;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String magicScroll = sc.nextLine();
        String angel = sc.nextLine();
        String devil = sc.nextLine();

        System.out.println(solve(angel, devil, magicScroll));

    }

    /**
     *
     *  @��������
     *  ������ȹ������ Ǯ�����ϴ�.
     *  �� �ε������� ������ �η縶�� ���ڿ� �����ϴ� ����� ���� �����ؼ� ���ϰ�
     *  dp�迭�� ������ �ε����� �η縶�� ���� ��ü�� ����� ����� ���� ��ȯ�մϴ�.
     *
     *  @����
     *  Runtime: 104 ms
     *  Memory Usage: 14224 KB
     *  �ð����⵵: O(�η縶�� ���� * �ٸ�����) = O(NM)
     *
     */
    private static int solve(String angel, String devil, String magicScroll) {
        int[][][] dp = new int[2][angel.length()][magicScroll.length()];

        // �������
        if(angel.charAt(0) == magicScroll.charAt(0))
            dp[ANGEL][0][0] = 1;
        if(devil.charAt(0) == magicScroll.charAt(0))
            dp[DEVIL][0][0] = 1;

        for(int i = 1; i < angel.length(); i++){

            dp[ANGEL][i][0] = angel.charAt(i) == magicScroll.charAt(0) ? dp[ANGEL][i-1][0] + 1 : dp[ANGEL][i-1][0];
            for(int j = 1; j < magicScroll.length(); j++)
                dp[ANGEL][i][j] = angel.charAt(i) == magicScroll.charAt(j) ? dp[ANGEL][i-1][j] + dp[DEVIL][i-1][j-1] : dp[ANGEL][i-1][j];

            dp[DEVIL][i][0] = devil.charAt(i) == magicScroll.charAt(0) ? dp[DEVIL][i-1][0] + 1 : dp[DEVIL][i-1][0];
            for(int j = 1; j < magicScroll.length(); j++)
                dp[DEVIL][i][j] = devil.charAt(i) == magicScroll.charAt(j) ? dp[DEVIL][i-1][j] + dp[ANGEL][i-1][j-1] : dp[DEVIL][i-1][j];
        }

        return dp[DEVIL][devil.length()-1][magicScroll.length()-1] + dp[ANGEL][angel.length()-1][magicScroll.length()-1];
    }

    /**
     *
     *  @��������
     *  ����Ž������ ��� ����� ���� Ž���߽��ϴ�.
     *
     *  @����
     *  �ð��ʰ�
     */
    public static void dfs(int idx, int scrollIdx, String magicScroll, String angel, String devil, boolean isAngel){
        if(magicScroll.length() == scrollIdx){
            answer++;
            return;
        }

        if(isAngel){
            for(int i = idx + 1; i < angel.length(); i++){
                if(angel.charAt(i) == magicScroll.charAt(scrollIdx))
                    dfs(i, scrollIdx + 1, magicScroll, angel, devil, false);
            }
        }
        else{
            for(int i = idx + 1; i < devil.length(); i++){
                if(devil.charAt(i) == magicScroll.charAt(scrollIdx))
                    dfs(i, scrollIdx + 1, magicScroll, angel, devil, true);
            }
        }
    }
}

