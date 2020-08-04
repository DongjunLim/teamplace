/**
 * @��������
 * ������ȹ������ Ǯ�����ϴ�.
 * �ε��� ��ġ���� ���� �� �ִ� �ִ��� ã�� lis �迭�� �����ϰ�
 * ã�� �� �߿� ���� ū ���� answer�� ������ ��ȯ�մϴ�.
 */

package ps.boj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BOJ_11055_����_ū_�����ϴ�_�κ�_���� {

    public static int solve(int[] A){
        int answer = A[0];
        int[] lis = A.clone();

        for(int i=1; i<A.length; i++){
            for(int j=0; j<i; j++)
                if(A[i] > A[j]) lis[i] = Math.max(lis[i], lis[j] + A[i]);

            answer = Math.max(answer, lis[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("./src/ps/boj/input.txt");
        Scanner sc = new Scanner(file);

        int N = sc.nextInt();
        sc.nextLine();
        int[] A = new int[N];

        for(int i=0; i<N; i++) A[i] = sc.nextInt();

        System.out.println(solve(A));
    }
}

