package reflection;

/**
 * @ClassName Aa
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/12/6  15:16
 * @Version 1.0
 **/
public class Aa {
    public static String name = "wangchenge";

    static {
        System.out.println("执行静态代码块");
    }

    public Aa() {
        System.out.println("执行构造方法");
    }
}
