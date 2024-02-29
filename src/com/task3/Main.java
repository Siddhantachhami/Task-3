package com.task3;

import java.util.Scanner;

public class Main{

    public static int maxSumIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] msis = new int[n];

        // Initialize each element to its value in the input array initially
        System.arraycopy(arr, 0, msis, 0, n);

        // Iterate through the array to find the maximum sum increasing subsequence
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }

        // Find the maximum sum in the msis array
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, msis[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the sequence: ");
        int size = scanner.nextInt();

        int[] sequence = new int[size];
        System.out.println("Enter the elements of the sequence:");
        for (int i = 0; i < size; i++) {
            sequence[i] = scanner.nextInt();
        }

        int result = maxSumIncreasingSubsequence(sequence);
        System.out.println("Maximum Sum Increasing Subsequence: " + result);
    }
}