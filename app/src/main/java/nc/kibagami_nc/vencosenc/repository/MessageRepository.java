package nc.kibagami_nc.vencosenc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nc.kibagami_nc.vencosenc.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    // Tous les messages d'un thread, du plus ancien au plus recent
    List<Message> findByThread_IdThreadOrderBySentAtAsc(Long idThread);
}
