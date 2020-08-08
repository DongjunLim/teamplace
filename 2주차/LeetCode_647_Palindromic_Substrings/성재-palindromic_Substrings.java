package leetcode;
/*
 * 각 자리수의 부분 문자열을 구해서 대칭인지 확인.
 * 효율면으로 매우 안좋은것으로 보임
 * O(mN^2)
*/
import java.util.*;
public class palindrom_substrings {
	static String s = "aba";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=s.length();
		for(int i=0;i<s.length();i++) {
			for(int j=i+2;j<=s.length();j++) {
				if(find(s.substring(i, j))){
					res++;
				}
			}
		}
		return res;
		
	}
	static boolean find(String str) {//좌우대칭인지 확인하는 함수
		int start=0;
		int end=str.length()-1;
		
		while(start<=end) {
			if(str.charAt(start)!=str.charAt(end)) {
				return false;
			}
			start++;end--;
		}
		
		return true;
	}
}
