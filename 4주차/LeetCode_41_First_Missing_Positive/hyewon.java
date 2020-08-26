/*
Solution 1) PriorityQueue를 이용한 풀이
모든 배열의 원소를 PriorityQueue에 넣고
가장 첫번째 자연수인 1부터 비교햐여
현재 가지고 있는 숫자의 경우 answer += 1
아닐 경우 missing value 이므로 return 하게 된다.

Solution 2) HashSet을 이용한 풀이
모든 배열의 원소를 HashSet에 넣는다.
가장 첫번째 자연수인 1부터 hashset에 있는지 확인하고
없을 경우 missing value 이므로 return 하게된다.

Time Complexity:O(NlogN)
Space Complexity:O(N)
*/

import java.util.*;

public class Leetcode41_First_Missing_Positive {


    public static int firstMissingPositive(int[] nums) {
        Set<Integer> hashset = new HashSet<Integer>();

        for(int num: nums){
            hashset.add(num);
        }
        for(int value = 1; value <= hashset.size(); value++){
            if(!hashset.contains(value))
                return value;
        }
        return hashset.size() + 1;
    }
    /*public static int firstMissingPositive(int[] nums) {
        int answer = 1;

        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        for (int num : nums) {
            que.offer(num);
        }
        while(!que.isEmpty()){
            int value = que.poll();
            if(value == answer)
                answer++;
        }
        return answer;
    }*/

    public static void main(String[] args) {
        // write your code here
        int[] nums = {2, 3};
        int answer = firstMissingPositive(nums);
        System.out.print(answer);
    }
}
