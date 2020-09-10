/*
set으로 중복되나 안되나 check함
트라이로 했을때는 시간초과가 발생..
시간복잡도 set>트라이??
*/
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        trie tri=new trie();
        String str[]=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        HashSet hst=new HashSet();
        for(int i=0;i<n;i++){
            hst.add(br.readLine());
//            tri.insert(br.readLine());
        }
        int res=0;
        for(int i=0;i<m;i++){
//            if(tri.find(br.readLine()))res++;
                if(hst.contains(br.readLine()))res++;
        }
        System.out.println(res);
    }

}

class trienode{
    HashMap childnodes;
    boolean islast=false;
    trienode(){
        childnodes=new HashMap();
    }
    HashMap getChildnodes(){
        return childnodes;
    }
}
class trie{
    trienode rootnode;
    trie(){
        rootnode=new trienode();
    }

    void insert(String s){
        trienode thisnode=rootnode;
        for (int i=0;i<s.length();i++){
            thisnode= (trienode) thisnode.getChildnodes().computeIfAbsent(s.charAt(i), c->new trienode());
        }
        thisnode.islast=true;
    }
    boolean find(String s){
        trienode thisnode=rootnode;
        for(int i=0;i<s.length();i++){
            if(thisnode.getChildnodes().containsKey(s.charAt(i))){
                thisnode= (trienode) thisnode.getChildnodes().get(s.charAt(i));
            }else{
                return false;
            }
        }
        if(thisnode.islast)return true;
        else return false;
    }
}
