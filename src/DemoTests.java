import java.util.*;

/**
 * @Author: KangJieyu
 * @DATE: 2022/2/13 下午2:18
 */
public class DemoTests {

    /**
     * 打印边长为5的等腰三角形
     *      *
     *     * *
     *    * * *
     *   * * * *
     *  * * * * *
     */
    public void printStars() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
            continue;
        }
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
//        if (s.length() == 1) {
//            return 1;
//        }
        Set<Character> set = new HashSet<>();
        // 最长子串长度
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // 子串
                String sub = s.substring(i, j);
                boolean b = true;
                char[] chars = sub.toCharArray();
                for (char c : chars) {
                    if (set.contains(c)) {
                        // 子串重复
                        b = false;
                        break;
                    }
                    set.add(c);
                }
                if (b) {
                    res = res > sub.length() ? res : sub.length();
                }
                set.clear();
            }
        }
        return res;
    }


    private static Map mapAdd(Map<Integer, Integer> map, int[][] items) {
        for (int i = 0; i < items.length; i++) {
            map.put(items[i][0], map.getOrDefault(items[i][0], 0) + items[i][1]);
        }
        return map;
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map = mapAdd(map, items1);
        map = mapAdd(map, items2);
        Set<Integer> integers = map.keySet();
        for (Integer v : integers) {
            List<Integer> list = new ArrayList<>();
            list.add(v);
            list.add(map.get(v));
            res.add(list);
        }
        return res;
    }

    private static Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }


    public static String findLongestWord(String s, List<String> dictionary) {
        Map<Character, Integer> sMap = toMap(s);
        String str = "";
        for (String v : dictionary) {
            Map<Character, Integer> vMap = toMap(v);
            Set<Character> set = vMap.keySet();
            // 设可通过删除得到
            boolean b = true;
            for (Character c : set) {
                // 不可通过删除得到
                if (!(sMap.containsKey(c) && sMap.get(c) >= vMap.get(c))) {
                    b = false;
                    break;
                }
            }
            // 验证了可通过删除得到
            if (b) {
                // 验证长度和字符序列
                char[] strChars = str.toCharArray();
                char[] vChars = v.toCharArray();
                if (strChars.length < vChars.length) {
                    for (int i = 0; i < strChars.length; i++) {
                        if (strChars[i] > vChars[i]) {
                            str = v;
                            break;
                        }
                    }
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
//        containsNearbyDuplicate(new int[]{1,0,1,1}, 1);
//        String s = "hello,world";
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        System.out.println(chars);
//        String s1 = Arrays.toString(chars);

        String s = "abcabcbb";
//        s = " ";
//        s = "au";
        int i = lengthOfLongestSubstring(s);
//        System.out.println(i);
//
//        Map<Integer, Integer> map = new HashMap<>();
//        Integer it = map.getOrDefault("1", 1);
//        map.put(1,2);
//        map.put(2,3);
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Integer> next = iterator.next();
//            System.out.println(next.getKey() + "---->>" + next.getValue());
//        }

        int[][] items1 = {{15,5},{2,6},{5,3},{14,8},{12,4},{19,6},{25,4},{13,4},{9,1}};
        int[][] items2 = {{15,9},{2,4},{5,2},{14,4},{12,3},{19,10},{25,7},{13,6},{9,9}};
//        System.out.println(mergeSimilarItems(items1, items2));


        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        for (Integer v : set) {

        }

        String s1 = "hello!";
        int b = "b".compareTo("b");
        s1 = "abpcplea";
        List<String> lists = Arrays.asList("a","b","c");
        System.out.println("find1 : " + findLongestWord(s1, lists));

        s1 = "abpcplea";
        lists = Arrays.asList("ale","apple","monkey","plea");
        System.out.println("find2 : " + findLongestWord(s1, lists));

    }
}
