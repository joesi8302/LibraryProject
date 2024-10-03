package com.synergisticIT.Service;

import com.synergisticIT.Domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    void deleteUser(Integer userId);

}
