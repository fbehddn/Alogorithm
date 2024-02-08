package Sliver4.baekjoon_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size()!=1) {
            queue.remove();
            Integer findNumber = queue.remove();
            queue.add(findNumber);
        }
        System.out.println(queue.peek());
    }
}
/**
 * 1 2 3 4 5 6
 *
 * 2 3 4 5 6
 * 3 4 5 6 2
 *
 * 4 5 6 2
 * 5 6 2 4
 *
 * 6 2 4
 * 2 4 6
 *
 * 4 6
 * 6 4
 *
 * 4
 */
