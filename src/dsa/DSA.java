/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author hkorada
 */
public class DSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int x = -2147483648;

        System.out.println("========== " + reverNum(x));

    }

    public static int reverNumStr(int x) {

        String rev = "";

        String val[] = String.valueOf(x).split("");

        for (int i = val.length - 1; i >= 0; i--) {

            String str = val[i];
            if (rev.isEmpty()) {
                if (!str.equalsIgnoreCase("0")) {
                    rev += str;
                }
            } else {
                rev += str;
            }

        }

        if (rev.contains("-")) {
            rev = rev.replaceAll("-", "");

            if (Long.parseLong(rev) >= Integer.MAX_VALUE || Long.parseLong(rev) <= Integer.MIN_VALUE) {
                return 0;
            }

            return -Integer.parseInt(rev);
        }
        if (rev.isEmpty()) {
            return 0;
        }
        if (Long.parseLong(rev) >= Integer.MAX_VALUE || Long.parseLong(rev) <= Integer.MIN_VALUE) {
            return 0;
        }

        return Integer.parseInt(rev);
    }

    public static int reverNum(int x) {

        long revers = 0;
        while (x != 0) {
            int temp = x % 10;
            revers = revers * 10 + temp;
            x /= 10;
        }

        if (revers >= Integer.MIN_VALUE && revers <= Integer.MAX_VALUE) {
            return (int) revers;
        } else {
            return 0;
        }
    }

}
