package Bronze5.baekjoon_11382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        Long result = Long.parseLong(strArr[0]) +Long.parseLong(strArr[1]) + Long.parseLong(strArr[2]);

        System.out.println(result);
    }
}
