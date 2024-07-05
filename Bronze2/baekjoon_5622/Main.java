package Bronze2.baekjoon_5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toLowerCase().toCharArray();
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'a': case 'b': case 'c':
                    result += 3;
                    break;
                case 'd': case 'e': case 'f':
                    result += 4;
                    break;
                case 'g': case 'h': case 'i':
                    result += 5;
                    break;
                case 'j': case 'k': case 'l':
                    result += 6;
                    break;
                case 'm': case 'n': case 'o':
                    result += 7;
                    break;
                case 'p': case 'q': case 'r': case 's':
                    result += 8;
                    break;
                case 't': case 'u': case 'v':
                    result += 9;
                    break;
                case 'w': case 'x': case 'y': case 'z':
                    result += 10;
                    break;
            }
        }
        System.out.println(result);
    }
}
