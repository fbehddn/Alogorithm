package Gold2.baekjoon_9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 목적지인 곳 두 곳으로 다익스트라를 사용하여 최단거리를 구한 후,
// 필수 정점인 g,h를 지나는지 확인하고 지나지 않았으면 목적지 집합에서 제외후 출력

public class Main {
    static ArrayList<Node>[] map;
    static int node, road, dest; //교차로, 도로, 목적지 개수
    static int start, g, h; //시작점, 필수 교차로1, 필수 교차로2
    static int[] d;
    static ArrayList<Integer> destination;
    static List<Integer> passed; //다익스트라로 최단경로 구할 때 지나온 노드 담기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        //전체 TC
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            road = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            //간선 입력
            map = new ArrayList[node];
            for (int j = 0; j < node; j++) {
                map[j] = new ArrayList<>();
            }

            d = new int[node];
            destination = new ArrayList<>();
            passed = new ArrayList<>();

            for (int j = 0; j < road; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                map[a].add(new Node(b, d));
                map[b].add(new Node(a, d));
            }

            //목적지 입력
            destination = new ArrayList<>();
            for (int j = 0; j < dest; j++) {
                destination.add(Integer.parseInt(br.readLine()));
            }
            for (int j = 0; j < dest; j++) {
                dijkstra(destination.get(i));
            }
        }
    }

    private static void dijkstra(int end) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int node = cur.node;
            for (Node temp : map[node]) {
                int nextNode = temp.node;
                int value = temp.value;
                if (d[nextNode] > d[cur.node] + value) {
                    d[nextNode] = d[cur.node] + value;
                    queue.add(new Node(nextNode, d[nextNode]));
                    passed.add(nextNode);
                    
                }
            }
        }
    }

    static class Node {
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
