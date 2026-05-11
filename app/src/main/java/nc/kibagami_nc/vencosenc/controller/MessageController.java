package nc.kibagami_nc.vencosenc.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.MessageDto;
import nc.kibagami_nc.vencosenc.entity.Message;
import nc.kibagami_nc.vencosenc.mapper.MessageMapper;
import nc.kibagami_nc.vencosenc.repository.MessageRepository;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    // POST /api/message -> envoie un nouveau message (date auto)
    @PostMapping
    public MessageDto create(@RequestBody MessageDto dto) {

        Message message = messageMapper.toEntity(dto);
        message.setSentAt(LocalDateTime.now());

        return messageMapper.toDto(messageRepository.save(message));
    }
}
