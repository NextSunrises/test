package com.tkrs.service;

import com.tkrs.bean.User;

/**
 * @ClassName IUserService
 * @Description 用户Service
 * @Author wangchenge
 * @Date 2018/8/13  13:46
 * @Version 1.0
 **/
public interface IUserService {
    /***
     * @Author wcg
     * @Description 通过特定参数遍历得到User集合
     * @Date 13:47 2018/8/13
     * @Param [user]
     * @return java.util.List<com.tkrs.bean.User>
     **/
    Integer insertUser(User user);
}
