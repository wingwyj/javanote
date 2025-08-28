package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 算法：合并区间
 * @author wyj
 * @version 1.0
 * @date 2025/5/24
 */
public class MergeIntervalAlgorithmTest {

    @Test
    public void test() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        // 先将所有区间按照起始值排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 开始判断是否合并，有区间交集就合并，用b[0]和a[1]判断
        List<int[]> mergeList = new ArrayList<>();
        mergeList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = mergeList.get(mergeList.size() - 1);
            int[] currentInterval = intervals[i];
            if (currentInterval[0] > lastInterval[1]) {
                mergeList.add(intervals[i]);
            }else {
                lastInterval[1]= Math.max(currentInterval[1], lastInterval[1]);
            }
        }

        return mergeList.toArray(new int[0][]);
    }
}
