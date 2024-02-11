package Silver2.baekjoon_24444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static int result[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[N+1];
        A = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        result[start] = cnt++;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : A[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    result[next] = cnt++;
                    q.add(next);
                }
            }
        }
    }
}
