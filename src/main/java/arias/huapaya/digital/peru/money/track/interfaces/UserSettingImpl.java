package arias.huapaya.digital.peru.money.track.interfaces;

import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingFindByUserDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user_setting.UserSettingUpdateDTO;

public interface UserSettingImpl {

    String create(UserSettingCreateDTO setting);

    String update(UserSettingUpdateDTO setting);

    UserSettingFindByUserDTO findByUserId(Long userId);
}
