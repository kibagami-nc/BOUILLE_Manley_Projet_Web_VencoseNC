package nc.kibagami_nc.vencosenc.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_mobile", length = 20)
    private String phoneMobile;

    @Column(name = "phone_landline", length = 20)
    private String phoneLandline;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "user")
    private Set<Bid> bids;

    @OneToMany(mappedBy = "user")
    private Set<Message> messages;

    @ManyToMany
    @JoinTable(
        name = "users_threads",
        joinColumns = @JoinColumn(name = "fk_id_user"),
        inverseJoinColumns = @JoinColumn(name = "fk_id_thread")
    )
    private Set<Thread> threads;

    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "fk_id_user"),
        inverseJoinColumns = @JoinColumn(name = "fk_id_role")
    )
    private Set<Role> roles;
}
