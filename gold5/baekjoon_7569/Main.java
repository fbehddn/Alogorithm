package gold5.baekjoon_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] map;
    static Queue<Tomato> queue;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[M][N][H];
        queue = new LinkedList<>();

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    map[x][y][z] = Integer.parseInt(st.nextToken());
                    if (map[x][y][z] == 1) {
                        queue.add(new Tomato(x, y, z));
                    }
                }
            }
        }
        bfs();

        int max = Integer.MIN_VALUE;

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[x][y][z] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, map[x][y][z]);
                }
            }
        }
        int result = max - 1;
        System.out.println(result);
    }

    private static void bfs() {
        while (queue.size() > 0) {
            Tomato tomato = queue.poll();
            int curX = tomato.x;
            int curY = tomato.y;
            int curZ = tomato.z;

            for (int i = 0; i < 6; i++) {
                int nextRow = curX + dx[i];
                int nextCol = curY + dy[i];
                int nextZ = curZ + dz[i];

                if (0 <= nextRow && nextRow < M && 0 <= nextCol && nextCol < N && 0 <= nextZ && nextZ < H
                        && map[nextRow][nextCol][nextZ] == 0) {
                    queue.add(new Tomato(nextRow, nextCol, nextZ));
                    map[nextRow][nextCol][nextZ] = map[curX][curY][curZ] + 1;
                }
            }
        }
    }

    private static class Tomato {
        int x, y, z;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
