package main.java.AlgorithmProgrammingTutorial.Lesson5;

//2022-03-23 시작 - todo 다시 보기

// 퀵 정렬 ( Quick Sort)

// 앞 세 개의 알고리즘보다 빠른 애가 이거
// 대표적인 분할 정복 알고리즘 (특정 배열이 있을 때 그 배열을 반복적으로 분할. 원소들을 나누어서 계산)

// 평균 속도가 O(N * logN)

// 다음의 숫자들을 오름차순으로 정렬하는 프로그램을 작성하세요.

// 1 10 5 8 7 6 4 3 2 9

// 퀵은 하나의 큰 문제를 두 개의 작은 문제로 분할하는 식으로 빠르게 정렬

// 더 쉽게 말하자면 특정 값을 기준으로 큰 숫자와 작은 숫자를 서로 교환한 뒤 배열을 반으로 나눔

// 특정한 값을 기준으로 큰 숫자와 작은 숫자를 나누면 어떨까?

// 일반적으로 퀵에서는 기준 값이 있는데 이를 피벗(Pivot)이라고 한다.
// 보통 첫 원소를 피벗 값으로 정하고 사용


// 손코딩
// (3) 7 8 1 5 9 6 10 2 4

// 1. 왼쪽에서 오른쪽으로 이동 시 pivot보다 큰 값 선택

// 1-1. 7이 왼쪽에서부터 3보다 큰 첫 값

// 2. 오른쪽에서 왼쪽으로 이동 시 pivot보다 작은 값 선택

// 2-1. 2가 오른쪽에서부터 2보다 작은 첫 값

// 이 때 큰 값과 작은 값을 서로 바꾸어 준다.

// (3) 2 8 1 5 9 6 10 7 4

// 이제 여기에서 1, 2 반복

// 8과 1 선택

// (3) 2 1 8 5 9 6 10 7 4

// 8과 1은 엇갈림( 작은 값의 index가 큰 값의 index보다 더 작음)
// 엇갈린 상황에서는 왼 쪽에 있는 값과 작은 값을 서로 바꿔주면 된다.

// 1 2 3 8 5 9 6 10 7 4

// 이렇게 3은 정렬이 됐다고 할 수 있음

// 현재 3보다 작은 값은 전부 왼쪽, 3보다 큰 값은 전부 오른 쪽에 있음

// 이렇게 한 번 분할을 하는 것

// 분할된 왼쪽 집합은 기준값보다 작고, 분할된 오른쪽 집합은 기준값보다 큼

// 이제 새 기준인 1, 8을 pivot으로 잡고 3은 그대로 둔 후 왼쪽과 오른쪽을 또 반복적으로 수행

// (1) 2 [3] (8) 5 9 6 10 7 4

// 1은 왼쪽부터 큰 값을 찾고 오른쪽부터 작은값을 찾는데,
// 큰 값은 2고 작은 값은 없음

// 이 경우는 자기 자신을 고름

// 마찬가지로 엇갈렸으니까 1과 자기자신을 바꾸고 이건 정렬됐다고 판단

// [1] (2) [3] (8) 5 9 6 10 7 4

// 2는 데이터가 하나여서 그대로 둔다.

// [1] [2] [3] (8) 5 9 6 10 7 4

// 8을 기준으로 첫 큰 애, 첫 작은 애
// 9와 4
// [1] [2] [3] (8) 5 4 6 10 7 9
// 10과 7
// [1] [2] [3] (8) 5 4 6 7 10 9
// 10과 7 -> 엇갈림 -> 7과 8 자리 바꾸기

// [1] [2] [3] (7) 5 4 6 [8] 10 9
// 7 기준으로 큰 값 없어서 위치를 마지막으로, 작은 값은 6
// 값이 엇갈림 따라서 7과 자리 바꾸기
// [1] [2] [3] (6) 5 4 [7] [8] 10 9
// 6 기준으로 큰 값 없어서 위치 마지막으로, 작은 값은 4
// 값이 엇갈리니까 자리 바꾸기
// [1] [2] [3] (4) 5 [6] [7] [8] 10 9
// 4 기준으로 큰 값은 5, 작은 값 없으니까 자기 자신을 고름
// 엇갈렸으니까 작은 값과 4 자리 바꾸기(그대로)
// [1] [2] [3] [4] (5) [6] [7] [8] 10 9
// 5는 데이터가 하나이므로 그대로
// [1] [2] [3] [4] [5] [6] [7] [8] (10) 9
// 10 기준으로 큰 값 없고 작은 값 9
// 엇갈렸으니까 작은 값과 자리 바꾸기
// [1] [2] [3] [4] [5] [6] [7] [8] (9) [10]
// 데이터 하나니까 그대로
// [1] [2] [3] [4] [5] [6] [7] [8] [9] [10]

// 퀵정렬은 값을 기준으로 왼쪽 오른쪽이 나누어진다는 특징이 있음

// 이 것 때문에 퀵 정렬이 빠른 것





// (1) 10 5 8 7 6 4 3 2 9

// 이 경우 1봐 큰 숫자를 왼쪽부터 찾고, 1보다 작은 숫자를 오른쪽부터 찾는다.

// 선택 정렬을 사용하면 대략 100이 나옴(N*N)
// 반반씩 나누면
// 1 2 3 4 5 => 5 * 5 = 25
// 6 7 8 9 10 => 5 * 5 = 25
// 이 원리가 분할 정복이 강력한 이유






// 깔끔하게 구현하기 위해 재귀함수를 쓰는 경우가 많음

public class QuickSort {

    public static void quickSort(int[] array,
                                 int start, // 정렬 수행 부분집합의 첫번째
                                 int end){ // 정렬 수행 부분집합의 마지막


        if(start >= end){ // 원소가 한 개인 경우
            return;
        }
        int key = start; // 키는 첫번째 원소 ( pivot )
        int i = start + 1; // 왼쪽부터 하나씩 큰 값을 찾을 때 그 index 의미
        // 기본적으로 키 값의 오른쪽부터 시작해서 start+1
        int j = end;

        int temp; // 임시 변수 (바꿔주기 위해)

        while(i <= j){ // 엇갈릴 때까지 반복

            while(i<=end && array[i] <= array[key]){// i가 key값보다 작다면 키 값보다 큰 값 만날 때까지
                i++; // 오른쪽으로 한 칸 씩 옮겨주기
            }
            while(array[j] >= array[key] // key 값보다 작은 값을 만날 때까지
                    && j > start){ // 더 작은 값이 없는 경우 방지
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

// 퀵은 기준값보다 큰 값과 작은 값을 엇갈릴 때까지 반복해서 교체하는 식으로 작동


// 분할 정복 기법 이용해서 평균 시간 복잡도가 O(N * logN)
// 하지만 최악의 시간 복잡도는 O(N^2)

// 최악의 경우가 나오는 이유는?

// 1 2 3 4 5 6 7 8 9 10

// 이 경우 퀵 정렬을 사용하면  O(N^2)에 가까움

// 손코딩 시작

// (1) 2 3 4 5 6 7 8 9 10
// 1을 기준으로 큰 값과 작은 값 찾으면 10, 1
// 둘 자리 바꿈

// [1] 2 3 4 5 6 7 8 9 10
// 1 하나 정렬

// [1] (2) 3 4 5 6 7 8 9 10
// 2 하나 정렬 => 분할 정복의 장점을 살리지 못함(분할이 안 돼서)
// 분할 정복이 이상적이려면 중간쯤의 값을 pivot으로 잡아야 함

