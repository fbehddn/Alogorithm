package Silver1.baekjoon_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] arr;
    static int N;
    static int count = 0;
    static int count1 = 0;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        int size = N * N;
        int sum = 0;
        /**
         * 총 1의 개수 찾기
         */

        int numbersOfOne = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1 ) numbersOfOne++;
            }
        }

        while (count1 < numbersOfOne) {
            count = 0;
            int semiResult = BFS(0, 0);
            result.add(semiResult);
            sum++;
        }

        System.out.println(sum);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if (arr[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        count1++;
                        count++;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return count;
    }
}
