package Silver2.baekjoon_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,V;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N + 1];
        sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        DFS(V);
        visited = new boolean[N + 1];
        sb.append("\n");
        BFS(V);
        System.out.println(sb);
    }

    private static void BFS(int start) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur + " ");
            for (int i : arr[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    private static void DFS(int start) {
        visited[start] = true;
        sb.append(start + " ");
        for (int i : arr[start]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
