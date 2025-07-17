package arias.huapaya.digital.peru.money.track.presentation.dto.category;

import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import arias.huapaya.digital.peru.money.track.persistence.enums.TypeMovementEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryCreateDTO {

    @Enumerated(EnumType.STRING)
    private TypeMovementEnum type;

    private String description;

    private UserEntity user;

}
