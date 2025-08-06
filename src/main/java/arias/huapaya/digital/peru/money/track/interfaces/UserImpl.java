package arias.huapaya.digital.peru.money.track.interfaces;

import java.util.Optional;

import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserCreateGoogleDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserProviderCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserUpdateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserUpdatePasswordDTO;

public interface UserImpl {

    String create(UserCreateDTO user);

    String update(UserUpdateDTO user);

    UserFindOneDTO findOne(Long id);

    String updatePassword(UserUpdatePasswordDTO user);

    String create(UserCreateGoogleDTO user);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    String createUserAndProvider(UserProviderCreateDTO userProvider);

}
