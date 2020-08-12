/**
 *  @��������
 *  �������ͷ� Ǯ�����ϴ�.
 *  �迭�� ���ۺ��� �������ε������� ��ȸ�ϸ�
 *  �ڱ� �ڸ��� �ƴ� �ε����� �ִ񰪰�(�ִ��� �����ϸ� �ε����� ������Ű�� �ش� ���� ���� �ε������� �ִ����� Ȯ��)
 *  �ڱ� �ڸ��� �ƴ� �ε����� �ּڰ��� ���մϴ�(�ּڰ��� �����ϸ� �ε����� ���ҽ�Ű�� �ش� ���� ���� �ε������� �ּڰ����� Ȯ��)
 *
 *  @����
 *  Runtime: 1 ms
 *  Memory Usage: 40.9 MB
 *  �ð����⵵ O(N)
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
