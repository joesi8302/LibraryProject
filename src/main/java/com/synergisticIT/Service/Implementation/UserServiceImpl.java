package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.User;
import com.synergisticIT.Repositories.UserRepository;
import com.synergisticIT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



    @Override
    public void deleteUser(Integer userId) {
        User foundUser = getUserById(userId);
        if(foundUser != null){
            userRepository.delete(foundUser);
        }

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Page<User> findAllPaginiated(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }


}
