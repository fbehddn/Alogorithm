package Gold4.baekjoon_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 2차원 배열로 나타내기에는, 방향성을 표시할 수 없음
 * 2. 왜 우선순위 큐 인가?
 * 3. Node class compareTo 메서드를 왜 오버라이딩 하는가?
 *    -> 우선순위큐는 일반적으로 오름차순
 *    -> 임의의 클래스로 구성된 우선순위 큐 이거나, 기본 타입이지만 우선순위를 바꾸고 싶은 경우에도 따로 지정이 가능하다.
 *    -> 여기서는 사용자가 만든 클래스인 Node 를 우선순위 큐의 자료형으로 사용하였으므로 재정의를 해줘야함
 * 4. distance[nextNode] 값을 왜 큐에 다시 넣는가?
 *    -> 다익스트라 알고리즘에서 우선순위 큐는 최단 거리 값을 기준으로 정렬되기 때문
 *    -> 따라서 큐에 넣는 값은 갱신된 최단거리(distance[nextNode]) 여야한다.
 */
public class Main {
    static int V, E, start;
    static List<Node>[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        graph = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int node = current.node;

            if (visited[node]) continue;
            visited[node] = true;

            for (Node tmp : graph[node]) {
                int nextNode = tmp.node;
                int value = tmp.value;
                if (!visited[nextNode] && distance[nextNode] > distance[node] + value) {
                    distance[nextNode] = distance[node] + value;
                    queue.add(new Node(nextNode, distance[nextNode]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (visited[i]) sb.append(distance[i]).append("\n");
            else sb.append("INF").append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value); // 가중치 기준 오름차순 정렬
        }
    }
}
