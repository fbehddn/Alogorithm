package Silver3.baekjoon_1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int len = Math.min(row, col);

        /**
         * 3 5
         * 4 2 1 0 1
         * 2 3 1 1 0
         * 2 2 1 1 0
         */
        /**
         * row = 3, col = 5
         * len = 3
         */
        while (len > 1) {
            for (int i = 0; i <= row - len; i++) {
                for (int j = 0; j <= col - len; j++) { // j=2
                    int a = map[i][j]; //a=1 len=3
                    if (a == map[i][j + len - 1] && a == map[i + len - 1][j] && a == map[i + len - 1][j + len - 1]) {
                        System.out.println(len * len);
                        return;
                    }
                }
            }
            len--;
        }
        System.out.println(len * len);
    }
}