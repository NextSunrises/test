package com.tkrs.test.jdk8;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @ClassName Jdk8NashornTest
 * @Description Nashorn一个javascript引擎，Java8开始Nashorn取代Rhino成为java嵌入式js引擎,完全支持EcmaScript5.1规范及一些扩展
 * 包含jdk7中的引入的invokeDynamic,将Js编译成java字节码
 * @Author wangchenge
 * @Date 2018/8/10  13:43
 * @Version 1.0
 **/
public class Jdk8NashornTest {

    /**
     * jjs是基于Nashorn引擎的命令行工具,接受js源代码作为参数,并且执行这些源代码
     * Java中调用js
     */
    @Test
    public void testJjs(){
        ScriptEngineManager scriptEngineManager=new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name ="Runnoob";
        Integer result=null;
        try {
            nashorn.eval("print('"+name+"')");
            result=(Integer) nashorn.eval("10+2");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


}
