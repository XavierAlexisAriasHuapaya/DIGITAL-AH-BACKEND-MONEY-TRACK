package arias.huapaya.digital.peru.money.track.service.security;

import java.sql.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final int minute = 60;

    private final Date createdAt = new Date(System.currentTimeMillis());

    private final Date expired = new Date(createdAt.getTime() + (minute * 60 * 1000));

    public String generateToken(UserDetails userDetails, Map<String, Object> extraClaims) {
        String jwt = "";
        jwt = Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .subject(userDetails.getUsername())
                .issuedAt(createdAt)
                .expiration(expired)
                .claims(extraClaims)
                .signWith(this.generateKey(), Jwts.SIG.HS256)
                .compact();
        return jwt;
    }

    private SecretKey generateKey() {
        String secret = "secretkeyapplicationsecretkeyapplicationsecretkeyapplication";
        byte[] password = secret.getBytes();
        return Keys.hmacShaKeyFor(password);
    }

    private Claims extractClaim(String jwt) {
        return Jwts.parser().verifyWith(this.generateKey()).build().parseSignedClaims(jwt).getPayload();
    }

    public String extractUsername(String token) {
        return this.extractClaim(token).getSubject();
    }

}
