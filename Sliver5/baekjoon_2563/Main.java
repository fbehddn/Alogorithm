package Sliver5.baekjoon_2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] arr = new boolean[101][101];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    arr[j][k] = true;
                    result++;
                }
            }
        }

        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                if (arr[x][y]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
