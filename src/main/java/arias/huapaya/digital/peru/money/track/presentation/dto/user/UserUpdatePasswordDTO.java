package arias.huapaya.digital.peru.money.track.presentation.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePasswordDTO {

    private Long id;

    private String password;

    private String newPassword;

    private String confirmPassword;

}
