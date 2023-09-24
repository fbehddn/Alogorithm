package 알고리듬수업.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 격자 크기 n * n
        int m = Integer.parseInt(st.nextToken()); // 치즈의 개수 (좌표 입력 행의 개수)

        int[][] setCheese = new int[n][n]; // 좌표별 치즈의 개수를 담는 배열


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());

            setCheese[x-1][y-1] = 1;
        }

        int maxCh = maxCh(setCheese, n, n); //찾아야 할 값. (n,n) 에서의 먹고온 치즈의 총 개수

        System.out.println(maxCh);
    }
    private static int maxCh(int[][] setCheese, int x, int y) {
        int[][] f = new int[x][y];

        f[0][0] = setCheese[0][0];

        // 맨 밑 행
        for (int i = 1; i < x; i++) {
            f[i][0] = f[i-1][0] + setCheese[i][0];
        }

        //맨 왼쪽 열
        for (int j = 1; j < y; j++) {
            f[0][j] = f[0][j-1] + setCheese[0][j];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + setCheese[i][j];
            }
        }

        return f[x-1][y-1];
    }
}
