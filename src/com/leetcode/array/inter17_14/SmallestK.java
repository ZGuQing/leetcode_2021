package com.leetcode.array.inter17_14;

/**
 * @Author zhuguoqing
 * @Description 快速选择
 * @Date 2021/12/8 8:53 下午
 * @Version 1.0
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        quick_select(arr, 0, arr.length - 1, k);    //快速选择
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public void quick_select(int[] arr, int l, int r, int k) {
        if (l == r || k == 0) return;
        int x = arr[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (arr[++i] < x);
            while (arr[--j] > x);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int sk = j - l + 1; //左边的数字个数
        if (sk >= k) {  //最小的k个数在左边
            quick_select(arr, l, j, k);
        } else {    //最小的k个数在右边
            quick_select(arr, j + 1, r, k - sk);
        }
    }
}
