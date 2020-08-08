package leetcode;
/*
 * 간단하게 모든 케이스를 만들어두고 시작
 * 각 자리수를 구해 만들어둔 값들에 넣어 문자열을 만듬
 * O(N)
 * 6ms 39.7 MB
 */
import java.util.*;
public class integer_to_roman {
	static int num=1994;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] one = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
	    String[] ten = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	    String[] hdr = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String res="";
		int start=(int) Math.log10(num);
		
		for(int i=start;i>=0;i--) {
			int div = (int)Math.pow(10, i);
			int val = num/div;
			num -= div*val;
			
			if(i==3) {
				for(int j=0;j<val;j++)res+="M";
			}
			if(i==2) {
				res+=hdr[val];
			}
			if(i==1) {
				res+=ten[val];
			}
			if(i==0) {
				res+=one[val];
			}
		}
		return res;
	}

}
