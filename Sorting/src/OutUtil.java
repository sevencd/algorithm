package Sorting.src;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutUtil {
    //lamba用法
    public static void printLamba(Object[][] numsBefore) {
        for (int i = 0; i < numsBefore.length; i++) {
            printLamba(numsBefore[i], i + 1);
        }
    }

    //lamba用法
    public static void printLamba(Object[] numsBefore, int row) {
        System.out.println("第" + row + "行" + Arrays.stream(numsBefore).map(x -> x.toString())
                .collect(Collectors.joining(",")));

    }

    //非lamba用法（打印二维数组）
    public static void print(Object[][] numsBefore) {
        for (int i = 0; i < numsBefore.length; i++) {
            print(numsBefore[i], i + 1);
        }

    }

    //打印单行
    public static void print(Object[] numsBefore, int row) {

        StringBuilder str = new StringBuilder();
        for (int j = 0; j < numsBefore.length; j++) {
            str.append(numsBefore[j] + ",");
        }
        System.out.println("第" + row + "行" + str.substring(0, str.length() - 1));

    }

}
