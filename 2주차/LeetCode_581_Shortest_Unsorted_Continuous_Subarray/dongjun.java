/**
 *  @문제접근
 *  투포인터로 풀었습니다.
 *  배열의 시작부터 마지막인덱스까지 순회하며
 *  자기 자리가 아닌 인덱스의 최댓값과(최댓값을 갱신하며 인덱스를 증가시키며 해당 값이 현재 인덱스에서 최댓값인지 확인)
 *  자기 자리가 아닌 인덱스의 최솟값을 구합니다(최솟값을 갱신하며 인덱스를 감소시키며 해당 값이 현재 인덱스에서 최솟값인지 확인)
 *
 *  @성능
 *  Runtime: 1 ms
 *  Memory Usage: 40.9 MB
 *  시간복잡도 O(N)
 */


class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int lastIdx = nums.length-1;
        int start = 0, end = 0;
        int minNum = nums[lastIdx], maxNum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= maxNum)
                maxNum = nums[i];
            else
                end = i;

            if(nums[lastIdx-i] <= minNum)
                minNum = nums[lastIdx-i];
            else
                start = lastIdx-i;
        }
        return start == 0 && end == 0 ? 0 : end - start + 1;
    }
}
