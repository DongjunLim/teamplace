package ps.swea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SWEA_8934_팰린드롬공포증 {
    /**
     * @문제접근: 입력 알파벳이 a, b, c밖에 없습니다. 이 때 길이 2 이상의 문자가 팰린드롬이지 않으려면
     * abc, acb 와 같이 세 알파벳을 모두 사용해야 합니다. 두 알파벳만으로 문자를 만들경우, aab, aba와 같이
     * 무조건 팰린드롬이 만들어지게 됩니다. 따라서 입력 문자열의 알파벳 중 빈도가 가장 적은 알파벳과 가장 큰 알파벳
     * 의 빈도차가 2 이상 날 경우 해당 문자열은 팰린드롬을 가지게 됩니다. 따라서 빈도가 가장 적은 알파벳의 빈도와
     * 빈도가 가장 높은 알파벳의 빈도를 각각 구하고, 빈도차가 2 이상 날 경우 NO를 그렇지 않다면 YES를 반환하게
     * 구현했습니다.
     */
    public static String solve(String s){
        int[] cnt = new int[3];
        int a = 0, b = 1, c = 2;

        for(int i=0; i<s.length(); i++)
            cnt[s.charAt(i)-'a'] += 1;

        int min = Math.min(Math.min(cnt[a], cnt[b]), cnt[c]);
        int max = Math.max(Math.max(cnt[a], cnt[b]), cnt[c]);

        return max-min > 1 ? "NO" : "YES";
    }


    public static void main(String[] args) throws Exception{
        File inputFile = new File("./src/ps/swea/input.txt");
        try {
            Scanner sc = new Scanner(inputFile);
            int T = sc.nextInt();
            sc.nextLine();
            for (int tc = 1; tc <= T; tc++) {
                String S = sc.nextLine();
                System.out.println("#" + tc + " " + solve(S));;
            }
            sc.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
