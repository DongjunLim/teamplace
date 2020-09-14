import java.util.*;

/*
Time Complexity: O(M)
Space compleixty: O(N)
*/

public class BJ_14425_문자열_집합 {

    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            set.add(scanner.next());
        }
        for (int i = 0; i < m; i++) {
            String sentence = scanner.next();
            if (set.contains(sentence)) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}

