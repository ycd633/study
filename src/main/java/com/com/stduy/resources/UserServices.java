package com.com.stduy.resources;

import com.com.stduy.users.model.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

public class UserServices {

    private static UserServices _instance = new UserServices();

    public static UserServices getInstance() {return _instance;};

    public UserVo createUser(UserVo userVo)
    {
        return userVo;
    }

    public UserVo updateUser(UserVo userVo)
    {
        return userVo;
    }

    public List<UserVo> updateUsers(List<UserVo> userVo)
    {
        return userVo;
    }

    public int deleteUser(String loginId)
    {
        return 0;
    }

    public int deleteUser(List<String> loginIds)
    {
        return 0;
    }

    public UserVo retrieveUser(UserVo userVo)
    {
        return userVo;
    }

    public List<UserVo> retrieveUsers(UserVo userVo)
    {
        List<UserVo> userList = new ArrayList<>();

        return userList;
    }
}
