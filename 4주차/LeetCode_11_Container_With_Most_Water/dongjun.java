    /**
     *  @��������
     *  �������͸� ����� Ǯ�����ϴ�.
     *  �ΰ��� �����͸� ���ʰ� ������ ���� �ΰ�,
     *  ���� �� ���� �����͸� �������� �̵���ŵ�ϴ�.
     *  ���� �� ���� �����͸� �̵���Ű�� ������,
     *  �� �����Ϳ��� ���� �� �ִ� �ִ� ���� ���� ���߱� �����Դϴ�.
     *
     *  @����
     *  Runtime: 2 ms
     *  Memory Usage: 39.5 MB
     *  �ð����⵵: O(N)
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
