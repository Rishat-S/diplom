package ru.netology.netologydiplom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.netology.netologydiplom.payload.request.LoginRequest;
import ru.netology.netologydiplom.payload.response.JwtTokenSuccessResponse;
import ru.netology.netologydiplom.payload.response.MessageResponse;
import ru.netology.netologydiplom.repository.TokenBlacklistRepository;
import ru.netology.netologydiplom.security.JwtTokenProvider;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/cloud")
@PreAuthorize("permitAll()")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, TokenBlacklistRepository tokenBlacklistRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;

    }

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getLogin(),
                loginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtTokenSuccessResponse(jwt));
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logoutUser(@RequestHeader("auth-token") String bearerToken) {
        jwtTokenProvider.addTokenToBlacklist(bearerToken);
        return ResponseEntity.ok(new MessageResponse("User logout successfully"));
    }
}
