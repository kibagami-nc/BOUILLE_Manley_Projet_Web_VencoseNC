package nc.kibagami_nc.vencosenc.service;

import java.util.List;

import nc.kibagami_nc.vencosenc.dto.BidDto;

public interface BidService {

    // Renvoie toutes les annonces
    List<BidDto> findAll();

    // Renvoie une annonce par son id
    BidDto findById(Long id);

    // Cree une nouvelle annonce
    BidDto create(BidDto dto);

    // Modifie une annonce existante
    BidDto update(Long id, BidDto dto);

    // Supprime une annonce par son id
    void delete(Long id);
}
