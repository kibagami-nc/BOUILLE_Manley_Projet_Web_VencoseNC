package nc.kibagami_nc.vencosenc.mapper;

import org.springframework.stereotype.Component;

import nc.kibagami_nc.vencosenc.dto.UserDto;
import nc.kibagami_nc.vencosenc.entity.User;

@Component
public class UserMapper {

    // Entite -> DTO (pour envoyer au front)
    public UserDto toDto(User user) {

        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setIdUser(user.getIdUser());
        dto.setLastName(user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setEmail(user.getEmail());
        dto.setPhoneMobile(user.getPhoneMobile());
        dto.setPhoneLandline(user.getPhoneLandline());
        dto.setPassword(user.getPassword());
        dto.setRegistrationDate(user.getRegistrationDate());
        dto.setIsActive(user.getIsActive());

        return dto;
    }

    // DTO -> Entite (pour creer un User)
    public User toEntity(UserDto dto) {

        if (dto == null) return null;

        User user = new User();
        user.setIdUser(dto.getIdUser());
        user.setLastName(dto.getLastName());
        user.setFirstName(dto.getFirstName());
        user.setEmail(dto.getEmail());
        user.setPhoneMobile(dto.getPhoneMobile());
        user.setPhoneLandline(dto.getPhoneLandline());
        user.setPassword(dto.getPassword());
        user.setRegistrationDate(dto.getRegistrationDate());
        user.setIsActive(dto.getIsActive());

        return user;
    }

    // Maj d'un User existant (touche pas a l'ID ni a la date d'inscription)
    public void updateEntity(User user, UserDto dto) {

        user.setLastName(dto.getLastName());
        user.setFirstName(dto.getFirstName());
        user.setEmail(dto.getEmail());
        user.setPhoneMobile(dto.getPhoneMobile());
        user.setPhoneLandline(dto.getPhoneLandline());
        user.setPassword(dto.getPassword());
        user.setIsActive(dto.getIsActive());
    }
}
