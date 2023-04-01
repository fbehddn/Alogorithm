package Bronze3.baekjoon_1085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        int w = sc.nextInt(), h = sc.nextInt();
        System.out.println(Math.min(Math.min(x,y),Math.min(w-x,h-y)));

    }
}
