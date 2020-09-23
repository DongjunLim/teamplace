public class Leetcode_283_Move_Zeroes {
    /*
    solution 1
    Time Complexity: O(N)
    Space Complexity: O(1)

    two pointer
    fast pointer : 현재 위치를 가리킴
    current pointer : fast pointer가 0이 아닌 숫자를 가리키는 경우
        현재 위치에 0이 아닌 숫자를 추가하고 포인터를 이동함줌
    이 후,
    배열의 길이(nums.length)와 current pointer의 위치의 차이만큼
    0 으로 채워
     */
    public static void moveZeroes(int[] nums) {
        int current = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0) continue;
            nums[current++] = nums[fast];
        }
        while (current < nums.length) {
            nums[current++] = 0;
        }
    }
    /*
    solutioin 2
    Time Complexity: O(N^2)
    Space Complexity: O(1)

    인접한 두 원소를 확인하여 정렬
    두 원소 중 하나의 원소가 0일 경우
    자리를 바꾸어 0을 뒤로 보
    모든 0을 뒤로 보낼때까지 회전

     */
/*    public static void moveZeroes(int[] nums) {
        while (true) {
            boolean done = true;

            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i - 1] != 0) continue;
                if (nums[i] == 0) continue;
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
                done = false;
            }
            if (done) break;
        }
    }*/
    /*
    0 1 0 3 12
    1 0 3 0 12
    1 3 0 12 0
    1 3 12 0 0
     */

    public static void main(String[] args) {
        // write your code here
        moveZeroes(new int[]{0, 1, 0, 0, 3, 0, 0, 0, 0, 12});
    }
}
