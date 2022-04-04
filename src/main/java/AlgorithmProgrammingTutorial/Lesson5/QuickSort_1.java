package main.java.AlgorithmProgrammingTutorial.Lesson5;

//2022-03-23 내림차순 버전

// 퀵 정렬 ( Quick Sort)

// 기본적으로 퀵은 항상 큰 값과 작은 값을 바꾸고 왼쪽 값을 pivot 값과 바꾸는 것

// 그래서 내림 차순 정렬은 큰 값 찾는 위치랑 작은 값 찾는 위치만 바꿔주면 됨

// line33 & line36


public class QuickSort_1 {

    public static void quickSort(int[] array,
                                 int start,
                                 int end){


        if(start >= end){
            return;
        }
        int key = start;
        int i = start + 1;

        int j = end;

        int temp;

        while(i <= j){

            while(i<=end && array[i] >= array[key]){
                i++;
            }
            while(array[j] <= array[key] && j > start){
                j--;
            }
            if(i > j){ // 현재 엇갈린 상태면 키 값과 교체
                temp = array[j];
                array[j] = array[key];
                array[key] = temp;
            }else{ // 엇갈리지 않았다면 두 값 교체(큰, 작)
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        quickSort(array, start, j-1);
        quickSort(array, j+1, end);

    }

    public static void main(String[] args) {

        int num = 10; //데이터 갯수

        int[] array = {1,10,5,8,7,6,4,3,2,9};

        quickSort(array, 0, num-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }




    }
}



