/**
 * @문제접근
 * HashSet을 사용해 풀었습니다.
 * nums 배열을 순회하며 모든 원소를 set에 담고,
 * 1부터 차례로 set에 해당 정수가 존재하는지 확인하고,
 * 존재하지 않는다면 해당 원소값을 반환합니다.
 *
 * @성능
 * Runtime: 1 ms
 * Memory Usage: 37.6 MB
 * 시간복잡도: O(2N)
 *
 */
class Solution41 {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;

        if(nums.length == 0)
            return 1;

        for(int n: nums)
            set.add(n);
        
        while(true){
            if(!set.contains(i))
                break;
            i++;
        }
        return i;
    }
}

