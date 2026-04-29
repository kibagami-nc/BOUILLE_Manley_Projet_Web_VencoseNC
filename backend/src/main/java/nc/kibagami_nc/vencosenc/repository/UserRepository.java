package nc.kibagami_nc.vencosenc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nc.kibagami_nc.vencosenc.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
