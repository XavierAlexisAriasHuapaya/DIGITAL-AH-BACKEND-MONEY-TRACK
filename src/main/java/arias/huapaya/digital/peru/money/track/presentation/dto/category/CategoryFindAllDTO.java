package arias.huapaya.digital.peru.money.track.presentation.dto.category;

import arias.huapaya.digital.peru.money.track.persistence.enums.TypeMovementEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryFindAllDTO {

    private Long id;

    private TypeMovementEnum type;

    private String description;

    private Boolean enabled;

}
