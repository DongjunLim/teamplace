/**
 * @문제접근
 * 동적계획법으로 풀었습니다.
 * 인덱스 위치에서 가질 수 있는 최댓값을 찾아 lis 배열에 저장하고
 * 찾은 값 중에 가장 큰 값을 answer에 저장해 반환합니다.
 */

package ps.boj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BOJ_11055_가장_큰_증가하는_부분_수열 {

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

