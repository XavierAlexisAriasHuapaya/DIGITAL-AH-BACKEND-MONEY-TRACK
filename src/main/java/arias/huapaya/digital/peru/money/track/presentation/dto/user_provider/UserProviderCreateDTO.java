package arias.huapaya.digital.peru.money.track.presentation.dto.user_provider;

import arias.huapaya.digital.peru.money.track.persistence.enums.AuthProviderEnum;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserCreateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProviderCreateDTO {

    UserCreateDTO user;

    private AuthProviderEnum authProvider;

    private String providerUserId;

    private String accessToken;

}
