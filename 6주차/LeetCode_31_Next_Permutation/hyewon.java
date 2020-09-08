import java.util.Arrays;
/*
Step1. 주어진 배열의 뒤에서부터 값이 감소하기 시작하는 지점을 찾는다. = start
Step2. 주어진 배열의 뒤에서부터 nums[start]보다 큰 값을 찾는다.
nums[start]보다 작아지는 경우 while문에서 탈출하여 결과적으로 nums[start]값과 가장 작은 차이를 가지는 숫자의 위치(index)를 return하게된다. = end
Step3. start와 end의 위치에 있는 값을 바꾼다.
Step4. 남아있는 값들을 Reverse해준다.

Time Complexity: O(N)
    - findStartIndex: O(N)
    - findEndIndex: O(N)
    - reverseForlast: O(N)
    - mySwap: O(1)

Space Complexity: O(1)
 */
public class Leetcode31_Next_Permutation {

    public static void nextPermutation(int[] nums) {

        int start = findStartIndex(nums);
        if (start >= 0) {
            int end = findEndIndex(start, nums);
            mySwap(nums, start, end);
        }
        reverseForlast(nums, start + 1);

    }

    private static int findStartIndex(int[] nums) {

        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) index--;
        return index;

    }

    private static int findEndIndex(int start, int[] nums) {
        int endIndex = nums.length - 1;
        while (endIndex > start && nums[start] >= nums[endIndex])
            endIndex--;
        return endIndex;
    }

    private static void reverseForlast(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            mySwap(nums, start++, end--);
        }
    }

    private static void mySwap(int[] nums, int start, int end) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }

    public static void main(String[] args) {
        // write your code here
//        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        int[] nums = {2, 3, 1, 3, 3};

        nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
    }
}


