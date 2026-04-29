package nc.kibagami_nc.vencosenc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nc.kibagami_nc.vencosenc.entity.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
