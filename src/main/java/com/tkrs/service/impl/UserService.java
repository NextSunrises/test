package com.tkrs.service.impl;

import com.tkrs.bean.User;
import com.tkrs.dao.UserDao;
import com.tkrs.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/8/13  13:48
 * @Version 1.0
 **/
@Service
@Transactional
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public Integer insertUser(User user) {
        int count = userDao.insert(user);
        return count;
    }
}
