package Sliver5.baekjoon_25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        int N = 20;
        double result = 0;
        double temp = 0;
        double sum = 0;
        int count = N;

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            //몇학점?
            double grade = Double.parseDouble(str[1]);
            //등급
            String score = str[2];
            if (score.equals("A+")) {
                temp += grade * 4.5;
                sum += grade;
            } else if (score.equals("A0")) {
                temp += grade * 4.0;
                sum += grade;

            } else if (score.equals("B+")) {
                temp += grade * 3.5;
                sum += grade;

            } else if (score.equals("B0")) {
                temp += grade * 3.0;
                sum += grade;

            } else if (score.equals("C+")) {
                temp += grade * 2.5;
                sum += grade;

            } else if (score.equals("C0")) {
                temp += grade * 2.0;
                sum += grade;

            } else if (score.equals("D+")) {
                temp += grade * 1.5;
                sum += grade;

            } else if (score.equals("D0")) {
                temp += grade * 1.0;
                sum += grade;

            } else if (score.equals("F")) {
                temp += grade * 0;
                sum += grade;

            } else {
                count--;
            }
            result = temp / sum;
        }
        System.out.println(result);
    }
}
