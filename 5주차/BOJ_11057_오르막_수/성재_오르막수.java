package algo;
import java.util.*;
import java.io.*;
public class algo11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		long dp[][]=new long[1001][11];
		Arrays.fill(dp[1],1);
		long sum=0;
		for(int i=2;i<=n;i++) {
			for(int j=9;j>=0;j--) {
				dp[i][j]=dp[i-1][j]+dp[i][j+1];
				dp[i][j]%=10007;
				if(i==n) {
					sum+=dp[i][j];
				}
			}
		}
		if(n==1) {
			System.out.println(10);
		}else {
			System.out.println(sum%10007);
		}
	}

}
