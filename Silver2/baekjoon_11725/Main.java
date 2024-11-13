package Silver2.baekjoon_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] link;
    static int[] result;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        result = new int[N + 1];
        link = new ArrayList[N + 1];

        for (int i = 0; i < link.length; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            link[node1].add(node2);
            link[node2].add(node1);
        }

        bfs(1);

        for (int i = 1; i <= N - 1; i++) {
            System.out.println(result[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int findNodeNumber = 2;
        while (findNodeNumber < N + 1) {
            queue.add(start);
            int current = queue.poll();
            for (Integer node : link[current]) {
                if (node == findNodeNumber) {
                    result[findNodeNumber - 1] = current;
                    findNodeNumber++;
                } else {
                    queue.add(node);
                }
            }
        }
    }
}
