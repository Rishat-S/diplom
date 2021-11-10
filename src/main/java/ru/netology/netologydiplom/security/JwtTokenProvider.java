package ru.netology.netologydiplom.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.netology.netologydiplom.entity.TokenBlacklist;
import ru.netology.netologydiplom.entity.User;
import ru.netology.netologydiplom.exceptions.JwtAuthenticationException;
import ru.netology.netologydiplom.repository.TokenBlacklistRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    public static final Logger LOG = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Autowired
    private TokenBlacklistRepository tokenBlacklistRepository;

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime() + SecurityConstants.EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("id", userId);
        claimsMap.put("username", user.getUsername());
        claimsMap.put("firstname", user.getFirstName());
        claimsMap.put("lastname", user.getLastName());

        return Jwts.builder()
                .setSubject(userId)
                .addClaims(claimsMap)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        if (tokenBlacklistRepository.existsById(token)) throw new JwtAuthenticationException("Forbidden token.");
        try {
            Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException |
                UnsupportedJwtException | IllegalArgumentException e) {
            LOG.error(e.getMessage());
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();
        String id = (String) claims.get("id");
        return Long.parseLong(id);
    }

    public void addTokenToBlacklist(String bearToken) {
        var forbiddenToken = new TokenBlacklist();
        forbiddenToken.setToken(bearToken.split(" ")[1]);
        tokenBlacklistRepository.save(forbiddenToken);
    }

}
