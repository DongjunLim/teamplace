/**
 *  @문제접근
 *   약수 + 메모이제이션을 사용해 풀었습니다.
 *   곱셈연산만 가능하니 A * b = target이 되는 A, B를 찾습니다.
 *   target의 계산기 입력 최소횟수는 A의 최소횟수 + B의 최소횟수 + 1입니다. ( 1은 곱셈키 )
 *   다시 A와 B 각각의 최소횟수는 A의 두 약수의 최소횟수를 더한 값 + 1,
 *   B의 두 약수의 최소횟수를 더한 값 + 1로 볼 수 있습니다.
 *   이렇게 재귀적으로 들어가 각각의 최소횟수를 모두 구하고 이를 더해 target의 최소횟수를 구합니다.
 */

package ps.swea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class SWEA_1808_지희의_고장난_계산기 {
    static int[] dp;
    final static int IMPOSSIBLE = 999999999;

    // 연산 없이 숫자만 눌러서 매개변수 n을 만들 수 있는지 확인하고, 만들 수 있다면 누르는 횟수를 반환합니다.
    public static int findPressCnt(int n, ArrayList<Integer> usableNumbers){
        int cnt = 0;
        while(n > 0){
            if(!usableNumbers.contains(n%10)) return IMPOSSIBLE;
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    // 매개변수 num에서 버튼을 입력하는 최소 횟수를 계산합니다.
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

    // 고장나지 않은 버튼의 최소횟수를 1로 초기화하고 calc 메서드를 호출해 target의 최소 버튼입력횟수를 찾습니다.
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

