package string;

/**
 *
 JZ5 替换空格
 描述
 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
："We Are Happy"
 返回值："We%20Are%20Happy"
 示例2
 输入：" "
 返回值："%20"

 * @Author: KangJieyu
 * @DATE: 2022/2/8 下午4:19
 */
public class Jz5 {

    public String replaceSpace (String s) {
        // write code here

        return s.replaceAll(" ", "%20");

    }

}
