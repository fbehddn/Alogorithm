package Gold4.baekjoon_1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, E;
    static ArrayList<Node>[] graph;
    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, weight));
            graph[b].add(new Node(a, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int route1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int route2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        int minimumDistance = (route1 >= INF && route2 >= INF) ? -1 : Math.min(route1, route2);

        System.out.println(minimumDistance);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] d = new int[N + 1];
        Arrays.fill(d, INF);
        queue.add(new Node(start, 0));
        d[start] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int node = cur.node;

            for (Node temp : graph[node]) {
                int nextNode = temp.node;
                int distance = temp.weight;

                if (d[nextNode] > d[node] + distance) {
                    d[nextNode] = d[node] + distance;
                    queue.add(new Node(nextNode, d[nextNode]));
                }
            }
        }
        return d[end];
    }

    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
