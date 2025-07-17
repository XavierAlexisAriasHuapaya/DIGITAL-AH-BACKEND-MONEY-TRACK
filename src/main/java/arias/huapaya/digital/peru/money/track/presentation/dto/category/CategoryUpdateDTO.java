package arias.huapaya.digital.peru.money.track.presentation.dto.category;

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
public class CategoryUpdateDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeMovementEnum type;

    private String description;

}
