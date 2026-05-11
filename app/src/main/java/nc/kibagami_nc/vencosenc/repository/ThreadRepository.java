package nc.kibagami_nc.vencosenc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nc.kibagami_nc.vencosenc.entity.Thread;

public interface ThreadRepository extends JpaRepository<Thread, Long> {

    // Renvoie tous les threads dans lesquels l'utilisateur est inscrit
    @Query("SELECT t FROM Thread t JOIN t.users u WHERE u.idUser = :userId")
    List<Thread> findByUserId(@Param("userId") Long userId);
}
