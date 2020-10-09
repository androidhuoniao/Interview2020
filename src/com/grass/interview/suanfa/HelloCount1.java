package com.grass.interview.suanfa;

/**
 * Java求一个整数的二进制中1的个数
 */
public class HelloCount1 {
    public static void main(String[] args) {
        int num = 7;
        int i = times1(num);
        int i2 = times2(num);
        System.out.println(i+" i2: "+i2);
    }

    public static int times1(int n) {
        int count = 0;
        int flag = 1;
        while (flag <= n) {
            if ((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public static int times2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }


}
