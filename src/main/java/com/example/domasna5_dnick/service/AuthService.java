package com.example.domasna5_dnick.service;

import com.example.domasna5_dnick.model.User;

public interface AuthService {
    User login(String username, String password);
}
