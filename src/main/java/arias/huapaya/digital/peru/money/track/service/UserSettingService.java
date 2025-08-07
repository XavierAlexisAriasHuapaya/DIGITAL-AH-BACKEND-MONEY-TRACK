package arias.huapaya.digital.peru.money.track.service;

import org.springframework.stereotype.Service;
import arias.huapaya.digital.peru.money.track.interfaces.UserSettingImpl;
import arias.huapaya.digital.peru.money.track.persistence.entity.UserSettingEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.UserSettingRepository;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingFindByUserDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingUpdateDTO;
import arias.huapaya.digital.peru.money.track.util.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserSettingService implements UserSettingImpl {

    private final UserSettingRepository userSettingRepository;

    @Override
    public String create(UserSettingCreateDTO setting) {
        UserSettingEntity userSetting = UserSettingEntity.builder()
                .user(setting.getUser())
                .language(setting.getLanguage())
                .currency(setting.getCurrency())
                .theme(setting.getTheme())
                .notifications(setting.getNotifications())
                .build();
        this.userSettingRepository.save(userSetting);
        return "Successfully Created";
    }

    @Override
    public String update(UserSettingUpdateDTO setting) {
        UserSettingEntity userSettingOne = userSettingRepository.findById(setting.getId())
                .orElseThrow(() -> new ObjectNotFoundException("User setting not found"));

        userSettingOne.setId(setting.getId());
        userSettingOne.setLanguage(setting.getLanguage());
        userSettingOne.setCurrency(setting.getCurrency());
        userSettingOne.setTheme(setting.getTheme());
        userSettingOne.setNotifications(setting.getNotifications());

        this.userSettingRepository.save(userSettingOne);
        return "Successfully Updated";
    }

    @Override
    public UserSettingFindByUserDTO findByUserId(Long userId) {
        UserSettingEntity userSettingOne = this.userSettingRepository.findByUserId(userId);

        UserFindOneDTO userOne = UserFindOneDTO.builder()
                .id(userSettingOne.getUser().getId())
                .firstName(userSettingOne.getUser().getFirstName())
                .lastName(userSettingOne.getUser().getLastName())
                .country(userSettingOne.getUser().getCountry())
                .email(userSettingOne.getUser().getEmail())
                .username(userSettingOne.getUser().getUsername())
                .enabled(userSettingOne.getUser().getEnabled())
                .build();

        UserSettingFindByUserDTO dtos = UserSettingFindByUserDTO.builder()
                .id(userSettingOne.getId())
                .user(userOne)
                .language(userSettingOne.getLanguage())
                .currency(userSettingOne.getCurrency())
                .theme(userSettingOne.getTheme())
                .notifications(userSettingOne.getNotifications())
                .build();
        return dtos;
    }

}
