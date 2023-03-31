package Bronze5.baekjoon_10872;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans=1;

        if (n == 0) {
            System.out.println(1);
        } else {
            for (int i = 1; i <= n; i++) {
                ans*=i;
            }
            System.out.println(ans);
        }
    }
}

/*
#include <stdio.h>
int main(void){
    int id,pass;
    printf("아이디와 패스워드 숫자로 입력: \n");
    printf("id:____\b\b\b\b");
    scanf("%d",&id);

    printf("pass:____\b\b\b\b");
    scanf("%d",&pass);

    printf("|a입력된 아이디는 \%d\"이고 패스워드는 \"%d\"입니다.", id,pass);
 */
