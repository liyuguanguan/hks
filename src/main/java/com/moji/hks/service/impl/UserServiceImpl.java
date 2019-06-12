package com.moji.hks.service.impl;


import com.moji.hks.mybaties.mapper.UserMapper;
import com.moji.hks.mybaties.model.User;
import com.moji.hks.mybaties.model.UserExample;
import com.moji.hks.service.UserService;
import com.moji.hks.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user){
        log.trace("这是trace日志...");
        log.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；
        log.info("这是info日志...");
        log.warn("这是warn日志...");
        log.error("这是error日志...");
        System.out.println("hahahaaaaaaaaaaaaa");
        System.out.println("dsadsad");
        System.out.println("sadsa");
        System.out.println("sadasdasdasdasdas");
        return  userMapper.insert(user);
    }

    @Override
    public  User getSys(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(user.getName()).andPasswordEqualTo(MD5Util.MD5Encode(user.getPassword())).andTypeEqualTo(0);
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)){
            return users.get(0);
        } else {
            return null;
        }

    }


}
