/**
 * @문제접근
 * 백트래킹을 통해 풀었습니다.
 * 괄호가 성립하는 조건에 맞춰 탐색을 진행했습니다.
 *
 * @성능
 * Runtime: 1 ms
 * Memory Usage: 39.4 MB
 */
public class GenerateParentheses {
    public static ArrayList<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        answer.clear();
        dfs("(", 1, 0, n);

        return answer;
    }

    public void dfs(String now, int lbCnt, int rbCnt, int n){
        if(now.length() == n * 2){
            answer.add(now);
            return;
        }
        if(lbCnt < n)
            dfs(new String(now + "("), lbCnt + 1, rbCnt, n);

        if(lbCnt <= n && lbCnt > rbCnt)
            dfs(new String(now + ")"), lbCnt, rbCnt + 1, n);
    }
}

