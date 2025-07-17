package arias.huapaya.digital.peru.money.track.presentation.dto.category;

import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import arias.huapaya.digital.peru.money.track.persistence.enums.TypeMovementEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CategoryFindOneDTO {

    private Long id;

    private TypeMovementEnum type;

    private String description;

    private UserEntity user;

}
