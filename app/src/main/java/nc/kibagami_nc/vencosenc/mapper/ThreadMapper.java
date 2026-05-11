package nc.kibagami_nc.vencosenc.mapper;

import java.util.Comparator;
import java.util.Set;

import org.springframework.stereotype.Component;

import nc.kibagami_nc.vencosenc.dto.ThreadDto;
import nc.kibagami_nc.vencosenc.entity.Message;
import nc.kibagami_nc.vencosenc.entity.Thread;
import nc.kibagami_nc.vencosenc.entity.User;

@Component
public class ThreadMapper {

    // Convertit un Thread en DTO en se placant du point de vue de currentUserId
    // (le "peer" est l'autre participant du thread)
    public ThreadDto toDto(Thread thread, Long currentUserId) {

        if (thread == null) return null;

        ThreadDto dto = new ThreadDto();
        dto.setIdThread(thread.getIdThread());
        dto.setTitle(thread.getTitle());
        dto.setBidId(thread.getBid() != null ? thread.getBid().getIdBid() : null);

        // Trouve l'autre participant (premier user qui n'est pas currentUser)
        Set<User> users = thread.getUsers();
        if (users != null) {
            users.stream()
                .filter(u -> !u.getIdUser().equals(currentUserId))
                .findFirst()
                .ifPresent(peer -> {
                    dto.setPeerId(peer.getIdUser());
                    dto.setPeerFirstName(peer.getFirstName());
                    dto.setPeerLastName(peer.getLastName());
                });
        }

        // Recupere le dernier message (le plus recent par sentAt, puis par idMessage en cas d'egalite).
        // Le tiebreak via idMessage assure qu'on prend toujours le message le plus recemment insere
        // meme si plusieurs ont le meme timestamp.
        Set<Message> messages = thread.getMessages();
        if (messages != null && !messages.isEmpty()) {
            messages.stream()
                .filter(m -> m.getSentAt() != null)
                .max(Comparator.comparing(Message::getSentAt)
                    .thenComparing(Message::getIdMessage))
                .ifPresent(last -> {
                    dto.setLastMessage(last.getContent());
                    dto.setLastMessageAt(last.getSentAt());
                });
        }

        return dto;
    }
}
