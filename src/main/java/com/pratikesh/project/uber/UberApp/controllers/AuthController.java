package com.pratikesh.project.uber.UberApp.controllers;

import com.pratikesh.project.uber.UberApp.dto.*;
import com.pratikesh.project.uber.UberApp.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO){
        return new ResponseEntity<>(authService.signUp(signUpDTO), HttpStatus.CREATED);
    }

    @PostMapping("/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDTO> onBoardNewDriver(@PathVariable Long userId,@RequestBody OnBoardDriverDTO onboardDriverDto){
        return new ResponseEntity<>(authService.onBoardNewDriver(userId,
                onboardDriverDto.getVehicleId()), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String tokens[] = authService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

        Cookie cookie = new Cookie("token", tokens[1]);
        cookie.setHttpOnly(true);

        httpServletResponse.addCookie(cookie);

        return ResponseEntity.ok(new LoginResponseDTO(tokens[0]));
    }


}
