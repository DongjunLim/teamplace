import java.util.Arrays;
import java.util.Scanner;

public class BJ_1107_리모컨 {

    private static final int MAXVALUE = 500000;
    public static boolean[] availableButton = new boolean[10];
    public static int answer = Integer.MAX_VALUE;

    private static void solution(int target) {

        answer = Math.min(answer, Math.abs(target - 100)); // 100dptj +/- 만으로 이동하는 경우로 초깃값 설

        String targetStr = Integer.toString(target); // 도달하고자 하는 채널
        String currentNum = "";

        //버튼으로 눌러서 이동할 수 있는 경우까지 이동
        int num = 0;
        for (int index = 0; index < targetStr.length(); index++) {
            num = Integer.parseInt(String.valueOf(targetStr.charAt(index)));
            if (availableButton[num])
                currentNum += Integer.toString(num);
            else
                break; // 버튼을 누를 수 없는 경우 탈출한다
        }
        alternativeNumber(target, currentNum); // 하한 값을 계산 
        if (currentNum.length() != 0)
            alternativeNumber(target, currentNum.substring(0, currentNum.length() - 1)); // 상한값을 계산


        System.out.print(answer);
    }

    private static void alternativeNumber(int target, String currentNum) {
        for (int index = 0; index < 10; index++) {
            if (!availableButton[index]) continue; // 버튼을 누를 수 없는 경우 
            //버튼을 누를 수 있는 경우
            String number = currentNum + Integer.toString(index); 

            if (Integer.parseInt(number) >= MAXVALUE) {
                return;
            }

            answer = Math.min(answer, Math.abs(target - Integer.parseInt(number)) + number.length());
            
            if (number.length() != Integer.toString(target).length())
                alternativeNumber(target, number);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        int notWorkingButton = scanner.nextInt();

        Arrays.fill(availableButton, true);

        for (int i = 0; i < notWorkingButton; i++) {
            int broken = scanner.nextInt();
            availableButton[broken] = false;
        }
        if (notWorkingButton < 10) {
            solution(target);
        }
    }
}

/*
5457
3
6 7 8

195
1
9

375
5
4 5 7 8 9

500000
6
1 3 4 5 7 8
 */
