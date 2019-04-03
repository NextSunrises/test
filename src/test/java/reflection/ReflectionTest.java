package reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @ClassName ReflectionTest
 * @Description 测试反射
 * @Author wcg
 * @Date 2018/12/6  13:44
 * @Version 1.0
 **/
public class ReflectionTest {

    /**
     * 类型消息:Java让我们在运行时识别对象和类的信息,1:传统的RTTI,假定在编译时知道了所有的
     * 类型消息;2 反射机制,允许在允许时发现和使用类的信息
     * 每个类都会生成一个class对象,即保存在.class文件,所有类都是在对其第一次使用时,动态加载
     * 到jvm中,当程序创建一个对类的静态成员的引用时,就会加载这个类.class对象仅在需要的时候
     * 才会加载,static初始化是在类加载时进行的
     */

    @Test
    public void test(){
        System.out.println(Aa.name);
        System.out.println(Aa.name);
    }

    /**
     * 类加载器首先会检查这个类的class对象是否已被加载过,
     * 如果尚未加载,默认的类加载器会根据类名查找对应的.class文件
     * 在运行时使用类型信息,必须获取对象的class对象的引用,使用功能Class.forName("Base")或
     * Base.class可以实现该目的,使用.class创建对象不会自动初始化该class对象,使用forName会
     * 自动初始化该class对象
     */
    @Test
    public void test2() throws ClassNotFoundException {
        Class aa = Aa.class;
        Class.forName("reflection.Aa");
//        System.out.println("===");
        Class aClass = Class.forName("reflection.Aa",true,this.getClass().getClassLoader());
        System.out.println(aClass.getConstructors().toString());
        System.out.println(aClass.getDeclaredFields().toString());
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(declaredFields[0].getName());
        System.out.println(declaredFields.length);
    }

    @Test
    public void test3(){
        long start = System.currentTimeMillis();
        String key="12341zzzzzzxcxcx2aassdasscxzzvdfxzxcsd13asdvadfvafvfva2123123123123123123123123123333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333323333333333333333333123123123123123123123123123333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333";//-530043478380740601
        String hash = hash(key);
        System.out.println(hash);
        System.out.println(hash.length());
        long end = System.currentTimeMillis();
        System.out.println((end-start));
    }
    /**
     *  MurMurHash算法，是非加密HASH算法，性能很高，r
     *  比传统的CRC32,MD5，SHA-1（这两个算法都是加密HASH算法，复杂度本身就很高，带来的性能上的损害也不可避免）
     *  等HASH算法要快很多，而且据说这个算法的碰撞率很低.
     */
    private  String hash(String key) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;
        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);
        long m = 0xc6a4a7935bd1e995L;
        int r = 47;
        long h = seed ^ (buf.remaining() * m);
        long k;
        while (buf.remaining() >= 8) {  
            k = buf.getLong();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }
        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;
        buf.order(byteOrder);
        return String.valueOf(h);
    }

}
