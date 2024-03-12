package Silver2.baekjoon_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        /**
         * - 부터 그 다음 - 전까지 묶기
         */

        String[] strArr = str.split("-");

        sum += Integer.parseInt(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            fuc(strArr[i]);
        }

        System.out.println(sum);
    }

    private static void fuc(String temp) {
        sum -= Integer.parseInt(temp);
    }
}
