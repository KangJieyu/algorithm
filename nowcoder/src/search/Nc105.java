package search;

/**
 *
 NC105 二分查找-II

 描述     请实现有重复数字的升序数组的二分查找
 给定一个 元素有序的（升序）长度为n的整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的第一个出现的target，
 如果目标值存在返回下标，否则返回 -1

 示例1
 输入：[1,2,4,4,5],4
 返回值：2
 说明：从左到右，查找到第1个为4的，下标为2，返回2

 示例2
 输入：[1,2,4,4,5],3
 返回值：-1

 示例3
 输入：[1,1,1,1,1],1
 返回值：0

 * @Author: KangJieyu
 * @Date: 2022/7/15 下午9:50
 */
public class Nc105 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 如果目标值存在返回下标，否则返回 -1
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search(int[] nums, int target) {
        // write code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums.length == 1 && nums[0] != target ? -1 : left;
    }


    public static void main(String[] args) {
        int[] nums = {5};
        System.out.println(search(nums, 4));
    }

}
