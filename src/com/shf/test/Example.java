package com.shf.test;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        int start=0,end,middle;
        int a[]={12,45,67,89,123,-45,67};
        int N=a.length;
//        排序
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < N; j++) {
                if (a[j]<a[i]){
                    int t=a[j];
                    a[j]=a[i];
                    a[i]=t;
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入整数，程序判断该整数是否在数组中：");
        int number=scanner.nextInt();
        int count=0;
        end=N;  // 结束位置
        middle=(start+end)/2;  // 中间位置
        while (number!=a[middle]){ //  输入的数字不等于中间的数字，继续判断
            if (number>a[middle])  start=middle;  //如果输入的数字大于中间的数字 起始位置从中间开始
            else if (number<a[middle]) end=middle; //如果输入的数字小于中间的数字，结束位置从中间开始
            middle=(start+end)/2;  // 更新最新中间的位置
            count++; // 计数器
            if (count>N/2) break;  // 一半的数字都不是就跳出循环
        }
        if (count>N/2) System.out.println(number+"不在数组中");
        else System.out.println(number+"在数组中");
    }
}
