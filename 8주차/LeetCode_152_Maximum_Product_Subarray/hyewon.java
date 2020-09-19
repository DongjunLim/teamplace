public class Leetcode152_Maximum_Product_Subarray {

    /*
    Time Complexity : O(N)
    Space Complexity : O(1)

    음수 * 음수도 고려해야 하므로 최솟값과 최댓값을 같이 저장해야 한다.
    현재까지의 최댓값, 최솟값을 저장하기 위한 변수 : curMax, curMin
    다음 숫자와의 연산 후 최댓값 최솟값을 저장하기 위한 변수 : nextMax, nextMin
    */

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for(int i = 1;i< nums.length;i++){
            int nextMin = currentMin * nums[i];
            int nextMax = currentMax * nums[i];

            currentMax = Math.max(nums[i], Math.max(nextMax,nextMin));
            currentMin = Math.min(nums[i], Math.min(nextMax,nextMin));

            max = Math.max(currentMax,max);
        }
        return max;
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = {2, 3, -2, 4};
        int answer = maxProduct(nums);
        System.out.print(answer);
    }
}

