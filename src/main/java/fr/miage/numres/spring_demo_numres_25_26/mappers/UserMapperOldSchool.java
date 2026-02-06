package fr.miage.numres.spring_demo_numres_25_26.mappers;

import fr.miage.numres.spring_demo_numres_25_26.dtos.UserResponseDTO;
import fr.miage.numres.spring_demo_numres_25_26.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperOldSchool {

    public User userDTOToUserEntity(UserResponseDTO userDTO)
    {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .build();
    }

    public UserResponseDTO userEntityToUserDTO(User user)
    {
        return UserResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
