package fr.miage.numres.spring_demo_numres_25_26.services;

import fr.miage.numres.spring_demo_numres_25_26.dtos.UserCreateDTO;
import fr.miage.numres.spring_demo_numres_25_26.dtos.UserResponseDTO;
import fr.miage.numres.spring_demo_numres_25_26.dtos.UserUpdateDTO;
import fr.miage.numres.spring_demo_numres_25_26.entities.User;
import fr.miage.numres.spring_demo_numres_25_26.mappers.UserMapper;
import fr.miage.numres.spring_demo_numres_25_26.mappers.UserMapperOldSchool;
import fr.miage.numres.spring_demo_numres_25_26.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null)
            return userMapper.userEntityToUserDTO(user);
        return null;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public User saveUser(UserCreateDTO userDTO) {
        return null;
    }

    @Override
    public User updateUser(UserUpdateDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
