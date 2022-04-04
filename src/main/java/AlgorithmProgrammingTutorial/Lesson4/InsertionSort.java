package main.java.AlgorithmProgrammingTutorial.Lesson4;

// 2022-03-23 시작

// 문제는 지난 시간과 동일

// 다음의 숫자들을 오름차순으로 정렬하는 프로그램을 작성하세요.

// 1 10 5 8 7 6 4 3 2 9

// 삽입 정렬 : 각 숫자를 적절한 위치에 삽입하는 방법
// 이전의 정렬은 무조건 위치를 바꾸는 방식이었다면
// 삽입 정렬은 '필요할 때만' 위치를 바꾼다.

// 각 숫자를 적절한 위치에 삽입하면 어떨까?

// 삽입 정렬은 비교적 느린 정렬 알고리즘이지만 쉽게 생각할 수 없는, 조금은
// 복잡한 구조

//시간복잡도 O(N^2)을 가지는 세 정렬 알고리즘 중에서는 가장 강력함
// 특정 경우의 수에서는 굉장히 빠름


// 손코딩

// 삽입 정렬에서는 적절한 위치에 삽입
// 앞 원소들이 이미 정렬 되어 있다고 가정함
// 이 가정이란 특성 때문에 효율적

// 1 10 5 8 7 6 4 3 2 9 - 1은 이미 가장 앞에 있기 때문에 삽입할 필요가 없어서 내버려둠

// 1 10 5 8 7 6 4 3 2 9 - 10은 이 앞에 있는 것들을 봤을 때 들어갈 위치가 1의 앞과 뒤 이렇게 두 군데가 있음

// 즉 10은 1보다 크기 때문에 그대로 위치 유지

// 1 10 5 8 7 6 4 3 2 9 - 5는 앞을 봤을 때 들어갈 위치가 세 군데(1 앞, 1과 10 사이, 10 뒤)

// 적절한 위치는 1-10 사이

// 1 5 10 8 7 6 4 3 2 9 - 1-5-10 3원소 정렬

// 8은 위치 중 5-10 사이에 삽입

// 1 5 8 10 7 6 4 3 2 9 - 1-5-8-10 4원소 정렬

//


import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {1,10,5,8,7,6,4,3,2,9};
        int temp;
        int j;

        for (int i = 0; i < array.length-1; i++) {
            j = i; // 현재 정렬할 원소 선택해서 적절한 위치에 삽입할수있도록 하기 위함
            while(array[j] > array[j + 1]){// 1씩 빼나가면서 오른쪽 값이 왼쪽보다 작다면 위치 바꾸기
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                j--;
                if(j<0){
                    break;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        int[] array2 = {1,10,5,8,7,6,4,3,2,9};

        List<Integer> list = new ArrayList<>();
        list.add(array2[0]);

        for (int i = 1; i < array2.length; i++) {
            if(list.size()==1){
                if(array2[i] >list.get(0)){
                    list.add(array2[i]);
                }else{
                    list.add(0,array2[i]);
                }
            }else{
                for (int k = 0; k < list.size()-1; k++) {
                    if(array2[i] > list.get(k) && array2[i] < list.get(k+1)){
                        list.add(k+1, array2[i]);
                    }
                }
            }

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}


// 정렬이 되어 있다고 가정하기 때문에 특정한 배열에서 좋음

// 최악의 경우에는 O(N * N)이지만

// 2 3 4 5 6 7 8 9 10 1 이런 배열이라면?

// 거의 정렬된 상태라면 필요할 때에 한해서만 삽입을 진행하기 때문에
// 데이터가 이미 거의 정렬된 상태에서는 어떤 알고리즘보다도 빠르다



