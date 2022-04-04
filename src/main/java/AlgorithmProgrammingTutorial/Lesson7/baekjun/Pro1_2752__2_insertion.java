package main.java.AlgorithmProgrammingTutorial.Lesson7.baekjun;

// 2022-03-23 시작

// 세수정렬 - 삽입 정렬

// https://www.acmicpc.net/problem/2752

//동규는 세수를 하다가 정렬이 하고싶어졌다.
//
//숫자 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어 졌다.
//
//숫자 세 개가 주어졌을 때,
// 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.


import java.io.*;
import java.util.StringTokenizer;

public class Pro1_2752__2_insertion {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(System.out));

        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        int first = Integer.parseInt(stringTokenizer.nextToken());
        int second = Integer.parseInt(stringTokenizer.nextToken());
        int third = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = {first, second, third};

        int temp;
        int j;

        for (int i = 0; i < 2; i++) {
            j=i;

            while(array[j] > array[j + 1]){
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                j--;
                if(j<0){
                    break;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            stringBuilder.append(array[i]).append(" ");
        }

        bufferedWriter.write(String.valueOf(stringBuilder));

        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();

    }


}
