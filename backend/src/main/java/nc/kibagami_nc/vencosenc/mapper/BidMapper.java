package nc.kibagami_nc.vencosenc.mapper;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.BidDto;
import nc.kibagami_nc.vencosenc.entity.Bid;
import nc.kibagami_nc.vencosenc.entity.User;
import nc.kibagami_nc.vencosenc.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class BidMapper {

    // Sert a retrouver le User a partir du userId du DTO
    private final UserRepository userRepository;

    // Entite -> DTO (garde juste le userId pour eviter d'envoyer tout le User)
    public BidDto toDto(Bid bid) {

        if (bid == null) return null;

        BidDto dto = new BidDto();
        dto.setIdBid(bid.getIdBid());
        dto.setTitle(bid.getTitle());
        dto.setDescription(bid.getDescription());
        dto.setCreationDate(bid.getCreationDate());
        dto.setUserId(bid.getUser() != null ? bid.getUser().getIdUser() : null);

        return dto;
    }

    // Dto -> entite (va chercher le vrai User en BDD avec le userId)
    public Bid toEntity(BidDto dto) {

        if (dto == null) return null;

        Bid bid = new Bid();
        bid.setIdBid(dto.getIdBid());
        bid.setTitle(dto.getTitle());
        bid.setDescription(dto.getDescription());
        bid.setCreationDate(dto.getCreationDate());

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId()).orElseThrow();
            bid.setUser(user);
        }

        return bid;
    }

    // Maj d'une bid existante (juste le titre et la description)
    public void updateEntity(Bid bid, BidDto dto) {

        bid.setTitle(dto.getTitle());
        bid.setDescription(dto.getDescription());
    }
}
