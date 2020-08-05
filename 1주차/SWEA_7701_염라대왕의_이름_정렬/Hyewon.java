import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1181_단어정렬 {

    /*
    알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
    길이가 짧은 것부터
    길이가 같으면 사전 순으로
     */

    private static void solution(HashSet<String> words) {
        List<String> wordlist = new ArrayList<>(words);

        Collections.sort(wordlist, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        printAnswer(wordlist);
    }

    private static void printAnswer(List<String> wordlist) {
        for(String word : wordlist){
            System.out.println(word);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());

        HashSet<String> words = new HashSet<>();

        for(int i =0;i< size;i++){
            String str= bufferedReader.readLine();
            words.add(str);
        }
        solution(words);
    }
    
}
