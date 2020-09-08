/**
 *  @문제접근
 *  HashSet을 이용해 풀었습니다.
 *  nums 배열의 모든 값을 set에 저장한 후,
 *  각 숫자에서 연속적으로 몇개의 숫자가 set에 저장되어 있는지
 *  카운팅하여, 가장 높은 카운트를 반환하게 구현했습니다.
 *
 *  @성능
 *  Runtime: 3 ms
 *  Memory Usage: 39.9 MB
 *  시간복잡도: O(N)
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        int cnt = 1;
        int answer = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int n: nums)
            set.add(n);

        for(int n: nums){
            if(!set.contains(n-1)){
                int temp = n;
                while(set.contains(++temp))
                    cnt++;

                answer = Math.max(answer, cnt);
                cnt = 1;
            }
        }
        return answer;
    }
}
