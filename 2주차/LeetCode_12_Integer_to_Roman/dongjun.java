/**
 *  @문제접근
 *  각 숫자에 맞는 로마자 배열을 선언하고,
 *  그리디로 풀었습니다.
 *  참고: https://leetcode.com/problems/integer-to-roman/discuss/6310/My-java-solution-easy-to-understand
 *
 *  @성능
 *  Runtime: 4 ms
 *  Memory Usage: 39 MB
 *  시간복잡도: O(N)
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
