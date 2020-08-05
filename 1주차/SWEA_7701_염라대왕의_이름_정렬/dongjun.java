/**
 * @문제접근
 * 문제에 맞는 정렬조건을 람다식으로 만들어 풀었습니다.
 * 중복을 제거하기 위해 처음 입력을 받을 때 HashSet을 사용해 중복을 제거했습니다.
 */


package ps.swea;

import java.io.*;
import java.util.*;


public class SWEA_7701_염라대왕의_이름_정렬 {

    public static void solve(HashSet<String> input) throws IOException{

        // System IO가 자주 발생하기 때문에, 성능향상을 위해 BufferedWriter를 사용했습니다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> nameList = new ArrayList<>(input);

        // 길이를 기준으로 문자열 비교
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

