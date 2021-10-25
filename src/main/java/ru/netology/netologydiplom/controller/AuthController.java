package ru.netology.netologydiplom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.netology.netologydiplom.payload.request.LoginRequest;
import ru.netology.netologydiplom.payload.request.SignupRequest;
import ru.netology.netologydiplom.payload.response.JwtTokenSuccessResponse;
import ru.netology.netologydiplom.payload.response.MessageResponse;
import ru.netology.netologydiplom.security.JwtTokenProvider;
import ru.netology.netologydiplom.security.SecurityConstants;
import ru.netology.netologydiplom.service.UserService;
import ru.netology.netologydiplom.validations.ResponseErrorValidation;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/cloud")
@PreAuthorize("permitAll()")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) {
            return errors;
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = SecurityConstants.TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtTokenSuccessResponse(true, jwt));

    }

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody SignupRequest signupRequest, BindingResult bindingResult) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) {
            return errors;
        }

        userService.createUser(signupRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }
}
