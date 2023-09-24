package Sliver4.baekjoon_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        if (n == 1 || n == 2 || n == 4 || n == 7) {
            count = -1;
        } else if (n % 5 == 0) {
            count = n / 5;
        } else if (n % 5 == 1 || n % 5 == 3) {
            count = n / 5 + 1;
        } else {
            count = n / 5 + 2;
        }

        System.out.println(count);
    }
}

/**
 * 3kg, 5kg 봉지 존재.
 * 1. 정확하게 주어진 숫자를 3,5의 조합으로 만들 수 있는지
 * if %5 == 0 -> count 반환
 * if %3 == 0 -> 5를 섞어서도 나누어 떨어지는지 확인 -> OK ? 5를 포함해야 최소 가짓수
 *
 * 3과 5의 조합으로 구성할 수 없는 수가 뭐가 있을까? : 1,2,4,7,
 * 3 => 3 6 9 12 15 18 21 24 27 ...
 * 5 => 5 10 15 20 25 30 ...
 *
 * 11 12 13 14
 * 11, %5 = 1 => 3 3 5,
 * 12, %5 = 2 => 3 3 3 3
 * 13, %5 = 3 => 3 3 5
 * 14, %5 = 4 => 3 3 3 5
 *
 * 2. 만들 수 있다면 어떻게 조합해야 가장 적은 수를 사용하여 정확히 무게를 맞출 수 있는지
 */
