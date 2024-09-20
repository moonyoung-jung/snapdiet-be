package com.snapdiet.user.controller;

import com.snapdiet.user.domain.User;
import com.snapdiet.user.domain.UserCreateForm;
import com.snapdiet.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입 페이지 보여주기
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    // 회원가입 처리
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute User user, Model model) {
//        if (userService.isUsernameTaken(user.getUsername())) {
//            model.addAttribute("error", "이미 사용 중인 사용자 이름입니다.");
//            return "register";
//        }
//        userService.saveUser(user);
//        return "redirect:/login"; // 회원가입 후 로그인 페이지로 리다이렉트
//    }

    // 회원가입 페이지 보여주기
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userCreateForm", new UserCreateForm());
        return "register";
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String registerUser(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            User user = new User(userCreateForm.getUsername(), userCreateForm.getPassword(), userCreateForm.getEmail());
            userService.saveUser(user);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("registerFailed", "이미 등록된 사용자입니다.");
            return "register";
        } catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("registerFailed", e.getMessage());
            return "register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


}