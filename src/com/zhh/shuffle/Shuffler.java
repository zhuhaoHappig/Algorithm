package com.zhh.shuffle;

import java.util.Random;

public class Shuffler{

    /**
     * 返回0~9,随机排列
     */
    public static int[] shuffle() {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rd = new Random();
        for (int i = 0; i < a.length; i++){
            int r = rd.nextInt(i+1);
            exchange(a, i, r);
        }
        return a;
    }

    /**
     * 返回0~n-1,随机排列
     */
    public static int[] shuffle(int n) {
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = i;
        }

        Random rd = new Random();

        for (int i = 0; i < a.length; i++){
            int r = rd.nextInt(i+1);
            exchange(a, i, r);
        }
        return a;
    }

    /**
     * 将一副牌洗成随机数列
     * 思路：取第n张牌，在0~n-1(包括0和n-1)中取一个随机数r，将第n张牌与第r张牌交换
     * @param a
     */
    public static void shuffle(int[] a) {
        Random rd = new Random();
        for (int i = 0; i < a.length; i++){
            int r = rd.nextInt(i+1);
            exchange(a, i, r);
        }
    }

    private static void exchange(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
