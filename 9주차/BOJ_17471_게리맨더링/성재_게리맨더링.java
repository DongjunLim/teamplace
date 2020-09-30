package 백준;
/*
1,2 두개를 dfs로 나눠주고 마지막에 두개로나눠진건지 bfs를 사용해서 연결을 체크함
*
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class algo17471_게리맨더링2 {
    static int map[][],nums[];
    static int n,k;
    static int total=0;
    static int people[];
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        map=new int[n+1][n+1];
        nums=new int[n+1];
        people=new int[n+1];
        for (int i=1;i<=n;i++){
            nums[i]=scan.nextInt();
            total+=nums[i];
        }
        for (int i=1;i<=n;i++){
            int m=scan.nextInt();
            for (int j=1;j<=m;j++){
                int temp=scan.nextInt();
                map[i][temp]=1;map[temp][i]=1;
            }
        }
        dfs(1);
        System.out.println((min==Integer.MAX_VALUE)?-1:min);
    }
    static void dfs(int c){
        if (c==n+1){
            int sum1=0;
            int sum2=0;
            for (int i=1;i<=n;i++){
                if (people[i]==1)sum1+=nums[i];
                if (people[i]==2)sum2+=nums[i];
            }
            boolean visit[]=new boolean[n+1];
            int count=0;
            for (int i=1;i<=n;i++){
                if (!visit[i]){
                    count++;
                    isOk(i,people[i],visit);
                }
            }
            if (count==2){
                min=Math.min(min,Math.abs(sum1-sum2));
            }
            return;
        }
        people[c]=1;
        dfs(c+1);
        people[c]=2;
        dfs(c+1);
    }
    static void isOk(int idx,int c,boolean visit[]){
        visit[idx]=true;
        for (int i=1;i<=n;i++){
            if (!visit[i]&&map[i][idx]==1&&people[i]==c){
                if (!visit[i]){
                    isOk(i,c,visit);
                }
            }
        }
    }
}
