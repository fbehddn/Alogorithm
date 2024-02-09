package Silver2.baekjoon_24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int[] answer;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int start = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            A[n1].add(n2);
            A[n2].add(n1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        visited[start] = true;
        DFS(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void DFS(int n) {
        answer[n] = ++idx;
        for (int i : A[n]) {
            if (visited[i]) continue;
            visited[i] = true;
            DFS(i);
        }
    }
}
