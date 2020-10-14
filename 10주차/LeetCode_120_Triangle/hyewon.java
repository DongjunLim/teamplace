import java.util.ArrayList;
import java.util.List;

/*
DP Bottom-up 방식
triangle중 가장 밑에 있는 배열로 초깃값 setting
순차적으로 triangle의 윗방향으로 올라가면서
아래에 있는 값 중 최솟 값을 선택하여 더한다.

Time Complexity: O(N^2)
Space Complexity: O(N)
 */
public class Leetcode120_Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {

        int size = triangle.size();
        int[] cache = new int[triangle.get(size - 1).size()];

        for (int col = 0; col < cache.length; col++) {
            cache[col] = triangle.get(size - 1).get(col); // 초깃값 셋팅
        }
        for (int row = size - 2; row >= 0; row--) { // 가장 밑에 있는 배열부터 시작해서 위로 올라감
            for (int col = 0; col < triangle.get(row).size(); col++) {
                cache[col] = triangle.get(row).get(col) + Math.min(cache[col],cache[col+1]); // 현재 위치에 있는 Triangle 값과 이전까지의 최솟값을 더하여 업데이트
            }
        }
        return cache[0];
    }

    public static void main(String[] args) {
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(2);

        List<Integer> temp2 = new ArrayList<>();
        temp2.add(3);
        temp2.add(4);

        List<Integer> temp3 = new ArrayList<>();
        temp3.add(6);
        temp3.add(5);
        temp3.add(7);

        List<Integer> temp4 = new ArrayList<>();
        temp4.add(4);
        temp4.add(1);
        temp4.add(8);
        temp4.add(3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(temp1);
        list.add(temp2);
        list.add(temp3);
        list.add(temp4);

        System.out.print(minimumTotal(list));
    }
}
