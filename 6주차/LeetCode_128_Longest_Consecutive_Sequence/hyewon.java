/* 
Set 을 이용한 풀이

초기 배열의 값을 모두 Set에 넣는다.
주어진 배열을 순차적으로 돌면서 해당 숫자가 set에 포함되어있는지를 검사한다.
해당 숫자가 set에 포함되어있는 경우
while문을 통해 연속적으로 다음 숫자가 있는 지를 확인한다.

불필요하게 반복되는 오버헤드를 줄이기 위하여
이전숫자를 이미 가지고 있는 경우 continue문을 이용하여 재확인 하지 않도록 한다.
*/

import java.util.Arrays;
import java.util.HashSet;

public class Leetcode128_Longest_Consecutive_Sequence_2 {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }
        int maxLen = 0;
        for(int num: nums){
            if(numSet.contains(num -1)) continue;

            int curLen = 0;
            while(numSet.contains(num)){
                curLen++;
                num++;
            }
            maxLen = Math.max(maxLen,curLen);
        }
        return maxLen;
    }

/*

N : 주어진 배열의 크기
L :  주어진 배열에서 최댓값
최댓값 크기만큼 새로운 boolean 배열을 생성한다. 
nums가 가지고 있는 값은 true, 가지고 있지 않은 값은 false로 초기화한다. O(N)
이제, boolean 배열을 순차적으로 돌면서 연속적으로 true인 길이를 구한다. O(L)

Time Complexity: O(L)
Space Compexity: O(L)

그러나 이는, 음수가 input으로 들어왔을때 run time error를 발생시킨다.

*/
    /*public static int longestConsecutive(int[] nums) {

        int maxLen = 0;
        if (nums.length < 1) return maxLen;

        int maxValue = findMax(nums);
        boolean[] memo = new boolean[maxValue + 1];

        lookAround(memo,nums);
        maxLen = findLCS(memo);

        return maxLen;
    }

    private static int findLCS(boolean[] memo) {
        int curLen = 0;
        int maxLen = 0;

        for(int i = 0;i< memo.length; i++){
            if(memo[i] == true){
                curLen++;
            }
            else{
                curLen = 0;
            }
            maxLen = Math.max(curLen,maxLen);
        }
        return maxLen;
    }

    private static void lookAround(boolean[] memo, int[] nums) {
        for(int i =0;i< nums.length; i++){
            if(nums[i] < 0) continue;
            memo[nums[i]] = true;
        }
    }

    private static int findMax(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){
            maxValue = Math.max(maxValue, nums[i]);
        }
        return maxValue;
    }
*/

    public static void main(String[] args) {
        // write your code here
        int[] nums = {0,1,1,2,5};
        int answer = longestConsecutive(nums);
        System.out.print(answer);
    }

}

