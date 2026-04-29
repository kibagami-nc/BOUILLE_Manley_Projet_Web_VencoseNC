package nc.kibagami_nc.vencosenc.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.BidDto;
import nc.kibagami_nc.vencosenc.entity.Bid;
import nc.kibagami_nc.vencosenc.entity.User;
import nc.kibagami_nc.vencosenc.repository.BidRepository;
import nc.kibagami_nc.vencosenc.repository.UserRepository;

@RestController
@RequestMapping("/api/bid")
@RequiredArgsConstructor
public class BidController {

    private final BidRepository bidRepository;
    private final UserRepository userRepository;

    /*
     * Utilisation du BidDto.java pour l'affichage, suppression, modification et création
     */

    //TODO: Faire le mapper pour soulager le controller

    @GetMapping
    public List<BidDto> findAll() {
        return bidRepository.findAll().stream().map(BidDto::fromEntity).toList();
    }

    @GetMapping("/{id}")
    public BidDto findById(@PathVariable Long id) {
        return BidDto.fromEntity(bidRepository.findById(id).orElseThrow());
    }

    @PostMapping
    public BidDto create(@RequestBody BidDto dto) {

        Bid bid = new Bid();

        bid.setTitle(dto.getTitle());
        bid.setDescription(dto.getDescription());
        bid.setCreationDate(LocalDateTime.now());
        User user = userRepository.findById(dto.getUserId()).orElseThrow();

        bid.setUser(user);

        return BidDto.fromEntity(bidRepository.save(bid));
    }

    @PutMapping("/{id}")
    public BidDto update(@PathVariable Long id, @RequestBody BidDto dto) {
        Bid bid = bidRepository.findById(id).orElseThrow();
        bid.setTitle(dto.getTitle());
        bid.setDescription(dto.getDescription());

        return BidDto.fromEntity(bidRepository.save(bid));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bidRepository.deleteById(id);
    }
}
