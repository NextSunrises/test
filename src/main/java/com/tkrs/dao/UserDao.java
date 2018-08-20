package com.tkrs.dao;

import com.tkrs.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     *
     */
    int deleteByPrimaryKey(Integer userid);

    /**
     *
     */
    int insert(User record);

    /**
     *
     */
    int insertSelective(User record);

    /**
     *
     */
    User selectByPrimaryKey(Integer userid);

    /**
     *
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     */
    int updateByPrimaryKey(User record);
}