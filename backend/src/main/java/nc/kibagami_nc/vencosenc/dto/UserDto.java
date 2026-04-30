package nc.kibagami_nc.vencosenc.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long idUser;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneMobile;
    private String phoneLandline;
    private String password;
    private LocalDateTime registrationDate;
    private Boolean isActive;
}
