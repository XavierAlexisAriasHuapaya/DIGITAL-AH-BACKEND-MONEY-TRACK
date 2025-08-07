package arias.huapaya.digital.peru.money.track.presentation.dto.user_setting;

import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserFindOneDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSettingFindByUserDTO {

    private Long id;

    private UserFindOneDTO user;

    private String language;

    private String currency;

    private String theme;

    private Boolean notifications;

}
