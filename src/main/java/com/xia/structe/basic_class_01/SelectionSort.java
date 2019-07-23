package com.xia.structe.basic_class_01;

/**
 * @author q9826 选择排序 就是0-n-1 找一个最小的放到0位置上 然后1-N-1找一个最小的放到1的位置 这个就是选择排序
 */
public class SelectionSort {

	private static void selectionSort(int[] arr) {
		if (arr == null && arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			// 假设最前面位置上的是最小的
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					swap(arr, min, j);
				}
			}
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 7, 3, 2,1 };
		selectionSort(arr);
		for (int i : arr) {
			System.out.print(i + ",");
		}
	}

}
