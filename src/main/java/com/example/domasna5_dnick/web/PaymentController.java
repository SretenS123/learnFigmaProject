package com.example.domasna5_dnick.web;

import com.example.domasna5_dnick.model.User;
import com.example.domasna5_dnick.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    private final UserService userService;

    public PaymentController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getPaymentPage(HttpServletRequest request, Model model)
    {
        User user =(User) request.getSession().getAttribute("user");
        if(user.isPayed())
            return "redirect:/courses";
        else
        {
            return "payment";
        }
    }
    @GetMapping("/done")
    public String donePayment(HttpServletRequest request)
    {
        User user =(User) request.getSession().getAttribute("user");
        this.userService.payed(user);
        return "redirect:/courses";

    }
}
