package Silver2.baekjoon_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,V;
    static ArrayList<Integer>[] A;

    /**
     * DFS에 필요한 변수
     */
    static boolean[] visited;
    static ArrayList<Integer> result;

    /**
     * BFS에 필요한 변수
     */
    static boolean[] visited2;
    static ArrayList<Integer> result2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        visited2 = new boolean[N+1];

        A = new ArrayList[N+1];
        result = new ArrayList<>();
        result2 = new ArrayList<>();

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
        BFS(V);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }

        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < result2.size(); i++) {
            sb2.append(result2.get(i) + " ");
        }

        System.out.println(sb2);
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited2[start] = true;
        result2.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : A[cur]) {
                if (!visited2[next]) {
                    visited2[next] = true;
                    result2.add(next);
                    queue.add(next);
                }
            }
        }
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
