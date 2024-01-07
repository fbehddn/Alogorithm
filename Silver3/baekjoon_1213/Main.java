package Silver3.baekjoon_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }

        /**
         * 문자열 입력의 길이에 따라 분류
         * 개수가 홀수개인 문자가 2개이상 존재하면 에러
         * 개수가 짝수개인 문자가 홀수개면 에러
         */

        StringBuilder sb = new StringBuilder();

        int odd = 0;
        int center = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                odd++;
                center = i;
            }
            if(odd>=2) {
                System.out.println("I'm Sorry Hansoo");
                return ;
            }
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                sb.append((char)(i+'A'));
            }
        }

        // aabbccc center = 2 , abc c cba
        // aabbcc
        String result = sb.toString();
        if (odd == 1) {
            result += (char)(center + 'A');
        }
        result += sb.reverse().toString();

        System.out.println(result);
    }
}
