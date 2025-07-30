package arias.huapaya.digital.peru.money.track.presentation.controller.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arias.huapaya.digital.peru.money.track.presentation.dto.security.AuthenticationRequest;
import arias.huapaya.digital.peru.money.track.presentation.dto.security.AuthenticationResponse;
import arias.huapaya.digital.peru.money.track.service.security.AuthenticationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PreAuthorize("permitAll()")
    @PostMapping(path = "/authenticate")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = this.authenticationService.login(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("permitAll()")
    @PostMapping(path = "validate")
    public ResponseEntity<?> validate(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        Boolean validate = this.authenticationService.validateToken(request.get("jwt"));
        response.put("validate", validate ? "Valid" : "Invalid");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
