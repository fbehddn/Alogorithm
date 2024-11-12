package Silver2.baekjoon_24445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] link;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        link = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < link.length; i++) {
            link[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            link[s].add(e);
            link[e].add(s);
        }
        for (ArrayList<Integer> integers : link) {
            Collections.sort(integers, Collections.reverseOrder());
        }
        bfs(V);

        for(int i=1; i<N+1; i++) {
            System.out.println(result[i]);
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        visited[v] = true;
        result[v] = count++;
        queue.add(v);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer i : link[current]) {
                if(!visited[i]) {
                    visited[i] = true;
                    result[i] = count++;
                    queue.add(i);
                }
            }
        }
    }
}
