/*
Stack과 정규식을 이용한 풀이
후위 연산을 적용하기 위하여 stack을 사용
들어온 요소가 0-9 사이의 자연수 일 경우 push
들어온 요소가 +, -, *, / 일 경우 stack에서 2개의 요소를 pop하여
연산을 적용한 후 다시 push
마지막 원소를 pop함으로써 결과값을 얻어낼 수 있다.

Time Complexity:O(N)
Space Complexity:(N)
*/

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Valid operators are +, -, *, /. Each operand may be an integer or another expression.

public class Leetcode150_Evaluate_Reverse_Polish_Notation {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String DIV = "/";
    public static final String MULTI = "*";

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Pattern pattern = Pattern.compile("[0-9]");

        for (String token : tokens) {
            Matcher matcher = pattern.matcher(token);
            if (matcher.find()) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            //is not intger
            int b = stack.pop();
            int a = stack.pop();
            switch (token) {
                case PLUS:
                    stack.push(a + b);
                    break;
                case MINUS:
                    stack.push(a - b);
                    break;
                case DIV:
                    stack.push(a / b);
                    break;
                case MULTI:
                    stack.push(a * b);
                    break;

            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // write your code here
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int answer = evalRPN(tokens);
        System.out.print(answer);
    }
}
