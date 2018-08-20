package com.tkrs.controller;

import com.tkrs.bean.User;
import com.tkrs.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName UserController
 * @Description 用户controller
 * @Author wangchenge
 * @Date 2018/8/11  16:26
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {
    /***
     * @Author wcg
     * @Description Logger的构造方法参数是class,决定logger是根据类的结构进行区分日志,所以一个类一个logger,所以是static
     * final表示该类的logger只是记录该类的信息。否则日志无法提供令人信服的记录
     * 内部实现细节,故私有
     * @Date 9:39 2018/8/13
     **/
    private static final Logger logger=LogManager.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/welcome")
    @ResponseBody
    public String testHello(String name) {
        System.out.println(name);
        System.out.println("Hello,你们！");
        logger.info("打印出日志");
        logger.debug("debug日志");
        logger.error("error日志");
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
        Integer integer = userService.insertUser(user);
        System.out.println(integer);
        System.out.println(user.getUserid());
        return "WelCome,欢迎访问!";
    }

    public String userTest(User user){
        //alt+enter 弹出inject language(注入语言) 视图,inject language or reference选择并按enter键后弹出inject language
        //选择json组件,edit json fragment 便可以自动转义json,ctrl+f4快捷键退出
        String jsonString="{\"username\":\"wangchenge\",\"age\":\"120\"}";
        //language=JSON
        String jsonStr="{\"username\":\"administrator\",\"password\":\"000000\",\"age\":\"18\",\"sex\":\"1\"}";
        //自动收尾,ctrl+shift+enter
        if (jsonStr == null || jsonStr.length() == 0 || jsonStr.isEmpty()) {

        }
        if (jsonStr != null) {

        }
        //ctrl+shift+A -> 输入Search Struct,编辑模板变量输入可以搜索找到未做处理的异常代码块
        try {

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return "success";
    }
}
