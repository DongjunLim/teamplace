package ps.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  @문제접근
 *  타겟에서 위아래로 채널을 증감시키며
 *  직접 누를 수 있는지 확인합니다.
 *  직접 누를 수 있다면 입력 카운트 + 채널 이동 횟수를 더해 반환합니다.
 *  타겟에서 현재 채널(100번) 까지 이동했을 경우 target - 100 을 반환합니다.
 *
 *  @성능
 *  Runtime: 232 ms
 *  Memory Usage: 69924 KB
 *  시간복잡도: O(N)
 */

public class BOJ_1107_리모컨 {
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        sc.nextLine();

        int m = sc.nextInt();
        sc.nextLine();

        boolean[] button = new boolean[10];
        Arrays.fill(button, true);

        for(int i = 0; i < m; i++)
            button[sc.nextInt()] = false;

        System.out.println(solve(target, button));

    }

    public static int solve(int target, boolean[] button){
        if(target == 100)
            return 0;

        int deNum = target, inNum = target;
        int totalCnt = 0;
        int dCnt, iCnt;

        while(deNum != 100 && inNum != 100){
            if(deNum > -1) {
                dCnt = isDirect(deNum--, button);
                if (dCnt > 0) {
                    return Math.min(totalCnt + dCnt, Math.abs(target - 100));
                }
            }

            iCnt = isDirect(inNum++, button);
            if(iCnt > 0){
                return Math.min(totalCnt + iCnt, Math.abs(target - 100));
            }

            totalCnt++;
        }

        return totalCnt;
    }

    public static int isDirect(int num, boolean[] button){
        int cnt = 0;

        String str = Integer.toString(num);

        for(int i = 0; i < str.length(); i++){
            if(!button[str.charAt(i)-'0'])
                return 0;
            cnt++;
        }
        return cnt;
    }
}

