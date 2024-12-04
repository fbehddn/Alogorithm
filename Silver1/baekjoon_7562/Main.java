package Silver1.baekjoon_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[][] map;
    static boolean[][] visited;
    static int targetX, targetY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            int size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            visited = new boolean[size][size];

            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            int result = bfs(curX, curY, size);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int curX, int curY, int size) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curX, curY});
        //처음 노드를 방문체크 하지 않으면, 시작점과 목표지점이 동일한 경우 추후 방문시 값을 업데이트하는 오류가 생김.
        visited[curX][curY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (0 <= nextX && nextX < size && 0 <= nextY && nextY < size && !visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[cur[0]][cur[1]] + 1;

                    if (nextX == targetX && nextY == targetY) {
                        return map[targetX][targetY];
                    }
                }
            }
        }
        return 0;
    }
}
