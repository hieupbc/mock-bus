package com.example.mockbus.controllers;

import com.example.mockbus.DTO.UserDTO;
import com.example.mockbus.entities.RoleDomain;
import com.example.mockbus.entities.UserDomain;
import com.example.mockbus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/index"})
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/register")
    public String signUp(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String submitSignup(@Valid UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        UserDomain userDomain = userService.registerNewUser(userDTO);
        Set<RoleDomain> roles = userDomain.getRoles();
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(e -> authorities.add(new SimpleGrantedAuthority(e.getName().toString())));

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDomain.getEmail(), userDomain.getPassword(), authorities));

        return "index";
    }
//
//    @GetMapping("/error")
//    public String error(){
//        return "404";
//    }

    @GetMapping("/404")
    public String error(){
        return "404";
    }

}
