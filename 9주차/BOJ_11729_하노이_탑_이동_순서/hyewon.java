import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_11729_하노이_탑_이동_순서 {

    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void Hanoi(int N, int start, int mid, int to) throws IOException {

        // 이동할 원반의 수가 1개라면?
        if (N == 1) {
            bufferedWriter.write(start + " " + to + "\n");
            return;
        }

        // STEP 1 : N-1개를 A에서 B로 이동
        Hanoi(N - 1, start, to, mid);

        // STEP 2 : 1개를 A에서 C로 이동
        bufferedWriter.write(start + " " + to + "\n");

        // STEP 3 : N-1개를 B에서 C로 이동
        Hanoi(N - 1, mid, start, to);

    }
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        bufferedWriter.write((int)(Math.pow(2,n) -1) + "\n");

        Hanoi(n,1,2,3);

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
