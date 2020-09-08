/**
 *  @문제접근
 *  완전탐색으로 풀었습니다.
 *
 *  @성능
 *  Runtime: 1 ms
 *  Memory Usage: 40 MB
 */
public class Permutations {
    class Solution {
        public static boolean[] visited;
        public static List<List<Integer>> ret;

        public List<List<Integer>> permute(int[] nums) {
            ret = new ArrayList<>();
            visited = new boolean[nums.length];
            LinkedList<Integer> start = new LinkedList<>();

            dfs(start, nums);

            return ret;
        }

        public void dfs(LinkedList<Integer> now, int[] nums){
            if(now.size() == nums.length){
                ret.add(new LinkedList<>(now));
                return;
            }

            for(int i = 0; i < nums.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    now.add(nums[i]);
                    dfs(now, nums);
                    now.pollLast();
                    visited[i] = false;
                }
            }
        }
    }
}

