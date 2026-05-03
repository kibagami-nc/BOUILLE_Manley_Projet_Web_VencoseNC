package nc.kibagami_nc.vencosenc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.BidDto;
import nc.kibagami_nc.vencosenc.entity.Bid;
import nc.kibagami_nc.vencosenc.mapper.BidMapper;
import nc.kibagami_nc.vencosenc.repository.BidRepository;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final BidMapper bidMapper;

    // Recupere toutes les annonces et les renvoie en DTO
    @Override
    public List<BidDto> findAll() {
        return bidRepository.findAll().stream().map(bidMapper::toDto).toList();
    }

    // Cherche une annonce par son id (exception si elle n'existe pas)
    @Override
    public BidDto findById(Long id) {
        return bidMapper.toDto(bidRepository.findById(id).orElseThrow());
    }

    // Cree une annonce et fixe la date de creation a maintenant
    @Override
    public BidDto create(BidDto dto) {

        Bid bid = bidMapper.toEntity(dto);
        bid.setCreationDate(LocalDateTime.now());

        return bidMapper.toDto(bidRepository.save(bid));
    }

    // Recupere une annonce existante et met a jour ses champs
    @Override
    public BidDto update(Long id, BidDto dto) {

        Bid bid = bidRepository.findById(id).orElseThrow();
        bidMapper.updateEntity(bid, dto);

        return bidMapper.toDto(bidRepository.save(bid));
    }

    // Supprime une annonce par son id
    @Override
    public void delete(Long id) {
        bidRepository.deleteById(id);
    }
}
