package gold1.baekjoon_2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] preOrder, inOrder, postOrder;
    static BufferedReader br;
    static int N;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //정점의 개수

        preOrder = new int[N];
        inOrder = getOrder();
        postOrder = getOrder();
        getPreOrder(0, N - 1, 0, N - 1);

        for (int i : preOrder) {
            System.out.print(i + " ");
        }
    }

    private static void getPreOrder(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return;
        }
        preOrder[idx++] = postOrder[pe];
        int rootNode = postOrder[pe];
        int rootIdx = getRootIdx(rootNode);

        getPreOrder(is, rootIdx - 1, ps, ps + rootIdx - is - 1);
        getPreOrder(rootIdx + 1, ie, ps + rootIdx - is, pe - 1);
    }

    private static int getRootIdx(int rootNode) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootNode) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getOrder() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        return temp;
    }
}
