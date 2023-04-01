package Bronze2.baekjoon_1075;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), f = sc.nextInt();
        int temp=0;

        n=(n/100)*100;

        while(true){
            if(n%f != 0){
                temp++;
                n++;
            }
            else break;
        }
        if(temp/10 <1) System.out.println("0"+temp);
        else System.out.println(temp);
    }
}
