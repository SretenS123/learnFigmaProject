package com.example.domasna5_dnick.web;

import com.example.domasna5_dnick.model.User;
import com.example.domasna5_dnick.model.exceptions.InvalidUserCredentialsException;
import com.example.domasna5_dnick.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping
    public String getLoginPage(Model model)
    {
        return "login";
    }
    @PostMapping
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest request,
                        Model model)
    {
        User user = null;
        try{
            user = this.authService.login(username,password);
            request.getSession().setAttribute("user",user);
            return "redirect:/payment";


        }
        catch (InvalidUserCredentialsException exception)
        {
            model.addAttribute("hasError",true);
            model.addAttribute("error",exception.getMessage());
            model.addAttribute("bodyContent","login");
            return "master-template";
        }
    }
}
