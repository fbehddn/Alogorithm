package Silver2.baekjoon_11279;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                if (queue.size() == 0) {
                    sb.append(num).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            }else{
                queue.add(num);
            }
        }
        System.out.println(sb);
    }
}
