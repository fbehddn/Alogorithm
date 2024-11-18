package Silver1.baekjoon_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, eachHome;
    static List<Integer> houseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        houseCount = new ArrayList<>();
        eachHome = 1;

        // 지도 초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    eachHome = 1;
                    dfs(i, j);
                    houseCount.add(eachHome);
                }
            }
        }

        Collections.sort(houseCount);

        System.out.println(houseCount.size());
        for (Integer i : houseCount) {
            System.out.println(i);
        }
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY] && map[nextX][nextY]==1) {
                eachHome++;
                dfs(nextX, nextY);
            }
        }
    }
}
