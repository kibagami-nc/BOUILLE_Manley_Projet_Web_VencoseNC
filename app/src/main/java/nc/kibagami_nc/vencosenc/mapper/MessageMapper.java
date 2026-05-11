package nc.kibagami_nc.vencosenc.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.MessageDto;
import nc.kibagami_nc.vencosenc.entity.Message;
import nc.kibagami_nc.vencosenc.entity.Thread;
import nc.kibagami_nc.vencosenc.entity.User;
import nc.kibagami_nc.vencosenc.repository.ThreadRepository;
import nc.kibagami_nc.vencosenc.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class MessageMapper {

    private final UserRepository userRepository;
    private final ThreadRepository threadRepository;

    public MessageDto toDto(Message message) {

        if (message == null) return null;

        MessageDto dto = new MessageDto();
        dto.setIdMessage(message.getIdMessage());
        dto.setContent(message.getContent());
        dto.setSentAt(message.getSentAt());
        dto.setThreadId(message.getThread() != null ? message.getThread().getIdThread() : null);

        User user = message.getUser();
        if (user != null) {
            dto.setUserId(user.getIdUser());
            dto.setUserFirstName(user.getFirstName());
            dto.setUserLastName(user.getLastName());
        }

        return dto;
    }

    public Message toEntity(MessageDto dto) {

        if (dto == null) return null;

        Message message = new Message();
        message.setIdMessage(dto.getIdMessage());
        message.setContent(dto.getContent());
        message.setSentAt(dto.getSentAt());

        if (dto.getThreadId() != null) {
            Thread thread = threadRepository.findById(dto.getThreadId()).orElseThrow();
            message.setThread(thread);
        }

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElseThrow();
            message.setUser(user);
        }

        return message;
    }
}
