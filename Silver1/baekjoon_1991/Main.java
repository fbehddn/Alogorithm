package Silver1.baekjoon_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    static int N;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] nodes = br.readLine().split(" ");
            int parent = nodes[0].charAt(0) - 'A';
            char leftChild = nodes[1].charAt(0);
            char rightChild = nodes[2].charAt(0);

            if (leftChild == '.') {
                tree[parent].add(-1);
            } else {
                tree[parent].add(leftChild - 'A');
            }

            if (rightChild == '.') {
                tree[parent].add(-1);
            } else {
                tree[parent].add(rightChild - 'A');
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int current) {
        if (current == -1) {
            return;
        }
        System.out.print((char)(current + 'A'));
        preOrder(tree[current].get(0));
        preOrder(tree[current].get(1));
    }

    private static void inOrder(int current) {
        if (current == -1) {
            return;
        }
        inOrder(tree[current].get(0));
        System.out.print((char)(current + 'A'));
        inOrder(tree[current].get(1));
    }

    private static void postOrder(int current) {
        if (current == -1) {
            return;
        }
        postOrder(tree[current].get(0));
        postOrder(tree[current].get(1));
        System.out.print((char)(current + 'A'));
    }
}
