package 백준;
/*
모든 사로의 지점을 배열로 받은후 정렬
동물들의 x좌표를 binarySearch로 가장 가까운 인덱스를 구함
그인덱스에서 위아래를 확인하고 둘중 가장 짧은길이를 사용
y좌표와 더한후 사정거리보다 작거나같으면 통과
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class algo8983 {
    static int n,m,l;
    static HashMap<Integer,Integer> range=new HashMap<>();
    static int map[];
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        map=new int[m];int c=0;
        st=new StringTokenizer(br.readLine()," ");
        while (st.hasMoreTokens()){
            int temp=Integer.parseInt(st.nextToken());
            map[c++]=temp;
        }
        Arrays.sort(map);

        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());int y=Integer.parseInt(st.nextToken());
            int idx=binarySearch(x);
            if (idx==map.length-1){
                int temp=Math.abs(map[idx]-x);
                if (temp+y<=l)res++;
            }else{
                int temp=(Math.abs(x-map[idx])>Math.abs(x-map[idx+1]))?Math.abs(x-map[idx+1]):Math.abs(x-map[idx]);
                if (temp+y<=l)res++;
            }

        }

        System.out.println(res);
    }

    static int binarySearch(int x){
        int i=0;int j=map.length-1;
        int mid=(i+j)/2;
        while (i<=j){
            if (map[mid]<x){
                i=mid+1;
                mid=(i+j)/2;
            }else if (map[mid]>x){
                j=mid-1;
                mid=(i+j)/2;
            }else if(map[mid]==x){
                return mid;
            }
        }
        return mid;
    }
}
