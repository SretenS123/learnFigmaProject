package com.example.domasna5_dnick.service.impl;

import com.example.domasna5_dnick.model.User;
import com.example.domasna5_dnick.model.exceptions.InvalidArgumentsException;
import com.example.domasna5_dnick.model.exceptions.PassworDoNotMatchException;
import com.example.domasna5_dnick.model.exceptions.UserIdNotFoundException;
import com.example.domasna5_dnick.model.exceptions.UsernameAlreadyExistsException;
import com.example.domasna5_dnick.repository.UserRepository;
import com.example.domasna5_dnick.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public User reqister(String username, String email, String password, String repeatPass) {
        if(username==null || username.isEmpty())
            throw new InvalidArgumentsException();
        if(!password.equals(repeatPass))
            throw new PassworDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
        {
            throw new UsernameAlreadyExistsException(username);
        }
        User u = new User(username,email,password);
        userRepository.save(u);
        return u;
    }

    @Override
    public User payed(User user) {
        User user1 = this.userRepository.findById(user.getId()).orElseThrow(()->new UserIdNotFoundException(user.getId()));
        user1.setPayed(true);
        this.userRepository.save(user1);
        return user1;
    }
}
