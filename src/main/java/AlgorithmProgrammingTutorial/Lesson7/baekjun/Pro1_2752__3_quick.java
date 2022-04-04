package main.java.AlgorithmProgrammingTutorial.Lesson7.baekjun;

// 2022-03-23 시작

// 세수정렬 - 퀵 정렬

// https://www.acmicpc.net/problem/2752

//동규는 세수를 하다가 정렬이 하고싶어졌다.
//
//숫자 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어 졌다.
//
//숫자 세 개가 주어졌을 때,
// 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.


import java.io.*;
import java.util.StringTokenizer;

public class Pro1_2752__3_quick {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(System.out));

        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        int first = Integer.parseInt(stringTokenizer.nextToken());
        int second = Integer.parseInt(stringTokenizer.nextToken());
        int third = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = {first, second, third};

        int number = 3;

        quickSort(array, 0, number-1);


        for (int i = 0; i < 3; i++) {
            stringBuilder.append(array[i]).append(" ");
        }

        bufferedWriter.write(String.valueOf(stringBuilder));

        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();

    }

    public static void quickSort(int[] array, int start, int end){

        if(start >= end){
            return;
        }
        int pivot = start;
        int i = start + 1;
        int j = end;

        int temp;

        while(i<=j){

            while(i<=end && array[i] <= array[pivot]){
                i++;
            }
            while(j>start && array[j]>=array[pivot]){
                j--;
            }
            if(i > j){
                temp = array[j];
                array[j] = array[pivot];
                array[pivot] = temp;
            }else{
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        quickSort(array, start, j-1);
        quickSort(array, j+1, end);
    }


}
