package sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description:
 * 快速排序
 *
 * @Date: 2022/9/19 16:24
 * @Author: jieyukang
 */
public class QuickSort {

    /**
     *
     * @param arr 需要排序的元素
     * @param left 左哨兵
     * @param right 右哨兵
     * @return 排序后的元素
     */
    public static int[] sort(int[] arr, int left, int right) {
        int mid = arr[0];
        int l = left,
                r = right;
        int slot = 0;

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        arr = QuickSort.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        HashMap map = new HashMap();


    }


}
