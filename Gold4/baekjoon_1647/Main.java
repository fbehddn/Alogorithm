package Gold4.baekjoon_1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] parent = new int[N + 1];
		for (int i = 0; i < N; i++) parent[i] = i;

		int[][] edges = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges[i][0] = nodeA;
			edges[i][1] = nodeB;
			edges[i][2] = cost;
		}
		Arrays.sort(edges, (a, b) -> (a[2] - b[2]));

		int total = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < edges.length; i++) {
			if (findRoot(parent, edges[i][0]) != findRoot(parent, edges[i][1])) {
				total += edges[i][2];
				if(max<edges[i][2]) max = edges[i][2];
				union(parent, edges[i][0], edges[i][1]);
			}
		}
		System.out.println(total - max);
	}

	static int findRoot(int[] parent, int node) {
		if (node == parent[node]) return node;
		else return parent[node] = findRoot(parent, parent[node]);
	}

	static void union(int[] parent, int nodeA, int nodeB) {
		int rootA = findRoot(parent, nodeA);
		int rootB = findRoot(parent, nodeB);
		if (rootA > rootB) parent[rootA] = rootB;
		else parent[rootB] = rootA;
	}
}
