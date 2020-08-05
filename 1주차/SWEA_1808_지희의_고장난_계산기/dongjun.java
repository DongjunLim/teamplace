/**
 *  @��������
 *   ��� + �޸������̼��� ����� Ǯ�����ϴ�.
 *   �������길 �����ϴ� A * b = target�� �Ǵ� A, B�� ã���ϴ�.
 *   target�� ���� �Է� �ּ�Ƚ���� A�� �ּ�Ƚ�� + B�� �ּ�Ƚ�� + 1�Դϴ�. ( 1�� ����Ű )
 *   �ٽ� A�� B ������ �ּ�Ƚ���� A�� �� ����� �ּ�Ƚ���� ���� �� + 1,
 *   B�� �� ����� �ּ�Ƚ���� ���� �� + 1�� �� �� �ֽ��ϴ�.
 *   �̷��� ��������� �� ������ �ּ�Ƚ���� ��� ���ϰ� �̸� ���� target�� �ּ�Ƚ���� ���մϴ�.
 */

package ps.swea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class SWEA_1808_������_���峭_���� {
    static int[] dp;
    final static int IMPOSSIBLE = 999999999;

    // ���� ���� ���ڸ� ������ �Ű����� n�� ���� �� �ִ��� Ȯ���ϰ�, ���� �� �ִٸ� ������ Ƚ���� ��ȯ�մϴ�.
    public static int findPressCnt(int n, ArrayList<Integer> usableNumbers){
        int cnt = 0;
        while(n > 0){
            if(!usableNumbers.contains(n%10)) return IMPOSSIBLE;
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    // �Ű����� num���� ��ư�� �Է��ϴ� �ּ� Ƚ���� ����մϴ�.
    public static int calc(int num, ArrayList<Integer> usableNumbers){

        if(dp[num] != 0)   return dp[num];
        dp[num] = findPressCnt(num, usableNumbers);

        for(int candidateNum = 2; candidateNum < Math.sqrt(num) + 1; candidateNum++){
            if(num % candidateNum == 0){
                int divisor1 = calc(candidateNum, usableNumbers);
                int divisor2 = calc(num / candidateNum, usableNumbers);

                int calcResult = divisor1 != IMPOSSIBLE && divisor2 != IMPOSSIBLE ? divisor1 + divisor2 : IMPOSSIBLE;
                dp[num] = Math.min(dp[num], calcResult + 1);
            }
        }

        return dp[num];
    }

    // ���峪�� ���� ��ư�� �ּ�Ƚ���� 1�� �ʱ�ȭ�ϰ� calc �޼��带 ȣ���� target�� �ּ� ��ư�Է�Ƚ���� ã���ϴ�.
    public static int solve(int target, ArrayList<Integer> usableNumbers){
        dp = new int[target+10];
        for(int un: usableNumbers) dp[un] = 1;

        calc(target, usableNumbers);

        return dp[target] != IMPOSSIBLE ? dp[target] + 1 : -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("./src/ps/swea/input.txt");
        Scanner sc = new Scanner(file);
        ArrayList<Integer> usableNumbers = new ArrayList<>();

        int T = sc.nextInt();
        sc.nextLine();
        for(int tc = 1; tc <= T; tc++){
            usableNumbers.clear();
            for(int i=0; i<10; i++) {
                if(sc.nextInt() ==1){
                    usableNumbers.add(i);
                };
            }

            sc.nextLine();
            int target = sc.nextInt();
//            System.out.println(usableNumbers.toString());
            System.out.println("#" + tc + " " + solve(target, usableNumbers));
        }
    }
}

