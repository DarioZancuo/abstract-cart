package com.ecommerce.cart.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
    private static final String SECRET = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET)))
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET))).build()
                .parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean isTokenValid(String token, UserDetails user) {
        return extractUsername(token).equals(user.getUsername());
    }
}