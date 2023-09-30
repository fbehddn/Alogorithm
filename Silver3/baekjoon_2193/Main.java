package Silver3.baekjoon_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Main {
    static Long[] dp = new Long[91];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[0] = Integer.toUnsignedLong(0);
        dp[1] = Integer.toUnsignedLong(1);

        System.out.println(recursive(N));
    }

    private static Long recursive(int n) {
        if (dp[n] == null) {
            dp[n] = recursive(n - 1) + recursive(n - 2);
        }
        return dp[n];
    }
}

/**
 * 1자리 이진수의 개수 : 0,1 = 2개
 *                  => 이친수의 개수 : 1
 *
 * 2자리 이진수의 개수 : 00, 01, 10, 11 2^2 = 4개
 *                  => 이친수의 개수 : 1개
 *
 * 3자리 이진수의 개수 : 000 001 010 100 011 101 110 111 2^3 = 8개
 *                  => 이친수의 개수 : 100, 101 2개
 *
 * 4자리 이진수의 개수 : 0000, 0001, 0010, 0100, 1000, 0011, 0101, 1001, 1010, 1100, 0110,  0111, 1011, 1101, 1110, 1111 2^4 = 16개
 *                  => 이친수의 개수 : 1000, 1001, 1010 3개
 * 5자리 이진수의 개수 : 00000, 00001, 00010, 00100, 01000, 10000,  6
 *                  00011, 00101, 01001, 10001, 00110, 01100, 11000, 10100, 10010, 01010     10
 *                  00111, 01110, 11100, 11010, 11001, 10110, 10101, 10011, 01011, 01101     10
 *                  01111, 10111, 11011, 11101, 11110, 11111  6
 *                  => 이친수의 개수 : 10000, 10001, 10100, 10010, 10101 5개
 */
