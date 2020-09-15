import java.util.*;
/*
bfs로 3가지 방법을 다 돌려서 + memorization 방법으로 해결
*/
public class Main {

	//static int map[]=new int[100001];
	static int visit[];
	static int s,e,t;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		
		s=scan.nextInt();
		e=scan.nextInt();
		t=Math.max(s, e);
		
		visit=new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE-1);
		visit[s]=0;
		find(s);
		
		System.out.println(visit[e]);
		

	}
	
	static void find(int s) {
		
		Queue q=new LinkedList();
		q.add(s);
		
		while(!q.isEmpty()) {
		
		int a=(int)q.poll();	
		int state[]=new int[3];
		if(a==e)break;
		state[0]=a-1;
		state[1]=a+1;
		state[2]=a*2;
		
		for(int i=0;i<3;i++) {
			
			if(state[i]>=0&&state[i]<=100000) {
				
				if(visit[state[i]]==Integer.MAX_VALUE-1) {
					q.add(state[i]);
					visit[state[i]]=visit[a]+1;
				}
				
				
			}
			
			
		}
		
		}
	
	}
	
	

}
