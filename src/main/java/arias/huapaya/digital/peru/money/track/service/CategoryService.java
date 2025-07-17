package arias.huapaya.digital.peru.money.track.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import arias.huapaya.digital.peru.money.track.interfaces.CategoryImpl;
import arias.huapaya.digital.peru.money.track.persistence.entity.CategoryEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.CategoryRepository;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryPaginationDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryUpdateDTO;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryService implements CategoryImpl {

    private final CategoryRepository categoryRepository;

    @Override
    public String create(CategoryCreateDTO category) {
        CategoryEntity categoryCreate = CategoryEntity.builder()
                .description(category.getDescription())
                .type(category.getType())
                .user(category.getUser())
                .build();
        this.categoryRepository.save(categoryCreate);
        return "Successfully created";
    }

    @Override
    public String update(CategoryUpdateDTO category) {
        Optional<CategoryEntity> categoryOpt = this.categoryRepository.findById(category.getId());
        if (!categoryOpt.isPresent()) {
            return "Category not found";
        }
        CategoryEntity categoryUpdate = CategoryEntity.builder()
                .id(category.getId())
                .description(category.getDescription())
                .type(category.getType())
                .user(categoryOpt.get().getUser())
                .enabled(categoryOpt.get().getEnabled())
                .build();
        this.categoryRepository.save(categoryUpdate);
        return "Successfully updated";
    }

    @Override
    public List<CategoryFindAllDTO> findAll(Long userId) {
        List<CategoryEntity> categories = this.categoryRepository.findAllByUserId(userId);
        List<CategoryFindAllDTO> listCategoriesDTO = new ArrayList<>();
        categories.forEach(category -> {
            CategoryFindAllDTO categoryFindAllDTO = CategoryFindAllDTO.builder()
                    .id(category.getId())
                    .description(category.getDescription())
                    .type(category.getType())
                    .enabled(category.getEnabled())
                    .build();
            listCategoriesDTO.add(categoryFindAllDTO);
        });
        return listCategoriesDTO;
    }

    @Override
    public PageDTO<CategoryPaginationDTO> pagination(Long userId, Pageable pageable) {
        Page<CategoryEntity> categoriesPage = this.categoryRepository.findAllByUserId(userId, pageable);
        List<CategoryPaginationDTO> categoriesList = categoriesPage.getContent()
                .stream()
                .map(category -> new CategoryPaginationDTO(category))
                .toList();
        return new PageDTO<>(categoriesList, categoriesPage.getNumber(), categoriesPage.getSize(),
                categoriesPage.getTotalElements());
    }

    @Override
    public CategoryFindOneDTO findOne(Long id) {
        Optional<CategoryEntity> categoryOpt = this.categoryRepository.findById(id);
        if (!categoryOpt.isPresent()) {
            return null;
        }
        return CategoryFindOneDTO.builder()
                .id(categoryOpt.get().getId())
                .description(categoryOpt.get().getDescription())
                .type(categoryOpt.get().getType())
                .user(categoryOpt.get().getUser())
                .build();
    }

    @Override
    public PageDTO<CategoryPaginationDTO> paginationSearch(Long userId, String search,
            Pageable pageable) {
        Page<CategoryEntity> categoriesPage = this.categoryRepository.findByUserIdAndDescriptionContainingIgnoreCase(userId, search, pageable);
        List<CategoryPaginationDTO> categoriesList = categoriesPage.getContent()
                .stream()
                .map(category -> new CategoryPaginationDTO(category))
                .toList();
        return new PageDTO<>(categoriesList, categoriesPage.getNumber(), categoriesPage.getSize(),
                categoriesPage.getTotalElements());
    }

}
