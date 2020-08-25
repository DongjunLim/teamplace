package leetcode;
/*
 * dp를 사용해서 왼쪽부터 중복합을 구함
 * 각 행의 합은 dp[col2]-dp[col1]의값을 row2-row1만큼 수행해줌
 */
import java.util.*;
public class leet304 {
	static int[][] NumMatrix= {
			  {3, 0, 1, 4, 2},
			  {5, 6, 3, 2, 1},
			  {1, 2, 0, 1, 5},
			  {4, 1, 0, 1, 7},
			  {1, 0, 3, 0, 5}
	};
	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(NumMatrix.length==0||NumMatrix[0].length==0)return;
		dp=new int[NumMatrix.length+1][NumMatrix[0].length+1];
		for(int i=0;i<NumMatrix.length;i++) {
			for(int j=0;j<NumMatrix[0].length;j++) {
				if(j==0) {
					dp[i][j]=NumMatrix[i][j];
					continue;
				}
				dp[i][j]=dp[i][j-1]+NumMatrix[i][j];
			}
		}
		
		System.out.println(sumRegion(1,2,2,4));
	}
	static int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        if(col1==0) {
        	for(int i=row1;i<=row2;i++) {
        		res+=dp[i][col2];
            }	
        }else {
        	for(int i=row1;i<=row2;i++) {
        		res+=(dp[i][col2]-dp[i][col1-1]);
        	}
        }
		return res;
    }
}
