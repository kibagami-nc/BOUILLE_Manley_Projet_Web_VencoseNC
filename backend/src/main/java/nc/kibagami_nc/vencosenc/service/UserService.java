package nc.kibagami_nc.vencosenc.service;

import java.util.List;

import nc.kibagami_nc.vencosenc.dto.UserDto;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto create(UserDto dto);

    UserDto update(Long id, UserDto dto);

    void delete(Long id);
}
