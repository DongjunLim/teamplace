package leetcode;
/*
 * dfs를 사용하여 문제를 접근
 * 처음은 항상 (로 시작
 * (의 개수가 n보다 작다면 스텍에 넣은후 다시 탐색
 * 스텍의 사이즈가 0이아니라면 pop() 한 후 문자열에 )를 추가하고 다시 탐색
 */
import java.util.*;
public class Generate_Parentheses {
	static int k;
	static List list;
	public static void main(String[] args) {
		k=3;
		list=new ArrayList();
		
		Stack s = new Stack();
		s.add('(');
		dfs(1,0,1,s,"(");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	static void dfs(int l,int r,int c,Stack s,String str) {
		if(c==(k*2)) {
			if(s.size()==0&&l==k&&r==k) {
				list.add(str);
				return;
			}
		}
		Stack temp=(Stack)s.clone();
		if(l<k) {
			temp.add('(');
			dfs(l+1,r,c+1,temp,str+"(");
			temp.pop();
		}
		
		if(!temp.isEmpty()) {
			temp.pop();
			dfs(l,r+1,c+1,temp,str+")");
		}
	}
}
