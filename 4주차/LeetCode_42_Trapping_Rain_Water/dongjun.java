public class TrappingRainWater {

    /**
     *
     *  @문제접근
     *  위치 I 에서 물의 양 w = min(왼쪽 최대 높이, 오른쪽 최대 높이) - 현재 높이
     *  왼쪽 벽을 기준으로 물의 양을 체크하고,
     *  반대로 오른쪽 벽을 기준으로 물의 양을 체크했습니다.
     *  체크한 두 값 중 작은 값이 고일 수 있는 물의 양이므로
     *  두 값 중 작은 값을 ret에 더합니다.
     *
     *  @성능
     *  Runtime: 1 ms
     *  Memory Usage: 39.3 MB
     *  시간복잡도: O(2N)
     *
     */
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int[] waters = new int[height.length];

        int left = height[0];
        int ret = 0;

        for(int i = 1; i < height.length; i++){
            if(height[i] < left)
                waters[i] = left - height[i];
            else
                left = height[i];
        }

        int length = height.length;
        int right = height[length-1];

        for(int j = length-1; j >= 0; j--){
            int water = 0;
            if(height[j] < right)
                water = right - height[j];
            else
                right = height[j];

            ret += Math.min(waters[j], water);
        }
        return ret;
    }
}

