import java.util.Scanner;

public class BJ_5052_전화번호_목록 {


    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for (int t = 0; t < testCase; t++) {
            boolean answer;
            int num = scanner.nextInt();
            String[] phoneBook = new String[num];

            for (int i = 0; i < num; i++) {
                phoneBook[i] = scanner.next();
            }
            answer = solution(phoneBook);
            System.out.print((answer)? "YES" : "NO");
        }
    }

    private static boolean solution(String[] phoneBook) {
        for (int i = 0; i < phoneBook.length -1; i++) {
            for (int j = i + 1; j < phoneBook.length; j++) {
                if (phoneBook[j].startsWith(phoneBook[i])) return false;
                if (phoneBook[i].startsWith(phoneBook[j])) return false;
            }
        }
        return true;
    }
}
