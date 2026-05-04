package nc.kibagami_nc.vencosenc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nc.kibagami_nc.vencosenc.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // recherche un utilisateur par son email
    Optional<User> findByEmail(String email);
}
