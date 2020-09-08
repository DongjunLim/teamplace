/*
Backtracking

Time Complexity: O(N!*N)
Space Complexity: O(N!)

 All permutation problem's time complexity is O(n!). 
 For this algorithm using add(nums[i]), so total is (N!*N) time complexity
*/

import java.util.ArrayList;
import java.util.List;

public class Leetcode46_Permutations {

    public static List<List<Integer>> answer = new ArrayList<>();
    public static boolean[] visit = null;

    public static List<List<Integer>> permute(int[] nums) {

        visit = new boolean[nums.length];
        nextStep(new ArrayList<Integer>(), nums);
        return answer;
    }

    private static void nextStep(ArrayList<Integer> current, int[] nums) {

        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            current.add(nums[i]);
            nextStep(current, nums);
            current.remove(current.size() - 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        // write your code here
        List<List<Integer>> answer = permute(new int[]{1, 2, 3});
        System.out.print(answer);
    }
}
