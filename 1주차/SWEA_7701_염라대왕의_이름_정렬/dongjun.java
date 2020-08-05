/**
 * @��������
 * ������ �´� ���������� ���ٽ����� ����� Ǯ�����ϴ�.
 * �ߺ��� �����ϱ� ���� ó�� �Է��� ���� �� HashSet�� ����� �ߺ��� �����߽��ϴ�.
 */


package ps.swea;

import java.io.*;
import java.util.*;


public class SWEA_7701_��������_�̸�_���� {

    public static void solve(HashSet<String> input) throws IOException{

        // System IO�� ���� �߻��ϱ� ������, ��������� ���� BufferedWriter�� ����߽��ϴ�.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> nameList = new ArrayList<>(input);

        // ���̸� �������� ���ڿ� ��
        nameList.sort((n1, n2) -> {
            if(n1.length() == n2.length())
                return n1.compareTo(n2);
            return Integer.compare(n1.length(), n2.length());
        });

        for(String name: nameList)
            bw.write(name+'\n');

        bw.flush();
    }


    public static void main(String args[]){
        try{
            FileReader file = new FileReader("./src/ps/swea/input.txt");
            BufferedReader br = new BufferedReader(file);

            int T = Integer.parseInt(br.readLine());

            for(int tc = 1; tc <= T; tc++){
                int N = Integer.parseInt(br.readLine());
                HashSet<String> input = new HashSet<>();

                for(int i = 0; i < N; i++)
                    input.add(br.readLine());

                System.out.println("#" + tc);
                solve(input);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

