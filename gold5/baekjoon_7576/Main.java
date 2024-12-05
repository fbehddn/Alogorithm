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
    static List<int[]> startIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //열
        N = Integer.parseInt(st.nextToken()); //행
        map = new int[N][M];
        startIdx = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    startIdx.add(new int[]{i, j});

                }
            }
        }

        int result = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    result = -1;
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < startIdx.size(); i++) {
            queue.add(new int[]{startIdx.get(i)[0], startIdx.get(i)[1]});
        }

        int day = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // 큐 크기 고정
            for (int t = 0; t < size; t++) {
                int[] current = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = current[1] + dx[i];
                    int nextY = current[0] + dy[i];
                    if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N && map[nextY][nextX] == 0) {
                        queue.add(new int[]{nextY, nextX});
                        map[nextY][nextX] = 1;
                    }
                }
            }
            day++;
        }
        return day - 1;
    }
}
