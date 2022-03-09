package collectons;

/**
 * 自定义运行时异常，
 * @Author: KangJieyu
 * @DATE: 2022/3/8 下午1:03
 */
public class ArgumentException extends RuntimeException {

    public ArgumentException(String s) {
        super(s);
    }

    public ArgumentException() {
        super();
    }



}
