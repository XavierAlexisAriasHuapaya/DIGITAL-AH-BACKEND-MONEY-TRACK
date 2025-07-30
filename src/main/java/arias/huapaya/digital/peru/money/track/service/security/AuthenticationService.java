package arias.huapaya.digital.peru.money.track.service.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.UserRepository;
import arias.huapaya.digital.peru.money.track.presentation.dto.security.AuthenticationRequest;
import arias.huapaya.digital.peru.money.track.presentation.dto.security.AuthenticationResponse;
import arias.huapaya.digital.peru.money.track.util.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private Map<String, Object> generateExtraClaims(UserEntity userEntity) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", userEntity.getAuthorities());
        return claims;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        AuthenticationResponse response = new AuthenticationResponse();
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword());
        this.authenticationManager.authenticate(authentication);
        UserEntity userEntity = this.userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ObjectNotFoundException("User not found: " + request.getUsername()));
        String jwt = this.jwtService.generateToken(userEntity, this.generateExtraClaims(userEntity));
        response.setUsername(request.getUsername());
        response.setJwt(jwt);
        return response;
    }

    public Boolean validateToken(String jwt) {
        try {
            this.jwtService.extractUsername(jwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
