import java.util.ArrayList;
import java.util.List;

/*
모든 가능한 부분 집합을 나열하는 문제

모든 조합의 수를 살펴보는 것이므로 백트래킹(Backtracking)으로 접근

Time Complexity: O(N*2^N);
Space Complexity: O(N*2^N);
N개의 원소를 가지고 있는 경우 2^N개의 부분 집합이 존재하므로 위와 같은 복잡도를 갖는다.

 */
public class Leetcode78_Subsets {

    public static List<List<Integer>> answer = new ArrayList<>();
    public static int k;

    public static List<List<Integer>> subsets(int[] nums) {

        for (k = 0; k <= nums.length; k++) {
            backtracking(0, new ArrayList<>(), nums);
        }
        return answer;
    }

    private static void backtracking(int index, ArrayList<Integer> current, int[] nums) {

        if (current.size()== k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtracking(i + 1, current, nums);
            current.remove(current.size() - 1);
        }
    }


    public static void main(String[] args) {
        // write your code here
        int[] nums = {1, 2, 3};
        List<List<Integer>> solution = subsets(nums);
        System.out.print(solution.toString());
    }
}
