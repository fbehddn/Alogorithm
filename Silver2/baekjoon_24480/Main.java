package Silver2.baekjoon_24480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] line;
    static int[] count;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        line = new ArrayList[N + 1];
        count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            line[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            line[s].add(e);
            line[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(line[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
        visited[start] = true;
        dfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(count[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int n) {
        count[n] = ++idx;
        for (int i : line[n]) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i);
        }
    }
}
