package Sorting.src;

import Sorting.src.OutUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * 堆排序要求数组第 0 个元素不使用
 * 因此测试用例和其它排序方法不同
 * 需要单独创建一个测试类
 */
public class HeapSortTest {

    @Test
    public void sort() {

        Integer[] numsBefore = {0, 2, 3, 6, 5, 4, -1, -2, 0, Integer.MIN_VALUE, Integer.MAX_VALUE};
        Integer[] numsAfter = {0, Integer.MIN_VALUE, -2, -1, 0, 2, 3, 4, 5, 6, Integer.MAX_VALUE};

        HeapSort<Integer> sort = new HeapSort<>();
        sort.sort(numsBefore);
        OutUtil.print(numsBefore,1);
        OutUtil.printLamba(numsBefore,1);

        Assert.assertArrayEquals(numsBefore, numsAfter);
    }
}