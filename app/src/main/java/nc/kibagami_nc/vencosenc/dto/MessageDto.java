package nc.kibagami_nc.vencosenc.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {

    private Long idMessage;
    private String content;
    private LocalDateTime sentAt;
    private Long threadId;
    private Long userId;
    private String userFirstName;
    private String userLastName;
}
