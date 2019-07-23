package com.xia.structe.basic_class_01;

/**
 * @author q9826 冒泡排序 如果0位置的数比1位置上的数大 那么就交换 下一步看1位置和2位置的数 依此类推
 * 前一个数如果比后一个数大的话
 *         就进行交换 这样做完一圈最大的数来到最后的位置 那么现在就排好了一个数 我们就可以减少一个数进行排序了
 */
public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		if (arr == null && arr.length < 2) {
			return;
		}
		for (int end = arr.length - 1; end > 0; end--) {
			for (int i = 0; i < end; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
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
		int[] arr = new int[] { 1, 5, 7, 3, 2 };
		bubbleSort(arr);
		for (int i : arr) {
			System.out.print(i+",");
		}
	}
}
