package arias.huapaya.digital.peru.money.track.presentation.dto.user;

import arias.huapaya.digital.peru.money.track.persistence.entity.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFindOneDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private CountryEntity country;

    private String email;

    private String username;

    private Boolean enabled;

}
