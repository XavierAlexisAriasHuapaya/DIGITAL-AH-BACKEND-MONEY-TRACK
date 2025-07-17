package arias.huapaya.digital.peru.money.track.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryPaginationDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryUpdateDTO;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;

public interface CategoryImpl {

    String create(CategoryCreateDTO category);

    String update(CategoryUpdateDTO category);

    List<CategoryFindAllDTO> findAll(Long userId);

    PageDTO<CategoryPaginationDTO> pagination(Long userId, Pageable pageable);

    PageDTO<CategoryPaginationDTO> paginationSearch(Long userId, String search, Pageable pageable);

    CategoryFindOneDTO findOne(Long id);
}
