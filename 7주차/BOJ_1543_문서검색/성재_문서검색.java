import java.util.*;
import java.io.*;
/*
맨 첫글자 부터 검사 -> 첫글자가 같으면 비교시작 ->비교했으면 check
*/
public class Main {
	static int tot=0;
	static int dn=0;
	static int tn=0;
	static boolean visit[]=new boolean[3000];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String mon=br.readLine();
		char doc[]=mon.toCharArray();
		dn=doc.length;
		String tar=br.readLine();
		char t[]=tar.toCharArray();
		tn=t.length;
		
		find(doc,0,t);
		System.out.println(tot);
		
	}
	
	static void find(char[] map,int s,char[] tmap) {
		int e=-1;
		boolean can=false;
		for(int i=s;i<=dn-tn;i++) {
			can=false;
			if(map[i]==tmap[0]&&!visit[i]) {
				int k=0;
				for(int j=i;j<i+tn;j++) {
//					System.out.println(tmap[k]+"   "+map[j]+"   "+i);
					if(tmap[k]==map[j]) {
						can=true;k++;
					}else {
						can=false;break;
					}
				}
			}
			if(can) {
				for(int j=i;j<i+tn;j++) {
					visit[j]=true;
				}
				tot++;
			
			}
			
		}
		
		
		
		
	}
	

}
