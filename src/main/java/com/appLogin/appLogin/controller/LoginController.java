package com.appLogin.appLogin.controller;

import com.appLogin.appLogin.model.Usuario;
import com.appLogin.appLogin.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository ur;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String dashboard() { return "index"; }


    @PostMapping("/logar")
    public String loginUser(Usuario user, Model model, HttpServletResponse response) {
        Usuario userLogado = this.ur.login(user.getEmail(), user.getPassword());
        System.out.println(userLogado);
        if(userLogado != null) {
            return "redirect:/";

        }

        model.addAttribute("erro", "Usuario Inválido");
        return "redirect:/login";

    }



    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid Usuario user, BindingResult result) {

        if(result.hasErrors()) {
            return "redirect:/register";
        }

        ur.save(user);
        return "redirect:/login";
    }

}
