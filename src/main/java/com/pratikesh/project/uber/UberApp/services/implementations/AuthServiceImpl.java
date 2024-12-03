package com.pratikesh.project.uber.UberApp.services.implementations;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.SignUpDTO;
import com.pratikesh.project.uber.UberApp.dto.UserDTO;
import com.pratikesh.project.uber.UberApp.entities.Driver;
import com.pratikesh.project.uber.UberApp.entities.User;
import com.pratikesh.project.uber.UberApp.entities.enums.Role;
import com.pratikesh.project.uber.UberApp.exceptions.ResourceNotFoundException;
import com.pratikesh.project.uber.UberApp.exceptions.RuntimeConflictException;
import com.pratikesh.project.uber.UberApp.repositories.UserRepository;
import com.pratikesh.project.uber.UberApp.security.JWTService;
import com.pratikesh.project.uber.UberApp.services.AuthService;
import com.pratikesh.project.uber.UberApp.services.DriverService;
import com.pratikesh.project.uber.UberApp.services.RiderService;
import com.pratikesh.project.uber.UberApp.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.pratikesh.project.uber.UberApp.entities.enums.Role.DRIVER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @Override
    public String[] login(String email, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        User user = (User)authentication.getPrincipal();
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new String[]{accessToken, refreshToken};
    }

    @Override
    @Transactional
    public UserDTO signUp(SignUpDTO signUpDTO) {
        User user = userRepository.findByEmail(signUpDTO.getEmail()).orElse(null);
        if(user != null)
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+signUpDTO.getEmail());

        User mappedUser = modelMapper.map(signUpDTO, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        mappedUser.setPassword(passwordEncoder.encode(mappedUser.getPassword()));
        User savedUser = userRepository.save(mappedUser);

        //creating user related entities
        riderService.createNewRider(savedUser);
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public DriverDTO onBoardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id "+userId));

        if (user.getRoles().contains(DRIVER))
            throw new RuntimeException("User with id "+userId+ " is already a driver");

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();

        user.getRoles().add(DRIVER);
        userRepository.save(user);

        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDTO.class);
    }
}
