package nc.kibagami_nc.vencosenc.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreadDto {

    private Long idThread;
    private String title;
    private Long bidId;

    // Infos sur l'autre participant (calcule cote backend pour eviter au front de devoir filtrer)
    private Long peerId;
    private String peerFirstName;
    private String peerLastName;

    // Infos sur le dernier message du thread (pour la previsualisation dans la liste)
    private String lastMessage;
    private LocalDateTime lastMessageAt;
}
