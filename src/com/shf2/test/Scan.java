package com.shf2.test;

import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入整型：");
        int integer = scanner.nextInt();
        System.out.println("整型："+integer);

        System.out.print("请输入实型：");
        double dou = scanner.nextDouble();
        System.out.println("实型："+dou);

        System.out.print("请输入字符类型：");
        char ch = scanner.next().charAt(0);
        System.out.println("字符类型："+ch);

        System.out.print("请输入布尔类型：");
        boolean bool = scanner.nextBoolean();
        System.out.println("布尔型："+bool);
    }
}
