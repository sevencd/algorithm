import Sorting.src.OutUtil;
import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortTest {

    private Integer[][] numsBefore = {
            {1, 2, 3},
            {3, 2, 1},
            {1},
            {1, 3, 5, 7, 6, 4, 2, 0, -1, -2},
            {Integer.MAX_VALUE, Integer.MIN_VALUE}
    };

    private Integer[][] numsAfter = {
            {1, 2, 3},
            {1, 2, 3},
            {1},
            {-2, -1, -0, 1, 2, 3, 4, 5, 6, 7},
            {Integer.MIN_VALUE, Integer.MAX_VALUE}
    };


    @org.junit.Test
    public void SelectionTest() {
        test(new Selection<>(),"选择排序");
    }


    @org.junit.Test
    public void BubbleTest() {
        test(new Bubble<>(),"冒泡排序");
    }


    @org.junit.Test
    public void InsertionTest() {
        test(new Insertion<>(),"插入排序");
    }


    @org.junit.Test
    public void ShellTest() {
        test(new Shell<>(),"希尔排序");
    }

    @org.junit.Test
    public void Up2DownMergeSortTest() {
        test(new Up2DownMergeSort<>(),"自顶向下归并排序");
    }


    @org.junit.Test
    public void Down2UpMergeSortTest() {
        test(new Down2UpMergeSort<>(),"自底向上归并排序");
    }


    @org.junit.Test
    public void QuickSortTest() {
        test(new QuickSort<>(),"快速排序");
    }


    @org.junit.Test
    public void ThreeWayQuickSortTest() {
        test(new ThreeWayQuickSort<>(),"三切分快速排序");
    }


    private void test(Sort<Integer> sort) {
        for (int i = 0; i < numsBefore.length; i++) {
            sort.sort(numsBefore[i]);
            //Assert.assertArrayEquals(numsBefore[i], numsAfter[i]);
        }
        OutUtil.print(numsBefore);
    }

    private void test(Sort<Integer> sort,String algorithmName) {
        long t = System.nanoTime();

        for (int i = 0; i < numsBefore.length; i++) {
            sort.sort(numsBefore[i]);
            //Assert.assertArrayEquals(numsBefore[i], numsAfter[i]);
        }
        long time=System.nanoTime()-t;
        OutUtil.printLamba(numsBefore);
        System.out.println(algorithmName+time);

    }
}
