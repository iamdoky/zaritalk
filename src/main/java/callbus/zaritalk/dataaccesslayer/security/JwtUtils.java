package callbus.zaritalk.dataaccesslayer.security;

import callbus.zaritalk.dataaccesslayer.entity.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class JwtUtils {

    private static final String JWT_SECRET = "secret";

    public static final int JWT_EXPIRATION_MS = 86_400_000;

    public String generateJwtToken(UserDetailsImpl userPrincipal) {
        return Jwts.builder()
                .setHeaderParam("typ", Header.JWT_TYPE)
                .claim("email", userPrincipal.getEmail())
                .claim("phone_number", userPrincipal.getPhoneNumber())
                .claim("nickname", userPrincipal.getUsername())
                .claim("jti", UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plusMillis(JWT_EXPIRATION_MS)))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET.getBytes())
                .compact();
    }

    public String getEmailFromJwtToken(String token) {
        return (String) Jwts.parser().setSigningKey(JWT_SECRET.getBytes()).parseClaimsJws(token).getBody().get("email");
    }

    public String getTypeFromJwtToken(String token) {
        return (String) Jwts.parser().setSigningKey(JWT_SECRET.getBytes()).parseClaimsJws(token).getBody().get("type");
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET.getBytes()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}