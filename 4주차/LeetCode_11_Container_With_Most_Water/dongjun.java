    /**
     *  @문제접근
     *  투포인터를 사용해 풀었습니다.
     *  두개의 포인터를 왼쪽과 오른쪽 끝에 두고,
     *  값이 더 작은 포인터를 안쪽으로 이동시킵니다.
     *  값이 더 작은 포인터를 이동시키는 이유는,
     *  그 포인터에서 얻을 수 있는 최대 물의 양을 구했기 때문입니다.
     *
     *  @성능
     *  Runtime: 2 ms
     *  Memory Usage: 39.5 MB
     *  시간복잡도: O(N)
     *
     */
    class Solution {
        public int maxArea(int[] height) {
            int ret = 0;
            int left = 0, right = height.length - 1;

            while(left < right){
                int water = calcWater(left, right, height);

                ret = Math.max(ret, water);

                if(height[left] > height[right])
                    right--;
                else
                    left++;
            }

            return ret;
        }

        public int calcWater(int start, int end, int[] height){
            return Math.min(height[start], height[end]) * (end - start);
        }
    }
