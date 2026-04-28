package nc.kibagami_nc.vencosenc.entity;

import org.jspecify.annotations.Nullable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bids")
@Getter
@Setter
@NoArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bid")
    private Long idId;

    @Column(name = "title")
    private title;

    @Column(name = "description")
    private description;

    @Column(name = "creation_date")
    private creationDate;

    @Column(name = "fk_id_user")
    private fkIdUser;

}
