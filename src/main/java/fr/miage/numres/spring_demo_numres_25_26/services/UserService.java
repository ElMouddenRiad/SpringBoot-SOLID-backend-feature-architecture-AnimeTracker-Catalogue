package fr.miage.numres.spring_demo_numres_25_26.services;

import fr.miage.numres.spring_demo_numres_25_26.dtos.UserCreateDTO;
import fr.miage.numres.spring_demo_numres_25_26.dtos.UserResponseDTO;
import fr.miage.numres.spring_demo_numres_25_26.dtos.UserUpdateDTO;
import fr.miage.numres.spring_demo_numres_25_26.entities.User;

import java.util.List;

public interface UserService {

    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    User saveUser(UserCreateDTO userDTO);
    User updateUser(UserUpdateDTO userDTO);
    void deleteUserById(Long id);
}
