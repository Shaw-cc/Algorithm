package com.shaw.algorithm.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * @Author: Shaw
 * @Date: 2022/3/27 13:00
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123", "321"));
        System.out.println(addStrings("123", "321"));

    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        StringBuilder builder = new StringBuilder();


        builder.append("1");
        return builder.toString();
    }

    // 字符串相加
    public static String addStrings(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return num1.equals("0") ? num2 : num1;
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            char a = i >= 0 ? num1.charAt(i) : '0';
            char b = j >= 0 ? num2.charAt(j) : '0';
            int sum = (a - '0' + b - '0' + carry);
            carry = sum / 10;
            builder.append(sum % 10);
            i--;
            j--;
        }
        if (carry != 0) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}
