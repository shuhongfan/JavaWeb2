package com.shf2.test;

import java.util.Scanner;

public class Arr {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner scanner = new Scanner(System.in);
//        输入9个数字
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print("请输入第 "+ (i+1) +" 个整数数字，共输入9个数字：");
            arr[i] = scanner.nextInt();
        }

//        排序 最后一位不排序
        BubbleSort(arr);
//        排序后的数据
        for (int i : arr) System.out.print(i+" ");
        System.out.println();

//        输入插入的数字
        System.out.print("请输入插入的数字：");
        int num = scanner.nextInt();

//        插入数组
        for (int i = 0; i < arr.length; i++) {
//            num大于最大的数 放到最后一个位置
            if (num>=arr[arr.length-1-1]){
                arr[arr.length-1]=num;
                break;
            }
//            num大于其中的一个数字
            if (arr[i]>=num) {
                int temp=arr[i];
                arr[i]=num;
//                每个元素 往后移一个
                for (int j = i + 1; j < arr.length; j++) {
                    int t=arr[i+1];
                    arr[i+1]=arr[j];
                    arr[j]=t;
                }
                arr[i+1]=temp;
                break;
            }
        }

        for (int i : arr) System.out.print(i+" ");
    }

    public static void BubbleSort(int[] arr) {
        int temp;
        for(int i=0;i<arr.length-1-1;i++){
            for(int j=0;j<arr.length-i-1-1;j++){
                if(arr[j+1]<arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
