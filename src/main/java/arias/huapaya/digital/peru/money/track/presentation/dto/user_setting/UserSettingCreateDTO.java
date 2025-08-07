package arias.huapaya.digital.peru.money.track.presentation.dto.user_setting;

import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSettingCreateDTO {

    private UserEntity user;

    private String language;

    private String currency;

    private String theme;

    private Boolean notifications;

}
