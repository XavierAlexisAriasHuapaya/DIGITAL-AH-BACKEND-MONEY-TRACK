package arias.huapaya.digital.peru.money.track.presentation.dto.category;

import java.time.LocalDateTime;

import arias.huapaya.digital.peru.money.track.persistence.entity.CategoryEntity;
import arias.huapaya.digital.peru.money.track.persistence.enums.TypeMovementEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CategoryPaginationDTO {

    private Long id;

    private TypeMovementEnum type;

    private String description;

    private LocalDateTime createdAt;

    private Boolean enabled;

    public CategoryPaginationDTO(CategoryEntity categoryEntity) {
        this.id = categoryEntity.getId();
        this.type = categoryEntity.getType();
        this.description = categoryEntity.getDescription();
        this.createdAt = categoryEntity.getCreatedAt();
        this.enabled = categoryEntity.getEnabled();
    }

}
