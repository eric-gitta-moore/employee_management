package com.example.employee_management.common.utils;

public class ToolsUtil {
    /**
     * 转驼峰
     * @param varName 待转化字符串
     * @param isClass true大驼峰，false小驼峰
     * @return 转换后驼峰
     */
    public static String toCamel(String varName, boolean isClass) {
        String str = varName.toLowerCase();
        String[] names = str.split("_");
        StringBuilder finalName = new StringBuilder();
        int i = 0;
        if (!isClass) {
            if (names.length == 1) {
                return str;
            }
            i = 1;
            finalName.append(names[0]);
        }
        for (; i < names.length; i++) {
            String temp = names[i];
            char ch = temp.charAt(0);
            ch = Character.toUpperCase(ch);
            temp = ch + temp.substring(1);

            finalName.append(temp);
        }
        return finalName.toString();
    }
}
