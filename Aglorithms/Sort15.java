// Java Program to perform Introsort
import java.util.*;

public class IntroSortExample {

    // Threshold for switching to InsertionSort
    private static final int SIZE_THRESHOLD = 16;

    // Utility function to swap
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* Function to sort a subarray using Insertion Sort */
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Partition function (Lomuto’s scheme)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return (i + 1);
    }

    // Median of three method
    private static int medianOfThree(int[] arr, int a, int b, int c) {
        int x = arr[a], y = arr[b], z = arr[c];
        if (x < y) {
            if (y < z) return b;
            else if (x < z) return c;
            else return a;
        } else {
            if (x < z) return a;
            else if (y < z) return c;
            else return b;
        }
    }

    // Utility function for Introsort
    private static void introSortUtil(int[] arr, int begin, int end, int depthLimit) {
        int size = end - begin + 1;

        // If small subarray, use InsertionSort
        if (size < SIZE_THRESHOLD) {
            insertionSort(arr, begin, end);
            return;
        }

        // If depth limit is 0, use HeapSort
        if (depthLimit == 0) {
            heapSort(arr, begin, end);
            return;
        }

        // Else, use QuickSort with Median-of-Three
        int pivotIndex = medianOfThree(arr, begin, begin + size / 2, end);
        swap(arr, pivotIndex, end);

        int partitionPoint = partition(arr, begin, end);

        introSortUtil(arr, begin, partitionPoint - 1, depthLimit - 1);
        introSortUtil(arr, partitionPoint + 1, end, depthLimit - 1);
    }

    // Implementation of Introsort
    public static void introSort(int[] arr) {
        int n = arr.length;
        int depthLimit = (int) (2 * Math.floor(Math.log(n) / Math.log(2)));
        introSortUtil(arr, 0, n - 1, depthLimit);
    }

    // HeapSort implementation for fallback
    private static void heapSort(int[] arr, int begin, int end) {
        int size = end - begin + 1;
        int[] temp = Arrays.copyOfRange(arr, begin, end + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : temp) pq.add(val);

        int i = begin;
        while (!pq.isEmpty()) {
            arr[i++] = pq.poll();
        }
    }

    // Utility function to print array
    private static void printArray(int[] arr) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {3, 1, 23, -9, 233, 23, -313, 32, -9};

        System.out.println("Before sorting:");
        printArray(arr);

        introSort(arr);

        System.out.println("After sorting:");
        printArray(arr);
    }
}
