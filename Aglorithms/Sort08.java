3-Way merge Sort

// Java program to implement 3-way Merge Sort
import java.util.*;

class GfG {
    
    static void merge(int arr[], int left, int mid1, int mid2, int right) {
        
        // Sizes of three subarrays
        int size1 = mid1 - left + 1;
        int size2 = mid2 - mid1;
        int size3 = right - mid2;
        
        // Temporary arrays for three parts
        int[] leftArr = new int[size1];
        int[] midArr = new int[size2];
        int[] rightArr = new int[size3];
        
        // Copy data to temporary arrays
        for (int i = 0; i < size1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < size2; i++) {
            midArr[i] = arr[mid1 + 1 + i];
        }
        for (int i = 0; i < size3; i++) {
            rightArr[i] = arr[mid2 + 1 + i];
        }
        
        // Merge three sorted subarrays
        int i = 0, j = 0, k = 0, index = left;
        while (i < size1 || j < size2 || k < size3) {
            int minValue = Integer.MAX_VALUE, minIdx = -1;
            
            // Find the smallest among the three current elements
            if (i < size1 && leftArr[i] < minValue) {
                minValue = leftArr[i];
                minIdx = 0;
            }
            if (j < size2 && midArr[j] < minValue) {
                minValue = midArr[j];
                minIdx = 1;
            }
            if (k < size3 && rightArr[k] < minValue) {
                minValue = rightArr[k];
                minIdx = 2;
            }
            
            // Place the smallest element in the merged array
            if (minIdx == 0) {
                arr[index++] = leftArr[i++];
            } else if (minIdx == 1) {
                arr[index++] = midArr[j++];
            } else {
                arr[index++] = rightArr[k++];
            }
        }
    }
    
    static void threeWayMergeSort(int arr[], int left, int right) {
        
        // Base case: If single element, return
        if (left >= right) {
            return;
        }
        
        // Finding two midpoints for 3-way split
        int mid1 = left + (right - left) / 3;
        int mid2 = left + 2 * (right - left) / 3;
        
        // Recursively sort first third
        threeWayMergeSort(arr, left, mid1);
        
        // Recursively sort second third
        threeWayMergeSort(arr, mid1 + 1, mid2);
        
        // Recursively sort last third
        threeWayMergeSort(arr, mid2 + 1, right);
        
        // Merge the sorted parts
        merge(arr, left, mid1, mid2, right);
    }
    
    public static void main(String args[]) {
        
        // Input array
        int arr[] = {5, 2, 9, 1, 6, 3, 8, 4, 7};
        
        // Size of the array
        int n = arr.length;
        
        // Calling 3-way merge sort function
        threeWayMergeSort(arr, 0, n - 1);
        
        // Printing the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
