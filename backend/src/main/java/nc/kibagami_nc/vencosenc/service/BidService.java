package nc.kibagami_nc.vencosenc.service;

import java.util.List;

import nc.kibagami_nc.vencosenc.dto.BidDto;

public interface BidService {

    List<BidDto> findAll();

    BidDto findById(Long id);

    BidDto create(BidDto dto);

    BidDto update(Long id, BidDto dto);

    void delete(Long id);
}
