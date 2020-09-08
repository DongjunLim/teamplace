/**
 *  @문제접근
 *  Next permutation 공식을 사용해 풀었습니다.
 *
 *  @성능
 *  Runtime: 0 ms
 *  Memory Usage: 39.9 MB
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1)
            return;
        int temp;
        int ti = nums.length - 2;
        int si = nums.length - 1;

        while(ti >= 0 && nums[ti + 1] <= nums[ti]) ti--;

        if(ti >= 0){
            while(si >= 0 && nums[si] <= nums[ti])  si--;

            temp = nums[ti];
            nums[ti] = nums[si];
            nums[si] = temp;
        }

        int left = ti;
        int right = nums.length;

        while(++left < --right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}

