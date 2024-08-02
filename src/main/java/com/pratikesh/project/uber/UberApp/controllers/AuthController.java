package com.pratikesh.project.uber.UberApp.controllers;

import com.pratikesh.project.uber.UberApp.dto.SignUpDTO;
import com.pratikesh.project.uber.UberApp.dto.UserDTO;
import com.pratikesh.project.uber.UberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    UserDTO signUp(@RequestBody SignUpDTO signUpDTO){
        return authService.signUp(signUpDTO);
    }
}
