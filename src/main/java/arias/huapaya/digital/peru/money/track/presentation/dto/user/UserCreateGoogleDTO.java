package arias.huapaya.digital.peru.money.track.presentation.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateGoogleDTO {

    private String provider;

    private String providerId;

    private String email;

    private String username;

    private String password;

}
