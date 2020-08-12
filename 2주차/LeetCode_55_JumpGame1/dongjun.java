/**
 * Runtime: 479 ms
 * Memory Usage: 44.4 MB
 * 시간복잡도: nums * nums[] = 최대 30000 * 100000 ?
 *
 *
 * @문제접근
 * dfs로 풀었습니다.
 * 
 */

package ps.leetcode;

public class JumpGame {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {8,2,5,1,2,7,5,1,9,9,3,5,0,7,5};

        System.out.println(s.canJump(nums));
    }

}

class Solution {
    public static boolean answer;
    public static boolean visited[];
    public boolean canJump(int[] nums) {
        visited = new boolean[nums.length];
        answer = false;

        dfs(0, nums);

        return answer;
    }

    public static void dfs(int idx, int[] nums) {
        if(idx == nums.length - 1){
            answer = true;
            return;
        }

        for(int i = idx+1; i <= idx+nums[idx]; i++){
            if(i < nums.length && !visited[i]){
                visited[i] = true;
                dfs(i, nums);
            }
        }
    }
}
