package com.synergisticIT.Service;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    void deleteUser(Integer userId);

    User findByEmail(String email);

    Page<User> findAllPaginiated(int page, int size);

}
