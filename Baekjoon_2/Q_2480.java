package Baekjoon_2;

import java.util.Scanner;

public class Q_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        int money=0;

        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();

        if(a==b && b==c){
            money+=10000;
            money+=a*1000;
        }

        else if(a==b || b==c || a==c){
            if(a==b){
                money+=1000+a*100;
            }
            else if(b==c){
                money+=1000+b*100;
            }
            else if(a==c){
                money+=1000+c*100;
            }
        }

        else{
            int max=0;
            if(a>b){
                if(b>c) max=a;
                else{
                    if(a>c) max=a;
                    if(a<c) max=c;
                }
            }
            else{
                if(a>c) max=b;
                else{
                    if(b>c) max=b;
                    if(b<c) max=c;
                }
            }
            money+=max*100;
        }
        System.out.println(money);
    }
}
