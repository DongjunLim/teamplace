package algo;
/*
 * 최대길이가 20개 임으로 dfs를 사용하여 품
 * 각 값을 사용&사용 안함으로 dfs를 돌림
 */
import java.util.*;
public class algo1182 {
	static int n;
	static int tar;
	static int count=0;
	static ArrayList map=new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		tar=scan.nextInt();
		
		for(int i=0;i<n;i++) {
			int temp=scan.nextInt();
			map.add(temp);
		}
		Collections.sort(map);
		
		dfs(0,0,new ArrayList());
		System.out.println(count);
	}
	static void dfs(int now,int cost,ArrayList a) {
		ArrayList tempa=(ArrayList) a.clone();
		if(now==map.size()) {
			if(cost==tar&&a.size()!=0) {
				count++;
			}
			return;
		}
		int temp=(int)map.get(now);
		
		dfs(now+1,cost,tempa);
		tempa.add(temp);
		dfs(now+1,cost+temp,tempa);
		
	}
}
