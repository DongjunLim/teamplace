/*

현재까지의 합을 저장하기 위한 변수로 current를 선언
current가 0보다 작아지는 경우 음수를 더하고 있음을 의미
따라서 현재까지의 합을 0으로 초기화한다.

Timme Complexity: O(N)
Space Complexity : O(1)
*/

public class Leetcode53_Maximum_Subarray {

    public static int maxSubArray(int[] nums) {
        if (nums.length < 1) return 0;
        int maxValue = nums[0];
        int current = Math.max(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            current = current + nums[i];
            maxValue = Math.max(maxValue, current);
            if (current < 0)
                current = 0;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = {1, 2};
        int answer = maxSubArray(nums);
        System.out.print(answer);
    }
}
