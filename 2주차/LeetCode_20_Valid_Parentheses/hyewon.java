/*
괄호의 쌍이 유효한지 판단하는 문제

스택을 사용한 풀이
열리는 괄호의 경우 조건을 따지지 않고 push
닫히는 괄호의 경우 즉시 pop하여 스택에 top에 있는 괄호와 짝지어지는 지를 검사
유효한 괄호쌍이 아닐 경우 바로 false를 return한다.
모든 괄호를 다 체크 한 이후, 스택에 값이 남아있지 않은 경우는 유효한 괄호이므로 true를 return할 수 있다.

Time Complexity: O(N)
Space Complexity: O(N)
*/


import java.util.Stack;

public class Leetcode20_Valid_Parentheses {
    public static boolean isValid(String s) {

        Stack<Character> parenthese = new Stack<>();
        char[] charArray = s.toCharArray();

        if (s.length() % 2 != 0) return false;

        for (char c : charArray) {

            if (c == '(' || c == '{' || c == '[') {
                parenthese.push(c);
                continue;
            }
            if (parenthese.empty()) return false;

            char innder = parenthese.peek();
            parenthese.pop();

            if (!(innder == '{' && c == '}' || innder == '(' && c == ')' || innder == '[' && c == ']'))
                return false;
        }
        return parenthese.empty();
    }

    public static void main(String[] args) {
        // write your code here
        String str = "[]{}[]{";
        boolean answer = isValid(str);
        System.out.print(answer);
    }
}
