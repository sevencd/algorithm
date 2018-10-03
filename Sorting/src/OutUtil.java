package Sorting.src;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutUtil {
    //lamba用法
    public static void printLamba(Integer[][] numsBefore) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < numsBefore.length; i++) {
            System.out.print("第" + (i + 1) + "行");
            System.out.println(Arrays.stream(numsBefore[i]).map(x -> x.toString())
                    .collect(Collectors.joining(",")));
        }
        long end = System.currentTimeMillis();
        System.out.println("printLamba用时" + (end - start));
    }

    //lamba用法
    public static void printLamba(Integer[] numsBefore) {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.stream(numsBefore).map(x -> x.toString())
                .collect(Collectors.joining(",")));
        long end = System.currentTimeMillis();
        System.out.println("printLamba用时" + (end - start));


    }

    //非lamba用法（打印二维数组）
    public static void print(Integer[][] numsBefore) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < numsBefore.length; i++) {
            print(numsBefore[i], i + 1);
        }
        long end = System.currentTimeMillis();
        System.out.println("print用时" + (end - start));

    }

    //打印单行
    public static void print(Integer[] numsBefore, int row) {
        long start = System.currentTimeMillis();

        StringBuilder str = new StringBuilder();
        for (int j = 0; j < numsBefore.length; j++) {
            str.append(numsBefore[j] + ",");
        }
        System.out.println("第" + row + "行" + str.substring(0, str.length() - 1));
        long end = System.currentTimeMillis();
        System.out.println("print用时" + (end - start));

    }

}
