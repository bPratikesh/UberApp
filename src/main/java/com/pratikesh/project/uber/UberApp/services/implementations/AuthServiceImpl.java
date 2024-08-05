package com.pratikesh.project.uber.UberApp.services.implementations;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.SignUpDTO;
import com.pratikesh.project.uber.UberApp.dto.UserDTO;
import com.pratikesh.project.uber.UberApp.entities.User;
import com.pratikesh.project.uber.UberApp.entities.enums.Role;
import com.pratikesh.project.uber.UberApp.exceptions.RuntimeConflictException;
import com.pratikesh.project.uber.UberApp.repositories.UserRepository;
import com.pratikesh.project.uber.UberApp.services.AuthService;
import com.pratikesh.project.uber.UberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    @Transactional
    public UserDTO signUp(SignUpDTO signUpDTO) {
        User user = userRepository.findByEmail(signUpDTO.getEmail()).orElse(null);
        if(user != null)
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+signUpDTO.getEmail());

        User mappedUser = modelMapper.map(signUpDTO, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        //creating user related entities
        riderService.createNewRider(savedUser);

        //TODO add wallet service here

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public DriverDTO onBoardNewDriver(String userId) {
        return null;
    }
}
