package Silver1.baekjoon_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] dx = {-1, 1, 2};
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        bfs(N);
        System.out.println(visited[K]);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int current = queue.poll();
                if (current == K) {
                    return;
                }
                for (int j = 0; j < 3; j++) {
                    int nextX = j == 2 ? current * dx[j] : current + dx[j];

                    if (0 <= nextX && nextX <= 100000 && visited[nextX] == 0) {
                        queue.add(nextX);
                        visited[nextX] = visited[current] + 1;
                    }
                }
            }
        }
    }
}
