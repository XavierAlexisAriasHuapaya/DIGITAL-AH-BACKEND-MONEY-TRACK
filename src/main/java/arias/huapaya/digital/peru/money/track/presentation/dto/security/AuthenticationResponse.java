package arias.huapaya.digital.peru.money.track.presentation.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationResponse {

    private String username;

    private String jwt;

}
