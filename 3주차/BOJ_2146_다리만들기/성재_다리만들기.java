package algo;
/*
 * 1. bfs로 영역을 표시해줌, 표시해주면서 각 영역의 좌표들을 저장해놓음
 * 2. 저장해놓은 좌표들을 사용하여 영역을 확장시켜줌
 * 3. 확장중에 dp=>거리가 초기화 된곳을 발견(이미 다른 확장영토)되면 지금까지 거리랑 확장된 크기를 더함
 */
import java.util.*;
import java.io.*;
import java.awt.*;
public class algo2146 {
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static int n;
	static int dp[][];
	static ArrayList a[];
	static int[][] map;
	static boolean visit[][];
	static int[][] tmap;
	static int min=Integer.MAX_VALUE-1;
	static boolean can=true;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		input();
		a=new ArrayList[10001];
		for(int i=0;i<10001;i++)a[i]=new ArrayList();
		tmap=new int[n+1][n+1];
		int landcnt=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(tmap[i][j]==0&&map[i][j]==1) {
					landcnt++;
					landmark(landcnt,new Point(i,j));
				}
			}
		}
		while(can) { //만날때까지 돌림
			for(int i=1;i<=landcnt;i++) {
				a[i]=(ArrayList) find(a[i],i).clone();
			}
		}
		
		System.out.println(min);
		
	}
	static void input() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n+1][n+1];
		visit=new boolean[n+1][n+1];
		dp=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			String str[]=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(str[j-1]);
			}
		}
		
		
	}
	static void landmark(int lcnt,Point p) {//영토나누기
		Queue q=new LinkedList();
		q.add(new Point(p.x,p.y));
		tmap[p.x][p.y]=lcnt;
		a[lcnt].add(new Point(p.x,p.y));
		while(!q.isEmpty()) {
			Point tp=(Point)q.poll();
			int x=tp.x;int y=tp.y;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>0&&ny>0&&nx<=n&&ny<=n) {
					if(map[nx][ny]==1&&tmap[nx][ny]==0) {
						tmap[nx][ny]=lcnt;
						q.add(new Point(nx,ny));
						a[lcnt].add(new Point(nx,ny));
					}
				}
			}
			
		}
	}
	static ArrayList find(ArrayList nowa,int num) {//영토확장
		ArrayList ta=new ArrayList();
		
		for(int i=0;i<nowa.size();i++) {
			Point pt=(Point)nowa.get(i);
			for(int j=0;j<4;j++) {
				int nx=pt.x+dx[j]; int ny=pt.y+dy[j];
				if(nx>0&&ny>0&&nx<=n&&ny<=n) {
					if(tmap[nx][ny]!=num) {
						if(dp[nx][ny]!=0) {
							can=false;
							min=dp[nx][ny]+dp[pt.x][pt.y];
							return ta;
						}
						tmap[nx][ny]=num;
						dp[nx][ny]=dp[pt.x][pt.y]+1;
						ta.add(new Point(nx,ny));
					}
				}
			}
		}
		return ta;
	}
}

