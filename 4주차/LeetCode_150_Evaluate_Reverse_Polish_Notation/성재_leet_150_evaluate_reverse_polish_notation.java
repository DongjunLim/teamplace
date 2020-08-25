package leetcode;
import java.util.*;
/*
 * 숫자는 stack에 넣어놓음
 * 연산자가 나오면 스텍에서 2개를 빼서 연산자에 맞게 계산한 뒤 스텍에 다시 넣음
 * 스텍에 남은 마지막 수가 답
 */
public class evaluate_reverse_polich_notation {
	static String[] tokens= {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
	static Stack<Integer> num=new Stack();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<tokens.length;i++) {
			String str=tokens[i];
			if(str.equals("*")||str.equals("+")||str.equals("-")||str.equals("/")) {
				int b=num.pop();
				int a=num.pop();
				int temp=calcul(a,b,str);
				num.push(temp);
			}else {
				num.push(Integer.parseInt(str));
			}
		}
			
		System.out.println(num.pop());
	}
	static int calcul(int a,int b,String c) {
		switch(c) {
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		case "/":
			return a/b;
		}
		return 0;
	}
}
