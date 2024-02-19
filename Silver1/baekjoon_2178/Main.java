package Silver1.baekjoon_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] A;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[x][y] = true;
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int nextX = now[0] + dx[k];
                int nextY = now[1] + dy[k];
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (A[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        A[nextX][nextY] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
