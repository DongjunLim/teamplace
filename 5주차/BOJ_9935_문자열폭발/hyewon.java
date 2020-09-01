/*
스택을 사용한 풀이

제공되는 문자열을 조건 없이 바로 stack에 쌓는다.
폭발 문자열의 마지막 문자와 같은 경우 계산을 시작한다.

제공되는 문자열의 문자와, 폭발 문자열의 마지막 문자와 같을 경우
스택에 top에서부터 아래로 내려가며 폭발문자열과 비교한다
완전히 동일한 문자열일 경우 stack에서 pop하여 제거한다.

Time Complexity: O(N^2)
Space Complexity : O(N)
*/
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class BJ_9935_문자열_폭발 {

    public static Stack<Character> stack = new Stack<>();
    public static String str = "";
    public static String pattern = "";
    public static boolean isBomb = false;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        str = scanner.next();
        pattern = scanner.next();

        solution();
    }

    private static void solution() {

        for (int index = 0; index < str.length(); index++) {
            stack.push(str.charAt(index));

            int patternSize = pattern.length();

            if (stack.size() < patternSize) {
                continue;
            }
            if (stack.peek() == pattern.charAt(patternSize - 1)) {
                isBomb = true;

                for (int gap = 1; gap < patternSize; gap++) {
                    if ( stack.get(stack.size() - gap - 1) != pattern.charAt(patternSize - gap - 1)){
                        isBomb = false;
                        break;
                    }
                }
            }
            if (isBomb) {
                while (patternSize-- > 0) {
                    stack.pop();
                }
                isBomb = false;
            }
        }
        printAnswer();
    }


    private static void printAnswer() {
        StringBuffer answer = new StringBuffer();

        if (stack.empty()) {
            answer.append("FRULA");
        } else {
            while (!stack.empty()) {
                answer.append(stack.pop());
            }
            answer.reverse();
        }
        System.out.print(answer);
    }
}
