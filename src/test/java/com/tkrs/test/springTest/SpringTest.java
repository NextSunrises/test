package com.tkrs.test.springTest;

import com.tkrs.bean.User;
import com.tkrs.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName SpringTest
 * @Description Spring test framework spring框架测试
 * @Author wangchenge
 * @Date 2018/8/14  19:55
 * @Version 1.0
 **/

/**
 * @RunWith 注释标签是 Junit 提供的,说明此测试类的运行者,
 * SpringJUnit4ClassRunner 针对 Junit 运行环境的自定义扩展,
 * 标准化在spring环境中Junit4.5的测试用例
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * @ContextConfiguration 注释标签是 Spring test context 提供的,指定spring配置信息的来源
 * 支持指定 XML 文件位置或者 Spring 配置类名
 */
@ContextConfiguration({"classpath:spring/applicationContext.xml",
        "classpath:spring/spring-mybatis.xml",
        "classpath:spring/spring-mvc.xml"})
/**
 * @Transactional 注释标签是表明此测试类的事务启用,所有测试方案都会rollback
 * 即不用清除自己所做的任何对数据库的变更
 */
@Transactional

public class SpringTest {
    /**
     * @TransactionConfiguration 和 @Rollback
     * 缺省情况下，Spring 测试框架将事务管理委托到名为 transactionManager 的 bean 上，
     * 如果您的事务管理器不是这个名字，那需要指定 transactionManager 属性名称，
     * 还可以指定 defaultRollback 属性，缺省为 true，即所有的方法都 rollback，
     * 您可以指定为 false，这样，在一些需要 rollback 的方法，
     * 指定注释标签 @Rollback（true）即可。
     */
    @Resource
    private IUserService userService;
    /***
     * @Author wcg
     * @Description 测试spring集成测试框架
     * @Date 20:04 2018/8/14
     * @Param []
     * @return void
     **/
    @Test

    public void testUserService(){
        User user=new User();
        user.setAge(11);
        LocalDateTime now = LocalDateTime.now();
        String userName="wangchenge";
        String password="000000";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        user.setCreateTime(now);
        user.setAge(11);
//        user.setUserid(1);
        user.setUsername(userName);
        user.setDeleteFlag(0);
        user.setSex(0);
        user.setPassword(DigestUtils.md5Hex(password));
        Integer userCount = userService.insertUser(user);

        System.out.println(userCount);
        System.out.println(user.getUserid());
    }

    private MockMvc mockMvc;
}
