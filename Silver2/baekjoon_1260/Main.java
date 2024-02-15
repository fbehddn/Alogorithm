package Silver2.baekjoon_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,M,V;
    static boolean[] visited;
    /**
     * DFS에 필요한 변수
     */
    static ArrayList<Integer>[] A;
    static ArrayList<Integer> result;

    /**
     * BFS에 필요한 변수
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        result = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(A[i]);
        }

        DFS(V);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }

        System.out.println(sb);
    }

    private static void DFS(int start) {
        if(!visited[start]) {
            visited[start] = true;
            result.add(start);
        }
        for (int i : A[start]) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(i);
                DFS(i);
            }
        }
    }
}
