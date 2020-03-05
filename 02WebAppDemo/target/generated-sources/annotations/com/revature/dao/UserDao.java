package com.revature.dao;

import java.util.Set;

import com.revature.pojo.User;

public interface UserDao {
    User getUserById(int id);
    Set<User> getAllUsers();
    User getUserByUserNameAndPassword(String username, String password);
    boolean insertUser(User user);
    boolean updateUserInfo(User user);
    
}

