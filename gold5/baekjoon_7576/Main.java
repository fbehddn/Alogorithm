package gold5.baekjoon_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }
        System.out.println(result - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int t = 0; t < size; t++) {
                int[] current = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = current[0] + dx[i];
                    int nextCol = current[1] + dy[i];
                    if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M && map[nextRow][nextCol] == 0) {
                        queue.add(new int[]{nextRow, nextCol});
                        map[nextRow][nextCol] = map[current[0]][current[1]] + 1;
                    }
                }
            }
        }
    }
}
