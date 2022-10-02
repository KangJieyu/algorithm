package search;

/**
 * BM18 二维数组中的查找
 *
 * 描述
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [ [1,2,8,9], [2,4,9,12], [4,7,10,13], [6,8,11,15] ] 给定 target = 7，返回 true。给定 target = 3，返回 false。
 *
 * 示例1
 * 输入： 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值： true
 * 说明： 存在7，返回true
 *
 * 示例2
 * 输入： 1,[[2]]
 * 返回值： false
 *
 * 示例3
 * 输入： 3,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值： false
 * 说明： 不存在3，返回false
 *
 * @Author: KangJieyu
 * @Date: 2022/4/7 下午7:42
 */
public class Bm18 {

    /**
     * 每行进行二分查找
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            int start = 0, end = array[0].length - 1;
            while (start <= end) {
                int mid = (start + end)/2;
                if (array[i][mid] == target) {
                    return true;
                } else if (array[i][mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }

    /*public static boolean findColumn(int col, int target, int[][] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (array[mid][col] == target) {
                return true;
            } else if (array[mid][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static boolean find(int target, int [][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int length = array[0].length;
        for (int i = 0; i < length; i++) {
            // 找相同的数或第一个比target大的数
            if (array[0][i] == target) {
                 return true;
            } else if (array[0][i] > target) {
                // 说明target可能在i-1列
                // 判断列索引的合法性
                if (i - 1 >= 0) {
                    return Bm18.findColumn(i - 1, target, array);
                }
            } else if (array[0][i] < target && i == length - 1) {
                // target可能在最后一列
                return Bm18.findColumn(i, target, array);
            }
        }
        return false;
    }*/

    public static void main(String[] args) {
//        int[][] array = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
//        int[][] array = {{}};
//        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] array = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(Bm18.find(19, array));
    }

}
