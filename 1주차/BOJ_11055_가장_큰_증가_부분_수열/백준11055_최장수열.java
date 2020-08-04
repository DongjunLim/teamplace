/* dp로 접근함
 * map=>input 받은 값을 저장
 * dp =>현재 숫자가 포함된 최장증가 수열의 합
 * 0->n 까지 증가하면서 이전 dp에 저장된 값중 가장 큰값이 현재 수보다 작고 현재 dp보다 작다면 
 * 값을 바꿔줌
 */


import java.util.*;
public class algo11055_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int map[]=new int[n];
		int dp[]=new int[n];
		
		for(int i=0;i<n;i++) {
			map[i]=scan.nextInt();
		}
		dp[0]=1;
		int max=0;
		for(int i=0;i<n;i++) {
			dp[i]=map[i];
			for(int j=0;j<i;j++) {
				if((dp[j]+map[i]>dp[i])&&map[i]>map[j]) {
					dp[i]=map[i]+dp[j];
				}
			}
			if(max<dp[i])max=dp[i];
		}
		System.out.println(max);
	}

}
