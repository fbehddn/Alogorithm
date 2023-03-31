package Bronze5.baekjoon_1271;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger money=sc.nextBigInteger();
        BigInteger n = sc.nextBigInteger();

        sc.close();

        System.out.println(money.divide(n));
        System.out.println(money.remainder(n));
    }
    /*
    ⊙ BigInteger
        int와 BigInteger의 차이점
               int의 범위는 '-2,147,483,648~2,147,483,647'이지만
               BigInteger의 범위는 문자열 형태로 이루어져 있어 무한이다.

        BigInteger 계산법
              문자열 형태로 이루어져 있기에 사칙연산이 안된다.
              따라서 BigInteger의 값을 계산을 하려면 클래스 내부의 함수를 이용해야 한다.

      더하기 : add()
      빼   기 : subtract()
      곱하기 : multiply()
      나누기 : divide()
     */
}
