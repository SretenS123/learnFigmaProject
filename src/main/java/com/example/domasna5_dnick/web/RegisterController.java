package com.example.domasna5_dnick.web;

import com.example.domasna5_dnick.model.exceptions.InvalidArgumentsException;
import com.example.domasna5_dnick.model.exceptions.PassworDoNotMatchException;
import com.example.domasna5_dnick.service.AuthService;
import com.example.domasna5_dnick.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model)
    {
        if(error!=null && !error.isEmpty())
        {
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        return "register";
    }
    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String repeatPass)
    {
        try{
            userService.reqister(username, email, password, repeatPass);
            return "redirect:/login";
        }
        catch (PassworDoNotMatchException | InvalidArgumentsException exception)
        {
            return "redirect:/reqister?error=" + exception.getMessage();
        }
    }
}
