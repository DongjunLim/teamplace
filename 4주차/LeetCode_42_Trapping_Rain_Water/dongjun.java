public class TrappingRainWater {

    /**
     *
     *  @��������
     *  ��ġ I ���� ���� �� w = min(���� �ִ� ����, ������ �ִ� ����) - ���� ����
     *  ���� ���� �������� ���� ���� üũ�ϰ�,
     *  �ݴ�� ������ ���� �������� ���� ���� üũ�߽��ϴ�.
     *  üũ�� �� �� �� ���� ���� ���� �� �ִ� ���� ���̹Ƿ�
     *  �� �� �� ���� ���� ret�� ���մϴ�.
     *
     *  @����
     *  Runtime: 1 ms
     *  Memory Usage: 39.3 MB
     *  �ð����⵵: O(2N)
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

