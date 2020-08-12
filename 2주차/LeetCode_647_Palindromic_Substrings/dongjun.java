/**
 *  @�����ذ�
 *  ������ �ε����� �߾Ӱ����� �ؼ� �� ������ ���ڿ��� �÷����� ���� �� �ִ� �Ӹ������ ī�����߽��ϴ�.
 *  
 * 
 *  @����
 *  Runtime: 2 ms
 *  Memory Usage: 39.1 MB
 *  �ð����⵵: O(n^2) -> �־��� ��� = ��� ���ڰ� ������ (0.5n*(4+(0.5n-1)*2))/2 = O(n^2)
 *
 */

package ps.leetcode;

public class PalindromicSubstrings {
    public static void main(String[] args){
        String input = "aaa";
        Solution647 s = new Solution647();
        
        System.out.println(s.countSubstrings(input));
    }
}


class Solution647 {
    public int countSubstrings(String s) {
        char[] str = s.toCharArray();
        int palindromCnt = 0;
        
        for(int i = 0; i < str.length; i++){
            palindromCnt += countPalindrom(i, i, str);
            palindromCnt += countPalindrom(i, i + 1, str);
        }
        
        return palindromCnt;
    }

    private int countPalindrom(int left, int right, char[] str){
        if(left < 0 || str.length <= right)
            return 0;

        if(str[left] == str[right])
            return countPalindrom(left -1, right + 1, str) + 1;
        else
            return 0;
    }
}
