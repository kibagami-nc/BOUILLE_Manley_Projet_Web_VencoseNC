package nc.kibagami_nc.vencosenc.service;

import java.util.List;

import nc.kibagami_nc.vencosenc.dto.UserDto;

public interface UserService {

    // Renvoie tous les utilisateurs
    List<UserDto> findAll();

    // Renvoie un utilisateur par son id
    UserDto findById(Long id);

    // Cree un nouvel utilisateur
    UserDto create(UserDto dto);

    // Modifie un utilisateur existant
    UserDto update(Long id, UserDto dto);

    // Supprime un utilisateur par son id
    void delete(Long id);
}
