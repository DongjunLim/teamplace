/**
 *  @문제해결
 *  각각의 인덱스를 중앙값으로 해서 양 옆으로 문자열을 늘려가며 만들 수 있는 팰린드롬을 카운팅했습니다.
 *  
 * 
 *  @성능
 *  Runtime: 2 ms
 *  Memory Usage: 39.1 MB
 *  시간복잡도: O(n^2) -> 최악의 경우 = 모든 문자가 같을때 (0.5n*(4+(0.5n-1)*2))/2 = O(n^2)
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
