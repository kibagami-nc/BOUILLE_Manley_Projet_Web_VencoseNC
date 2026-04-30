package nc.kibagami_nc.vencosenc.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.BidDto;
import nc.kibagami_nc.vencosenc.entity.Bid;
import nc.kibagami_nc.vencosenc.mapper.BidMapper;
import nc.kibagami_nc.vencosenc.repository.BidRepository;

@RestController
@RequestMapping("/api/bid")
@RequiredArgsConstructor
public class BidController {

    private final BidRepository bidRepository;
    private final BidMapper bidMapper;

    /*
     * Utilisation du BidDto.java pour l'affichage, suppression, modification et création
     */

    @GetMapping
    public List<BidDto> findAll() {
        return bidRepository.findAll().stream().map(bidMapper::toDto).toList();
    }

    @PostMapping
    public BidDto create(@RequestBody BidDto dto) {

        Bid bid = bidMapper.toEntity(dto);
        bid.setCreationDate(LocalDateTime.now());

        return bidMapper.toDto(bidRepository.save(bid));
    }

    @GetMapping("/{id}")
    public BidDto findById(@PathVariable Long id) {
        return bidMapper.toDto(bidRepository.findById(id).orElseThrow());
    }

    @PutMapping("/{id}")
    public BidDto update(@PathVariable Long id, @RequestBody BidDto dto) {

        Bid bid = bidRepository.findById(id).orElseThrow();
        bidMapper.updateEntity(bid, dto);

        return bidMapper.toDto(bidRepository.save(bid));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bidRepository.deleteById(id);
    }
}
