/*

제공되는 배열을 copy한 새로운 배열을 할당합니다.
copy된 배열을 sorting한후, 기존 배열과 비교합니다.

Time Complexity:O(NlogN)
Space Complexity:O(N)
*/

import java.util.Arrays;

public class Leetcode581_Shortest_Unsorted_Continuous_Subarray {
    public static int findUnsortedSubarray(int[] nums) {

        int size = nums.length;
        int[] copyArray = new int[size];
        int answer = 0;

        System.arraycopy(nums, 0, copyArray, 0, size);
        Arrays.sort(copyArray);

        int start = nums.length;
        int end = 0;

//        int start = findStartIndex(nums, copyArray);
//        int end = findEndIndex(nums, copyArray);

        for(int index = 0; index < nums.length; index++){
            if(nums[index] != copyArray[index]){
                start = Math.min(start, index);
                end = Math.max(end, index);
            }
        }
        answer = end - start + 1;
        if(end == 0) return 0;
        return answer;
    }

/*
  처음 저의 코드입니다.
  배열을 앞에서 부터 탐색하는 findStartIndex 함수와
  뒤에서 부터 탐색하는 findEndIndex 함수입니다.
  이는 주어진 배열을 두번 탐색하는 꼴이 되므로 이를 하나로 합쳤습니다.

    private static int findEndIndex(int[] nums, int[] copyArray) {
        int index = nums.length - 1;
        while (index >= 0) {
            if (nums[index] != copyArray[index]) break;
            index--;
        }
        return index;
    }

    private static int findStartIndex(int[] nums, int[] copyArray) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != copyArray[index]) break;
            index++;
        }
        return index;
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int answer = findUnsortedSubarray(nums);
        System.out.print(answer);
    }
}
