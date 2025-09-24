
//Counting Sort

import java.util.ArrayList;

class GfG {
    public static ArrayList<Integer> countsort(int arr[]) {
        int n = arr.length;

        // find the maximum element
        int maxval = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] > maxval) maxval = arr[i];

        // create and initialize count array
        int[] count = new int[maxval + 1];

        // count frequency of each element
        for (int i = 0; i < n; i++)
            count[arr[i]]++;

        // compute prefix sum
        for (int i = 1; i <= maxval; i++)
            count[i] += count[i - 1];

        // build output array
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // convert to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : ans)
            result.add(x);

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2,5,3,0,2,3,0,3};
        ArrayList<Integer> sorted = countsort(arr);

        for (int x : sorted)
            System.out.print(x + " ");
    }
}
