package Silver2.baekjoon_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int M, N, B;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로길이
            B = Integer.parseInt(st.nextToken()); // 심어져 있는 배추의 개수

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < B; i++) {
                String[] str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                map[x][y] = 1;
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }
            result.add(count);
        }
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static void dfs(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];
            if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && visited[nextX][nextY] == false
                    && map[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }
}
