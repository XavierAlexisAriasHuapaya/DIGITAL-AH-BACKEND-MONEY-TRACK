package arias.huapaya.digital.peru.money.track.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import arias.huapaya.digital.peru.money.track.persistence.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    List<CategoryEntity> findAllByUserId(Long userId);

    Page<CategoryEntity> findAllByUserId(Long userId, Pageable pageable);

    Page<CategoryEntity> findByUserIdAndDescriptionContainingIgnoreCase(Long userId, String search, Pageable pageable);

}
