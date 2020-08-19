package algo;
/*
 * 1.모든 순서쌍을 구함
 * 2.구한 순서쌍으로 순서대로 시뮬레이션해봄
 * 3.매번 시뮬레이션을 통해 만든 맵에서 최소 행을 구함
 */
import java.util.*;
import java.io.*;
import java.awt.*;
public class algo17406 {
	static int n,m,k;
	static int min=Integer.MAX_VALUE-1;
	static ArrayList turn=new ArrayList();
	static int map[][];
	static int[][] ttmap=new int[n+1][m+1];
	static ArrayList make=new ArrayList();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		makeit(new boolean[k],new ArrayList(),0);
		for(int i=0;i<make.size();i++) {
		ttmap = new int[n+1][m+1];
		for(int j=0;j<=n;j++)ttmap[j]=map[j].clone();
		ArrayList a=(ArrayList)make.get(i);
		for(int j=0;j<a.size();j++) {
			int temp=(int) a.get(j);
			int km[]=(int[])turn.get(temp);
//			System.out.println(km[0]+" "+km[1]+" "+km[2]);
			for(int l=km[2];l>0;l--) {
			linking(km[0],km[1],l);
			}
		}
		findmin(ttmap);
	}
		System.out.println(min);
	}
	static void input() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		m=Integer.parseInt(str[1]);
		k=Integer.parseInt(str[2]);
		map=new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			str=br.readLine().split(" ");
			for(int j=1;j<=m;j++) {
				map[i][j]=Integer.parseInt(str[j-1]);
			}
		}
		for(int i=0;i<k;i++) {
			str=br.readLine().split(" ");
			int r=Integer.parseInt(str[0]);
			int c=Integer.parseInt(str[1]);
			int s=Integer.parseInt(str[2]);
			int temp[]=new int[] {r,c,s};
			turn.add(temp);
		}
	}
	
	static void findmin(int tmap[][]) {
		for(int i=1;i<=n;i++) {
			int tmin=0;
			for(int j=1;j<=m;j++) {
				tmin+=tmap[i][j];
			}
			min=Math.min(tmin, min);
		}
	}
	static void makeit(boolean visit[],ArrayList a,int now) {
		ArrayList ta=(ArrayList) a.clone();
		if(now==k) {
			make.add(ta);
			return;
		}
		for(int i=0;i<k;i++) {
			if(!visit[i]) {
				visit[i]=true;
				ta.add(i);
				makeit(visit,ta,now+1);
				ta.remove((Integer)i);
				visit[i]=false;
			}
		}
	}
	static void linking(int r,int c,int s) {
		ArrayList link=new ArrayList();
		
		for(int i=c-s;i<c+s;i++) {
			link.add(ttmap[r-s][i]);
		}
		for(int i=r-s;i<r+s;i++) {
			link.add(ttmap[i][c+s]);
		}
		for(int i=c+s;i>c-s;i--) {
			link.add(ttmap[r+s][i]);
		}
		for(int i=r+s;i>r-s;i--) {
			link.add(ttmap[i][c-s]);
		}
		int temp=(int)link.get(0);
		link.add(temp);
		int step=0;
		for(int i=c-s+1;i<=c+s;i++) {
			ttmap[r-s][i]=(int) link.get(step);
			step++;
		}
		for(int i=r-s+1;i<=r+s;i++) {
			ttmap[i][c+s]=(int) link.get(step);
			step++;
		}
		for(int i=c+s-1;i>=c-s;i--) {
			ttmap[r+s][i]=(int) link.get(step);
			step++;
		}
		for(int i=r+s-1;i>=r-s;i--) {
			ttmap[i][c-s]=(int) link.get(step);
			step++;
		}
		
		
	}
}



//for(int i=0;i<make.size();i++) {
//	ArrayList a=(ArrayList)make.get(i);
//	for(int j=0;j<a.size();j++) {
//		System.out.printf("%d ", a.get(j));
//	}System.out.println("");
//}
