/*
Backtracking

Time Complexity: O(2N)
Space Complexity: O(2N)

*/

import java.util.ArrayList;
import java.util.List;

public class Leetcode22_Generate_Parentheses {

    public static List<String> answer = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        backtracking("", 0, 0, n);
        return answer;
    }

    private static void backtracking(String cur, int open, int close, int n) {
        if (cur.length() == n * 2) {
            answer.add(cur);
            return;
        }
        if (open < n) {
            backtracking(cur + '(', open + 1, close, n);
        }
        if (close < open) {
            backtracking(cur + ')', open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        // write your code here
        int n = 3;
        answer = generateParenthesis(n);
        System.out.print(answer.toString());
    }
}
