/**
 *  @성능
 *  Runtime: 1 ms
 *  Memory Usage: 39.9 MB
 *  시간복잡도: O(n)
 *  
 *  @문제접근
 *  DP로 풀었습니다.
 */

class Solution53 {
    public int maxSubArray(int[] nums) {
        int arrSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            arrSum = Math.max(arrSum + nums[i], nums[i]);
            maxSum = Math.max(arrSum, maxSum);
        }
        return maxSum;
    }
}
