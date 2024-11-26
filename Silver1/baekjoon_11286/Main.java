package Silver1.baekjoon_11286;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else return -1;
            }
        });

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                if (queue.size() == 0) {
                    sb.append(num).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(num);
            }
        }
        System.out.println(sb);
    }
}
