package algo;
/*
 * 기본적인 bfs를 사용 
 */
import java.util.*;
class point {
	int x,y;
	
	point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
}
public class algo2667_1 {
	static int n;
	static int[][] map;
	static int count;
	static int[] dx = new int[] {0,-1,0,1};
	static int[] dy = new int[] {-1,0,1,0};
	static Stack s =  new Stack();
	static boolean[][] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		ArrayList res = new ArrayList();
		
		n=scan.nextInt();
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String in = scan.next();
			for(int j=1;j<=n;j++) {
				map[i][j]=in.charAt(j-1)-'0';
		}
	}
		visit=new boolean[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==1&&!visit[i][j]) {
					
					visit[i][j]=true;
					count=0;
					point pt = new point(i,j);
					s.push(pt);
					find();
					res.add(count);
					
				}
			}
		}
		Collections.sort(res);
		System.out.println(res.size());
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
	}
	static void find() {
		while(!s.isEmpty()) {
			point p = (point)s.pop(); 
			count++;
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<=n&&ny<=n&&nx>0&&ny>0) {
					if(map[nx][ny]==1&&!visit[nx][ny]) {
						point temp = new point(nx,ny);
						s.push(temp);
						visit[nx][ny]=true;
					}
				}
			}
		}
	}
}


