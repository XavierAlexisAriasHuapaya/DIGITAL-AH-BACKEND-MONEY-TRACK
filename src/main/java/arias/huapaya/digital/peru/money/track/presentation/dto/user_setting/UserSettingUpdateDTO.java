package arias.huapaya.digital.peru.money.track.presentation.dto.user_setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSettingUpdateDTO {

    private Long id;

    private String language;

    private String currency;

    private String theme;

    private Boolean notifications;

}
