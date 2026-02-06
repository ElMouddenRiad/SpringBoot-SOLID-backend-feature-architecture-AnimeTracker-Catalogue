package fr.miage.numres.spring_demo_numres_25_26.controllers;

import fr.miage.numres.spring_demo_numres_25_26.dtos.UserResponseDTO;
import fr.miage.numres.spring_demo_numres_25_26.entities.User;
import fr.miage.numres.spring_demo_numres_25_26.repositories.UserRepository;
import fr.miage.numres.spring_demo_numres_25_26.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired // Facultatif
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }
}
