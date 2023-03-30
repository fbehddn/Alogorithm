package Bronze5.baekjoon_2475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0;
        for(int i=0; i<5; i++){
            int temp = sc.nextInt();
            sum+=temp*temp;
        }
        int result=sum%10;
        System.out.println(result);
    }
}
