package Bronze2.baekjoon_10809;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] ch = str.toCharArray();
        char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l',
                        'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int[] result= {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (ch[i] == alpha[j]) {
                    if(result[j]!=-1) continue;
                    result[j] = i;
                }
            }
        }
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
