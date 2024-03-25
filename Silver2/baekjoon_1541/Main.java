package Silver2.baekjoon_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] str = line.split("-");

        for (int i = 0; i < str.length; i++) {
            if (i == 0) {
                result += myFunc(str[i]);
            } else {
                int sum = myFunc(str[i]);
                result -= sum;
            }
        }

        System.out.println(result);
    }

    private static int myFunc(String str) {
        int sum = 0;
        String[] temp = str.split("\\+");
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
