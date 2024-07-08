package Sliver5.baekjoon_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = N;

        for (int i = 0; i < N; i++) {
            boolean[] arr = new boolean[26];
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (!arr[str.charAt(j) - 'a']) {
                    arr[str.charAt(j) - 'a'] = true;
                } else if (j > 0 && str.charAt(j) != str.charAt(j - 1)) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
