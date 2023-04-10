package Sliver5.baekjoon_4673;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 10000; i++) {
            map.put(i,i);
        }
        for (int i = 1; i <= 10000; i++) {
            int n = i;
            int sum = n;
            while (n  != 0) {
                //55 -> 55 + 5 + 5 = 65 => 셀프넘버가 아니다
                sum += n % 10;
                n /= 10;
            }
            map.remove(sum);
        }
        for (Integer integer : map.keySet()) {
            System.out.println(integer);
        }
    }
}
