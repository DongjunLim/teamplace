// https://leetcode.com/problems/triangle/submissions/
/*
간단한 dp로 문제를 해결함 위의 양옆중에 작은값을 선택
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][triangle.size()];
        dp[0][0]=triangle.get(0).get(0);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            ArrayList<Integer> arr=(ArrayList)triangle.get(i);
            for(int j=0;j<arr.size();j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+arr.get(j);
                }else if(j==arr.size()-1){
                    dp[i][j]=dp[i-1][j-1]+arr.get(j);
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+arr.get(j);
                }
            }
        }
        for(int i=0;i<triangle.size();i++){
             min=Math.min(min,dp[triangle.size()-1][i]);
        }
        return min;
    }
}
