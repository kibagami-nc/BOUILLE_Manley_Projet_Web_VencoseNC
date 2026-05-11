package nc.kibagami_nc.vencosenc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.MessageDto;
import nc.kibagami_nc.vencosenc.dto.ThreadDto;
import nc.kibagami_nc.vencosenc.mapper.MessageMapper;
import nc.kibagami_nc.vencosenc.mapper.ThreadMapper;
import nc.kibagami_nc.vencosenc.repository.MessageRepository;
import nc.kibagami_nc.vencosenc.repository.ThreadRepository;

@RestController
@RequestMapping("/api/thread")
@RequiredArgsConstructor
public class ThreadController {

    private final ThreadRepository threadRepository;
    private final MessageRepository messageRepository;
    private final ThreadMapper threadMapper;
    private final MessageMapper messageMapper;

    // GET /api/thread/user/{userId} -> tous les threads dont l'utilisateur fait partie
    @GetMapping("/user/{userId}")
    public List<ThreadDto> findByUser(@PathVariable Long userId) {
        return threadRepository.findByUserId(userId).stream()
                .map(t -> threadMapper.toDto(t, userId))
                .toList();
    }

    // GET /api/thread/{id}/messages -> tous les messages d'un thread tries chronologiquement
    @GetMapping("/{id}/messages")
    public List<MessageDto> findMessages(@PathVariable Long id) {
        return messageRepository.findByThread_IdThreadOrderBySentAtAsc(id).stream()
                .map(messageMapper::toDto)
                .toList();
    }
}
