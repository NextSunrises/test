package checkStr;

import org.junit.Test;

/**
 * @ClassName Son
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/11/23  15:04
 * @Version 1.0
 **/
public class Son extends Father {

    @Override
    public void say(){
        System.out.println("son");
    }

    @Test
    public void test(){
        this.say();
        super.say();
        say();
        Father father = new Son();
        father.say();
    }

}
