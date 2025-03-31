package Silver2.baekjoon_11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int temp;
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (pq.size() == 0) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(temp);
            }
        }

        System.out.println(sb);
    }
}
