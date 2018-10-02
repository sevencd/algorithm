import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {

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
        test(new Selection<>());
    }


    @org.junit.Test
    public void BubbleTest() {
        test(new Bubble<>());
    }


    @org.junit.Test
    public void InsertionTest() {
        test(new Insertion<>());
    }


    @org.junit.Test
    public void ShellTest() {
        test(new Shell<>());
    }


    @org.junit.Test
    public void Up2DownMergeSortTest() {
        test(new Up2DownMergeSort<>());
    }


    @org.junit.Test
    public void Down2UpMergeSortTest() {
        test(new Down2UpMergeSort<>());
    }


    @org.junit.Test
    public void QuickSortTest() {
        test(new QuickSort<>());
    }


    @org.junit.Test
    public void ThreeWayQuickSortTest() {
        test(new ThreeWayQuickSort<>());
    }


    private void test(Sort<Integer> sort) {

        for (int i = 0; i < numsBefore.length; i++) {
            sort.sort(numsBefore[i]);
            //Assert.assertArrayEquals(numsBefore[i], numsAfter[i]);
        }
        //print();
        printLamba();
    }
    //普通用户
    private void print() {
        for (int i = 0; i < numsBefore.length; i++) {
            System.out.print("第" + (i + 1) + "行");
            StringBuilder str = new StringBuilder();//单行打印字符串
            for (int j = 0; j < numsBefore[i].length; j++) {
                str.append(numsBefore[i][j] + ",");
            }
            System.out.print(str.substring(0, str.length() - 1));
            System.out.println();

        }

    }
    //lamba用法
    private void printLamba () {
        for (int i = 0; i < numsBefore.length; i++) {
            System.out.print("第" + (i + 1) + "行");
            System.out.println(Arrays.stream(numsBefore[i]).map(x -> x.toString())
                    .collect(Collectors.joining(",")));
        }

    }
}
