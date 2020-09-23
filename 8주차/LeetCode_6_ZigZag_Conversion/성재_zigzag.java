package LEETCODE;
/*
글로 설명하기 너무 복잡함ㅎㅎ
 */

import java.util.*;
public class leet_ZigZag_Conversion {
    public static void main(String[] args) {
        String s="PAYPALISHIRING"; int numRows=2;
        int len=s.length();
        String res="";
        boolean visit[]=new boolean[len];
        int jump=(numRows-1)*2;
        int term=(len/numRows)*jump;
        for (int i=0;i<numRows;i++){
            for (int j=0;j<=term;j+=jump){
                int start=j-i;
                int end=j+i;
                if(start>=0&&start<len){
                    if(!visit[start]){
                        res+=s.charAt(start);
                        visit[start]=true;
                    }
                }
                if(end<len){
                    if(!visit[end]){
                        res+=s.charAt(end);
                        visit[end]=true;
                    }
                }
            }
        }
        System.out.println(res);

    }
}
