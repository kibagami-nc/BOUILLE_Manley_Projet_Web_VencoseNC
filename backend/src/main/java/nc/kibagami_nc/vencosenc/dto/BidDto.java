package nc.kibagami_nc.vencosenc.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import nc.kibagami_nc.vencosenc.entity.Bid;

@Getter
@Setter
public class BidDto {

    private Long idBid;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Long userId;

    public static BidDto fromEntity(Bid bid) {

        BidDto dto = new BidDto();
        dto.setIdBid(bid.getIdBid());
        dto.setTitle(bid.getTitle());
        dto.setDescription(bid.getDescription());
        dto.setCreationDate(bid.getCreationDate());
        dto.setUserId(bid.getUser() != null ? bid.getUser().getIdUser() : null);

        return dto;
    }
}
