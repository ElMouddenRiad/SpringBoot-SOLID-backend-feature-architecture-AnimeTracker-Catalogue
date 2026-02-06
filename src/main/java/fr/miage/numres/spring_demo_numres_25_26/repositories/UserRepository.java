package fr.miage.numres.spring_demo_numres_25_26.repositories;

import fr.miage.numres.spring_demo_numres_25_26.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
