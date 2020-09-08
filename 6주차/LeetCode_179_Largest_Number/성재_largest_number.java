package leetcode;
/*
 * PriorityQueue를 사용
 * 두개의 값 ex) a1,a2 ->   a1a2와 a2a1을 비교해서 a1a2가 크다면 a1,a2순으로 정렬, a2a1이 더 크다면 a2,a1로 정렬하는 방식으로
 * 큐에 값을 넣은뒤 순서대로 꺼내면서 앞자리를 차지하면 가장 큰값이 나옴
 */
import java.util.*;
public class Largest_Number {
	static int nums[]= {0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1=o1.toString();
				String s2=o2.toString();

				String t1 = (s1+s2);
				String t2 = (s2+s1);
				
				for(int i=0;i<t1.length();i++) {
					int a1=t1.charAt(i)-'0'; int a2=t2.charAt(i)-'0';
					if(a1>a2) return -1;
					else if(a1<a2)return 1;
					else continue;
				}
				return 0;
				
			}
		});
		for(int i=0;i<nums.length;i++) {
			pq.add(nums[i]);
		}
		String str="";
		boolean can=false;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0)can=true;
			str+=pq.poll();
			
		}
		if(!can)System.out.println("0");
		else System.out.println(str);
	}

}
