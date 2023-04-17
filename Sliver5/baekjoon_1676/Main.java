package Sliver5.baekjoon_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger big = new BigInteger("1");

        for (int i = 1; i <= N; i++) {
            big = big.multiply(BigInteger.valueOf(i));
        }

        String str = big.toString();
        char[] chaArr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            chaArr[i] = str.charAt(i);
        }
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if(chaArr[i] =='0') count++;
            else break;
        }

        System.out.println(count);
    }
}
