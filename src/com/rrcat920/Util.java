package com.rrcat920;

import java.util.Scanner;

public class Util {
    private static final Scanner in = new Scanner(System.in);

    public static String readMenuSelection() {
        return readWithMatchAndPrompt("12345");
    }

    public static String readConfirmation() {
        return readWithMatchAndPrompt("YN");
    }

    private static String readWithMatchAndPrompt(String match) {
        while (true) {
            String key = read(1, false).toUpperCase();
            for (String matchItem : match.split("")) {
                if (matchItem.equals(key)) return key;
            }
            System.out.print("选择错误，请重新输入：");
        }
    }

    public static String readString(int limit) {
        return read(limit, false);
    }


    public static String readString(int limit, String defaultValue) {
        String value = read(limit, true);
        return "".equals(value) ? defaultValue : value;
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(read(2, false));
            } catch (NumberFormatException exception) {
                System.out.print("数字输入有误，请重新输入：");
            }
        }
    }


    public static int readInt(int defaultValue) {
        while (true) {
            try {
                String stringValue = read(2, true);
                return "".equals(stringValue) ? defaultValue : Integer.parseInt(stringValue);
            } catch (NumberFormatException e) {
                System.out.print("数字输入有误，请重新输入：");
            }
        }
    }

    public static int readCustomerIndex(CustomerList customers, String prompt) {
        int index;
        while (true) {
            System.out.print(prompt);
            index = Util.readInt();
            if (index == -1) return index;

            Customer customer = customers.getCustomer(index - 1);
            if (customer == null) System.out.println("无法找到指定客户！");
            else break;
        }
        return index;
    }

    private static String read(int limit, boolean returnEmpty) {
        while (true) {
            String line = in.nextLine();
            if (line.length() == 0) {
                if (returnEmpty) return line;
            } else if (line.length() > limit)
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
            else return line;
        }
    }
}
