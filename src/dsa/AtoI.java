/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author hkorada
 */
public class AtoI {

    public static void main(String[] args) {
//        String str = "3.14159";
        String str = "+-12";
//        String str = "   -42";
//        String str = "4193 with words";

        System.out.println(myAtoi(str));

    }

    public static int myAtoi(String s) {
        String digitStr = "";
        for (char ch : s.toCharArray()) {

            if (Character.isWhitespace(ch)) {
                continue;
            }
            int vv = Character.getType(ch);
            if ((vv == 25 || vv == 20)) {
                continue;
            }

            if (!Character.isDigit(ch)) {
                continue;
            }
            if (Character.isAlphabetic(ch)) {
                break;
            } else {
                digitStr += ch;
            }
        }

//        System.out.println("digitStr " + digitStr);
        digitStr = digitStr.trim();

        if (digitStr.contains("-")) {
            digitStr = digitStr.replaceAll("-", "");

//            System.out.println("digitStr after " + digitStr);
            if (Long.parseLong(digitStr) >= Integer.MAX_VALUE || Integer.MIN_VALUE >= Long.parseLong(digitStr)) {
                return Integer.MIN_VALUE;
            }
            int v = Integer.parseInt(digitStr);
            if (v > 0) {
                return -v;
            }
        } else if (digitStr.contains("+")) {
            digitStr = digitStr.replaceAll("//+", "");

            if (Long.parseLong(digitStr) >= Integer.MAX_VALUE || Integer.MIN_VALUE >= Long.parseLong(digitStr)) {
                return Integer.MAX_VALUE;
            }

            int v = Integer.parseInt(digitStr);
            if (v > 0) {
                return +v;
            }
        }

        if (digitStr.contains(".")) {
            digitStr = digitStr.split("\\.")[0];
        }
        if (digitStr.isEmpty()) {
            digitStr = "0";
        }
        return Integer.parseInt(digitStr);
    }
}
