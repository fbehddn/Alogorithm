package Silver2.baekjoon_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] myArr = new int[4];
    static int[] checkArr = new int[4];
    static int checkSecret = 0;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 4 2
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // G A T A
        char[] A = new char[S];
        A = br.readLine().toCharArray();

        // 1 0 0 1
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) checkSecret++;
        }

        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        if(checkSecret ==4) result++;

        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) result++;
        }


        System.out.println(result);
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

        private static void Add ( char s) {
            switch (s) {
                case 'A':
                    myArr[0]++;
                    if (myArr[0] == checkArr[0]) checkSecret++;
                    break;
                case 'C':
                    myArr[1]++;
                    if (myArr[1] == checkArr[1]) checkSecret++;
                    break;
                case 'G':
                    myArr[2]++;
                    if (myArr[2] == checkArr[2]) checkSecret++;
                    break;
                case 'T':
                    myArr[3]++;
                    if (myArr[3] == checkArr[3]) checkSecret++;
                    break;
            }
        }
}

