/**
 *  @��������
 *  �� ���ڿ� �´� �θ��� �迭�� �����ϰ�,
 *  �׸���� Ǯ�����ϴ�.
 *  ����: https://leetcode.com/problems/integer-to-roman/discuss/6310/My-java-solution-easy-to-understand
 *
 *  @����
 *  Runtime: 4 ms
 *  Memory Usage: 39 MB
 *  �ð����⵵: O(N)
 */

class Solution12 {
    public String intToRoman(int num) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder answer = new StringBuilder();

        for(int i=0;i<numbers.length;i++) {
            while(num >= numbers[i]) {
                num -= numbers[i];
                answer.append(romans[i]);
            }
        }
        return answer.toString();
    }
}
