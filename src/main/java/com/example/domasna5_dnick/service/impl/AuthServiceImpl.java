package com.example.domasna5_dnick.service.impl;

import com.example.domasna5_dnick.model.User;
import com.example.domasna5_dnick.model.exceptions.InvalidArgumentsException;
import com.example.domasna5_dnick.model.exceptions.InvalidUserCredentialsException;
import com.example.domasna5_dnick.repository.UserRepository;
import com.example.domasna5_dnick.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty())
            throw new InvalidArgumentsException();
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
