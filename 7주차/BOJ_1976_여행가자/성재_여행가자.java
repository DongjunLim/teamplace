/*
1. 들려야하는 노드부터 시작
2. 시작 노드부터 들릴수 있는 곳을 모두 들림 ->bfs
3. 마지막에 들려야하는 노드들이 모두 check되면 yes 아니면 no
*/
import java.util.*;
import java.io.*;
public class Main {
    static ArrayList map[];
    static int n;
    static int m;
    static int now=0;
    static ArrayList nums=new ArrayList();
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        map=new ArrayList[n+1];
        for (int i=1;i<=n;i++)map[i]=new ArrayList();
        visit=new boolean[n+1];
        for(int i=1;i<=n;i++){
            String str[]=br.readLine().split(" ");
            for(int j=1;j<=n;j++){
                if(str[j-1].equals("1")){
                    map[i].add(j);
                }
            }
        }
        String str[]=br.readLine().split(" ");
        for(int i=0;i<m;i++)nums.add(Integer.parseInt(str[i]));

        int start=(int)nums.get(0);

        Queue<Integer> q=new LinkedList<Integer>();
        q.add(start);
        visit[start]=true;
        while(!q.isEmpty()){
            int now=(int)q.poll();

            for(int i=0;i<map[now].size();i++){
                int temp=(int)map[now].get(i);
                if(!visit[temp]){
                    q.add(temp);
                    visit[temp]=true;
                }
            }
        }
        boolean can=true;
        for(int i=0;i<nums.size();i++){
            int temp=(int)nums.get(i);
            if(!visit[temp])can=false;
        }
        if(can)System.out.println("YES");
        else System.out.println("NO");
    }
}
