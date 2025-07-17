package arias.huapaya.digital.peru.money.track.presentation.dto.user;

import arias.huapaya.digital.peru.money.track.persistence.entity.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

    private String firstName;

    private String lastName;

    private CountryEntity country;

    private String email;

    private String username;

    private String password;

}
