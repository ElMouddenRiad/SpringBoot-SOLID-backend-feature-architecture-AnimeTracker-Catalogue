package fr.miage.numres.spring_demo_numres_25_26.mappers;

import fr.miage.numres.spring_demo_numres_25_26.dtos.UserCreateDTO;
import fr.miage.numres.spring_demo_numres_25_26.dtos.UserResponseDTO;
import fr.miage.numres.spring_demo_numres_25_26.dtos.UserUpdateDTO;
import fr.miage.numres.spring_demo_numres_25_26.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDTOToUserEntity(UserCreateDTO userDTO);
    List<User> userCreateDTOListToUserEntityList(List<UserCreateDTO> userDTOSList);

    User userDTOToUserEntity(UserUpdateDTO userDTO);
    List<User> userUpdateDTOListToUserEntityList(List<UserUpdateDTO> userDTOSList);

    UserResponseDTO userEntityToUserDTO(User user);
    List<UserResponseDTO> userEntityListToUserDTOList(List<User> userList);
}
