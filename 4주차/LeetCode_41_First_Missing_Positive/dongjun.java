/**
 * @��������
 * HashSet�� ����� Ǯ�����ϴ�.
 * nums �迭�� ��ȸ�ϸ� ��� ���Ҹ� set�� ���,
 * 1���� ���ʷ� set�� �ش� ������ �����ϴ��� Ȯ���ϰ�,
 * �������� �ʴ´ٸ� �ش� ���Ұ��� ��ȯ�մϴ�.
 *
 * @����
 * Runtime: 1 ms
 * Memory Usage: 37.6 MB
 * �ð����⵵: O(2N)
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

