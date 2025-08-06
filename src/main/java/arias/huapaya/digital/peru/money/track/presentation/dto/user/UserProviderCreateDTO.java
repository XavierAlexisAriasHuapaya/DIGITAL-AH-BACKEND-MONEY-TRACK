package arias.huapaya.digital.peru.money.track.presentation.dto.user;

import arias.huapaya.digital.peru.money.track.persistence.enums.AuthProviderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProviderCreateDTO {

    private UserCreateDTO user;

    private AuthProviderEnum authProvider;

    private String providerUserId;

    private String accessToken;

}
