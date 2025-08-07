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

import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingFindByUserDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingUpdateDTO;
import arias.huapaya.digital.peru.money.track.service.UserSettingService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "user-setting")
@AllArgsConstructor
public class UserSettingController {

    private final UserSettingService userSettingService;

    @PreAuthorize("hasAuthority('USER_SETTING_CREATE')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserSettingCreateDTO setting) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.userSettingService.create(setting));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER_SETTING_UPDATE')")
    @PatchMapping
    public ResponseEntity<?> update(@RequestBody UserSettingUpdateDTO setting) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.userSettingService.update(setting));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('USER_SETTING_FIND_ALL_BY_USER')")
    @GetMapping(path = "user/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable Long userId) {
        UserSettingFindByUserDTO userSettingEntities = this.userSettingService
                .findByUserId(userId);
        return new ResponseEntity<>(userSettingEntities, HttpStatus.OK);
    }

}
