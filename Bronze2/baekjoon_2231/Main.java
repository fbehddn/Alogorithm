package Bronze2.baekjoon_2231;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int result=0;
        int n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int sum=0;
            int number=i;

            while(number!=0){
                sum+=number%10;
                number/=10;
            }
            if(i+sum == n) {
                result=i;
                break;
            }
        }
        if(result==0)System.out.println(result);
        else System.out.println(result);
    }
}
