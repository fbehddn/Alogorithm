package Sliver4.baekjoon_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 8*8이 될 수 있는 경우의수 따지기
 * 2. 1에서의 각 경우마다 [0][0] 이 W or B 인지 따지고 더 작은값을 구한 후 각 경우의수마다 최솟값 판별
 */
public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        // 초기 배열 입력 및 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        System.out.println(count(arr));
        br.close();
    }

    private static int count(String[] arr) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                for (int k = 0; k < 2; k++) {
                    char start = k == 0 ? 'W' : 'B';

                    int count = 0;
                    for (int n = i; n < i + 8; n++) {
                        for (int m = j; m < j + 8; m++) {
                            if (start != arr[n].charAt(m)) {
                                count++;
                            }
                            start = start == 'W' ? 'B' : 'W';
                        }
                        start = start == 'W' ? 'B' : 'W';
                    }
                    result = Math.min(result, count);
                    if (result == 0) {
                        return 0;
                    }
                }
            }
        }
        return result;
    }
}
