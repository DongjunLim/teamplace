package LEETCODE;
/*
일단은 틀림=========================
스텍에 숫자가 나오면 숫자를 넣고 그후 [ , 문자를  ]가 나올때까지 스택에 넣는다
]가 나오면  [가 나올때까지 모두 뺀다음에 합쳐서 스트링을 만듬 그다음 pop을 하면 숫자가 나오니까 그만큼 스트링을 곱해줌
그다음에 다시 스텍에 넣고 반복하다가 스택의 크기가 1개이면 꺼내서 result에 붙임 ==>반복
*/

import java.util.*;
public class leet394_Decode_String {
    static String res="";
    static String number;
    public static void main(String[] args) {
        String s="100[leetcode]";
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c-'0'>=0&&c-'0'<=9){
                i=makeString(i,s);
            }else{
                res+=c;
            }
        }
        System.out.println(res);
    }
    static int makeString(int start,String s){
        int point=start;
        Stack<String> stack=new Stack<>();
        number="";
        point=startP(s,start);
        stack.push(number);
        stack.push(s.substring(point,point+1));  //괄호를 넣는다 [   =>이 두짓을 하는 이유는 나중에 스텍에 결과하나만 냄겨야되는데 isEmpty를 사용할경우 point의 위치가 범위를 벗어남 그래서 2개넣고 시작
        point++;
        String ts="";
        while (stack.size()>1){
            String  c=s.substring(point,point+1);
            if (c.equals("]")){
                String popingString=poping(stack);
                if (!stack.peek().equals("]")){
                    popingString+=stack.pop();
                }
                stack.push(popingString);

            }else{
                stack.push(c);
            }
            point++;
        }
        ts=stack.pop();
        res+=ts;
        return point-1;
    }
    static String poping(Stack<String> stack){
        String ts="";
        int multi=0;
        while (true){
            String st=stack.peek();
            if (st.equals("[")){
                stack.pop();
                multi=Integer.parseInt(stack.pop());
                break;
            }else{
                ts+=stack.pop();
            }
        }
        String temps="";                //숫자만큼 늘려주는거
        for (int i=0;i<multi;i++){
            temps+=ts;
        }
        String returnString="";         //스텍에는 거꾸로 들어가있기때문에 돌려줘야됨
        for (int i=temps.length()-1;i>=0;i--){
            returnString+=temps.charAt(i);
        }
        return returnString;
    }
    static int startP(String s,int start){
        int last=start;
        for (int i=start;i<s.length();i++){
            if (s.charAt(i)-'0'>=0&&s.charAt(i)-'0'<=9){
                number+=s.charAt(i);
            }else{
                last=i;
                break;
            }
        }
        return last;
    }
}
