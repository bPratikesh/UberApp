package com.pratikesh.project.uber.UberApp.services.implementations;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.SignUpDTO;
import com.pratikesh.project.uber.UberApp.dto.UserDTO;
import com.pratikesh.project.uber.UberApp.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public UserDTO signUp(SignUpDTO signUpDTO) {
        return null;
    }

    @Override
    public DriverDTO onBoardNewDriver(String userId) {
        return null;
    }
}
