package Silver2.baekjoon_1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int num = 1;
        boolean result = true;
        // arr = 4 3 6 8 7 5 2 1

        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                while (arr[i] >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                if (stack.pop() > arr[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}
