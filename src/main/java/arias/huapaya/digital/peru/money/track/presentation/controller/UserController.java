package arias.huapaya.digital.peru.money.track.presentation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserUpdateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserUpdatePasswordDTO;
import arias.huapaya.digital.peru.money.track.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateDTO user) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.userService.create(user));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER_UPDATE')")
    @PatchMapping
    public ResponseEntity<?> update(@RequestBody UserUpdateDTO user) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.userService.update(user));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER_UPDATE_PASSWORD')")
    @PatchMapping(path = "password")
    public ResponseEntity<?> updatePassword(@RequestBody UserUpdatePasswordDTO user) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.userService.updatePassword(user));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER_FIND_ONE')")
    @GetMapping(path = "{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        UserFindOneDTO user = this.userService.findOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
