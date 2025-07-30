package arias.huapaya.digital.peru.money.track.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import arias.huapaya.digital.peru.money.track.interfaces.UserImpl;
import arias.huapaya.digital.peru.money.track.persistence.entity.RolEntity;
import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.UserRepository;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserUpdateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserUpdatePasswordDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserImpl {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public String create(UserCreateDTO user) {
        RolEntity rolEntity = RolEntity.builder()
                .id(2L)
                .build();
        UserEntity userEntity = UserEntity
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .country(user.getCountry())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .rol(rolEntity)
                .build();
        userRepository.save(userEntity);
        return "Successfully created";
    }

    @Override
    public String update(UserUpdateDTO user) {
        Optional<UserEntity> userOpt = userRepository.findById(user.getId());
        if (!userOpt.isPresent()) {
            return "User not found";
        }
        UserEntity userEntity = userOpt.get();
        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setCountry(user.getCountry());

        userRepository.save(userEntity);
        return "Successfully updated";
    }

    @Override
    public UserFindOneDTO findOne(Long id) {
        Optional<UserEntity> userOpt = this.userRepository.findById(id);
        if (!userOpt.isPresent()) {

        }
        return UserFindOneDTO.builder()
                .id(id)
                .firstName(userOpt.get().getFirstName())
                .lastName(userOpt.get().getLastName())
                .country(userOpt.get().getCountry())
                .email(userOpt.get().getEmail())
                .username(userOpt.get().getUsername())
                .enabled(userOpt.get().getEnabled())
                .build();
    }

    @Override
    public String updatePassword(UserUpdatePasswordDTO user) {
        Optional<UserEntity> userOpt = this.userRepository.findById(user.getId());
        if (!userOpt.isPresent()) {

        }
        UserEntity userEntity = userOpt.get();

        if (!this.passwordEncoder.matches(user.getPassword(), userEntity.getPassword())) {
            return "Password is incorrect";
        }
        if (!user.getNewPassword().equals(user.getConfirmPassword())) {
            return "New password and confirm password do not match";
        }
        userEntity.setPassword(this.passwordEncoder.encode(user.getNewPassword()));
        userRepository.save(userEntity);
        return "Successfully updated password";
    }

}
