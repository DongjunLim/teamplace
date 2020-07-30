/**
 * @��������
 * ������ �´� ���������� ���� ����� Ǯ�����ϴ�.
 * input ���ڿ��� ���� ���� Name Ŭ�������·� ��ȯ�� �迭�� �����ϰ�,
 * Name Ŭ������ ������ compareTo�Լ��� ���� ����, ���� �� �����߽��ϴ�.
 * �ߺ��� �����ϱ� ���� ó�� �Է��� ���� �� HashSet�� ����� �ߺ��� �����߽��ϴ�.
 */


package ps.swea;

import java.io.*;
import java.util.*;


/**
 * String �״�� �����ϸ� ���� �� ������ �ƴ϶� ���� ������ ���ĵǱ� ������,
 * Name Ŭ������ ����� �������Ǹ� ������ �߽��ϴ�.
 */
class Name implements Comparable<Name>{
    private final String name;

    // ������
    public Name(String name){
        this.name = name;
    }

    // �Ű����� name�� ������
    public String getName(){
        return this.name;
    }

    // ���� ������
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


public class SWEA_7701_��������_�̸�_���� {

    public static void solve(ArrayList<Name> nameList) throws IOException{
        
        // System IO�� ���� �߻��ϱ� ������, ��������� ���� BufferedWriter�� ����߽��ϴ�.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // ���� ������ ���ĸ޼ҵ带 �������� nameList ����
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

