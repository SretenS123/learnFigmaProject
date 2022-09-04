package com.example.domasna5_dnick.service;

import com.example.domasna5_dnick.model.User;

public interface UserService {
     User reqister(String username,String email, String password, String repeatPass);
     User payed(User user);
}
