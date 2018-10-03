package Sorting.src;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 定义排序用的常量,公共方法
 *
 * 这里最好使用泛型类，更通用
 *
 *
 * @time 2018年3月24日14:39:51
 */
public abstract class Constant {

    public static final Object[] array = {8, 34, 64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2};
    public static final Integer[] numsBefore = {0, 2, 3, 6, 5, 4, -1, -2, 0, Integer.MIN_VALUE, Integer.MAX_VALUE};

    // 有序数组
    public static final Object[] array2 = {0, 1, 2, 2, 8, 22, 33, 34, 44, 51, 55, 64, 88};
    public static final int len = array.length;

    public static void printResult(Object[] array) throws Exception {
        if (array == null || array.length == 0)
            throw new Exception("no element or invalid element in array");
        // java 8 lambda
        //System.out.println(Arrays.stream(array).map(x -> x.toString()).collect(Collectors.joining(",", "[", "]")));
        OutUtil.print(array,1);
    }

    /**
     * 原始版
     *
     * @param array
     * @param len
     * @return
     */
    public abstract Object[] sort(Object[] array, int len);

    /**
     * 优化版
     *
     * @param array
     * @param len
     * @return
     */
    public Object[] sort2(Object[] array, int len) {
        return new Object[0];
    }
}
