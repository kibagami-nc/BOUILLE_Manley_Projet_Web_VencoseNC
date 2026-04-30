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

    /*
     * Injecte pour resoudre un userId (envoye par le front) en vraie entite User
     * lors du toEntity. Sans ca, JPA refuserait la sauvegarde puisque Bid.user est nullable=false.
     */
    private final UserRepository userRepository;

    /*
     * Sortie (BDD -> API) : convertit l'entite Bid lue en BDD en BidDto a renvoyer en JSON.
     * Particularite : la relation User est aplatie en simple userId pour eviter
     * de serialiser tout l'objet User imbrique (recursion, lazy-loading, payload enorme).
     */
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

    /*
     * Entree (API -> BDD) : construit une NOUVELLE entite Bid a partir du DTO recu du front.
     * Particularite : il faut resoudre le userId du DTO en vraie entite User via le repository.
     * Utilise dans create().
     */
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

    /*
     * Entree sur entite existante : modifie une entite Bid deja chargee depuis la BDD.
     * Tres restrictif volontairement : seuls title et description sont modifiables.
     * Regle metier : on ne veut pas qu'un PUT permette de changer le proprietaire (User)
     * ni de falsifier la date de creation.
     * Utilise dans update().
     */
    public void updateEntity(Bid bid, BidDto dto) {

        bid.setTitle(dto.getTitle());
        bid.setDescription(dto.getDescription());
    }
}
