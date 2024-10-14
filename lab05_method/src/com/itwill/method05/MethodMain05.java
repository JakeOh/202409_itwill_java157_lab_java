package com.itwill.method05;

public class MethodMain05 {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 10, 20, -50 }; // new int[] { ... };
        
        int sum = sum(numbers);
        System.out.println("sum = " + sum);
        
        double mean = mean(numbers);
        System.out.println("mean = " + mean);
        
        System.out.println("max = " + max(numbers));
        System.out.println("min = " + min(numbers));
    }

    /**
     * sum.
     * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 리턴.
     * 
     * @param array 정수들의 1차원 배열(int[]).
     * @return array의 모든 원소들의 합.
     */
    public static int sum(int[] array) {
        int result = 0;
        for (int x : array) {
            result += x;
        }
        
        return result;
    }
    
    /**
     * mean.
     * 아규먼트로 전달받은 정수들의 1차원 배열 원소들의 평균을 리턴.
     * 
     * @param array 정수들의 1차원 배열.
     * @return array 원소들의 평균을 double 타입으로 리턴.
     */
    public static double mean(int[] array) {
        int sum = sum(array); // MethodMain05 클래스에서 선언된 메서드를 호출.
        double average = (double) sum / array.length;
        
        return average;
    }
    
    /**
     * max.
     * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최댓값을 리턴.
     * 
     * @param array 정수들의 1차원 배열.
     * @return array 원소들 중 최댓값.
     */
    public static int max(int[] array) {
        int max = array[0];
        for (int x : array) {
            if (x > max) {
                max = x;
            }
        }
        
        return max;
    }
    
    /**
     * min.
     * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최솟값을 리턴.
     * 
     * @param array 정수들의 1차원 배열.
     * @return array 원소들 중 최솟값.
     */
    public static int min(int[] array) {
        int min = array[0];
        for (int x : array) {
            min = (x < min) ? x : min;
        }
        
        return min;
    }
    
}
