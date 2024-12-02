package gold5.baekjoon_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//이전 숨바꼭질 문제와 다르게, 방문을 늦게하더라도 시간이 더 짧게 소요됐을 수 있다는 점.
public class Main {
    static int[] dx = {-1, 1, 2};
    static int[] d;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치
        d = new int[100_001];

        dijkstra(N, K);
        System.out.println(d[K]);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                if ((i == 2) && (cur.node * dx[i] <= 100_000)) {
                    int nextNode = cur.node * dx[i];

                    if (d[nextNode] > d[cur.node] + 0) {
                        d[nextNode] = d[cur.node] + 0;
                        queue.add(new Node(cur.node * dx[i], d[cur.node] + 0));
                    }
                } else if ((i == 0 || i == 1) && (0 <= cur.node + dx[i] && cur.node + dx[i] <= 100_000)) {
                    int nextNode = cur.node + dx[i];

                    if (d[nextNode] > d[cur.node] + 1) {
                        d[nextNode] = d[cur.node] + 1;
                        queue.add(new Node(cur.node + dx[i], d[cur.node] + 1));
                    }
                }
            }

        }
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
