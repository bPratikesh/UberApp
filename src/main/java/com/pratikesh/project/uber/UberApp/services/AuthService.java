package com.pratikesh.project.uber.UberApp.services;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.SignUpDTO;
import com.pratikesh.project.uber.UberApp.dto.UserDTO;

public interface AuthService {
    String login(String email, String password);
    UserDTO signUp(SignUpDTO signUpDTO);

    DriverDTO onBoardNewDriver(String userId);


}
