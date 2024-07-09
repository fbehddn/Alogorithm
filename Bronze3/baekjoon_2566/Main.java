package Bronze3.baekjoon_2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int rows = 1;
        int cols = 1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int temp = max;
                max = Math.max(arr[i][j], max);
                if (temp != max) {
                    rows = i + 1;
                    cols = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.print(rows + " " + cols);
    }
}
