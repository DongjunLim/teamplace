package 백준;
/*
BFS로 물먼저 돌고 그다음 사람
사람이 움직이는 거리는 dp[][]에 저장
*/
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo3055 {
    static char map[][];
    static int n,m;
    static int dp[][];
    static int dx[]={0,-1,0,1};
    static int dy[]={-1,0,1,0};
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        n=Integer.parseInt(str[0]);m=Integer.parseInt(str[1]);
        map=new char[n+1][m+1];
        dp=new int[n+1][m+1];
        Queue man=new LinkedList();
        Queue water=new LinkedList();
        visit=new boolean[n+1][m+1];
        Point last=new Point(0,0);
        for (int i=1;i<=n;i++){
            String s=br.readLine();
            for(int j=1;j<=s.length();j++){
                map[i][j]=s.charAt(j-1);
                if(s.charAt(j-1)=='*'){
                    water.add(new Point(i,j));
                    visit[i][j]=true;
                }else if (s.charAt(j-1)=='S'){
                    man.add(new Point(i,j));
                    visit[i][j]=true;
                }else if(s.charAt(j-1)=='D'){
                    last=new Point(i,j);
                }
            }
        }

        while(true){
            water=waterq(water);
            man=manq(man);
            if(man.size()==0||dp[last.x][last.y]!=0)break;
        }
        if(dp[last.x][last.y]==0)System.out.println("KAKTUS");
        else System.out.println(dp[last.x][last.y]);

    }
    static Queue waterq(Queue q){
        Queue tq=new LinkedList();

        while (!q.isEmpty()){
            Point pt=(Point)q.poll();
            for (int i=0;i<4;i++){
                int x=pt.x+dx[i]; int y=pt.y+dy[i];

                if (x>0&&y>0&&x<=n&&y<=m){
                    if(!visit[x][y]&&(map[x][y]=='.'||map[x][y]=='S'||map[x][y]=='*')){
                        visit[x][y]=true;
                        tq.add(new Point(x,y));
                    }
                }

            }
        }
        return tq;
    }
    static Queue manq(Queue q){
        Queue tq=new LinkedList();

        while (!q.isEmpty()){
            Point pt=(Point)q.poll();
            for (int i=0;i<4;i++){
                int x=pt.x+dx[i]; int y=pt.y+dy[i];

                if (x>0&&y>0&&x<=n&&y<=m){
                    if(!visit[x][y]&&(map[x][y]=='.'||map[x][y]=='D')){
                        visit[x][y]=true;
                        dp[x][y]=dp[pt.x][pt.y]+1;
                        tq.add(new Point(x,y));
                    }
                }

            }
        }
        return tq;
    }
}
