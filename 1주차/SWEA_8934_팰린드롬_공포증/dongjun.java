package ps.swea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SWEA_8934_�Ӹ���Ұ����� {
    /**
     * @��������: �Է� ���ĺ��� a, b, c�ۿ� �����ϴ�. �� �� ���� 2 �̻��� ���ڰ� �Ӹ�������� ��������
     * abc, acb �� ���� �� ���ĺ��� ��� ����ؾ� �մϴ�. �� ���ĺ������� ���ڸ� ������, aab, aba�� ����
     * ������ �Ӹ������ ��������� �˴ϴ�. ���� �Է� ���ڿ��� ���ĺ� �� �󵵰� ���� ���� ���ĺ��� ���� ū ���ĺ�
     * �� ������ 2 �̻� �� ��� �ش� ���ڿ��� �Ӹ������ ������ �˴ϴ�. ���� �󵵰� ���� ���� ���ĺ��� �󵵿�
     * �󵵰� ���� ���� ���ĺ��� �󵵸� ���� ���ϰ�, ������ 2 �̻� �� ��� NO�� �׷��� �ʴٸ� YES�� ��ȯ�ϰ�
     * �����߽��ϴ�.
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
