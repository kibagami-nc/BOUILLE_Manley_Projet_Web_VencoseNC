package nc.kibagami_nc.vencosenc.mapper;

import org.springframework.stereotype.Component;

import nc.kibagami_nc.vencosenc.dto.UserDto;
import nc.kibagami_nc.vencosenc.entity.User;

@Component
public class UserMapper {

    /*
     * Sortie (BDD -> API) : convertit l'entite User lue en BDD en UserDto a renvoyer en JSON.
     * Utilise dans findAll(), findById(), et a la fin de create()/update() pour renvoyer le resultat.
     */
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

    /*
     * Entree (API -> BDD) : construit une NOUVELLE entite User a partir du DTO recu du front.
     * Utilise dans create(), pour transformer le payload JSON en entite a sauver.
     */
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

    /*
     * Entree sur entite existante : modifie une entite User deja chargee depuis la BDD.
     * Different de toEntity : on ne cree PAS une nouvelle entite, on met a jour les champs modifiables.
     * On NE touche PAS a idUser ni a registrationDate (champs immuables).
     * Utilise dans update().
     */
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
