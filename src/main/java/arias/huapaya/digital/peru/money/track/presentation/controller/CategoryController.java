package arias.huapaya.digital.peru.money.track.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryPaginationDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryUpdateDTO;
import arias.huapaya.digital.peru.money.track.service.CategoryService;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryCreateDTO category) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.categoryService.create(category));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody CategoryUpdateDTO category) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.categoryService.update(category));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "user/{id}")
    public ResponseEntity<?> findAll(@PathVariable Long id) {
        List<CategoryFindAllDTO> categories = this.categoryService.findAll(id);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        CategoryFindOneDTO category = this.categoryService.findOne(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping(path = "pagination/{id}")
    public ResponseEntity<?> pagination(@PathVariable Long id, @RequestParam(required = false) String search,
            Pageable pageable) {
        PageDTO<CategoryPaginationDTO> categoriesPage = null;
        categoriesPage = this.categoryService.paginationSearch(id, search, pageable);
        return new ResponseEntity<>(categoriesPage, HttpStatus.OK);
    }

}
