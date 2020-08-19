package algo;
import java.util.*;
/*
 * 100에서 시작했을때 vs target 숫자보다 큰수 중 가장 가깐 수 vs target 숫자보다 작은수 중 가장 가까운수
 * map = 리모컨
 */
public class algo1107 {
	static int tar;
	static boolean map[]=new boolean[10];
	static int now=100;
	static int min=Integer.MAX_VALUE-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		tar=scan.nextInt();
		int m=scan.nextInt();
		Arrays.fill(map, true); 
		
		for(int i=0;i<m;i++) {
			int temp=scan.nextInt();
			map[temp]=false;
		}
		min=Math.abs(tar-100);
		int u=up();
		min=Math.min(u, min);
		int d=down();
		min=Math.min(d, min);
		System.out.println(min);
	}
	static int up() { //무한대 까지 가능함으로 100과 비교했을때 더많이 눌러야 한다면 의미가 없음
		int temp=tar;
		while(Math.abs(tar-100)>=temp-tar) {
			String str=Integer.toString(temp);
			boolean can=true;
			for(int i=0;i<str.length();i++) {
				if(!map[str.charAt(i)-'0'])can=false;
			}
			if(can)break;
			else temp++;
		}
		return temp-tar+Integer.toString(temp).length();
	}
	static int down() {
		int temp=tar;
		boolean can=true;
		while(temp>=0) {
			String str=Integer.toString(temp);
			can=true;
			for(int i=0;i<str.length();i++) {
				if(!map[str.charAt(i)-'0'])can=false;
			}
			if(can)break;
			else if(temp==0)break;
			else temp--;
		}
		if(!can)return Integer.MAX_VALUE-1;
		return tar-temp+Integer.toString(temp).length();
	}
}
