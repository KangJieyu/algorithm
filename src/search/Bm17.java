package search;

/**
 * BM17 二分查找-I
 *
 * 描述
 * 请实现无重复数字的升序数组的二分查找  给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
 *
 * 示例1
 * 输入： [-1,0,3,4,6,10,13,14],13
 * 返回值： 6
 * 说明： 13 出现在nums中并且下标为 6
 *
 * 示例2
 * 输入： [],3
 * 返回值： -1
 * 说明： nums为空，返回-1
 *
 * 示例3
 * 输入： [-1,0,3,4,6,10,13,14],2
 * 返回值： -1
 * 说明： 2 不存在nums中因此返回 -1
 *
 * @Author: KangJieyu
 * @Date: 2022/4/7 上午9:56
 */
public class Bm17 {

    public static int search (int[] nums, int target) {
        // write code here
//        [-1,0,3,4,6,10,13,14],13
//          0 1 2 3 4  5  6  7
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,3,4,6,10,13,14};
//        System.out.println(Bm17.search(nums, 13));
//        int[] nums = {};
//        System.out.println(Bm17.search(nums, 3));
        int[] nums = {-1,0,3,4,6,10,13,14};
        System.out.println(Bm17.search(nums, 2));
    }

}
