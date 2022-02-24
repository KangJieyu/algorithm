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


    public static void main(String[] args) {
        DemoTests test = new DemoTests();
//        String s = "abcds";
//        System.out.println(s.substring(0,s.length()+1));
//        test.printStars();
        StringBuilder builder = new StringBuilder("]]]]]");
        builder.insert(0,'[');
        builder.insert(0,'[');
        System.out.println(builder);
    }
}
