/**
 * @문제접근
 * 문제에 맞는 정렬조건을 새로 만들어 풀었습니다.
 * input 문자열을 새로 만든 Name 클래스형태로 변환해 배열에 저장하고,
 * Name 클래스에 정의한 compareTo함수를 통해 길이, 사전 순 정렬했습니다.
 * 중복을 제거하기 위해 처음 입력을 받을 때 HashSet을 사용해 중복을 제거했습니다.
 */


package ps.swea;

import java.io.*;
import java.util.*;


/**
 * String 그대로 정렬하면 길이 순 정렬이 아니라 사전 순으로 정렬되기 때문에,
 * Name 클래스를 만들어 정렬조건만 재정의 했습니다.
 */
class Name implements Comparable<Name>{
    private final String name;

    // 생성자
    public Name(String name){
        this.name = name;
    }

    // 매개변수 name을 가져옴
    public String getName(){
        return this.name;
    }

    // 정렬 재정의
    @Override
    public int compareTo(Name n) {
        if(this.name.length() < n.name.length()){
            return -1;
        } else if(this.name.length() > n.name.length()){
            return 1;
        } else {
            return this.name.compareTo(n.name) < 0 ? -1 : 1;
        }
    }
}


public class SWEA_7701_염라대왕의_이름_정렬 {

    public static void solve(ArrayList<Name> nameList) throws IOException{
        
        // System IO가 자주 발생하기 때문에, 성능향상을 위해 BufferedWriter를 사용했습니다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 새로 정의한 정렬메소드를 기준으로 nameList 정렬
        Collections.sort(nameList);
        
        for(Name name: nameList)
            bw.write(name.getName()+'\n');

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
                ArrayList<Name> nameList = new ArrayList<>();

                for(int i = 0; i < N; i++)
                    input.add(br.readLine());


                for(String item: input){
                    Name name = new Name(item);
                    nameList.add(name);
                }

                System.out.println("#" + tc);
                solve(nameList);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

