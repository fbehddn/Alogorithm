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
    static int[] result;
    static boolean[] visited;
    // visited 의 역할을 result 와 혼용하기 위해
    // static int[] visited 로 선언하여, 값이 0인경우 방문함과 동시에 +1로 값 증가 ...

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = new int[100001];
        visited = new boolean[100001];

        bfs(N);
        System.out.println(result[K]);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            step += 1;
            for (int i = queue.size(); i > 0; i--) {
                int current = queue.poll();
                if (current == K) {
                    return;
                }
                for (int j = 0; j < 3; j++) {
                    int nextX = j == 2 ? current * dx[j] : current + dx[j];

                    if (nextX >= 0 && nextX <= 100000 && !visited[nextX]) {
                        queue.add(nextX);
                        visited[nextX] = true;
                        result[nextX] = step;
                    }
                }
            }
        }
    }
}
